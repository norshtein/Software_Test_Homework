package testunits;

import java.math.BigDecimal;
import java.math.RoundingMode;

class ExceedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceedMessage="the input is exceed the limit";
	ExceedException(String str){
		if(str!="")
		exceedMessage=str;
	}
	public String getMessage(){
		return exceedMessage;
		
	}
}
public class ComputerSale {
	private final static int maxDevice=90;
	private final static int minDevice=1;
	private final static int maxcompBox=70;
	private final static int mincompBox=1;
	private final static int maxScreen=80;
	private final static int minScreen=1;
	private static int deviceNum;
	private static int compBoxNum;
	private static int ScreenNum;
	private static int devicePrice=25;
	private static int compBoxPrice=45;
	private static int ScreenPrice=30;
	public ComputerSale (){
	}
	
	private enum ErrorCode
	{
		InputIsNotVaildNumber(-1.0),InputRangeIsNotCorrect(-2.0);
		
		double ec;
		private ErrorCode(double d)
		{
			this.ec = d;
		}
		
		@Override
		public String toString()
		{
			return String.valueOf(ec);
		}
		
	}
	
	
	public static double getProfit(String device,String compBox,String Screen)
	{
		try 
		{
			checkInput(device,compBox,Screen);
		} 
		catch(NumberFormatException e)
		{
			return truncate(Double.valueOf(ErrorCode.InputIsNotVaildNumber.toString()));
		}
		catch (AssertionError e) 
		{
			return truncate(Double.valueOf(ErrorCode.InputRangeIsNotCorrect.toString()));
		}
		
		return truncate(getProfit(Integer.parseInt(device),Integer.parseInt(compBox),Integer.parseInt(Screen)));
	}
	
	public static double getProfit(int device,int compBox,int Screen){
		
		System.out.println("getProfit()");
		int sum=deviceNum*devicePrice+
				compBoxNum*compBoxPrice+
				ScreenNum*ScreenPrice;
		double profit=0;
		if(sum>=1800)
			profit=sum*0.15;
		else if(sum>=1000)
			profit=sum*0.10;
		else
			profit=sum*0.05;
		return profit;
	}
	
	private static void checkInput(String device,String compBox,String Screen)
	{
		deviceNum = Integer.parseInt(device);
		compBoxNum = Integer.parseInt(compBox);
		ScreenNum = Integer.parseInt(Screen);
		assert (deviceNum<=maxDevice&&deviceNum>=minDevice);
		assert (compBoxNum<=maxcompBox&&compBoxNum>=mincompBox);
		assert (ScreenNum<=maxScreen&&ScreenNum>=minScreen);
		/*if(deviceNum>maxDevice)
			throw new ExceedException("device number >"+maxDevice);
		else if(deviceNum<minDevice)
			throw new ExceedException("device number <"+minDevice);
		else if(compBoxNum>maxcompBox)
			throw new ExceedException("computerBox number >"+maxcompBox);
		else if(compBoxNum<mincompBox)
			throw new ExceedException("computerBox number <"+mincompBox);
		else if(ScreenNum>maxScreen)
			throw new ExceedException("screen number >"+maxScreen);
		else if(ScreenNum<minScreen)
			throw new ExceedException("screen number <"+maxScreen);*/
		
	}
	
	private static double truncate(Double num)
	{
		return BigDecimal.valueOf(num).setScale(2,RoundingMode.HALF_UP).doubleValue();
	}
	
}
