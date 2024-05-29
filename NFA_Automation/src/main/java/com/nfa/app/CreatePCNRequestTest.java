package com.nfa.app;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.nfa.pom.PCNRequestPage;
import com.nfa.pom.WebDriver_Instance;
import com.nfa.utils.ExcelUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePCNRequestTest {
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	PCNRequestPage createPCN;
	LoginPage loginPage;
	HomePage homePage;
	String screenshotname;
	Properties config;
	Action action;
	Actions oActions;
	Robot orobot;

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
		
		fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/configpcn.properties");
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
			oActions = new Actions(WebDriver_Instance.driver);
			loginPage = new LoginPage(WebDriver_Instance.driver);
			homePage =  new HomePage(WebDriver_Instance.driver);
			orobot = new Robot();
			createPCN = new PCNRequestPage(WebDriver_Instance.driver);
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

	@DataProvider(name = "pcndata")
	public Object[][] pcndata() {
		String excelpathpcn = config.getProperty("excelpath_pcn");
		Object data[][] = testd(excelpathpcn, "Sheet1");
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
	
	@Test(dataProvider="pcndata")
	public void createPCN(String username, String password, String nfaTitle, String enddate , String expectedLaunch, String problem, String dataTosupport, 
			String background, String optionConsider, String segmentDetails, String compititiveoffer, String productOffer,
			String gtmPlan, String businessImpact, String keyKpi, String keyMilestone, String additionalNotes, 
			String uom, String month1, String month2, String month3, String month4, String month5, String currentmonth) throws InterruptedException, AWTException {
		
		test = extent.createTest("eNFA Portal PCN Create");	
		
		String fileLocation = new String("C://Workspace//NFA_Automation//Demo Upload//123.xlsx");
	
		//Enter Username
		Action.sendtext(LoginPage.userName, username);
		
		//Enter Password
		Action.sendtext(LoginPage.passwd, password);
		
		// Click Term
		//Action.click(LoginPage.clickTerms);
		
		// click Login Button
		Action.click(LoginPage.clickLogin);			
		Thread.sleep(5000);
		
		String CurrentURL = WebDriver_Instance.driver.getCurrentUrl();
		assertEquals(CurrentURL, config.getProperty("HOMEPAGE"));
		
		// Get Current Title
		System.out.println(WebDriver_Instance.driver.getTitle());
		
		//Get Current URL
		System.out.println(WebDriver_Instance.driver.getCurrentUrl());
		
		//Click Menu
		Action.click(HomePage.menu);
		Thread.sleep(2000);
		
		//Click Create NFA / PCN
		Action.click(HomePage.mrpcn);
		
		// Get Current Title
		System.out.println(WebDriver_Instance.driver.getTitle());
				
		//Get Current URL
		System.out.println(WebDriver_Instance.driver.getCurrentUrl());
		Thread.sleep(2000);
		
		//Enter NFA Title
		Action.sendtext(PCNRequestPage.pcnNFATitle, nfaTitle);
		
		// Select PCN Type
		Action.click(PCNRequestPage.pcnProductType);
		Thread.sleep(1000);
		Action.click(PCNRequestPage.pcnProductTypeVoice);		
		Thread.sleep(1000);		
		
		// Enter NFA End Date
		/*((JavascriptExecutor) WebDriver_Instance.driver).executeScript("document.getElementsByName('pcnEndDate')[0].setAttribute('value', '2019-12-21')");
		Action.sendtext(PCNRequestPage.pcnNFAEndDate, "12");
		String ovalue = PCNRequestPage.pcnNFAEndDate.getAttribute("value");
		System.out.println(ovalue);*/
		
		System.out.println("Select Date: Within 10 Seconds");
		Thread.sleep(10000);
		
		//Action.sendtext(PCNRequestPage.pcnNFAEndDate, "12022019");
		
		// Select Permanent Checkbox
		//Action.click(PCNRequestPage.pcnPermanentCheckBox);
		
		// Select Target Segment
		Action.click(PCNRequestPage.pcnTargetType);
		Thread.sleep(1000);
		Action.click(PCNRequestPage.pcnTargetTypeOpenMarket);			
		Thread.sleep(1000);
		
		//Select Contract Type		
		orobot.keyPress(KeyEvent.VK_TAB);
		orobot.keyPress(KeyEvent.VK_TAB);
		orobot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);		
		Action.click(PCNRequestPage.pcnContractTypePrepaid);
		
		// Enter Business Impact
		Action.sendtext(PCNRequestPage.pcnBusinessImpact, "3");
		
		//Enter ARU Impact
		Action.sendtext(PCNRequestPage.pcnArpuImpact, "3");		
		Thread.sleep(5000);	
		
		//Enter Expected Launch Date
		/*((JavascriptExecutor) WebDriver_Instance.driver).executeScript("document.getElementsByName('expectedLaunchDate')[0].setAttribute('value', '2019-12-21')");*/
		System.out.println("Select Date: Within 10 Seconds");
		Thread.sleep(10000);
		
		//Enter Problem Statement
		Action.sendtext(PCNRequestPage.pcnEnterProblem, problem);
		
		// Attach Problem File
		Action.sendtext(PCNRequestPage.pcnEnterProblemAttachFile, fileLocation);
				
		// Enter Data to Support
		Action.sendtext(PCNRequestPage.pcnEnterDataToSupport, dataTosupport);
		
		// Attach Data to Support File
		Action.sendtext(PCNRequestPage.pcnEnterDataToSupportAttachFile, fileLocation);
	
		// Enter Background Details
		Action.sendtext(PCNRequestPage.pcnEnterBackground, background);
		
		// Attach Background File
		Action.sendtext(PCNRequestPage.pcnEnterBackgroundAttachFile, fileLocation);
	
		// Enter Option Consider Details
		Action.sendtext(PCNRequestPage.pcnEnterOptionConsidered, optionConsider);
		
		// Attach Option Consider File
		Action.sendtext(PCNRequestPage.pcnEnterOptionConsideredAttachFile, fileLocation);
	
		// Enter Segment Details
		Action.sendtext(PCNRequestPage.pcnEnterSegmentDetails, segmentDetails);
		
		// Attach Segment Details File
		Action.sendtext(PCNRequestPage.pcnEnterSegmentDetailsAttachFile, fileLocation);

		// Enter Competitive Offer Details
		Action.sendtext(PCNRequestPage.pcnEnterCompOffer, compititiveoffer);
		
		// AttachCompetitive Offer File
		Action.sendtext(PCNRequestPage.pcnEnterCompOfferAttachFile, fileLocation);
	
		// Enter Product Offer Details
		Action.sendtext(PCNRequestPage.pcnEnterProductOffer, productOffer);
		
		// Attach Product Offer File
		Action.sendtext(PCNRequestPage.pcnEnterProductOfferAttachFile, fileLocation);
	
		// Enter GTM Plan Details
		Action.sendtext(PCNRequestPage.pcnEnterGTMPlan, gtmPlan);
		
		// Attach GTM Plan File
		Action.sendtext(PCNRequestPage.pcnEnterGTMPlanAttachFile, fileLocation);

		// Enter Business Impact Details
		Action.sendtext(PCNRequestPage.pcnEnterBusinessImpact, businessImpact);
		
		// Attach Business Impact File
		Action.sendtext(PCNRequestPage.pcnEnterBusinessImpactAttachFile, fileLocation);
	
		// Enter Key KPI
		Action.sendtext(PCNRequestPage.pcnEnterKeyKPI, keyKpi);
		
		// Attach Key KPI File
		Action.sendtext(PCNRequestPage.pcnEnterKeyKPIAttachFile, fileLocation);
		
		// Enter Key Milestone
		Action.sendtext(PCNRequestPage.pcnEnterKeyMilestone, keyMilestone);
		
		// Attach Key Milestone File
		Action.sendtext(PCNRequestPage.pcnEnterKeyMilestoneAttachFile, fileLocation);
			
		// Enter Additional Notes
		Action.sendtext(PCNRequestPage.pcnEnterAdditionalNotes, additionalNotes);
		
		// Attach Additional Notes File
		Action.sendtext(PCNRequestPage.pcnEnterAdditionalNotesAttachFile, fileLocation);				
		
		//Enter CR/DR Trend
		Action.sendtext(PCNRequestPage.pcnEntercrdrUom, uom);
		Action.sendtext(PCNRequestPage.pcnEntercrdrMonth1, month1);
		Action.sendtext(PCNRequestPage.pcnEntercrdrMonth2, month2);
		Action.sendtext(PCNRequestPage.pcnEntercrdrMonth3, month3);
		Action.sendtext(PCNRequestPage.pcnEntercrdrMonth4, month4);
		Action.sendtext(PCNRequestPage.pcnEntercrdrMonth5, month5);
		Action.sendtext(PCNRequestPage.pcnEntercrdrCurrentMonth, currentmonth);
		
		//Enter ARPU 		
		Action.sendtext(PCNRequestPage.pcnEnterarpuUom, uom);
		Action.sendtext(PCNRequestPage.pcnEnterarpuMonth1, month1);
		Action.sendtext(PCNRequestPage.pcnEnterarpuMonth2, month2);
		Action.sendtext(PCNRequestPage.pcnEnterarpuMonth3, month3);
		Action.sendtext(PCNRequestPage.pcnEnterarpuMonth4, month4);
		Action.sendtext(PCNRequestPage.pcnEnterarpuMonth5, month5);
		Action.sendtext(PCNRequestPage.pcnEnterarpuCurrentMonth, currentmonth);
		
		Thread.sleep(3000);
		((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", PCNRequestPage.pcnSubmit);
		
		// Click Submit Button
		Thread.sleep(2000);
		Action.click(PCNRequestPage.pcnSubmit);
		
		// Get Text From Alert
		Thread.sleep(2000);
		String AlertText = PCNRequestPage.pcnSubmitAlertText.getText();
		System.out.println(AlertText);
		
		if(AlertText.contains("An error occured while updating details. Kindly try after some time!")) {
			Thread.sleep(2000);
			Action.click(PCNRequestPage.pcnSubmitAlertOK);
			
		}else {
			
			//Click Alert
			Thread.sleep(2000);
			Action.click(PCNRequestPage.pcnSubmitAlertOK);
			
		}
		
		// Logout
		((JavascriptExecutor)WebDriver_Instance.driver).executeScript("arguments[0].scrollIntoView();", PCNRequestPage.pcnlogout);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(WebDriver_Instance.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(PCNRequestPage.pcnlogout)).click();
		
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.elementToBeClickable(PCNRequestPage.pcnlogoutdrop)).click();		
	}	
}
