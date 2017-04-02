package com.companyname.projectname.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.companyname.projectname.Data.Xls_Reader;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class Resources {
	
	
	public static WebDriver dr;
	public static EventFiringWebDriver driver;
	public static Properties Repository = new Properties();
	public static Properties Config = new Properties();
	public static Properties AppText = new Properties();
	public static Xls_Reader SuiteData;
	public static Xls_Reader TestStepData;

	public static String keyword;
	public static String webElement;
	public static String TestDataField;
	public static String TestData;
	public static String ProceedOnFail;
	public static String TSID;
	public static String Description;
	public static File f ;
	public static FileInputStream FI;
	
	public static void Initialize() throws IOException {
		
		TestStepData = new Xls_Reader(System.getProperty("user.dir")+"//src//test//java//com//companyname//projectname//Data//TestSuite1Data.xlsx");
		SuiteData = new Xls_Reader(System.getProperty("user.dir")+"//src//test//java//com//companyname//projectname//Data//TestSuite1.xlsx");
		System.out.println(System.getProperty("user.dir"));
		
		f = new File(System.getProperty("user.dir")+"//src//test//java//com//companyname//projectname//repository//login.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"//src//test//java//com//companyname//projectname//repository//creatAnAccount.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
	}
	
	public static void main(String[] args) throws IOException {
		Initialize();	
	}
	
}
