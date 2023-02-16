package testNGsamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardAndMouseHandling {
	WebDriver driver;
  @Test
  public void verifyEnteredMessage() throws InterruptedException {
	  
	  WebElement enterMessage=driver.findElement(By.xpath("//input[@id='single-input-field']"));
	  Actions action=new Actions(driver);
	  action.keyDown(Keys.SHIFT).build().perform();    //keypress
	  enterMessage.sendKeys("hii");
	  action.keyUp(Keys.SHIFT).build().perform();       //shiftkey release
	  
	/*  action.keyDown(Keys.TAB).build().perform();
	  action.keyUp(Keys.TAB).build().perform();
	  action.keyDown(Keys.ENTER).build().perform();
	  action.keyUp(Keys.ENTER).build().perform(); */
	  
	  
	  action.sendKeys(Keys.TAB).build().perform();      //tab key press
	 // action.sendKeys(Keys.ENTER).build().perform();
	
	  WebElement showMessage=driver.findElement(By.xpath("//button[@id='button-one']"));
	  action.sendKeys(showMessage,Keys.ENTER).build().perform();     //click by sendkeys
	
	  WebElement yourMessage=driver.findElement(By.xpath("//div[@id='message-one']"));
	  Boolean actual=yourMessage.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test
  public void mouseHandling() {
	
	  WebElement home=driver.findElement(By.xpath("//a[text()='Home']"));
	  Actions action=new Actions(driver);
	  action.moveToElement(home).build().perform();
	 // action.contextClick(home).build().perform();
	  action.doubleClick(home).build().perform();
	  
	  
  }
  
  @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
