package ara.seleniumassingment.seleniumassisgnment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
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
	public static WebDriver driver;
	public static Properties prop;
	//WebDriver driver;
	
	@BeforeClass
    public void startBrowser()
    
    {
    System.setProperty("webdriver.chrome.driver","C:\\SELENIUM\\webDriver\\chromedriver\\chromedriver.exe");
    driver=new ChromeDriver();
    System.out.println("===== BROWSER STARTED======");
    }
	
	@Test(priority=0)
	public void Configuration() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C://Users//ap82//git//seleniumassignmentrepo//seleniumassisgnment//src//main//java//config//config.property");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Test(priority=1)
	public void startApp()
	{
		 driver.get("https://www.zoopla.co.uk/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 String LocationName = prop.getProperty("Location");
		 driver.findElement(By.id("search-input-location")).sendKeys(LocationName + Keys.ENTER);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 System.out.println("===== london======");
		 System.out.println(LocationName);
		
		 
		 
		 //to catch all web elements into list
		/*// WebElement pricelist=driver.findElement(By.xpath("//a[@class='listing-results-price text-price']"));
		 WebElement pricelist=driver.findElement(By.xpath("//a[@class='listing-results-price text-price'][contains(text(),'£325,000')]"));
		
		 pricelist.getText();
		 System.out.println(pricelist);*/
		   List<WebElement> myList=driver.findElements(By.xpath("//a[@class='listing-results-price text-price']"));
		   
		    //myList contains all the web elements
		    //if you want to get all elements text into array list
		   Double[] priceArray= new Double[myList.size()];
		   
		    List<String> all_elements_text=new ArrayList<>();
		   // ArrayList<ArrayList<String>> all_elements_text = new ArrayList<ArrayList<String>>();
		    
//			NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
//        	System.out.println(nf.format(new BigDecimal(priceArray[i].substring(1).replace(",",""))));
		    for(int i=0; i<myList.size(); i++){

		        //loading text of each element in to array all_elements_text
		        all_elements_text.add(myList.get(i).getText().split(" ")[0]);
		        
		        priceArray[i] = Double.parseDouble(myList.get(i).getText().split(" ")[0].substring(1).replace(",",""));
		       
		       
		        //to print directly
		        System.out.println(myList.get(i).getText().split(" ")[0]);
		        
		        // System.out.println(myList.size()); //list size= 1
		       
		    }
		   /* Collections.sort(myList, Collections.reverseOrder());

	         Sorted List in reverse order
	        System.out.println("ArrayList in descending order:");
	        for(String d_order: all_elements_text){
	       System.out.println(d_order);
	       }
	       */
		    all_elements_text.sort(Comparator.comparing( String::toString ).reversed());
		    
		    
//		    int n;
			Double temp;
//	        Scanner a_list = new Scanner(System.in);
//	        System.out.print("Enter no. of elements you want in array:");
//	        n = a_list.nextInt();
//	        int a[] = new int[n];
//	        System.out.println("Enter all the elements:");
//	        for (int i = 0; i < n; i++) 
//	        {
//	            a[i] = a_list.nextInt();
//	        }
	        for (int i = 0; i < priceArray.length; i++) 
	        {
	            for (int j = i + 1; j < priceArray.length; j++) 
	            {
	            	            
	                if (priceArray[i]<priceArray[j]) 
	                {
	                    temp = priceArray[i];
	                    priceArray[i] = priceArray[j];
	                    priceArray[j] = temp;
	                }
	            }
	        }
	        System.out.print("Descending Order:");
	        /*ArrayList<String> nodeList = new ArrayList<String>();
			Double[] priceArray1= new Double[nodeList.size()];
			nodeList.addAll(all_elements_text);*/
	        
	        for (int i = 0; i < priceArray.length; i++) {
	       System.out.print("£"+priceArray[i]+"\n");
	        NumberFormat nf = NumberFormat.getCurrencyInstance();
	        System.out.println(nf.format(new BigDecimal(priceArray[i])).replaceAll("$","£"));
	       
	       
	     //String  output11=nf.format(new BigDecimal(priceArray1[i]));
	     // System.out.print("£"+priceArray[i] + "\n");
	        }
	       
//	        for (int i = 0; i < n - 1; i++) 
//	        {
//	            System.out.print(a[i] + ",");
//	        }
//	        System.out.print(a[n - 1]);
		    
	}
	
 	
	@AfterClass
	public void teardown() {
		//driver.quit();
	}

}
		    
		    
		    
		    
