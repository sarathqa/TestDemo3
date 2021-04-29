package com.qa.fdcalculator.baseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class commonfunction {

	
	
	public static void selectOperation(WebElement element, String Value){
		
		Select sel= new Select(element);
		sel.selectByVisibleText(Value);
		
	}
}
