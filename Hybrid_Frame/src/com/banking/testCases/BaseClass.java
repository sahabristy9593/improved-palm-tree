package com.banking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.banking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger= Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		    System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		    driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new IEDriver();
		}
		
	}
	
    @AfterClass
	public void tearDown() {
		driver.quit();
		
	}
    
    public void captureScreen(WebDriver driver, String tname) throws IOException{
    	takesScreenshot ts = (takesScreenshot)driver;
    	File source = ts. getScreenshotAs(OutputType.FILE);
    	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
    	FileUtils.copyFile(source,target);
    	System.out.println("Screenshot taken");
    	
    }
    
    public String randomeString() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return(generatedString);
	}
	
	public String randomeNum() {
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return(generatedString2);
	}

}
