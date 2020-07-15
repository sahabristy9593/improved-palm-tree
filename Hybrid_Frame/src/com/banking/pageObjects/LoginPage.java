package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver ldriver;
	LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initelements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	webElement txtUsername;
	
	@FindBy(name="password")
	webElement txtPassword;
	
	@FindBy(name="btnLogin")
	webElement btnLogin;
	
	public void setUserName(String uname) {
		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtUsername.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
}
