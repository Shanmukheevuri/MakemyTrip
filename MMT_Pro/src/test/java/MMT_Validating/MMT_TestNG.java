package MMT_Validating;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_TestNG {
	WebDriver web;
	
	
	private String mainWindowHandle;
	 @BeforeTest
	 public void Login_MMT() {
		 WebDriverManager.chromedriver().setup();
		 web=new ChromeDriver();
		 web.manage().window().maximize();	
		 web.get("https://www.makemytrip.com");
		 web.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		 
}
	 @Test
	 public void Validating_MMT() throws InterruptedException, AWTException {
		 
		 System.out.println("Make My Trip");
		 
		 web.findElement(By.xpath("(//*[@class='chNavText darkGreyText'])[4]")).click();
		 
		 Thread.sleep(2000);
		 web.findElement(By.id("fromCity")).click(); 
		 
		 Thread.sleep(3000);
		 web.findElement(By.xpath("(//*[@class='font14 blackText appendBottom6 autoSuggestValue'])[3]")).click();
		 
		 Thread.sleep(2000);
		 web.findElement(By.id("toCity")).click();
		 
		 Thread.sleep(3000);
		 web.findElement(By.className("dest-search-input")).sendKeys("Singapore");
		 Thread.sleep(2000);
		 WebElement SGP = web.findElement(By.className("dest-city-name"));
		 Actions act = new Actions(web);
		 act.click(SGP).build().perform();
		 
		 Thread.sleep(2000);
		 web.findElement(By.xpath("(//*[@class='DayPicker-Day'])[9]")).click();
		 	
		 JavascriptExecutor js=(JavascriptExecutor)web;
		 js.executeScript("window.scrollTo(0,150)");
		 
		 Thread.sleep(3000);
		 WebElement Click = web.findElement(By.className("applyBtn"));
		 Thread.sleep(3000);
		 act.click(Click).build().perform();
		 
		 Thread.sleep(3000);
		 web.findElement(By.className("action")).click();
		 
		 Thread.sleep(4000);
		 web.findElement(By.id("search_button")).click();
		 
		 
		 Thread.sleep(4000);
	     WebElement Perform = web.findElement(By.xpath("(//*[@class='skipBtn'])[1]"));
	     act.click(Perform).build().perform();
	     
//		 Thread.sleep(3000);
//		 web.findElement(By.className("skipBtn")).click();
//		 
		 Thread.sleep(2000);
		 web.findElement(By.id("searchBtn")).click();
		 
	     Thread.sleep(8000);
	     js.executeScript("window.scrollTo(0,800)");
	     
	     Thread.sleep(5000);
	     WebElement close = web.findElement(By.xpath("//*[@class='close closeIcon']"));
	     act.click(close).build().perform();
	     
	     Thread.sleep(7000);
	     web.findElement(By.xpath("(//*[@class='silderCardImage  active '])[8]")).click();
	
	     
	     Thread.sleep(3000);
	     for (String childWindowHandle : web.getWindowHandles()) {
	    	 
	    	  if(!childWindowHandle.equals(mainWindowHandle)){
	    		  web.switchTo().window(childWindowHandle);
	    	  
	    	  }
	    	} 
          
	     
	     Thread.sleep(4000);
	     WebElement Perform1 = web.findElement(By.xpath("(//*[@class='skipBtn'])[1]"));
	     act.click(Perform1).build().perform();
	     
	     
	     js.executeScript("window.scrollTo(0,300)");
	     Thread.sleep(3000);
	     web.findElement(By.xpath("(//*[@class='borderRadius4 vrtTop active '])[6]")).click();
	      //web.findElement(By.id("change")).click();
	    
	     
//	     Thread.sleep(2000);
//	     web.findElement(By.xpath("//*[@class='active  ']")).click();
	     
	     Thread.sleep(3000);
	     web.findElement(By.xpath("//*[@class='chngeLink linkText cursorPointer']")).click();
	     
	     
	     Thread.sleep(5000);
	     web.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[2]")).click();
	     String ActualchangeHotelName = web.findElement(By.xpath("//*[text()='Furama RiverFront Hotel']")).getText();
	     System.out.println(ActualchangeHotelName);
	     
	      Thread.sleep(4000);
	      web.findElement(By.xpath("//*[@class='updatePackageBtnText font10']")).click();
	      String changeHotelName = web.findElement(By.xpath("//*[text()='Furama RiverFront Hotel']")).getText();
	      System.out.println(changeHotelName);
	     
	      Assert.assertEquals(ActualchangeHotelName, changeHotelName);
          System.out.println(changeHotelName);

	     
	     Thread.sleep(2000);
	     web.findElement(By.id("chooseAndAddBtn")).click();
	     
	     Thread.sleep(2000);
	     web.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[2]")).click(); //Guided City Tour- Shared Transfers
	     String ActualchangeActivityName = web.findElement(By.xpath("//*[text()='Guided City Tour- Shared Transfers']")).getText();
	     System.out.println(ActualchangeActivityName);
	     
	     Thread.sleep(2000);
	     web.findElement(By.xpath("//*[@class='updatePackageBtnText font10 btn btn-primary btn-sm']")).click();
	     String ChangeActivityName = web.findElement(By.xpath("//*[text()='Guided City Tour- Shared Transfers']")).getText();
	     System.out.println(ChangeActivityName);
	     
	     Assert.assertEquals(ActualchangeActivityName, ChangeActivityName);
         System.out.println(ChangeActivityName);
         
         Thread.sleep(4000); 
	     web.close();
	     
	 }
	 
	 }
