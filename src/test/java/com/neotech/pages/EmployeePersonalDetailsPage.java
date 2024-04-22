package com.neotech.pages;

import com.neotech.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePersonalDetailsPage {

    @FindBy(xpath="//input[@id='firstName']")
    public WebElement firstName;

    @FindBy(xpath="//input[@id='lastName']")
    public WebElement lastName;

    public EmployeePersonalDetailsPage() {
        PageFactory.initElements(BaseClass.driver, this);
    }


}
