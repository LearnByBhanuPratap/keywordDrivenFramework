package com.companyname.projectname.uiActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.companyname.projectname.Test.Keywords;
import com.companyname.projectname.Utils.Resources;

public class RegistrationPage extends Resources{
	
	public String selectDaysInDropDown() throws Exception{
		try {
			System.out.println("clicking on day drop down");
			Keywords.getWebElement(Repository.getProperty("registration.days")).click();
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
	
	public String selectMonthInDropDown() throws Exception{
		try {
			System.out.println("clicking on month drop down");
			Keywords.getWebElement(Repository.getProperty("registration.months")).click();
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
	
	public String selectYearInDropDown() throws Exception{
		try {
			System.out.println("clicking on year drop down");
			Keywords.getWebElement(Repository.getProperty("registration.year")).click();
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
	
	public String selectYourAddressCountry() throws Exception{
		try {
			System.out.println("clicking on your Address Country Name");
			Keywords.getWebElement("registration.yourAddressCountryName").click();
			Thread.sleep(1000);
			System.out.println("selecting Country Name");
			driver.findElement(By.xpath("//*[@id='id_country']/option[2]")).click();
		} catch (Exception e) {
			return "Failed - unable to select country in dropdown";
		}
		return "Pass";
	}
	

}
