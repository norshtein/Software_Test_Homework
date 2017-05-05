package methods;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;

public class FareCalculator {

	private FareCalculator() {}
	private static final double baseFare = 25.0;
	private static final double farePerMinute = 0.15;
	private static HashMap<Integer,Integer> deferredTimesToCallingTime;
	private static final double[] pivots = {0,60,120,180,300};
	private static final double baseDiscount = 0.005;
	private static final double discountStep = 0.005;
	
	static{
		deferredTimesToCallingTime = new HashMap<Integer,Integer>();
		deferredTimesToCallingTime.put(0, 0);
		deferredTimesToCallingTime.put(1, 0);
		deferredTimesToCallingTime.put(2, 60);
		deferredTimesToCallingTime.put(3, 120);
		deferredTimesToCallingTime.put(4, 120);
		deferredTimesToCallingTime.put(5, 120);
		deferredTimesToCallingTime.put(6, 300);
	}
	
	public static double getTelephoneFare(String minutes,String deferredTimes)
	{
		try 
		{
			checkInput(minutes,deferredTimes);
		} 
		catch(NumberFormatException e)
		{
			return truncate(-1.0);
		}
		catch (AssertionError e) 
		{
			return truncate(-2.0);
		}
		
		return truncate(getTelephoneFare(Double.parseDouble(minutes),Integer.parseInt(deferredTimes)));
	}
	private static void checkInput(String arg1,String arg2)
	{
		double minutes = Double.parseDouble(arg1);
		int deferredTimes = Integer.parseInt(arg2);
		assert minutes >= 0;
		assert deferredTimes >= 0;
	}

	private static double getTelephoneFare(double minutes,int deferredTimes)
	{
		if(deferredTimes > 6 || minutes <= deferredTimesToCallingTime.get(deferredTimes))
			return baseFare + farePerMinute * minutes;
		else
		{
			int index = Arrays.binarySearch(pivots, minutes);
			int level = index > 0 ? index : Math.abs(index) - 1;
			double disCount = baseDiscount + level * 0.005;
			return baseFare + farePerMinute * minutes * (1 - disCount);
		}
	}

	private static double truncate(Double num)
	{
		return BigDecimal.valueOf(num).setScale(2,RoundingMode.HALF_UP).doubleValue();
	}
}
