package com.neotech.pages;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class LoginPageElements {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement loginBtn;
	
	@FindBy(id="txtPassword-error")
	public WebElement emptyPasswordError;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement wrongCredentialsMessage;
	

	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void login() {
		username.sendKeys(ConfigsReader.getProperty("username"));
		password.sendKeys(ConfigsReader.getProperty("password"));
		loginBtn.click();
	}


}
