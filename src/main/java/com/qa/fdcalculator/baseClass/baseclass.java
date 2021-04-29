package com.qa.fdcalculator.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class baseclass  extends commonfunction{
	
	private static WebDriver driver;
	
	public baseclass(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	protected static WebDriver getDriver(){
		return driver;
	}
	
	

}
