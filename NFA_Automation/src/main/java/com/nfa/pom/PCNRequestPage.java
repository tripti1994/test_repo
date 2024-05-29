package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PCNRequestPage {
	
	WebDriver driver;

	public PCNRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
	public static WebElement pcnlogout;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/div/a")
	public static WebElement pcnlogoutdrop;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[1]/div[1]/div/div/input")
	public static WebElement pcnNFATitle;		
		
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[2]/div[1]/div/div/input")
	public static WebElement pcnNFANumber;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[2]/div[2]/div/div/input")
	public static WebElement pcnCreatedBy;
	
	@FindBy(xpath="//*[@id=\"select-entity\"]")
	public static WebElement pcnEntity;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[3]/div[1]/div/div/input")
	public static WebElement pcnSubmissionDate;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[3]/div[2]/div/div/input")
	public static WebElement pcnOwner;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[3]/div[2]/div/div/input")
	public static WebElement pcnFunction;
	
	@FindBy(xpath="//*[@id=\"select-productType\"]")
	public static WebElement pcnProductType;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[1]")
	public static WebElement pcnProductTypeSelect;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[2]")
	public static WebElement pcnProductTypeVoice;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[3]")
	public static WebElement pcnProductTypeData;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[4]")
	public static WebElement pcnProductTypeVAS;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[5]")
	public static WebElement pcnProductTypeCombo;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[6]")
	public static WebElement pcnProductTypeInterConnect;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[7]")
	public static WebElement pcnProductTypeDevice;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[8]")
	public static WebElement pcnProductTypeDeviceSubsidy;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[9]")
	public static WebElement pcnProductTypeRoaming;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[10]")
	public static WebElement pcnProductTypeIDD;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[11]")
	public static WebElement pcnProductTypeAcquisitionOffer;
	
	@FindBy(xpath="//*[@id=\"menu-productType\"]/div[2]/ul/li[12]")
	public static WebElement pcnProductTypeDigital;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[4]/div[2]/div/div/input")
	public static WebElement pcnNFAEndDate;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[4]/div[3]/span/span[1]/input")
	public static WebElement pcnPermanentCheckBox;
		
	@FindBy(xpath="//*[@id=\"select-targetType\"]")
	public static WebElement pcnTargetType;
	
	@FindBy(xpath="//*[@id=\"menu-targetType\"]/div[2]/ul/li[1]")
	public static WebElement pcnTargetTypeOpenMarket;
	
	@FindBy(xpath="//*[@id=\"menu-targetType\"]/div[2]/ul/li[2]")
	public static WebElement pcnTargetTypeSegmented;
	
	@FindBy(xpath="//*[@id=\"menu-targetType\"]/div[2]/ul/li[3]")
	public static WebElement pcnTargetTypeOpenMarketSegmented;
	
	@FindBy(xpath="//*[@id=\"menu-targetType\"]/div[2]/ul/li[4]")
	public static WebElement pcnTargetTypeAMBundles;
	
	@FindBy(xpath="//*[@id=\"select-contractType\"]")
	public static WebElement pcnContractType;
	
	@FindBy(xpath="//*[@id=\"menu-contractType\"]/div[2]/ul/li[1]")
	public static WebElement pcnContractTypeSelect;
	
	@FindBy(xpath="//*[@id=\"menu-contractType\"]/div[2]/ul/li[2]")
	public static WebElement pcnContractTypePrepaid;
	
	@FindBy(xpath="//*[@id=\"menu-contractType\"]/div[2]/ul/li[3]")
	public static WebElement pcnContractTypePostpaid;
	
	@FindBy(xpath="//*[@id=\"menu-contractType\"]/div[2]/ul/li[4]")
	public static WebElement pcnContractTypeHybrid;
	
	@FindBy(xpath="//*[@id=\"menu-contractType\"]/div[2]/ul/li[5]")
	public static WebElement pcnContractTypeNA;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[5]/div[3]/div/div/input")
	public static WebElement pcnBusinessImpact;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[6]/div[1]/div/div/input")
	public static WebElement pcnArpuImpact;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[6]/div[2]/div/div/input")
	public static WebElement pcnExpectedLauchDate;
	
	@FindBy(xpath="//*[@id=\"select-segment\"]")
	public static WebElement pcnSegment;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[7]/div[1]/div/div/textarea")
	public static WebElement pcnEnterProblem;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[7]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterProblemAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[8]/div[1]/div/div/textarea")
	public static WebElement pcnEnterDataToSupport;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[8]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterDataToSupportAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[9]/div[1]/div/div/textarea")
	public static WebElement pcnEnterBackground;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[9]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterBackgroundAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[10]/div[1]/div/div/textarea")
	public static WebElement pcnEnterOptionConsidered;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[10]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterOptionConsideredAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[11]/div[1]/div/div/textarea")
	public static WebElement pcnEnterSegmentDetails;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[11]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterSegmentDetailsAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[12]/div[1]/div/div/textarea")
	public static WebElement pcnEnterCompOffer;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[12]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterCompOfferAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[13]/div[1]/div/div/textarea")
	public static WebElement pcnEnterProductOffer;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[13]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterProductOfferAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[14]/div[1]/div/div/textarea")
	public static WebElement pcnEnterGTMPlan;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[14]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterGTMPlanAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[15]/div[1]/div/div/textarea")
	public static WebElement pcnEnterBusinessImpact;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[15]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterBusinessImpactAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[16]/div[1]/div/div/textarea")
	public static WebElement pcnEnterKeyKPI;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[16]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterKeyKPIAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[17]/div[1]/div/div/textarea")
	public static WebElement pcnEnterKeyMilestone;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[17]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterKeyMilestoneAttachFile;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/fieldset/div[18]/div[1]/div/div/textarea")
	public static WebElement pcnEnterAdditionalNotes;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[18]/div[2]/div[1]/div[2]/label/span[1]/input")
	public static WebElement pcnEnterAdditionalNotesAttachFile;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[19]/div/table/tbody/tr/td[1]/div/div/input")
	public static WebElement pcnEntercrdrUom;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[19]/div/table/tbody/tr/td[2]/div/div/input")
	public static WebElement pcnEntercrdrMonth1;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[19]/div/table/tbody/tr/td[3]/div/div/input")
	public static WebElement pcnEntercrdrMonth2;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[19]/div/table/tbody/tr/td[4]/div/div/input")
	public static WebElement pcnEntercrdrMonth3;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[19]/div/table/tbody/tr/td[5]/div/div/input")
	public static WebElement pcnEntercrdrMonth4;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[19]/div/table/tbody/tr/td[6]/div/div/input")
	public static WebElement pcnEntercrdrMonth5;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[19]/div/table/tbody/tr/td[7]/div/div/input")
	public static WebElement pcnEntercrdrCurrentMonth;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[21]/div/table/tbody/tr/td[1]/div/div/input")
	public static WebElement pcnEnterarpuUom;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[21]/div/table/tbody/tr/td[2]/div/div/input")
	public static WebElement pcnEnterarpuMonth1;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[21]/div/table/tbody/tr/td[3]/div/div/input")
	public static WebElement pcnEnterarpuMonth2;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[21]/div/table/tbody/tr/td[4]/div/div/input")
	public static WebElement pcnEnterarpuMonth3;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[21]/div/table/tbody/tr/td[5]/div/div/input")
	public static WebElement pcnEnterarpuMonth4;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[21]/div/table/tbody/tr/td[6]/div/div/input")
	public static WebElement pcnEnterarpuMonth5;
	
	@FindBy(xpath="/html/body/div/div/div[2]/form/fieldset/div[21]/div/table/tbody/tr/td[7]/div/div/input")
	public static WebElement pcnEnterarpuCurrentMonth;	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[2]/div[1]/button")
	public static WebElement pcnSave;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[2]/div[2]/button")
	public static WebElement pcnSubmit;
	
	/*@FindBy(xpath="/html/body/div/div/div[2]/form/div[1]/div[5]/div/div/input")
	public static WebElement dates; */
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[2]/div")
	public static WebElement pcnSubmitAlertText;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[3]/button")
	public static WebElement pcnSubmitAlertOK;
	
	
	
}
