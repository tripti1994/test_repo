package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedApproval {
	WebDriver driver;

	public CompletedApproval(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[1]/div/div/input")
	public static WebElement comapprNFANumber;		
		
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[2]/div/div/input")
	public static WebElement comapprCreationDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[3]/div/div/input")
	public static WebElement comapprFromDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[4]/div/div/input")
	public static WebElement comapprToDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[5]/div/div/input")
	public static WebElement comapprSubmitDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[6]/div/div/div/div")
	public static WebElement comapprPCNType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[7]/div/div/input")
	public static WebElement comapprNFASubType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[8]/div/div/div/div")
	public static WebElement comapprOPCO;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[9]/div/div/div/div")
	public static WebElement comapprFunction;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[10]/div/div/input")
	public static WebElement comapprNFATitle;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[11]/div/div/div/div")
	public static WebElement comapprApprovalType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[12]/div/div/input")
	public static WebElement comapprPendingWith;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div/button")
	public static WebElement comapprSearch;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
	public static WebElement comapprlogout;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[11]/div/div/div/div")
	public static WebElement comapprlogoutdrop;


}
