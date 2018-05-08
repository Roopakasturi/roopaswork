package com.hb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hb.qa.utils.excelUtils;

public class cashFlow {
	
private WebDriver driverresa;
	


	@FindBy(xpath="(//*[text()='Cash flow']//ancestor::div[contains(@class,'row p-y')]//following-sibling::div//table)[1]")
	WebElement mytable3;
	
	
	
	public cashFlow(WebDriver driver) {
		driverresa= driver;
		PageFactory.initElements(driverresa, this);
	}

	

public void saveExcel(String acFilename){ 
	
		
		
	//XSSFSheet sheet=wb.createSheet("output");
	//FileOutputStream f = new FileOutputStream("C:\\Users\\Lovely Aadya\\Desktop\\output.xlsx");
	JavascriptExecutor js = (JavascriptExecutor) driverresa;
	js.executeScript("window.scrollBy(0,800)");
	 
	String restype2 ="Cash flow";
	
	int row_count2=mytable3.findElements(By.tagName("tr")).size();
	System.out.println(row_count2);
	
	
	int col_count2=mytable3.findElements(By.tagName("th")).size();
	System.out.println(col_count2);
	
	excelUtils.setWexcel(acFilename,restype2);
	
		for( int m=1;m<=col_count2;m++) {
		
		String headerValue=mytable3.findElement(By.xpath("//th["+m+"]")).getText();
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
			
			if(j>23) {
				break;
				
			}
			
			else {
				
			
			String cellvalue=driverresa.findElement(By.xpath("(//*[text()='Balance Sheet']//ancestor::div[contains(@class,'row p-y')]//following-sibling::div//table)[1]//tr["+j+"]//td["+k+"]")).getText();
			excelUtils.writeExcel(cellvalue, j, k,acFilename,restype2);
			System.out.println(cellvalue);
			}

			
			
			}
						
						
		}
	
	
		
		
							
						
									
			
		
	
	
	}
	
}









