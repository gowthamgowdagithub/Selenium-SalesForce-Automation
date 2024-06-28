package com.training.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
protected WebDriver driver;
	
	public void launchBrowser(String browserName){
		switch(browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("The Chrome Browser is launched.");
			driver.manage().window().maximize();
			System.out.println("Window has been maximized.");
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("The Edge Browser is launched.");
			driver.manage().window().maximize();
			System.out.println("Window has been maximized.");
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("The FireFox Browser is launched.");
			driver.manage().window().maximize();
			System.out.println("Window has been maximized.");
			break;
			
		default:
			System.out.println("The unknown browser is launched.");
		}
	}
	
	public void getUrl(String url){
		driver.get(url);
		System.out.println("The application url has been entered.");
	}
	
	public void enterData(WebElement element, String data, String objectName) {
		if(element.isDisplayed()) {
		   element.clear();
			element.sendKeys(data);
			System.out.println("The "+data+" has been entered in "+objectName+" textbox.");
		}
		else {
			System.out.println("The "+objectName+" is not identified.");
		}
	}
	
	public void clickOnButtonOrBoxes(WebElement element, String objectName) {
		if(!element.isSelected()) {
			element.click();
			System.out.println("The "+objectName+" is clicked.");
		}
		else {
			System.out.println("The "+objectName+" is not visible.");
		}
	}
	
	public void clickOnButtonOrLinks(WebElement element, String objectName) {
		if(element.isDisplayed()) {
			element.click();
			System.out.println("The "+objectName+" is clicked.");
		}
		else {
			System.out.println("The "+objectName+" is not visible.");
		}
	}
	
	public void getErrorMessageDisplayed(WebElement element, String expectText){
		String actualText=element.getText();
		System.out.println(actualText);
		String expectedText=expectText;
		if(actualText.equals(expectedText)) {
			System.out.println("The actual and expected text are same.");
		}
		else {
			System.out.println("The actual and expected text are not same.");
		}
	}
	
	public void verifyElementIsDisplay(WebElement element, String dataExpected, String objectName) {
		if(element.isDisplayed()) {
			System.out.println("The "+objectName+" is displayed.");
			String actualText=element.getText();
		    System.out.println(actualText);
			String expectedText=dataExpected;
			if(actualText.equals(expectedText)) {
			System.out.println("The actual "+objectName+" is same as expected "+objectName+ ".");
			}
			else {
				System.out.println("The "+objectName+" is not displayed and expected text is not similar.");
			}
		}
	}
	
	public void verifyCheckedElementAreSelected(WebElement element, String objectName) {
		if(element.isSelected()) {
			System.out.println("The "+objectName+" check box is selected.");
		}
		else {
			System.out.println("The "+objectName+" check box is not selected.");
		}
	}
	
	public void waitForFewSeconds(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	public void closeBrowser() {
		driver.close();
		System.out.println("All the testCases are passed so browser is closed.");
	}
	
	public void closeAllTheBrowsers() {
		driver.quit();
		System.out.println("All the testCases are passed so browser is closed.");
	}
	
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		System.out.println("Wait has been added.");
	}
	
	public void explicitWait(WebElement element, int time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void performAction(WebElement element, String objectName) {
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		System.out.println("The "+objectName+" has been selected or clicked.");
	}
	
	public void windowAlertHandle(WebElement element, String data, String objectName) {
		element.click();
		System.out.println("The "+objectName+" is clicked.");
		Alert al=driver.switchTo().alert();
		String alertText=al.getText();
		System.out.println(alertText);
		String ExpectedAlertText=data;
		if(alertText.equals(ExpectedAlertText)) {
			System.out.println("The alert text are same.");
		}
		else {
			System.out.println("The alert text are not similar.");
		}
		al.accept();
		System.out.println("The Window pop is accepted.");
	}
	
	public void windowAlert() {
		Alert al=driver.switchTo().alert();
		String alertText=al.getText();
		System.out.println("The alert Text is: "+alertText);
		al.accept();
		System.out.println("The window alert has been accepted.");
	}
	
	public void promtAlertHandle(WebElement element, String textBoxData, String objectName) {
		element.click();
		System.out.println("The "+objectName+" pop up is clicked.");
		Alert alertHandle=driver.switchTo().alert();
		alertHandle.sendKeys(textBoxData);
		System.out.println("The data is entered inside the textbox.");
	}
	
	public void acceptAlert() {
		Alert al=driver.switchTo().alert();
		al.accept();
		System.out.println("The promt alert pop up is accepted.");
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		System.out.println("The promt alert pop up is cancled.");
	}
	
	public void getAllLinksUsingTagName(String tagName) {
		System.out.println("List of links are:");
		List<WebElement>allItems=driver.findElements(By.tagName(tagName));
		for(WebElement element:allItems) {
			if(element.isDisplayed()) {
				String elementName=element.getText();
				System.out.println(elementName);
			}	
		}
	}
	
	public void getAllItemsUsingXpath(String tagName) {
		System.out.println("List of items are:");
		List<WebElement>allItems=driver.findElements(By.xpath(tagName));
		for(WebElement element:allItems) {
			if(element.isDisplayed()) {
				String elementName=element.getText();
				System.out.println(elementName);
			}	
		}
	}
	
	public void verifyPageTitle(String titleExpected) {
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle=titleExpected;
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Both title are same.");
		}
		else {
			System.out.println("Both title are not same.");
		}
	}
	
	public void windowHandle(String windowName, String expectPageTitle) {
		String windowName1=driver.getWindowHandle();
		System.out.println("The parent window ID is: "+windowName1);
		String getPageTitle=driver.getTitle();
		String expectedPageTitle=expectPageTitle;
		if(getPageTitle.equals(expectedPageTitle)) {
			System.out.println("The title of open page title is: "+getPageTitle);
			System.out.println("The actual and expected page title are equal.");
		}
		else {
			System.out.println("The actual and expected page title are not equal");
		}	
	}
	
	public void windowHandles(String windowName, String expectPageTitle, String expectedPageUrl) {
		String parentWindow=driver.getWindowHandle();
		for (String allWindows : driver.getWindowHandles()) {
			if(!allWindows.equals(parentWindow)) {
				WebDriver childWindow=driver.switchTo().window(allWindows);
				System.out.println("The childWindows ID:"+childWindow);
				String getPageTitle=driver.getTitle();
				String expectedPageTitle=expectPageTitle;
				if(getPageTitle.equals(expectedPageTitle)) {
					System.out.println("The title of open page title is: "+getPageTitle);
					String currentUrl=driver.getCurrentUrl();
					String expectedUrl=expectedPageUrl;
					if(currentUrl.equals(expectedUrl)) {
						System.out.println("Both the url's are same: ");
						System.out.println("The current url is: "+currentUrl);
					}
					else {
						System.out.println("Both the url's are not same");
					}
					System.out.println("The actual and expected page title are equal.");
				}
				else {
					System.out.println("The actual and expected page title are not equal");
				}
			}
		}			
	}

	public void handleOuterFrame(WebElement element, String objectName) {
		if(element.isDisplayed()) {
			driver.switchTo().frame(element);
			System.out.println("The"+ objectName+" frame is identified and entered inside that");
		}
		else {
			System.out.println("There is no "+objectName+" present in the DOM.");
		}
	}
	
	public void handleInnerFrame(WebElement element, String objectName) {
		if(element.isDisplayed()) {
			driver.switchTo().frame(element);
			System.out.println("The"+ objectName+" frame is identified and entered inside that");
		}
		else {
			System.out.println("There is no "+objectName+" present in the DOM.");
		}
	}
	
	public void handleGetInfoFromFrame(WebElement element, String expectedFrameText) {
		if(element.isDisplayed()) {
			String actualText=element.getText();
			String expectedInnerFrameText=expectedFrameText;
			if(actualText.equals(expectedInnerFrameText)) {
				System.out.println("The actual Text extrated from the frame is : "+actualText);
				System.out.println("Both actual and expected text are same as we expect.");
			}
		}
		else {
			System.out.println("Both actual and expected text are not same as we expect.");
		}
	}
	
	public void getBackToDOM() {
		driver.switchTo().defaultContent();
		System.out.println("It came back to DOM from the frame..");
	}
	
	public void autoComplete(WebElement element1, String path, String countryWantToSelect, String expectedCountry) {
		element1.sendKeys(countryWantToSelect);
		
		List<WebElement>allItems=driver.findElements(By.xpath(path));
		for (WebElement country : allItems) {
			System.out.println("The selected country is:"+country.getText());
			if(country.getText().equalsIgnoreCase(expectedCountry)) {
				country.click();
				break;
			}
		}
	}
	
	public void handleTables(WebElement allTable, String path1, String path2) {
		List<WebElement>allheader=allTable.findElements(By.xpath(path1));
		for(WebElement dataPresent1:allheader) {
			System.out.println("The list of header are:");
			System.out.println(dataPresent1.getText()+" ");	
		}
		List<WebElement>allData=allTable.findElements(By.xpath(path2));
		for(WebElement dataPresent2:allData) {
			System.out.println("The list of data's are:");
			System.out.println(dataPresent2.getText()+" ");	
		}
	}
	
	public void getVisibleText(WebElement element) {
		String text=element.getText();
		System.out.println("The list of visible elements are:");
		System.out.println(text);
	}
	
	public void fileUpload(WebElement element, String path) {
		element.sendKeys(path);
		System.out.println("The file has been uploaded.");
	}
	
	public void getPageTitle(String Pagename) {
		String name=driver.getTitle();
		System.out.println("The"+ Pagename+" is displayed.");
		System.out.println("Current page title is: "+name);
	}
	
	public void selectDataFromDropDownByVisibleText(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);	
		System.out.println("The "+text+" has been selected form the dropdown.");
	}
	
	public void getCurrentURL(String expectedURL) {
		String currentUrl=driver.getCurrentUrl();
		System.out.println("The current url of the page is: "+currentUrl);
		String ExpectedUrl=expectedURL;
		if(currentUrl.equals(ExpectedUrl)) {
			System.out.println("The current and expected url are same.");
		}
		else {
			System.out.println("The current and expected url are not same.");
		}
	}
	
	public void selectDataFromDropDownUsingValue(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);	
		System.out.println("The "+value+" has been selected form the dropdown.");
	}
	
	public void selectDataFromDropDownUsingIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);	
		System.out.println("The "+index+" has been selected form the dropdown.");
	}
	
	public void getSelectedOption(WebElement element) {
		Select dropdown=new Select(element);
		WebElement ActualselectedOptions=dropdown.getFirstSelectedOption();
		System.out.println("The selected option is: "+ActualselectedOptions.getText());
	}
	
	public void getErrorMessage(WebElement element, String expected) {
		String actualText=element.getText();
		String expectedText=expected;
		System.out.println("The actual error message is: "+actualText);
		if(actualText.equals(expectedText)) {
			System.out.println("The actual and expected error message are same.");
		}
		else {
			System.out.println("The actual and expected error message are not same.");
		}
	}
	
	public void identifyRequiredElementFound(WebElement element, String expected) {
		String text=element.getText();
		System.out.println("The list of visible elements are:");
		System.out.println(text);
		String expectedText=expected;
		if(text.equalsIgnoreCase(expectedText)) {
			System.out.println("The element present inside the drop down.");
		}
		else {
			System.out.println("There is no such element found in drop down.");
		}
	}
	
	public void identifyItIsLinkOrNot(WebElement element, String objectname) {
		if("a".equals(element.getTagName())) {
			System.out.println("The "+objectname+" is a link.");
		}
		else {
			System.out.println("The "+objectname+" is not a link.");
		}
	}
}

