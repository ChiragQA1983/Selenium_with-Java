package Practice_Tutorial;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice_ReadData_Excelsheet {

	public static void main(String[] args) throws IOException {
		
	// Step 1 - Declare File Input Stream Object  as a First Object
	FileInputStream file=new FileInputStream("C:\\Users\\Krishna\\Desktop\\DataDrivenTest.xlsx");
	
	// Step 2 - Declare Workbook Object and Pass file as a Parameter
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	
	// Step 3 - Declare Sheet Object which read sheet name from workbook object and Mentioned the Sheet name 
	XSSFSheet sheet = workbook.getSheet("Sheet2");
	
	
	// Step 4 - Declare rowcount variable for getLastRowNumber
	// Step 5 - Declare colcount variable for getLastCellNumber
	
	int rowcount=sheet.getLastRowNum();
	int colcount=sheet.getRow(0).getLastCellNum();
	
	// Step 6 - Fetch currentrow using below looping statement 
	
	
	for (int i=0; i<rowcount; i++)
	{
		XSSFRow currentrow=sheet.getRow(i);
		
    // Step 7 - Fetch  cell value and store it as a String using below looping statement and print it in console		
	
	  for (int j=0; j<colcount; j++)
	  {
	  String value=currentrow.getCell(j).toString();
	  System.out.print(" " + value);	 
		 
	  }
     System.out.println();
	}
	}
}
