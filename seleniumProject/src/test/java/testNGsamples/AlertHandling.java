package testNGsamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class AlertHandling {
	WebDriver driver;
  @Test
  public void alertAccepting() throws InterruptedException {
	 
	  WebElement customerId= driver.findElement(By.xpath("//input[@name='cusid']")); 
	  customerId.sendKeys("1234");
	  WebElement submitButton= driver.findElement(By.xpath("//input[@name='submit']"));
	  submitButton.click();
	  Thread.sleep(2000);   //execution stop for given time
	  driver.switchTo().alert().accept();
	  Thread.sleep(1000);
	  System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().accept();
	  
  }
  @Test
  public void alertCancelling(){
	 
	  WebElement customerId= driver.findElement(By.xpath("//input[@name='cusid']")); 
	  customerId.sendKeys("1234");
	  WebElement submitButton= driver.findElement(By.xpath("//input[@name='submit']"));
	  submitButton.click();
	  System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().dismiss();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("http://demo.guru99.com/test/delete_customer.php");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
