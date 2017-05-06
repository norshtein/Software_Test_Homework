package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import testunits.FareCalculator;
import testunits.Triangle;
import utils.BaseComparator;
import utils.CsvManipulator;
import utils.ExcelInformation;
import utils.HttpWrapper;

public final class FareCalculatorTester implements TestFacilty{

	private static FareCalculatorTester tester;
	private static ExcelInformation excelInformation;
	static
	{
		excelInformation = new ExcelInformation(1,3,3,4,4,5,5,8,1);
	}
	
	private FareCalculatorTester()
	{}
	
	@Override
	public String test(String path) throws Exception {
		
		BaseComparator comparator = new BaseComparator(path,excelInformation,this.getClass());
		int failCaseNumber = 0;
		int totalCaseNumber = comparator.getTestCaseNum();
		
		while(comparator.haveNextTestCase())
		{
			if(comparator.getNextTestResult() == false)
				failCaseNumber++;
		}
		
		comparator.close();
		
		return HttpWrapper.wrap("Fare calculator",totalCaseNumber,failCaseNumber,path);
	}


	public static TestFacilty getInstance() {
		if(tester != null)
			return tester;
		else
			return tester = new FareCalculatorTester();
	}

	@Override
	public List<String> eval(List<String> parameters) {
		double fare = FareCalculator.getTelephoneFare(parameters.get(0), parameters.get(1));
		List<String> resultList = new ArrayList<String>();
		resultList.add(String.format("%.2f", fare));
		return resultList;
	}

}
