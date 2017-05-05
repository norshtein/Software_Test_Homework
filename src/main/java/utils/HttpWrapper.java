package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class HttpWrapper {

	private HttpWrapper() {}
	public static String wrap(String testName,int testCaseNum,int failCaseNum,String downloadPath)
	{
		
		String json ="{"
				+"\"TestName\":"+"\""+testName+"\","
				+"\"TestTime\":"+"\""+new Date().toString()+"\","
				+"\"TestCaseNum\":"+"\""+String.valueOf(testCaseNum)+"\","
				+"\"FailCaseNum\":"+"\""+String.valueOf(failCaseNum)+"\","
				+"\"FailRate\":"+"\""+String.format("%.2f", (double)failCaseNum * 100/ testCaseNum)+"%\","
				+"\"ResultFileRef\":"+"\""+downloadPath.replace("\\", "\\\\")+"\""
				+"}";
		return json;
	}
}
