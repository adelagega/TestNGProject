package com.neotech.testbase;

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
	{
		System.out.println("Test will start: " + result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test passed: "  + result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test failed: " + result.getName());
	}
	
	
	
	
}
