package com.qa.fdcalculator.testcase;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.fdcalculator.baseTest.baseTest;
import com.qa.fdcalculator.page.fdpage;
import com.qa.utiles.dbOperation;

public class SIcalculation2 extends baseTest {
	
	
	
	@Test
	public static void calculationSI(){
		
	   fdpage fd= new fdpage(driver());
	   float interest=20000.00f;
	   DecimalFormat df = new DecimalFormat("0.00");
	   dbOperation.connectionsetup();
       LinkedHashMap<Integer, LinkedHashMap<String, String>> lhm= new LinkedHashMap<Integer, LinkedHashMap<String, String>>();
       lhm=dbOperation.executequery("SELECT * FROM automationdb.fdcalculator");
       for(int i=1;i<=lhm.size();i++){
	   fd.simpleinterestcalculation(lhm.get(i).get("principal"),lhm.get(i).get("rate"), lhm.get(i).get("year"), lhm.get(i).get("mode"));
	   String actualinterest=fd.interestextract().replace("Interest earned Rs.", " ");
	   String totalinvestedt=fd.totalinvested().replace("You Invested Rs. ", " ");
	   String totalamnt=fd.totalamount();
	   System.out.println("actualinterest "+ actualinterest);
	   System.out.println("totalinvested "+ totalinvestedt);
	   System.out.println("totalamnt "+ totalamnt);
	   
	   dbOperation.executeupdates("Update automationdb.fdcalculator_output set `Total_amoumt` = "+totalamnt+", `interest_earned` = "+actualinterest+", `Amountinvested` = "+totalinvestedt+" where `S.no`= "+i+"");
	//   dbOperation.executeupdates("Update automationdb.fdcalculator_output set (`Total_amoumt` = `"+totalamnt+"`, `interest_earned` = `"+actualinterest+"`, `Amountinvested` = `"+totalinvestedt+"` where `S.no `= `"+i+"`)");
	   String expectedinterest="Interest earned "+df.format(interest);	   
	   System.out.println(expectedinterest);
	   
	  // Assert.assertEquals(actualinterest, expectedinterest, "Interest are not matched");
   
   }
	   
		
		
	}

}
