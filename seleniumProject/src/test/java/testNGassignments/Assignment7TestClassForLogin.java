package testNGassignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testNGsamples.DataProviderForLogin;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assignment7TestClassForLogin {
	WebDriver driver;
	
	@Test(dataProvider="successfullLogin",dataProviderClass=Assignment7DataProviderForLogin.class)
	public void verifySuccessFullLogin(String uName,String pwd) {
		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys(uName);
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys(pwd);
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();
	
		WebElement carolThomasDashboard = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		String actualResult = carolThomasDashboard.getText();
		String expectedResult = "CAROL THOMAS";
		Assert.assertEquals(actualResult, expectedResult);

	}
	@Test(dataProvider="UnSuccessfullLogin",dataProviderClass=Assignment7DataProviderForLogin.class)
	public void verifyUnsuccessFullLogin(String uName,String pwd) {
		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys(uName);
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys(pwd);
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();

		WebElement alertText = driver.findElement(By.xpath("//div[@style='color:#999;margin:1em 0']"));
		String actualResult = alertText.getText();
		String expectedResult = "If you forgot your password you can reset it.";
		Assert.assertEquals(actualResult, expectedResult);

	}
  @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
