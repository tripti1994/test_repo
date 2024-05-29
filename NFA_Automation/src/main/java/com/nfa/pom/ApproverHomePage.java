package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApproverHomePage {
	
	WebDriver driver;

	public ApproverHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[1]/div/div/input")
	public static WebElement apprNFANumber;		
		
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[2]/div/div/input")
	public static WebElement apprCreationDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[3]/div/div/input")
	public static WebElement apprFromDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[4]/div/div/input")
	public static WebElement apprToDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[5]/div/div/input")
	public static WebElement apprSubmitDate;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[6]/div/div/div/div")
	public static WebElement apprPCNType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[7]/div/div/input")
	public static WebElement apprNFASubType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[8]/div/div/div/div")
	public static WebElement apprOPCO;

	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[9]/div/div/div/div")
	public static WebElement apprFunction;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[10]/div/div/input")
	public static WebElement apprNFATitle;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[11]/div/div/div/div")
	public static WebElement apprApprovalType;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[12]/div/div/input")
	public static WebElement apprPendingWith;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[2]/div/button")
	public static WebElement apprSearch;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
	public static WebElement apprlogout;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[11]/div/div/div/div")
	public static WebElement apprlogoutdrop;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/a")
	public static WebElement apprMenu;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[1]/a[1]")
	public static WebElement apprMenuPendingApproval;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[1]/a[2]")
	public static WebElement apprMenuShowAllPCN;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[1]/ul/li[2]/div/div[1]/a[3]")
	public static WebElement apprMenuCompletedAprroval;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[12]/div/a[1]")
	public static WebElement reviewPCN;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[12]/div/a[2]")
	public static WebElement downloadPCN;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[4]/div[2]/button")
	public static WebElement reviewPCNApprove;
	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[4]/div[5]/button")
	public static WebElement reviewPCNReject;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/div[4]/div[4]/button")
	public static WebElement reviewPCNReferBack;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[2]/div")
	public static WebElement reviewPCNApproveAlert;	
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[3]/button")
	public static WebElement reviewPCNApproveAlertOK;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[5]/div/div[2]/div/div/label/input")
	public static WebElement reviewPCNReferRadioButton;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[5]/div/div[1]/button")
	public static WebElement reviewPCNReferRadioButtonClose;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[5]/div/div[3]/button")
	public static WebElement reviewPCNRefereRadioButtonContinue;
		
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[2]/div")
	public static WebElement reviewPCNRefereRadioButtonContinueAlert;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[3]/button")
	public static WebElement reviewPCNRefereRadioButtonContinueAlertOk;
	
	@FindBy(xpath="/html/body/div/div/div[2]/p")
	public static WebElement noRecordFound;
	
}
