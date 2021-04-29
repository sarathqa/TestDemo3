package com.qa.fdcalculator.baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.fdcalculator.browserinit.browserInitization;

public class baseTest {
	
	
	static ThreadLocal<WebDriver>  drivers= new ThreadLocal<WebDriver>();
	static String url="https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html";
	
	@BeforeMethod
	public static void setup(){
	
		WebDriver driver=browserInitization.browserinit();
		drivers.set(driver);
		driver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver().manage().window().maximize();
		driver().get(url);
		
	}
	
	protected static WebDriver driver(){
		return drivers.get();
	}
	
	@AfterMethod
	public static void tear(){
		
	  driver().close();
	}

}
