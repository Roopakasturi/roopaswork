package com.hb.qa.base;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.hb.qa.utils.constant;

public class testBase {

	
	public static final Logger log = Logger.getLogger(testBase.class.getName());
	public WebDriver driver;
	public WebDriverWait wait;
		
	
	String Url;
	String browser ="firefox";
	
	public void init() throws Exception {
		
	    Url = constant.URL;
	    selectBrowser(browser);
	    System.out.print(Url);
		getUrl(Url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		getScreenshot();
		
		
				
	}
		
	public void selectBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("firefox")){
			log.info("Creating object of FireFox");
			driver = new FirefoxDriver();
			
		}
		
	}
	
	public void getUrl(String url) {
		
		log.info("navigating to url" +url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		
		
		
	}
	
	
	public void getScreenshot() {
		
		 File image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
		   // now copy the  screenshot to desired location using copyFile method
		  
		  FileUtils.copyFile(image, new File("C:\\Users\\Lovely Aadya\\Desktop\\SatishProject\\"+System.currentTimeMillis()+".png"));
		        }
		  
		 catch (IOException e)
		  
		 {
		  
		 System.out.println(e.getMessage());
		  
		     }
				  
		 }
	
		
		
	}



