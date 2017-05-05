package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import methods.FareCalculator;
import methods.Triangle;
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
		excelInformation.setOutputBegin(4);
		excelInformation.setOutputEnd(8);
	}
	private FareCalculatorTester()
	{}
	
	@Override
	public String test(String path) throws Exception {
		
		CsvManipulator cv = new CsvManipulator(path);
		int totalTestCase = cv.getRows() - excelInformation.getTestDataRowBegin();
		int failCaseNumber = 0;
		
		for(int i = excelInformation.getTestDataRowBegin();i < cv.getRows();i++)
		{
			List<String> parameters = new ArrayList<String>();
			for(int j = excelInformation.getParameterBegin();j < excelInformation.getParameterEnd();j++)
				parameters.add(cv.read(i, j));
			
			double fare = FareCalculator.getTelephoneFare(parameters.get(0), parameters.get(1));
			double answer = Double.parseDouble(cv.read(i,excelInformation.getAnswerBegin()));
			
			cv.write(i, excelInformation.getOutputBegin(), new Double(fare).toString());
			
			if(fare == answer)
				cv.write(i, excelInformation.getOutputBegin() + 1, "YES");
			else
			{
				cv.write(i, excelInformation.getOutputBegin() + 1, "NO");
				cv.write(i, excelInformation.getOutputBegin() + 2, "Fail");
				System.out.println(i);
				failCaseNumber++;
			}
			
			cv.write(i, excelInformation.getOutputBegin() + 3, new Date().toString());
		}
		
		cv.close();
		List<String> values = new ArrayList<String>();
		values.add("Test for triangle");
		values.add(new Date().toString());
		values.add(String.valueOf(totalTestCase));
		values.add(String.valueOf(failCaseNumber));
		Double percentage = new BigDecimal((double)failCaseNumber * 100/ totalTestCase).setScale(2, RoundingMode.HALF_UP).doubleValue();
		values.add(percentage.toString() + " %");
		values.add(path.replace("\\", "\\\\"));
		return HttpWrapper.wrap(values);
	}

	private Object Integer(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	public static TestFacilty getInstance() {
		if(tester != null)
			return tester;
		else
			return tester = new FareCalculatorTester();
	}
	
	
}
