package Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hemsarav\\Desktop\\ChromeDriver\\chromedriver.exe");

		WebDriver driver =new ChromeDriver();
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : Links) {
			
			if(link!=null){
		
		System.out.println("link text" +link.getAttribute("href"));
	}
			
		}
driver.quit();
}
}