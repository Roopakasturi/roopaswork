package com.hb.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hb.qa.base.testBase;
import com.hb.qa.utils.excelUtils;

public class quarterlyResults extends testBase {
	
	private WebDriver driverres;
	public String restype;


	
	@FindBy(xpath="(//div[starts-with(@class,'Ltop')])[1]/div[3]/div[1]//table")
	WebElement mytable1;
	

	
	
	public quarterlyResults(WebDriver driver) {
		driverres= driver;
		PageFactory.initElements(driverres, this);
	}

	

public void saveExcel(String acFilename){ 
	
		
	
	
	restype="Quarterly";
	int row_count1=mytable1.findElements(By.tagName("tr")).size();
	System.out.println(row_count1);
	
	
	int col_count1=mytable1.findElements(By.tagName("th")).size();
	System.out.println(col_count1);
	
	excelUtils.setWexcel(acFilename,restype);
	
		for( int m=1;m<=col_count1;m++) {
		
		String headerValue=mytable1.findElement(By.xpath("//th["+m+"]")).getText();
		excelUtils.writeExcel(headerValue, 0, m, acFilename,restype);
		System.out.println(headerValue);
	}
	
		
	for (int j=1;j<=row_count1;j++) {
		for(int k=1;k<=col_count1;k++) {
			
			String cellvalue=mytable1.findElement(By.xpath("//tr["+j+"]//td["+k+"]")).getText();
			excelUtils.writeExcel(cellvalue, j, k,acFilename,restype);
					

			
			
			}
						
						
									
			
		}
	
	
		
		
							
						
									
			
		
	
	
	}
	
}






	


