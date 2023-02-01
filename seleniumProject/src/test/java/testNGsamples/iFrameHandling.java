package testNGsamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class iFrameHandling {
	WebDriver driver;
  @Test
  public void verifyTheCorrectWebPageIsLoadingByClickingIframe() {
	    WebElement iFrameAd = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/RbSlW8jZFe8']"));
	 
		JavascriptExecutor js = (JavascriptExecutor) driver; // scrolling
		js.executeScript("arguments[0].scrollIntoView();", iFrameAd);
		

		/*// Using for loop, it tries for 3 times. 
		// If the element is located for the first time then it breaks from the for loop nad comeout of the loop
		for(int i=0; i<=2;i++){
		  try{
		     driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/RbSlW8jZFe8']")).click();
		     break;
		  }
		  catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		}
		*/
		
		driver.switchTo().frame(iFrameAd);
		Boolean actual=iFrameAd.isDisplayed();
		Assert.assertTrue(actual);
		
		
		driver.switchTo().parentFrame();  
  }
  @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
