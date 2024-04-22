package com.neotech.testcases;


import com.neotech.pages.AddEmployeePage;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.EmployeePersonalDetailsPage;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddEmployeeTest extends CommonMethods {


    @Test (dataProvider = "excelData", groups={"addEmp"})
    public void addEmployeeTest1(String firstName, String lastName, String username, String password) {

        LoginPageElements loginPage = new LoginPageElements();
        loginPage.login();
        DashboardPageElements dashboardPage = new DashboardPageElements();
        dashboardPage.openAddEmployeeWindow();
        AddEmployeePage employeePage = new AddEmployeePage();
        employeePage.addEmployeeDetails(firstName, lastName, username, password);
        EmployeePersonalDetailsPage personalDetailsPage = new EmployeePersonalDetailsPage();
        waitForVisibility(personalDetailsPage.firstName);
        Assert.assertEquals(personalDetailsPage.firstName.getText(), firstName);
        Assert.assertEquals(personalDetailsPage.lastName.getText(), lastName);
        System.out.println("Employee name has been added successful");

    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx";
        String sheetName = "Employee";

        return ExcelUtility.excelIntoArray(filePath, sheetName);
    }


}
