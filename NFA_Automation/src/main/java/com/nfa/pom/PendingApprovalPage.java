package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingApprovalPage {
	WebDriver driver;

	public PendingApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[1]/div/div/input")
	public static WebElement penAppNFANumber;		
		
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[2]/div/div/input")
	public static WebElement penAppCreationDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[3]/div/div/input")
	public static WebElement penAppFromDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[4]/div/div/input")
	public static WebElement penAppToDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[5]/div/div/input")
	public static WebElement penAppSubmitDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[6]/div/div/div/div")
	public static WebElement penAppPCNType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[7]/div/div/input")
	public static WebElement penAppNFASubType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[8]/div/div/div/div")
	public static WebElement penAppOPCO;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[9]/div/div/div/div")
	public static WebElement penAppFunction;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[10]/div/div/input")
	public static WebElement penAppNFATitle;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[11]/div/div/div/div")
	public static WebElement penAppApprovalType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[12]/div/div/input")
	public static WebElement penAppPendingWith;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div/button")
	public static WebElement penAppSearch;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
	public static WebElement penApplogout;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[11]/div/div/div/div")
	public static WebElement penApplogoutdrop;



}
