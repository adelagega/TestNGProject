package com.neotech.testbase;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.Constants;
import org.testng.CommandLineArgs;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class Listener implements ITestListener{
	public void onStart(ITestContext context)
	{
		System.out.println("Functionality test started!");
	}
	public void onFinish (ITestContext context)
	{
		System.out.println("Functionality test finished!");
	}
	public void onTestStart(ITestResult result)
	{   //it print the logs to the console
		System.out.println("Test will start: " + result.getName());
		//we want to create a test report, so the logs show in ExtendReport
		BaseClass.test = BaseClass.report.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test passed: "  + result.getName());
		//print test passed on the report
		BaseClass.test.pass("Test passed : " + result.getName());
		//take a screenshot and include it in the report
		String successImage = CommonMethods.takeScreenshot("passed/" + result.getName());
		BaseClass.test.addScreenCaptureFromPath(successImage);
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test failed: " + result.getName());
		//print test fail on the report
		BaseClass.test.fail("Test failed : " + result.getName());
		String failImage = CommonMethods.takeScreenshot("failed/" + result.getName());
		BaseClass.test.addScreenCaptureFromPath(failImage);
	}
}
