package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.TestFacilty;

public class BaseComparator {

	protected CsvManipulator cv;
	protected ExcelInformation ei;
	protected Class invoker;
	protected int cursor;
	
	public BaseComparator(String path,ExcelInformation excelInformation,Class thisClass) throws FileNotFoundException, IOException {
		cv = new CsvManipulator(path);
		ei = excelInformation;
		invoker = thisClass;
		cursor  = excelInformation.getTestDataRowBegin();
	}
	
	public int getTestCaseNum()
	{
		return cv.getRows() - ei.getTestDataRowBegin();
	}
	
	public boolean haveNextTestCase()
	{
		return cursor < cv.getRows();
	}
	
	public boolean getNextTestResult() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		List<String> parameters = new ArrayList<String>();
		for(int j = ei.getParameterBegin();j < ei.getParameterEnd();j++)
			parameters.add(cv.read(cursor, j));
		
		List<String> testResult = ((TestFacilty)(invoker.getMethod("getInstance").invoke(null))).eval(parameters);
		for(int i = ei.getOutputAnswerBegin();i < ei.getOutputAnswerEnd();i++)
			cv.write(cursor, i, testResult.get(i - ei.getOutputAnswerBegin()));
		
		List<String> answer = new ArrayList<String>();
		for(int i = ei.getAnswerBegin();i < ei.getAnswerEnd();i++)
			answer.add(cv.read(cursor, i));
		
		cv.write(cursor,ei.getOutputInformationBegin() + 2,new Date().toString());
		if(isEqual(testResult,answer))
		{
			cv.write(cursor, ei.getOutputInformationBegin(), "Yes");
			cursor++;
			return true;
		}
		else
		{
			cv.write(cursor, ei.getOutputInformationBegin(), "No");
			cv.write(cursor, ei.getOutputInformationBegin() + 1, "Failure");
			cursor++;
			return false;
		}
	}
	
	//return output filename
	public String close() throws IOException
	{
		return cv.close();
	}
	
	protected boolean isEqual(List<String> a,List<String> b)
	{
		if(a.size() != b.size())
			return false;
		for(int i = 0;i < a.size();i++)
		{
			if(!a.get(i).equals(b.get(i)))
				return false;
		}
		return true;
	}
}
