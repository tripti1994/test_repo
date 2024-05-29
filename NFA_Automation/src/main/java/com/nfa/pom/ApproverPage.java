package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApproverPage {
	WebDriver driver;

	public ApproverPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"select-function\"]")
	public static WebElement apprFunction;		
		
	@FindBy(xpath="//*[@id=\"select-entity\"]")
	public static WebElement apprEntity;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div/button")
	public static WebElement apprSubmit;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[3]/div/a")
	public static WebElement apprExportExcel;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table")
	public static WebElement apprReportList;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
	public static WebElement pcnrapprovlogout;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/div/a")
	public static WebElement pcnrapprovlogoutdrop;

}
