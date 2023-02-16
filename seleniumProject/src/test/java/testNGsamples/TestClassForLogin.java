package testNGsamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClassForLogin {
	WebDriver driver;
  @Test(dataProvider="successfullLogin",dataProviderClass=DataProviderForLogin.class)
  public void verifySuccessFullLogin(String uName,String pw) {
	  WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
	  userName.sendKeys(uName);
	  WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
	  passWord.sendKeys(pw);
	  WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	  submit.click();
	  
	  WebElement adminNameAfterLogin = driver.findElement(By.xpath("//a[ @data-toggle='dropdown']"));
	  Boolean actual=adminNameAfterLogin.isDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(dataProvider="UnSuccessfullLogin",dataProviderClass=DataProviderForLogin.class)
  public void verifyUnsuccessFullLogin(String uName,String pw) {
	  WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
	  userName.sendKeys(uName);
	  WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
	  passWord.sendKeys(pw);
	  WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	  submit.click();
	   
	  WebElement alertMessage = driver.findElement(By.xpath("//div[ @class='alert alert-danger alert-dismissible'] "));
	  Boolean actual=alertMessage.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
