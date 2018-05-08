package com.hb.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;




public class excelUtils {
		
		public String Path;
		private static HSSFSheet ExcelWSheet;
    	private static HSSFWorkbook ExcelWBook;
		private static HSSFCell Cell;
		private static HSSFWorkbook rwb=new HSSFWorkbook();
		private static HSSFSheet rsh;
		private static HSSFCell rcell;
		private static HSSFRow rrow;
		public static String shName;
		
		

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

   			// Open the Excel file
					   		
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new HSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			} catch (Exception e){
				
				throw (e);

			}

	}
	
	public static int rowCol(String FilePath, String SheetName) throws IOException {
		
		FileInputStream Excel = new FileInputStream(FilePath);
		ExcelWBook = new HSSFWorkbook(Excel);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
		int rcount = ExcelWSheet.getLastRowNum();
		
		
		return rcount;
		
		
		
		
		
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
		 
		   String[][] tabArray = null;
		   
		   
		   try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new HSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			
			int startRow=1;
			int startCol=1;
			int ci,cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			System.out.print(totalRows);
			int totalCols =2;
			tabArray= new String[totalRows][totalCols];
			ci=0;
			for(int i =startRow;i<=totalRows;i++, ci++) {
				
				cj=0;
				
				for(int j=startCol;j<=totalCols;j++, cj++) {
					
					tabArray[ci][cj] = getCellData(i,j);
					
					System.out.println(tabArray[ci][cj]);
					
				}
			}
			
		   }
		   catch(FileNotFoundException e) {
			   
			   System.out.println("Could not read excel sheet");
			   
			   e.printStackTrace();
		   }
		   
			
				catch(IOException e) {
					
					System.out.println("could not read excel sheet");
					e.printStackTrace();
					
				}
		   return(tabArray);
		   
				}
				   

	
	
 
	public static String getCellData(int RowNum, int ColNum) throws Exception{

			try{
				
			

  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

  			String CellData = Cell.getStringCellValue();

  			return CellData;

  			}catch (Exception e){

				return"";

  			}

    }

		
public static void setWexcel(String compname, String res) {
		
	       shName = compname.substring(0,9)+res;
	        System.out.print(shName);
	        rsh =rwb.createSheet(shName);
		
	}
  
  
  
  public static void writeExcel(String value, int rowCount, int colCount, String aFN, String type) {
	        
	  
	  
		
	            rsh=rwb.getSheet(shName);                   		          	
	    		   
	            if(rsh.getRow(rowCount) == null)	            	
	            	rrow = rsh.createRow(rowCount);
	            else
	            	rrow = rsh.getRow(rowCount);
	            	
	                                   
	              rcell =rrow.createCell(colCount);
	               
	                    rcell.setCellValue(value);
	                    
	                    try {
	                    	
	                    	
	                    		
	                    	FileOutputStream outputStream = new FileOutputStream(constant.Path_TestData+aFN+"ConsolidatedResults.xls");
	                    	 rwb.write(outputStream);
		                        rwb.close();
	                    	
	                    	
	                    	
 
	                        
	                    }
	                    
	                    catch (FileNotFoundException e) {
	                        e.printStackTrace();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }

	                    
	                        
	                    
	                    
	    	   }
	       
	       
	                
	}



	         
	         

	 


		



