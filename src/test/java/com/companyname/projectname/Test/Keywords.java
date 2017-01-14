package com.companyname.projectname.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.companyname.projectname.Utils.Resources;
import com.google.common.base.Function;

public class Keywords extends Resources{
	
	public static String Navigate() {
		System.out.println("Navigate is called");
		driver.get(webElement);		
		return "Pass";
	}

	public static String selectRadioButton() {
		System.out.println("InputText is called");
		try {
			getWebElement(webElement).click();;
		}catch (Throwable t) {
			return "Failed - Element not found "+webElement;
		}
		return "Pass";
	}
	
	public static String InputText() {
		System.out.println("InputText is called");
		try {
			getWebElement(webElement).sendKeys(TestData);
		}catch (Throwable t) {
			return "Failed - Element not found "+webElement;
		}
		return "Pass";
	}
	
	
	
	public static String ClickOnLink() {
		System.out.println("ClickOnLink is called");
		try {
			getWebElement(webElement).click();
		}catch (Throwable t) {
			t.printStackTrace();
			return "Failed - Element not found "+webElement;
		}
		return "Pass";
	}

	public static String VerifyText() {
		System.out.println("VerifyText is called");
		try {
			String ActualText= getWebElement(webElement).getText();
			if(!ActualText.equals(TestData)) {
				return "Failed - Actual text "+ActualText+" is not equal to to expected text "+AppText.getProperty(webElement);
			}
		}catch (Throwable t) {
			return "Failed - Element not found "+webElement;
		}
		return "Pass";
	}

	public static String VerifyAppText() {
		System.out.println("VerifyText is called");
		try {
			String ActualText= getWebElement(webElement).getText();
			if(!ActualText.equals(AppText.getProperty(webElement))) {
				return "Failed - Actual text "+ActualText+" is not equal to to expected text "+AppText.getProperty(webElement);
			}
		}catch (Throwable t) {
			return "Failed - Element not found "+webElement;
		}
		return "Pass";
	}
	
	public static String selectDaysInDropDown() throws Exception{
		try {
			System.out.println("clicking on day drop down");
			getWebElement(Repository.getProperty("registration.days")).click();
			Thread.sleep(1000);
			String day1 = "//*[@id='days']/option[";
			String day2 = "]";
			System.out.println("selecting day in day day drop down");
			driver.findElement(By.xpath(day1 + TestData + day2)).click();
		} catch (Exception e) {
			return "Failed - unable to select day in dropdown";
		}
		return "Pass";
	}
	
	public static String selectMonthInDropDown() throws Exception{
		try {
			System.out.println("clicking on month drop down");
			getWebElement(Repository.getProperty("registration.months")).click();
			Thread.sleep(1000);
			List<WebElement> monthsData = driver.findElements(By.xpath("//*[@id='months']/option"));
			for (WebElement mon : monthsData) {
				if (mon.getText().trim().toLowerCase().equals(TestData.toLowerCase())) {
					System.out.println("selecting month in month drop down");
					mon.click();
				}
			}
		} catch (Exception e) {
			return "Failed - unable to select month in dropdown";
		}
		return "Pass";
	}
	
	public static String selectYearInDropDown() throws Exception{
		try {
			System.out.println("clicking on year drop down");
			getWebElement(Repository.getProperty("registration.year")).click();
			Thread.sleep(1000);
			List<WebElement> years = driver.findElements(By.xpath("//*[@id='years']/option"));
			for (WebElement year : years) {
				if (year.getText().trim().equals(TestData)) {
					System.out.println("clickin on year option");
					year.click();
				}
			}
		} catch (Exception e) {
			return "Failed - unable to select year in dropdown";
		}
		return "Pass";
	}
	
	public static String selectYourAddressCountry() throws Exception{
		try {
			System.out.println("clicking on your Address Country Name");
			getWebElement("registration.yourAddressCountryName").click();
			Thread.sleep(1000);
			System.out.println("selecting Country Name");
			driver.findElement(By.xpath("//*[@id='id_country']/option[2]")).click();
		} catch (Exception e) {
			return "Failed - unable to select country in dropdown";
		}
		return "Pass";
	}
	
   /**
    * This Method will return web element.
    * @param locator
    * @return
    * @throws Exception
    */
	public static WebElement getLocator(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public static List<WebElement> getLocators(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public static WebElement getWebElement(String locator) throws Exception{
		System.out.println("locator data:-"+locator+"is---"+Repository.getProperty(locator));
		return getLocator(Repository.getProperty(locator));
	}
	
	public static List<WebElement> getWebElements(String locator) throws Exception{
		return getLocators(Repository.getProperty(locator));
	}
	
	public void expliciteWait() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getWebElement(webElement)));
	}
	
	/*
	public static String expliciteWait(){
     try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		return "Failed - unable to load the page";
	}
     return "Pass";
	}
	*/
	public static void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

		}
	}

	public static void clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

	}

	public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});

		return element;
	};

	public static WebElement getWhenVisible(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;

	}
	
	public static String waitFor() throws InterruptedException {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			return "Failed - unable to load the page";
		}
		return "Pass";
	}
	
	public static void closeBrowser(){
		driver.quit();
	}
	
}
