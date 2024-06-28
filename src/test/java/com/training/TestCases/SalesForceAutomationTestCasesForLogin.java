package com.training.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.training.Utilities.Constants;
import com.training.Utilities.PropertyUtility;

public class SalesForceAutomationTestCasesForLogin extends BaseLogin{

	public static void main(String[] args) {
		SalesForceAutomationTestCasesForLogin ob=new SalesForceAutomationTestCasesForLogin();
		ob.TestCase1();
		ob.TestCase2();
		ob.TestCase3();
		ob.TestCase4();
		ob.TestCase5();

	}
	public void TestCase1() {
		launchBrowser("chrome");
		getUrl("https://login.salesforce.com/");
		implicitWait(10);
		
		String usernameData=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "username");
		WebElement username=driver.findElement(By.cssSelector("input#username"));
		enterData(username, usernameData, "username");
		
		WebElement password=driver.findElement(By.cssSelector("input#password"));
		enterData(password, "", "password");
		
		WebElement clickOnLoginButton=driver.findElement(By.id("Login"));
		clickOnButtonOrBoxes(clickOnLoginButton, "clickOnLoginButton");
		
		WebElement error=driver.findElement(By.cssSelector("div#error"));
		getErrorMessageDisplayed(error, "Please enter your password.");
		
		closeBrowser();
	}
	
	public void TestCase2() {
		login_salesForce();
		closeBrowser();
	}
	
	public void TestCase3() {
		launchBrowser("chrome");
		String url=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "url");
		getUrl(url);
		String usernameData=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "password");
		
		WebElement username=driver.findElement(By.cssSelector("input#username"));
		enterData(username, usernameData, "username");
		
		WebElement password=driver.findElement(By.cssSelector("input#password"));
		enterData(password, passwordData, "password");
		
		WebElement rememberMe=driver.findElement(By.xpath("//label[text()='Remember me']"));
		clickOnButtonOrBoxes(rememberMe, "rememberMe");
		
		WebElement clickOnLoginButton=driver.findElement(By.id("Login"));
		explicitWait(clickOnLoginButton, 10);
		clickOnButtonOrBoxes(clickOnLoginButton, "clickOnLoginButton");
		
		WebElement usermenu=driver.findElement(By.cssSelector("div[id=userNavButton]"));
		explicitWait(usermenu, 10);
		clickOnButtonOrBoxes(usermenu, "usermenu");
		
		WebElement logout=driver.findElement(By.xpath("//a[starts-with(@title,'Log')]"));
		explicitWait(logout, 40);
		clickOnButtonOrLinks(logout, "logout");
		
		WebElement userName=driver.findElement(By.xpath("//div[@id='username_container']/div"));
		explicitWait(userName, 40);
		verifyElementIsDisplay(userName, "katte@tekarch.com", "userName");
		
		WebElement rememberMeChecked=driver.findElement(By.cssSelector("input#rememberUn"));
		explicitWait(rememberMeChecked, 40);
		verifyCheckedElementAreSelected(rememberMeChecked, "rememberMeChecked");
		
		closeBrowser();
	}
	
	public void TestCase4() {
		launchBrowser("chrome");
		String url=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "url");
		getUrl(url);
		String usernameData=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "username");
		WebElement username=driver.findElement(By.cssSelector("input#username"));
		enterData(username, usernameData, "username");
		
		WebElement forgetPasswordLink=driver.findElement(By.xpath("//a[text()='Forgot Your Password?']"));
		clickOnButtonOrLinks(forgetPasswordLink, "forgetPasswordLink");
		
		WebElement username1=driver.findElement(By.xpath("//input[@id='un']"));
		enterData(username1, "katte@tekarch.com", "username1");
		
		WebElement submit=driver.findElement(By.xpath("//input[@id='continue']"));
		clickOnButtonOrLinks(submit, "submit");
		
		WebElement message=driver.findElement(By.xpath("//div[@class='message']"));
		getErrorMessageDisplayed(message, "We’ve sent you an email with a link to finish resetting your password. Can’t find the email? Try checking your spam folder. If you still can’t log in, have us resend the email or contact your Salesforce administrator.");
		
		explicitWait(message, 10);
		closeBrowser();
	}
	
	public void TestCase5() {
		launchBrowser("chrome");
		String url=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "url");
		getUrl(url);
		
		WebElement username=driver.findElement(By.cssSelector("input#username"));
		enterData(username, "123", "username");
		
		WebElement password=driver.findElement(By.cssSelector("input#password"));
		enterData(password, "22124", "password");
		
		WebElement clickOnLoginButton=driver.findElement(By.id("Login"));
		clickOnButtonOrBoxes(clickOnLoginButton, "clickOnLoginButton");
		
		WebElement error=driver.findElement(By.xpath("//div[@id='error']"));
		getErrorMessageDisplayed(error, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		
		explicitWait(error, 10);
		closeBrowser();
	}

}
