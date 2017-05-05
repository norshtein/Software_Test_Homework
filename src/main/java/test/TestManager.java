package test;

import java.util.ArrayList;
import java.util.HashMap;
import utils.CsvManipulator;
import java.util.List;

public class TestManager {
	private static HashMap<String,TestFacilty> typeToTester;
	static {
		typeToTester = new HashMap<String,TestFacilty>();
		typeToTester.put("fare", FareCalculatorTester.getInstance());
	}
	
	public static String test(String type,String path) throws Exception
	{
		TestFacilty tester = typeToTester.get(type);
		assert tester != null;
		
		return tester.test(path);
	}
}
