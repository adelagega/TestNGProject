package com.neotech.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTest extends CommonMethods{

	
	
	@Test(groups= {"smoke", "regression"})
	public void validLogin()
	{
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		test.info("Entering valid username and password!");
		
		//send username
		sendText(login.username, ConfigsReader.getProperty("username"));
		
		//send password
		sendText(login.password, ConfigsReader.getProperty("password"));
		
		//click on login
		click(login.loginBtn);
		
		//assert Ms. White is there
		
		String expected = "Jacqueline White";
		String actual = dashboard.accountName.getText();
		
		//Assertion
		Assert.assertEquals(actual, expected, "The account name does NOT match!!!");
		
	}
		
	@Test(groups={"smoke", "regression"})
	public void emptyPasswordLogin()
	{
		
		LoginPageElements login = new LoginPageElements();
		
		//send username
		sendText(login.username, ConfigsReader.getProperty("username"));
		
		//leave password empty
		
		//click on login
		click(login.loginBtn);
		
		//Assert that message password cannot be empty is shown
		String expectedMessage = "Password cannot be empty";
		String actualMessage = login.emptyPasswordError.getText();
		
		Assert.assertEquals(actualMessage, expectedMessage, "Error messages do NOT match!!!");
	}
	
	@Test(groups = "regression")
	public void invalidPasswordLogin()
	{
		LoginPageElements login = new LoginPageElements();
		//send username
		sendText(login.username, ConfigsReader.getProperty("username"));
		//send wrong password
		sendText(login.password, "Wrong");
		//click on login button
		click(login.loginBtn);
		
		// assert the error message
		String expectedMessage = "Invalid Credentials - ";
		String actualMessage = login.wrongCredentialsMessage.getText();
		
		Assert.assertEquals(actualMessage, expectedMessage, "Error messages do NOT match!!!");
		
	}
	
	
}
