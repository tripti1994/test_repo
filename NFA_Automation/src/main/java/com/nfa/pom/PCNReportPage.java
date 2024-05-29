package com.nfa.pom;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PCNReportPage {
	
	WebDriver driver;
	Robot orobot;

	public PCNReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"select-function\"]")
	public static WebElement pcnrFunction;		
		
	@FindBy(xpath="//*[@id=\"select-entity\"]")
	public static WebElement pcnrEntity;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/form/div[2]/div/button")
	public static WebElement pcnrSubmit;
	
	@FindBy(how = How.XPATH, using="/html/body/div/div/div[2]/form/div[3]/div/a")
	public static WebElement pcnrExportExcel;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table")
	public static WebElement pcnrReportList;	
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]")
	public static WebElement pcnrReportListrow;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
	public static WebElement pcnrReportlogout;
	
	@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/div/a")
	public static WebElement pcnrReportlogoutdrop;
	
	public void downloadReport() {
		orobot.keyPress(KeyEvent.VK_TAB);
		orobot.keyPress(KeyEvent.VK_TAB);
		orobot.keyPress(KeyEvent.VK_TAB);
		orobot.keyPress(KeyEvent.VK_ENTER);
	}
	

}
