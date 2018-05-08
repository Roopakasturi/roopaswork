package com.hb.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hb.qa.base.testBase;
import com.hb.qa.utils.excelUtils;

public class AnnualResults extends testBase {
	
	private WebDriver driverresa;
	


	@FindBy(xpath="//div[contains(@class,'annual-standalone')]/div[1]//table")
	WebElement mytable2;
	
	
	
	public AnnualResults(WebDriver driver) {
		driverresa= driver;
		PageFactory.initElements(driverresa, this);
	}

	

public void saveExcel(String acFilename){ 
	
		
		
	//XSSFSheet sheet=wb.createSheet("output");
	//FileOutputStream f = new FileOutputStream("C:\\Users\\Lovely Aadya\\Desktop\\output.xlsx");
	JavascriptExecutor js = (JavascriptExecutor) driverresa;
	js.executeScript("window.scrollBy(0,800)");
	 
	String restype2 ="Annual";
	
	int row_count2=mytable2.findElements(By.tagName("tr")).size();
	System.out.println(row_count2);
	
	
	int col_count2=mytable2.findElements(By.tagName("th")).size();
	System.out.println(col_count2);
	
	excelUtils.setWexcel(acFilename,restype2);
	
		for( int m=1;m<=col_count2;m++) {
		
		String headerValue=driverresa.findElement(By.xpath("//div[contains(@class,'annual-standalone')]/div[1]//table//tr//th["+m+"]")).getText();
		
		excelUtils.writeExcel(headerValue, 0, m, acFilename,restype2);
		System.out.println(headerValue);
	}
	
		
	/*for (int i=1;i<=col_count;i++)
	{
		String rowvalue=mytable.findElement(By.xpath("//tr//th["+i+"]")).getText();
		excelUtils.writeExcel(rowvalue, 1, i, acFilename);
			
	}*/
	
	for (int j=1;j<=row_count2;j++) {
		for(int k=1;k<=col_count2;k++) {
			
			if(j>12) {
				break;
			}
			else {
			String cellvalue1=driverresa.findElement(By.xpath("//div[contains(@class,'annual-standalone')]/div[1]//table//tr["+j+"]//td["+k+"]")).getText();
			excelUtils.writeExcel(cellvalue1, j, k,acFilename,restype2);
			
			
			}
			
			
			}
						
						
									
			
		}
	
	
		
		
							
						
									
			
		
	
	
	}
	
}




	
//WebElement table= driver.findElement(By.xpath("(//div[starts-with(@class,'Ltop')])[1]/div[3]/div[1]//table)"));
//int row_count=table.findElements(By.tagName("tr")).size();
//System.out.print(row_count);


//int colcount=driver.findElements(By.xpath("//div[starts-with(@class,'content_consolidated qtr')]//table/td")).size();
//System.out.println(colcount);





	


