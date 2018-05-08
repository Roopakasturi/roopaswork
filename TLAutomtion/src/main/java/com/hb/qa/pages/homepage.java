package com.hb.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hb.qa.base.testBase;


public class homepage extends testBase {
	
	
	public static final Logger log = Logger.getLogger(homepage.class.getName());
	private WebDriver driver2;
	@FindBy(xpath="//input[@placeholder='Search for a Stock, Sector or Interest area']")
	WebElement search;
	
	public homepage(WebDriver driver) {
		driver2= driver;
		PageFactory.initElements(driver2, this);
	}
	
	public void searchEnterValues(String searchcomp,String actualcomp) throws InterruptedException {
		
		//wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(searchcomp);
		List<WebElement> searchoptions = search.findElements(By.xpath("//ul[3][starts-with(@class,'ui-menu')]/li"));
		System.out.print(searchoptions.size());
		
		for(WebElement option : searchoptions){
			
					
			
	        if(option.getText().equals(actualcomp)) {
	        	System.out.println("Trying to select: "+searchcomp);
	            option.click();
	            break;
	        }
	    }
		   System.out.print(searchcomp);
}
	
	
}

