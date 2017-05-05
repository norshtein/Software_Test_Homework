package test;

import java.util.List;
import utils.ExcelInformation;

public interface TestFacilty {
	public String test(String path) throws Exception;
	public List<String> eval(List<String> parameters);
}
