package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class DashboardPageElements {

	
	@FindBy(id="account-name")
	public WebElement accountName;

	@FindBy(xpath="//span[normalize-space()='PIM']")
	public WebElement pim;

	@FindBy(xpath="//span[normalize-space()='Add Employee']")
	WebElement addEmployee;
	
	public DashboardPageElements()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void openAddEmployeeWindow() {
		pim.click();
		addEmployee.click();
//		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(addEmployee));
	}
}
