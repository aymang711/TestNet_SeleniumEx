package Eitab__Keis.TesntNet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HtmlTablePage {
	WebDriver driver;
	
	public HtmlTablePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this); // to inizle all the webelement (like table..)
	}
	

	
	@FindBy(id="customers")WebElement customertbl;//the table locator	
	////table[@id="customers"]/tbody/tr/td[1] get all celltext in company column

	public String getTableCellText(int searchColumn, String searchText, int returnColumnText) {
        String cellText = "";

            WebElement tbody = customertbl.findElement(By.tagName("tbody"));
            int searchColumnIndex = getTableColumnIndex(searchColumn);
            int returnColumnIndex = getTableColumnIndex(returnColumnText);
            List<WebElement>rows=tbody.findElements(By.tagName("tr"));
            for (int i=1;i<rows.size();i++) {
            	cellText = rows.get(i).findElements(By.tagName("td")).get(searchColumnIndex).getText();

            	if(cellText.equals(searchText)) {
                    return rows.get(i).findElements(By.tagName("td")).get(returnColumnIndex).getText();
            		}
            }
			return null;
    }
	
	 private int getTableColumnIndex(int column) {
	        return column - 1;
	    }
	
	   public boolean verifyTableCellText(int searchColumn, String searchText, int returnColumnText, String expectedText) {
	        String actualText = getTableCellText(searchColumn, searchText, returnColumnText);
	        boolean result = actualText.equals(expectedText);
	        if (result) {
	            System.out.println("Verification Passed - Expected Text: " + expectedText + ", Actual Text: " + actualText);
	        } else {
	            System.out.println("Verification Failed - Expected Text: " + expectedText + ", Actual Text: " + actualText);
	        }
	        return result;
	    }


}

