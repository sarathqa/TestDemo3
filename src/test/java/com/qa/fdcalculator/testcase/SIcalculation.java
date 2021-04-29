package com.qa.fdcalculator.testcase;

import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.fdcalculator.baseTest.baseTest;
import com.qa.fdcalculator.page.fdpage;

public class SIcalculation extends baseTest {
	
	
	@Test
	public static void calculationSI(){
		
	   fdpage fd= new fdpage(driver());
	   float interest=20000.00f;
	   DecimalFormat df = new DecimalFormat("0.00");
	   fd.simpleinterestcalculation("100000", "10", "2", "year(s)");
	   String actualinterest=fd.interestextract();
	   String expectedinterest="Interest earned Rs."+df.format(interest);	   
	   System.out.println(expectedinterest);
	   Assert.assertEquals(actualinterest, expectedinterest, "Interest are not matched");
		
		
	}

}
