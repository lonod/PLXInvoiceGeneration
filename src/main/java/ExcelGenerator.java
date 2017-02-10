
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

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
        FileInputStream inputStream = new FileInputStream(new File(templateFile));
        Workbook workbook = new HSSFWorkbook(inputStream);  
        
    }
    
    
}
