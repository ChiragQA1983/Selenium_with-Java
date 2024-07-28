package Practice_Tutorial;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ReadingDataFromExcel_Result_Display_Console {

	public static void main(String[] args) throws IOException {
		
    //First need to create file object		
	FileInputStream file=new FileInputStream("C:\\Users\\Krishna\\Desktop\\DataDrivenTest.xlsx");	
		
	// Needs to create workbook object
	XSSFWorkbook workbook=new XSSFWorkbook(file); //providing the sheet name
	
	//Needs to create sheet object
	XSSFSheet sheet=workbook.getSheet("Sheet1");  //providing sheet name
	
	int rowcount=sheet.getLastRowNum();  //returns the row count
	
	int colcount=sheet.getRow(0).getLastCellNum(); //returns column cell count
	
	for (int i=0; i<rowcount; i++)
	{
		XSSFRow currentrow=sheet.getRow(i); //focused on current row 
		
		for (int j=0; j<colcount; j++)
		{
			String value=currentrow.getCell(j).toString(); //read the value from the cell
			System.out.print("  " +  value);
		}
		System.out.println();
	}
	
	}

}
