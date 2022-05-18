package bootcampday1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewDashboard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		//Disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);


		//1. Login to https://login.salesforce.com

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		// 2. Click on the toggle menu button from the left corner

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//3. Click View All and click Dashboards from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		WebElement Dashboard=  driver.findElement(By.xpath("//a//following::span/p[text()='Dashboards']"));
		Actions action = new Actions(driver);
		action.moveToElement(Dashboard).click().build().perform();


		// 4. Click on the New Dashboard option
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();



		//5. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		//System.out.println(iframe.getAttribute("name"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by  SaravanaKumar");


		driver.findElement(By.id("submitBtn")).click();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement iframe1 = driver.findElement(By.tagName("iframe"));
		//System.out.println(iframe1.getAttribute("name"));
		driver.switchTo().frame(iframe1);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral save']")).click();
		driver.switchTo().defaultContent();
		WebElement Dash1 =driver.findElement(By.xpath("//span[text()='Dashboards']"));
		action.moveToElement(Dash1).click().build().perform();
	/*	List<WebElement> DashboardName = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']//a"));

	
		for(WebElement E : DashboardName ) {
			String DashTitle = E.getAttribute("title");
			SoftAssert softAssert = new SoftAssert();

			softAssert.assertEquals(DashTitle, "Salesforce Automation by  SaravanaKumar");
			System.out.println("Title Present" +E.getDomAttribute(DashTitle));

			softAssert.assertNotEquals(DashTitle, "Salesforce Automation by  SaravanaKumar");
			System.out.println("Title is Different" + E.getAttribute(DashTitle));
			softAssert.assertAll();

		}*/

		//6.Click on Save and Verify Dashboard name.

		driver.quit(); 
	}




}


