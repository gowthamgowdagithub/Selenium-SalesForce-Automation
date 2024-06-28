package com.training.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.training.Utilities.Constants;
import com.training.Utilities.PropertyUtility;

public class BaseLogin extends BaseTest{
	public void login_FireBase() {
		launchBrowser("chrome");
		String url=PropertyUtility.readDataFromTheFile(Constants.FIREBASE_PROPERTIES, "url");
		getUrl(url);
		implicitWait(10);
		
		String usernameData=PropertyUtility.readDataFromTheFile(Constants.FIREBASE_PROPERTIES, "username");
		String passwordData=PropertyUtility.readDataFromTheFile(Constants.FIREBASE_PROPERTIES, "password");
		
		WebElement username=driver.findElement(By.id("email_field"));
		explicitWait(username, 10);
		username.sendKeys(usernameData);
		System.out.println("Username has been entered to the email_id textbox.");
		
		WebElement password=driver.findElement(By.id("password_field"));
		explicitWait(password, 10);
		password.sendKeys(passwordData);
		System.out.println("Password has been entered inside the password_field.");
		
		WebElement login=driver.findElement(By.xpath("//button[text()='Login to Account']"));
		login.click();
	}

	public void login_salesForce() {
		launchBrowser("chrome");
		String url=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "url");
		getUrl(url);
		String usernameData=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData=PropertyUtility.readDataFromTheFile(Constants.APPLICATION_PROPERTIES, "password");
		implicitWait(10);
		
		WebElement username=driver.findElement(By.cssSelector("input#username"));
		enterData(username, usernameData, "Username");
		
		WebElement password=driver.findElement(By.cssSelector("input#password"));
		enterData(password, passwordData, "Password");
		
		WebElement clickOnLoginButton=driver.findElement(By.id("Login"));
		clickOnButtonOrBoxes(clickOnLoginButton, "clickOnLoginButton");
	}
}
