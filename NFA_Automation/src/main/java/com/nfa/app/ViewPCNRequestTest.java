package com.nfa.app;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
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
import com.nfa.pom.HomePage;
import com.nfa.pom.LoginPage;
import com.nfa.pom.WebDriver_Instance;
import com.nfa.utils.ExcelUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewPCNRequestTest {
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	LoginPage loginNFA;
	HomePage homepage;
	String screenshotname;
	Properties config;
	Action action;

	@AfterTest
	public void afterT() {
		extent.flush();
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
			htmlReporter.config().setDocumentTitle("NFA Automation test");
			htmlReporter.config().setReportName("Accept TL Request Test||NFA App");
			htmlReporter.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Tester Name", "Vikrant Nandan");
			System.setProperty("webdriver.chrome.driver", "/Driver/chromedriver.exe");
			WebDriverManager.chromedriver().forceCache();
			WebDriverManager.chromedriver().setup();
			

			WebDriver_Instance.driver = new ChromeDriver();
			WebDriver_Instance.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

			loginNFA = new LoginPage(WebDriver_Instance.driver);
			homepage = new HomePage(WebDriver_Instance.driver);
			WebDriver_Instance.driver.manage().window().maximize();
			WebDriver_Instance.driver.get(config.getProperty("URL"));
			WebDriver_Instance.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			
		} catch (Exception exp) {
			System.out.println("Cause is :-" + exp.getCause());
			System.out.println("Message is" + exp.getMessage());
			exp.printStackTrace();
		}
	}

	@DataProvider(name = "LoginData")
	public Object[][] getdata1() {
		String excelpathlogin = config.getProperty("excelpath_login");
		Object data[][] = testd(excelpathlogin, "Sheet1");
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

	@Test(dataProvider = "LoginData")
	public void viewPCNRequest(String Username, String Password) throws InterruptedException {
		
		test = extent.createTest("eNFA Portal Login Test");
			Action.sendtext(LoginPage.userName, Username);
			Action.sendtext(LoginPage.passwd, Password);		
			Action.click(LoginPage.clickLogin);		
			Thread.sleep(5000);						
			String CurrentURL = WebDriver_Instance.driver.getCurrentUrl();
			assertEquals(CurrentURL, config.getProperty("HOMEPAGE"));
			
			String user = LoginPage.logout.getText();
			System.out.println(user);
			
			switch (user) {
			case "Kaoma":
				((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", HomePage.viewpcn);
				Thread.sleep(2000);
				String getview = HomePage.viewpcn.getText();
				System.out.println(getview);
				
				Action.click(HomePage.viewpcn);				
				((JavascriptExecutor)WebDriver_Instance.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(2000);
				
				WebDriver_Instance.driver.navigate().back();
				
				if(HomePage.updatepcn.isDisplayed()) {
					Thread.sleep(2000);
					Action.click(HomePage.updatepcn);
					((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", HomePage.updatepcnwithdraw);
					
					Thread.sleep(3000);
					WebDriver_Instance.driver.navigate().back();
					
				}else {
					Thread.sleep(2000);
					Action.click(HomePage.copypcn);	
					
					Thread.sleep(2000);
					((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", HomePage.copypcnsubmit);
					
					Thread.sleep(2000);
					Action.click(HomePage.copypcnsubmit);
					
					String alertMsg = HomePage.copypcnalertmsg.getText();
					System.out.println(alertMsg);
					
					Thread.sleep(2000);
					Action.click(HomePage.copypcnalertmsgclose);
					
					Thread.sleep(2000);
					WebDriver_Instance.driver.navigate().back();
				}
									
				Thread.sleep(2000);
				((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", HomePage.auditpcn);
				
				Thread.sleep(2000);
				Action.click(HomePage.auditpcn);
				
				if(HomePage.auditpcndetails == null) {
					Thread.sleep(2000);
					Action.click(HomePage.auditpcndetails);
					
					Thread.sleep(2000);
					Action.click(HomePage.auditpcndetailsclose);
					
				}else {
					Thread.sleep(3000);
					WebDriver_Instance.driver.navigate().back();
					
				}							
				
				((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", LoginPage.logout);
				
				Thread.sleep(3000);	
				Action.click(LoginPage.logout);	
				
				Thread.sleep(1000);
				Action.click(LoginPage.logoutdrop);				
				
				break;

			default:
				
				((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", LoginPage.logout);
				
				Thread.sleep(3000);	
				Action.click(LoginPage.logout);	
				
				Thread.sleep(1000);
				Action.click(LoginPage.logoutdrop);	
				
				break;
			}
		
					
	}

}
