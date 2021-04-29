package com.qa.fdcalculator.browserinit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserInitization {
	
	public static WebDriver driver= null;
	
	public static WebDriver browserinit(){
		
		String browsername="Chrome";
		String url="URL: https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html";
		
		if(browsername==""){
			System.out.println("Please provide the browser in config file");
		}
		else if(browsername.equalsIgnoreCase("chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		    
		}
		
        else if(browsername.equalsIgnoreCase("Firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		
		}
		
		
		return driver;

	}
	
	
	public static void main(String[] args) {
		browserinit();
	}

}
