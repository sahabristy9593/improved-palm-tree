package com.banking.testCases;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() {
		LoginPage lp = new LoginPage(driver);
		logger.info("Provided the username");
		lp.setUserName(username);
		
		lp.setPassword(password);
		logger.info("Provided the password");
		lp.clickSubmit();
		
		logger.info("Submitted");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		logger.info("Providing the customer details");
		
		addcust.custaddress("Shapoorji, Newtown");
		addcust.custcity("Kolkata");
		addcust.custstate("WB");
		addcust.custdob("09", "05", "93");
		addcust.custphonenb("7897897890");
		
		addcust.custgender("Female");
		
		
		
		String email=randomeString()+"@gmail.com";
		addcust.custemail(email);
		
		Thread.sleep(3000);
		
		logger.info("Validation Started");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		}
		else {
			captureScreen(driver,"addNewCustomer")
			Assert.assertTrue(false);
			logger.info("Testcase failed");
		}
		
	}
	
	
	
//	public String randomeString() {
//		String generatedString=RandomStringUtils.randomAlphabetic(8);
//		return(generatedString);
//	}
//	
//	public String randomeNum() {
//		String generatedString2=RandomStringUtils.randomNumeric(4);
//		return(generatedString2);
//	}

}
