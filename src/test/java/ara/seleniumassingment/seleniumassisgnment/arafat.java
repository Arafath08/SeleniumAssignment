package ara.seleniumassingment.seleniumassisgnment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class arafat {
	
	WebDriver driver;
	
	@BeforeClass
    public void startBrowser()
    
    {
    System.setProperty("webdriver.chrome.driver","C:\\SELENIUM\\webDriver\\chromedriver\\chromedriver.exe");
    driver=new ChromeDriver();
    System.out.println("===== BROWSER STARTED======");
    }
	
	@Test(priority=0)
	public void startApp()
	{
		 driver.get("https://www.zoopla.co.uk/");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 driver.findElement(By.id("search-input-location")).sendKeys("london" + Keys.ENTER);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 System.out.println("===== london======");
		 
		 //to catch all web elements into list
		    List<WebElement> myList=driver.findElements(By.className("listing-results-price text-price"));
		    System.out.println(((WebElement) myList).getText());
		    //myList contains all the web elements
		    //if you want to get all elements text into array list
		    List<String> all_elements_text=new ArrayList<>();

		    for(int i=0; i<myList.size(); i++){

		        //loading text of each element in to array all_elements_text
		        all_elements_text.add(myList.get(i).getText());
		       
		        //to print directly
		        System.out.println(myList.get(i).getText());
		         System.out.println(myList.size()); //list size= 1
		       
		    }
		
 	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
		    
		    
		    
		    
