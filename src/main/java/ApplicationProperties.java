
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.util.Properties;
import java.util.logging.Level;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAP Training
 */
public class ApplicationProperties {
       
    private static String propfilepath = "";
    private static InetAddress ip = null;
    private static String hIP = "";
    private static String vlogFile = null;
    private static String templateFile = null;    
    private static final String OS = System.getProperty("os.name").toLowerCase();
    public static String invoice_template ; 
    
    private ApplicationProperties(){
        
    }
    
    private static void initializeProperties(){
        try {
            ip = InetAddress.getLocalHost();
            hIP = ip.getHostAddress();
            if (OS.contains("nix") || OS.contains("nux")) {                
                vlogFile = "nix_logfile";
                templateFile = "nix_invoice_template";
            } else if (OS.contains("win")) {
                propfilepath = "C:\\temp\\intg\\intg.properties";
                vlogFile = "win_logfile";
                templateFile = "win_invoice_template";
            }
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream(propfilepath);
            prop.load(input);
            invoice_template = prop.getProperty(templateFile);
        }catch (IOException ie) {            
            String err_msg;
            StringWriter errors = new StringWriter();
            ie.printStackTrace(new PrintWriter(errors));
            err_msg = errors.toString();       
            MyLogging.log(Level.SEVERE, "Error in doInvoke", ie);
        }
    }
    
    public static String getInvoiceTempate(){
        initializeProperties();
        return invoice_template;
    }
    
}
