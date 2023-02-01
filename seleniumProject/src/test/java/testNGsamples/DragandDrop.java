package testNGsamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DragandDrop {
	WebDriver driver;
  @Test
  public void dragAndDrop() {
	  
	  WebElement amount5000=driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
	  WebElement amount=driver.findElement(By.xpath("//ol[@id='amt7']"));
	  Actions action=new Actions(driver);
	  action.dragAndDrop(amount5000, amount).build().perform();
	
	  WebElement verifyAmount=driver.findElement(By.xpath("//table[@align='center']//tbody//tr//td[2]"));
	  Boolean actual=verifyAmount.isDisplayed();
	  Assert.assertTrue(actual);
  }

  @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
