package com.qa.fdcalculator.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.fdcalculator.baseClass.baseclass;

public class fdpage extends baseclass {

	
	@FindBy(id="principal")
	WebElement prinicipal;
	
	@FindBy(id="interest")
	WebElement interest;
	
	@FindBy(id="tenure")
	WebElement period;
	
	@FindBy(id="tenurePeriod")
	WebElement tenureperiod;
	
	@FindBy(id="frequency")
	WebElement frequency;
	
	@FindBy(xpath="//*[@id='fdMatVal']//div[2]/a[1]")
	WebElement calculatebtn;
	
	@FindBy(xpath="//*[@id='resp_intval']/em")
	WebElement actinterest;
	
	@FindBy(id="resp_prin")
	WebElement invested;
	
	@FindBy(id="resp_matval")
	WebElement totalamnt;
	
	
	public fdpage(WebDriver driver) {
		super(driver);
		
	}
	
	
   public  void simpleinterestcalculation(String prinicipalamount, String rate, String year, String mode){
	   prinicipal.clear();
	   prinicipal.sendKeys(prinicipalamount);
	   interest.clear();
	   interest.sendKeys(rate);
	   period.clear();
	   period.sendKeys(year);
	   selectOperation(tenureperiod, mode);
	   selectOperation(frequency,"Simple Interest");
	   calculatebtn.click();
   }
   
   public String interestextract(){
	   
	   return actinterest.getText();   
	   
   }
   
   public String totalamount(){
	   
	   return totalamnt.getText();   
	   
   }
   
   public String totalinvested(){
	   
	   return invested.getText();   
	   
   }
	
	

}
