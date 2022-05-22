package bootcampday1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class deleteDashbard {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//1. Login to https://login.salesforce.com
	
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notifications");
		WebDriver driver  = WebDriverManager.chromedriver().capabilities(option).create();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
		driver.findElement(By.id("Login")).click();
	    
		//2. Click on the toggle menu button from the left corner

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//4. Click on the Dashboards tab 
		WebElement Dashboard = driver.findElement(By.xpath("//a//following::span/p[text()='Dashboards']"));
		Actions action = new Actions(driver);
		action.moveToElement(Dashboard).click().build().perform();
		//5. Search the Dashboard 'Salesforce Automation by Your Name'
		
		/*driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Saravanakumar",Keys.ENTER);
		//6. Click on the Dropdown icon and Select Delete
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_icon-border slds-button_icon-x-small')]/lightning-primitive-icon")).click();
		
		//7.Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']")).click(); */
	
		
		//8. Verify Whether Dashboard is Deleted using Dashboard Name

		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Saravanakumar",Keys.ENTER);
		 WebElement element = driver.findElement(By.xpath("//span[text()='No results found']"));
		 String searchtext = element.getAttribute("innerHTML");
		 VerifyDashboardDeleted(searchtext);
		 
		}
	
	  private static void  VerifyDashboardDeleted ( String pageresult ) {
		
		  if (pageresult.equalsIgnoreCase("No results found")) {
			  
			  System.out.println("Dashboard Deleted ");
			
		} else {
			 System.out.println("Dashboard Not  Deleted ");
		}
	
		  
	  }

	
		
	}


