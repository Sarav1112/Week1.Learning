package Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class First {
	
	
	    public static void main(String[] args) throws InterruptedException {
	   
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Hemsarav\\Desktop\\ChromeDriver\\chromedriver.exe");
	     		    	WebDriver driver = new ChromeDriver();
	    	driver.get("https://www.w3schools.com");
	    	driver.findElement(By.id("navbtn_tutorials")).click();
	    	List<WebElement> dropvalue = driver.findElements(By.xpath("//div[@class='w3-col l3 m6']//h3[text()=\"HTML and CSS\"]/following-sibling::a"));
	    	Thread.sleep(2000);
	    	
	    for(WebElement E : dropvalue) {
	    	
	    	System.out.println("The value of dropdown     "+  E.getAttribute("innerHTML"));
	    	
	    	
	    	
	    	if( E.getAttribute("innerHTML").contentEquals("Learn Bootstrap"))
	    	{
	    		E.click();
	    		break;
	    		
	    	}
	    	
	    }
	 
	    driver.quit();
	}
	    }
