package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[1]/a")
	public static WebElement homeLink;		
		
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/a")
	public static WebElement menu;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[1]/a")
	public static WebElement myRequest;	
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[2]/a")
	public static WebElement mrpcn;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[3]/a[1]")
	public static WebElement mrpcnReport;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[3]/a[2]")
	public static WebElement mrapproverWise;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[3]/a[3]")
	public static WebElement mrNFAPendingWith;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[3]/a[3]")
	public static WebElement mrinputNFANumber;
	
	@FindBy(xpath="//*[@id=\"select-nfaStatus\"]")
	public static WebElement mrnfaStatus;	
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[1]")
	public static WebElement mrnfaStatusSelect;
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[2]")
	public static WebElement mrnfaStatusDraft;
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[3]")
	public static WebElement mrnfaStatusUnderAprooval;
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[4]")
	public static WebElement mrnfaStatusAprooved;
	
	@FindBy(xpath="//*[@id=\\\"menu-nfaStatus\\\"]/div[2]/ul/li[5]")
	public static WebElement mrnfaStatusWithdrawn;	
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[6]")
	public static WebElement mrnfaStatusRejected;
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[7]")
	public static WebElement mrnfaStatusNew;
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[8]")
	public static WebElement mrnfaStatusRecommended;
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[9]")
	public static WebElement mrnfaStatusNotRecommended;
	
	@FindBy(xpath="//*[@id=\"menu-nfaStatus\"]/div[2]/ul/li[10]")
	public static WebElement mrnfaStatusReferredBack;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[1]/div[3]/div/div/input")
	public static WebElement mrCreationDate;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[1]/div[4]/div/div/input")
	public static WebElement mrFromDate;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[1]/div[5]/div/div/input")
	public static WebElement mrToDate;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[1]/div[6]/div/div/input")
	public static WebElement mrsubmittedBy;
	
	@FindBy(xpath="//*[@id=\"select-nfaType\"]")
	public static WebElement mrnfaType;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[1]/div[8]/div/div/input")
	public static WebElement mrnfaSubtype;
	
	@FindBy(xpath="//*[@id=\"select-OpCo\"]")
	public static WebElement mropco;
	
	@FindBy(xpath="//*[@id=\"select-function\"]")
	public static WebElement mrfunction;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[1]/div[11]/div/div/input")
	public static WebElement mrnfaTitle;
	
	@FindBy(xpath="//*[@id=\"select-approvalType\"]")
	public static WebElement mrapprovalType;
	
	@FindBy(xpath="//*[@id=\"menu-approvalType\"]/div[2]/ul/li[2]")
	public static WebElement mrapprovalTypeOpco;
	
	@FindBy(xpath="//*[@id=\"menu-approvalType\"]/div[2]/ul/li[3]")
	public static WebElement mrapprovalTypeOpcoGroup;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[1]/div[13]/div/div/input")
	public static WebElement mrpendingWith;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[2]/div/button")
	public static WebElement mrsearch;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/table")
	public static WebElement mrlistedNFA;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[12]/div/a[1]")
	public static WebElement viewpcn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[12]/div/a[2]")
	public static WebElement updatepcn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div[3]/button")
	public static WebElement updatepcnwithdraw;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[12]/div/a[3]")
	public static WebElement copypcn;
	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div[1]/button")
	public static WebElement copypcnsave;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div[2]/button")
	public static WebElement copypcnsubmit;
				
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[2]")
	public static WebElement copypcnalertmsg;
	
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[3]/button")
	public static WebElement copypcnalertmsgclose;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[12]/div/a[4]")
	public static WebElement auditpcn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody[1]/tr/td[5]/a")
	public static WebElement auditpcndetails;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/div/div/div[1]/button/span[1]")
	public static WebElement auditpcndetailsclose;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[12]/div/a[4]")
	public static WebElement downloadpcn;
	
	
	
	

}
