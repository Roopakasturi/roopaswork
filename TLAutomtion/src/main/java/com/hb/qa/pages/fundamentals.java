package com.hb.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hb.qa.base.testBase;

public class fundamentals extends testBase {
	
	public static final Logger log = Logger.getLogger(homepage.class.getName());
	private WebDriver driver2;
	@FindBy(xpath="//div[@class='markpanel']//a[contains(text(),'Fundamentals')]")
	WebElement fundamntls;
	
	public fundamentals(WebDriver driver) {
		driver2= driver;
		PageFactory.initElements(driver2, this);
	}
	
	
	public void click()  {
		
		
		
	fundamntls.click();

	
	
	}

}