package com.nfa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		WebDriver driver;

		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//*[@id=\'select-Change language\']")
		public static WebElement languageChoice;		
			
		@FindBy(xpath="/html/body/div/div/div/form/div/div[2]/div/input[1]")
		public static WebElement userName;
		
		@FindBy(xpath="/html/body/div/div/div/form/div/div[2]/div/input[2]")
		public static WebElement passwd;	
		
		@FindBy(xpath="/html/body/div/div/div/form/div/div[2]/div/div[3]/div[1]/span/span[1]/input")
		public static WebElement clickTerms;
		
		@FindBy(xpath="/html/body/div/div/div/form/div/div[2]/div/div[5]/button")
		public static WebElement clickLogin;
		
		@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/a")
		public static WebElement logout;
		
		@FindBy(xpath="/html/body/div/div/div[1]/nav/div/div/div/div[2]/div/div[2]/ul/li/div/a")
		public static WebElement logoutdrop;
		
		
		
		
}

