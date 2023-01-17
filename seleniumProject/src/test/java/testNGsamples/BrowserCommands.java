package testNGsamples;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class BrowserCommands {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();

		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
  }

  @Test
  public void getUrlByClickingInputForm() {
	  
		WebElement inputForm=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
		inputForm.click();
		//System.out.println(driver.getCurrentUrl());
		
		String expectedText="https://selenium.obsqurazone.com/simple-form-demo.php";
		String actualtext=driver.getCurrentUrl();
		//Assert.assertEquals(actualtext, expectedText);
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualtext, expectedText);
		softassert.assertAll();
		
}
  @Test
  public void getTitleMethod() {
	  
		System.out.println(driver.getTitle());
		
		
}
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
 
}
