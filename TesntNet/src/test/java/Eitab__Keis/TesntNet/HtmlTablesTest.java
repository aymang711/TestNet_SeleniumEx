package Eitab__Keis.TesntNet;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.List;


public class HtmlTablesTest {
	private HtmlTablePage htmltbl;
	ExtentReports extent;
	
//	@BeforeTest
//	public void cofig() {
//    	
//	}
	
	  

	  @BeforeTest
	  public void setup() {
		  
	    	System.setProperty("webdriver.chrome.driver", "C:\\JavaDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(options);
			
			driver.manage().window().maximize();
			driver.get("https://www.w3schools.com/html/html_tables.asp");
	        // initialize the page object
	    	htmltbl = new HtmlTablePage(driver);
	    	
//	    	String path=System.getProperty("user.dir")
//					+ "\\reports\\index.html";
//	    	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
//	    	reporter.config().setReportName("HTML Table Results");
//	    	reporter.config().setDocumentTitle("Test Results");
//	    	ExtentReports extent=new ExtentReports();
//	    	extent.attachReporter(reporter);
//	    	extent.setSystemInfo("Tester", "Eitab");
	    	

	    	
	    }
	 @Test
	    public void testGetTableCellText() {
		//extent.createTest("Get Table Cell Text");
	        String expectedCountry = "Germany";
	        String actualCountry = htmltbl.getTableCellText(1, "Alfreds Futterkiste", 3);
	        Assert.assertEquals(actualCountry, expectedCountry);
	      // extent.flush();
	    }
	  @Test
	    public void testVerifyTableCellText() {
		 // extent.createTest("Verify Table Cell Text");
	        String expectedCity = "Madrid";
	        boolean isTextMatched = htmltbl.verifyTableCellText(1, "Centro comercial Moctezuma", 1, expectedCity);
	        Assert.assertFalse(isTextMatched);
	        //extent.flush();
	        
	    }


		
		

}
