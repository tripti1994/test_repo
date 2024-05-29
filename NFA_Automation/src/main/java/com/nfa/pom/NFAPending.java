package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NFAPending {
	WebDriver driver;

	public NFAPending(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"select-function\"]")
	public static WebElement nfapFunction;		
		
	@FindBy(xpath="//*[@id=\"select-entity\"]")
	public static WebElement nfapEntity;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div/button/span[1]")
	public static WebElement nfapSubmit;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[3]/div/a")
	public static WebElement nfapExportExcel;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table")
	public static WebElement nfapReportList;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
	public static WebElement nfapReportlogout;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/div/a")
	public static WebElement nfapReportlogoutdrop;

}
