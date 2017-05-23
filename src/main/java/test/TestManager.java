package test;

import java.util.ArrayList;
import java.util.HashMap;
import utils.CsvManipulator;
import utils.ExcelInformation;

import java.util.List;

public class TestManager {
	private static HashMap<String,TestFacilty> typeToTester;
	static {
		typeToTester = new HashMap<String,TestFacilty>();
		typeToTester.put("fare", new FareCalculatorTester(new ExcelInformation(1,3,3,4,4,5,5,8,1)));
		typeToTester.put("computerSale", new ComputerSaleTester(new ExcelInformation(1,3,3,4,4,5,5,8,1)));
	}
	
	public static String test(String type,String path) throws Exception
	{
		TestFacilty tester = typeToTester.get(type);
		assert tester != null;
		
		return tester.test(type,path);
	}
	public static String singleTest(String type,String parameter) throws Exception 
	{
		TestFacilty tester = typeToTester.get(type);
		assert tester != null;
		
		String answer = "";
		List<String> ls = tester.singleTest(parameter);
		for(int i = 0;i < ls.size();i++)
			answer += ls.get(i);
		return answer;
	}
}
