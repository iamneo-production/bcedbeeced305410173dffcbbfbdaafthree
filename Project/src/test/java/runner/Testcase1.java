package runner;
import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.LoggerHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ch.qos.logback.classic.Logger;
// import pages.Deposit;
import pages.homepage;
import utils.Screenshot;
import utils.Base;
import utils.ReadPropertyFile;
import utils.EventHandler;
import utils.Reporter;
import utils.Screenshot;
public class Testcase1 extends Base {

    java.util.logging.Logger log = LoggerHandler.getLogger();
    ExtentReports extent = new ExtentReports();

    homepage Homepage;
   
    
    @Test(priority = 1)
    public void TC_001() throws IOException { 
        
        driver.get(prop.getProperty("url"));
        Homepage = new homepage(driver); // Provide the WebDriver instance here
        Homepage.Valid_Login_TC(driver);  

          
    }    

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        openBrowser();
        extent = Reporter.generateExtentReport();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        extent.flush();
        log.info("Browser closed");
        LoggerHandler.closeHandler();
    }
}
