package bootcampday1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditDashboard {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub


		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);


		//1. Login to https://login.salesforce.com

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//2. Click on the toggle menu button from the left corner

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		//4. Click on the Dashboards tab 
		WebElement Dashboard = driver.findElement(By.xpath("//a//following::span/p[text()='Dashboards']"));
		Actions action = new Actions(driver);
		action.moveToElement(Dashboard).click().build().perform();
		//5. Search the Dashboard 'Salesforce Automation by Your Name'

		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Saravanakumar",Keys.ENTER);
		Thread.sleep(2000);
		//6. Click on the Dropdown icon and Select Edit
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_icon-border slds-button_icon-x-small')]/lightning-primitive-icon")).click();
		driver.findElement(By.xpath("//span[text()='Edit']")).click();



		//7.Click on the Edit Dashboard Properties icon
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
		driver.switchTo().defaultContent();
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);

		//8. Enter Description as 'SalesForce' and click on save.
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys("SalesForce");
		Thread.sleep(2000);
		WebElement Save = driver.findElement(By.id("submitBtn"));
		action.moveToElement(Save).click().perform();

		//9. Click on Done and  Click on save in the popup window displayed.
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("modalBtn2")).click();
		driver.switchTo().defaultContent();
		//10. Verify the Description.


	}

}
