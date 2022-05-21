package Day1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hemsarav\\Desktop\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
	List<WebElement> Imagelist	=driver.findElements(By.tagName("img"));
	
	 
	for (WebElement e : Imagelist)  {
		
		System.out.println(e.getAttribute("naturalWidth")+"="+e.getAttribute("outerHTML"));
		
		if(e != null) {
		
		if( e.getAttribute("naturalWidth").equals("0")){
			System.out.println("broken Image"+ e.getAttribute("src"));
			
		}
		else 
		{
			System.out.println("Not an broken Image"+ e.getAttribute("src"));
		}
	}
	
	}
driver.quit();
		
		
	}

}
