package main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import test.TestManager;

@RestController
public class TestController {

	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String testControl(@RequestParam("program")String program,@RequestParam("testfile")String testfile) throws Exception
	{
		String answer = TestManager.test(program, testfile);
		return answer;
	}
	
	@RequestMapping(value="/singletest",method = RequestMethod.GET)
	public String singleTestControl(@RequestParam("program")String program,@RequestParam("parameter")String parameter) throws Exception
	{
		String answer = TestManager.singleTest(program, parameter);
		return answer;
	}
}
