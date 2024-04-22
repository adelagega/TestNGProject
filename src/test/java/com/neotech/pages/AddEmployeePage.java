package com.neotech.pages;

import com.neotech.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddEmployeePage {

    @FindBy(xpath="//input[@id='first-name-box']")
    WebElement firstNameInput;

    @FindBy(xpath="//input[@id='last-name-box']")
    WebElement lastNameInput;

    @FindBy(id="location")
    WebElement location;

    @FindBy(xpath="//div[@class='custom-control custom-switch']")
    WebElement createLoginDetails;

    @FindBy(xpath="//input[@id='username']")
    WebElement usernameInput;

    @FindBy(xpath="//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath="//input[@id='confirmPassword']")
    WebElement confirmPasswordInput;

    @FindBy(xpath="//button[@id='modal-save-button']")
    WebElement saveBtn;

    public AddEmployeePage() {
        PageFactory.initElements(BaseClass.driver, this);
    }

    public void addEmployeeDetails(String firstName, String lastName, String username, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        Select sel = new Select(location);
        sel.selectByVisibleText("Chinese Development Center");
        createLoginDetails.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        saveBtn.click();
    }
}
