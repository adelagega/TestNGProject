package com.neotech.testbase;

import java.time.Duration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;
import org.testng.annotations.BeforeTest;
import org.testng.reporters.TestHTMLReporter;

public class BaseClass {

	public static WebDriver driver;
	//extend report objects to create my Extent Report
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports report;
	public static ExtentTest test;

	//start the report creation process
	@BeforeTest(alwaysRun = true)
	public void generateReport() {
		sparkReport = new ExtentSparkReporter(Constants.REPORT_FILEPATH);
		sparkReport.config().setDocumentTitle("My Document Title");
		sparkReport.config().setReportName("My Report Name");
		sparkReport.config().setTheme(Theme.DARK);


		report = new ExtentReports();
		report.attachReporter(sparkReport);
	}
    //write report file to the html
	@AfterTest(alwaysRun = true)
	public void writeReport() {
       report.flush();
	}

	@BeforeMethod(alwaysRun=true) 
	public static void setUp() {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		String browser = ConfigsReader.getProperty("browser");
		// System.out.println(browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			// System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "firefox":
			// System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		
	//	Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		String website = ConfigsReader.getProperty("url");
		driver.get(website);
	}
	
	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
