package com.nfa.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nfa.action.Action;
import com.nfa.pom.ApproverHomePage;
import com.nfa.pom.LoginPage;
import com.nfa.pom.WebDriver_Instance;
import com.nfa.utils.ExcelUtils;

public class AprrovePCN {
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	LoginPage loginPage;
	ApproverHomePage appHomePage;
	String screenshotname;
	Properties config;
	
	@AfterTest
	public void afterT() throws InterruptedException {
		extent.flush();
		
		Thread.sleep(3000);	
		WebDriver_Instance.driver.quit();
		
	}

	@AfterMethod
	public void AfterTM(ITestResult result) throws IOException {
		Action.teardown(result, test, WebDriver_Instance.driver);
		screenshotname = result.getName();
		Action.GetScreenShot(WebDriver_Instance.driver, screenshotname);
	}

	@BeforeTest
	public void setup() throws Exception {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		Date objDate = new Date(); // Current System Date and time is assigned to objDate
		System.out.println(objDate);
		String strDateFormat = "hh_mm a dd-MMM-yyyy"; // Date format is Specified
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // Date format string is passed as an argument to
																		// the Date format object
		String timedate = this.getClass().getSimpleName() + " " + (objSDF.format(objDate)).toString(); // Date
																										// formatting is
																										// applied to
																										// the current
																										// date

		config = new Properties();
		FileInputStream fis;
		
		fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
		config.load(fis);
		
		try {
			htmlReporter = new ExtentHtmlReporter(
			System.getProperty("user.dir") + "/test-output/" + timedate + ".html");
			htmlReporter.config().setDocumentTitle("NFA Approover test");
			htmlReporter.config().setReportName("Accept TL Request Test||NFA App");
			htmlReporter.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Tester Name", "Vikrant Nandan");
			//System.setProperty("webdriver.chrome.driver", "/Driver/chromedriver.exe");
			/*WebDriverManager.chromedriver().forceCache();
			WebDriverManager.chromedriver().setup();*/			
			Action.getWebDriver("chrome", 30);
			
			/*WebDriver_Instance.driver = new ChromeDriver();
			WebDriver_Instance.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);	*/		
			loginPage = new LoginPage(WebDriver_Instance.driver);
			appHomePage =  new ApproverHomePage(WebDriver_Instance.driver);
			
			//WebDriver_Instance.driver.manage().window().maximize();
			WebDriver_Instance.driver.get(config.getProperty("URL"));
			WebDriver_Instance.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			
		} catch (Exception exp) {
			System.out.println("Cause is :-" + exp.getCause());
			System.out.println("Message is" + exp.getMessage());
			exp.printStackTrace();
		}
	}

	@DataProvider(name = "approver")
	public Object[][] pcndata() {
		String excelpathapproverlogin = config.getProperty("excelpath_login_Aprrover");
		Object data[][] = testd(excelpathapproverlogin, "Sheet1");
		return data;
	}

	public static Object[][] testd(String excelpath, String sheetname) {
		@SuppressWarnings("unused")
		ExcelUtils excel = new ExcelUtils(excelpath, sheetname);
		int rowcount = ExcelUtils.getrowcount();
		int colcount = ExcelUtils.getcolcount();
		Object data[][] = new Object[rowcount - 1][colcount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				String celldata = ExcelUtils.getcelldataNumber(i, j);
				System.out.println(celldata);
				data[i - 1][j] = celldata;
			}
		}
		return data;
	}
	@Test(dataProvider="approver")
	public void ApprovPCNRequest(String username, String password) throws InterruptedException {
		test = extent.createTest("eNFA Portal Approver");
		
		Action.sendtext(LoginPage.userName, username);
		
		Action.sendtext(LoginPage.passwd, password);
		
		Action.click(LoginPage.clickLogin);
		
		String currentURL = WebDriver_Instance.driver.getCurrentUrl();
		System.out.println(currentURL);
		System.out.println(WebDriver_Instance.driver.getTitle());
		
		if(ApproverHomePage.noRecordFound != null || ApproverHomePage.noRecordFound == null) {		
			
			Thread.sleep(5000);	
			Action.click(LoginPage.logout);
			
			Thread.sleep(1000);
			Action.click(LoginPage.logoutdrop);	
							
			
		}else{		
		
		Thread.sleep(2000);
		((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", ApproverHomePage.downloadPCN);
		
		Thread.sleep(1000);
		Action.click(ApproverHomePage.downloadPCN);
		
		Thread.sleep(2000);
		((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", ApproverHomePage.reviewPCN);
		
		Thread.sleep(1000);
		Action.click(ApproverHomePage.reviewPCN);
		
		Thread.sleep(2000);
		((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", ApproverHomePage.reviewPCNApprove);
		
		Thread.sleep(3000);
		Action.click(ApproverHomePage.reviewPCNApprove);
		
		Thread.sleep(3000);
		String alertmgs = ApproverHomePage.reviewPCNApproveAlert.getText();
		System.out.println("Alert : " + alertmgs);
		
		Thread.sleep(1000);		
		Action.click(ApproverHomePage.reviewPCNApproveAlertOK);		
		
		((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", LoginPage.logout);
		
		Thread.sleep(5000);	
		Action.click(LoginPage.logout);
		
		Thread.sleep(1000);
		Action.click(LoginPage.logoutdrop);
	
		
		}			
	}

}
