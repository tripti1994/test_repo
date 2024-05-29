package com.nfa.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nfa.pom.WebDriver_Instance;


public class Action{
	
	public static void click(WebElement web){
		web.click();
	}
	public static void sendtext(WebElement web, String Str){
		web.sendKeys(Str);
	}
	public static void clear(WebElement web){
		web.clear();
	}
	public static String gettext(WebElement web){
		return web.getText();
	}

	public static void teardown(ITestResult result,ExtentTest test,WebDriver driver) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "TEST CASE FAILED IS "+ result.getName());
			test.log(Status.FAIL,"TEST CASE FAIELD IS "+result.getThrowable());
			String screenshotpath=GetScreenShot(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIPPED IS "+result.getName());
		}
		else if (result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS,"TEST CASE PASSED IS "+result.getName());}
		String screenshotpath=GetScreenShot(driver,result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
	}

	public static String GetScreenShot(WebDriver driver,String screenshotname) throws IOException{
		String datename= new SimpleDateFormat("yyyyMMdd-hmmssa").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);

		String destination =System.getProperty("user.dir")+"/Screenshots/"+ screenshotname+datename+".png";
		File finaldestination = new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;
}
	
	public static WebDriver getWebDriver(String selectedDriver, int implicitWait){
        
        if(selectedDriver.toUpperCase().equals("IE")){
            System.setProperty("webdriver.ie.driver", "Driver/IEDriverServer.exe");
            WebDriver_Instance.driver = new InternetExplorerDriver();
            
        }else if(selectedDriver.toLowerCase().equals("firefox")){
            FirefoxOptions options = new FirefoxOptions();            
            options.addArguments("--lang=en-GB");
            options.setAcceptInsecureCerts(true);
            System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
            WebDriver_Instance.driver = new FirefoxDriver(options);
            
        }else {
        	
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=en-GB");
            options.setAcceptInsecureCerts(true);
            System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
            WebDriver_Instance.driver = new ChromeDriver(options);
        }
        
        WebDriver_Instance.driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        WebDriver_Instance.driver.manage().window().maximize();
        return WebDriver_Instance.driver;
    }
}

