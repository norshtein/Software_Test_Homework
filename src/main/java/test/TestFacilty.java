package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.BaseComparator;
import utils.ExcelInformation;
import utils.HttpWrapper;
import org.json.JSONObject;

public abstract class TestFacilty {
	protected ExcelInformation excelInformation;
	public TestFacilty(ExcelInformation ex)
	{
		this.excelInformation = ex;
	}
	public String test(String path,String program) throws Exception {
		BaseComparator comparator = new BaseComparator(path,excelInformation,this.getClass());
		int failCaseNumber = 0;
		int totalCaseNumber = comparator.getTestCaseNum();
		
		while(comparator.haveNextTestCase())
		{
			if(comparator.getNextTestResult() == false)
				failCaseNumber++;
		}
		
		String outputPath = comparator.close();
		
		return HttpWrapper.wrap(program,totalCaseNumber,failCaseNumber,outputPath);
	}
	public abstract List<String> eval(List<String> parameters);
	public List<String> singleTest(String parameter) throws Exception {
		JSONObject json = new JSONObject(parameter);
		List<String> ls = new ArrayList<String>();
		Iterator<String> itor = json.keys();
		while(itor.hasNext())
			ls.add(json.getString(itor.next()));
		return eval(ls);
	}
}
