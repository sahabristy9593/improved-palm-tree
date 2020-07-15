package com.banking.testCases;

import com.banking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {
		driver.get(baseURL);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager Homepage")) {
			Assert.assertTrue(true);
			logger.info("Login Test is Passed");
			
		}else {
			Assert.assertTrue(false);
			logger.info("Login Test is Failed");
		}
		
	}

}
