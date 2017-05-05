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
		excelInformation = new ExcelInformation();
		excelInformation.setTestDataRowBegin(1);
		excelInformation.setParameterBegin(1);
		excelInformation.setParameterEnd(3);
		excelInformation.setAnswerBegin(3);
		excelInformation.setAnswerEnd(4);
		excelInformation.setOutputAnswerBegin(4);
		excelInformation.setOutputAnswerEnd(5);
		excelInformation.setOutputInformationBegin(5);
		excelInformation.setOutputInformationEnd(8);
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
		
		List<String> values = new ArrayList<String>();
		values.add("Test for triangle");
		values.add(new Date().toString());
		values.add(String.valueOf(totalCaseNumber));
		values.add(String.valueOf(failCaseNumber));
		Double percentage = new BigDecimal((double)failCaseNumber * 100/ totalCaseNumber).setScale(2, RoundingMode.HALF_UP).doubleValue();
		values.add(percentage.toString() + " %");
		values.add(path.replace("\\", "\\\\"));
		
		return HttpWrapper.wrap(values);
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
