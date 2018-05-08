package com.test.automation.uiHB;



import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hb.qa.base.testBase;
import com.hb.qa.pages.AnnualResults;
import com.hb.qa.pages.balanceSheet;
import com.hb.qa.pages.cashFlow;
import com.hb.qa.pages.fundamentals;
import com.hb.qa.pages.homepage;
import com.hb.qa.pages.quarterlyResults;
import com.hb.qa.utils.constant;
import com.hb.qa.utils.excelUtils;


public class Tc_001 extends testBase {

	
	public static final Logger log=Logger.getLogger(Tc_001.class.getName());
	 
	 homepage home;
	 fundamentals fund;
	  quarterlyResults result;
	  AnnualResults aresults;
	  balanceSheet balsh;
	  cashFlow cf;
	  public String actualcompFilename;
	 	 
		@BeforeMethod
		public void setUp() throws Exception {
			
			init();
			
			home = new homepage(driver);
			fund = new fundamentals(driver);
			result = new quarterlyResults(driver);
			aresults=new AnnualResults(driver);
			balsh=new balanceSheet(driver);
			cf = new cashFlow(driver);
		}
		
		
		@Test(priority=1,dataProvider="userData")
		public void hpEnterValues(String searchcomp, String actualcomp) throws Exception {
			
			
			try {
				
				excelUtils.setExcelFile(constant.Path_TestData + constant.File_TestData,"Sheet1");
				home.searchEnterValues(searchcomp,actualcomp);
				actualcompFilename=actualcomp;
				System.out.print(actualcomp);
				log.info("==========login sucessful===========");
		
			} catch (Exception e) {
				System.out.print("abcd");
				e.printStackTrace();
			}
			
			fund.click();
			result.saveExcel(actualcompFilename);
			
			aresults.saveExcel(actualcompFilename);
			
			
			balsh.saveExcel(actualcompFilename);
			cf.saveExcel(actualcompFilename);
			
			driver.close();
			
		}
			

		    @DataProvider
		 
		    public Object[][] userData() throws Exception  {
		    	
		    	excelUtils.setExcelFile("C:\\Users\\Lovely Aadya\\Desktop\\SatishProject\\hbTestData.xls","Sheet1");
		 
		         Object[][] testObjArray = excelUtils.getTableArray("C:\\Users\\Lovely Aadya\\Desktop\\SatishProject\\hbTestData.xls","Sheet1");
		 
		         return (testObjArray);
		 
				}

		
}

		
		
		
			
		
		



