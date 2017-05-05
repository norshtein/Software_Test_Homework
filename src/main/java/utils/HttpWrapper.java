package utils;

import java.util.List;

public final class HttpWrapper {

	private HttpWrapper() {}
	public static String wrap(List<String> values)
	{
		String json ="{"
				+"\"TestName\":"+"\""+values.get(0)+"\","
				+"\"TestTime\":"+"\""+values.get(1)+"\","
				+"\"TestCaseNum\":"+"\""+values.get(2)+"\","
				+"\"FailCaseNum\":"+"\""+values.get(3)+"\","
				+"\"FailRate\":"+"\""+values.get(4)+"%\","
				+"\"ResultFileRef\":"+"\""+values.get(5)+"\""
				+"}";
		return json;
	}
}
