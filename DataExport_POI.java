package abcpack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataExport_POI {
	
	@Test
	public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("E:\\Selenium_Scripts_Sep18\\Results\\DataExport.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet s1=wb.createSheet("Results1");
		XSSFSheet s2=wb.createSheet("Results2");
		XSSFRow r=s1.createRow(0);
		r.createCell(0).setCellValue("selenium");
		r.createCell(1).setCellValue("Docker");
		wb.write(fos);
		fos.close();
	}

}
