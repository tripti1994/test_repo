package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowAllPCN {
	WebDriver driver;

	public ShowAllPCN(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[1]/div/div/input")
	public static WebElement showAllNFANumber;		
		
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[2]/div/div/input")
	public static WebElement showAllCreationDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[3]/div/div/input")
	public static WebElement showAllFromDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[4]/div/div/input")
	public static WebElement showAllToDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[5]/div/div/input")
	public static WebElement showAllSubmitDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[6]/div/div/div/div")
	public static WebElement showAllPCNType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[7]/div/div/input")
	public static WebElement showAllNFASubType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[8]/div/div/div/div")
	public static WebElement showAllOPCO;

	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[9]/div/div/div/div")
	public static WebElement showAllFunction;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[10]/div/div/input")
	public static WebElement showAllNFATitle;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[11]/div/div/div/div")
	public static WebElement showAllApprovalType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[12]/div/div/input")
	public static WebElement showAllPendingWith;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div/button")
	public static WebElement showAllSearch;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
	public static WebElement showAlllogout;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[11]/div/div/div/div")
	public static WebElement showAlllogoutdrop;


}
