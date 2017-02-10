
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAP Training
 */
public class ExcelGenerator {
    private String templateFile ;
    
    public void buildExcel() throws FileNotFoundException, IOException{
        templateFile = ApplicationProperties.getInvoiceTempate();
        FileInputStream fis = new FileInputStream(new File(templateFile));
        XSSFWorkbook workbook = new XSSFWorkbook (fis);
	XSSFSheet sheet = workbook.getSheetAt(0);
	XSSFRow row1 = sheet.getRow(1);
	XSSFCell cell1 = row1.getCell(1);
	cell1.setCellValue("Mahesh");
	XSSFRow row2 = sheet.getRow(2);
	XSSFCell cell2 = row2.getCell(1);
	cell2.setCellValue("Ramesh");
	fis.close();
	FileOutputStream fos =new FileOutputStream(new File("D:\\xlsx\\test.xlsx"));
	workbook.write(fos);
	fos.close();
	System.out.println("Done");
        
    }
    
    //write Header details
    public boolean writeHeaderDetails(String fileName){
        return true;
    }
    
    //write labour details
    public boolean writeLabourDetails(String fileName){
        return true;
    }
    
    //write parts details
    public boolean writePartsDetails(String fileName){
        return true;
    }
    
    //write lubricats and expense details
    public boolean writeLubricantsAndExpenseDetails(String fileName){
        return true;
    }
}
