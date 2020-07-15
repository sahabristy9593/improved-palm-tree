package com.banking.pageObjects;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public  AddCutomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElement(rdriver, this);
		
	}
	
	
	@FindBy(how = How.NAME, using="address");
	WebElement txtaddress;
	
	@FindBy(how = How.NAME, using="city");
	WebElement txtcity;
	
	@FindBy(how = How.NAME, using="state");
	WebElement txtstate;
	
	@FindBy(how = How.ID, using="BirthDate");
	WebElement txtdob;
	
	@FindBy(how = How.ID, using="c_phonenumber");
	WebElement txtphonenb;
	
	@FindBy(how = How.ID, using="c_email");
	WebElement txtemail;
	
	
	@FindBy(how = How.ID, using="c_gender");
	WebElement txtgender;
	
		
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		
		txtcity.sendKeys(ccity);
	}
	
    public void custstate(String cstate) {
		
		txtstate.sendKeys(cstate);
	}
    public void custdob(String mm, String dd,String yy) {
    	txtdob.sendkeys(mm);
    	txtdob.sendkeys(dd);
    	txtdob.sendkeys(yy);
	
}
    

	public void custphonenb(String cphone) {
		txtphonenb.sendKeys(cphone);
		
	}
	public void custemail(String cemail) {
		txtemail.sendKeys(cemail);
		
	}
	
	public void custgender(String cgender) {
		txtgender.sendKeys(cgender);
		
	}

}
