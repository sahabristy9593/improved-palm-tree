package com.banking.testCases;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd){
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warning("Login Failed");
		}else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			driver.SwitchTo().alert().accept();
			driver.SwitchTo().defaultContent();
		}
		
	}
	
	
	
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"";
				
				int rownum = XLUtils.getRowCount(path, "Sheet1");
		        int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		        
		        String logindata[][]=new String [rownum][colcount];
		        
		        for(int i=1;i<rownum;i++) {
		        	for(int j=1;j<colcount;j++) {
		        		logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i,j);//1,0
		        	}
		        }
		        
		        return logindata;
	}

}
