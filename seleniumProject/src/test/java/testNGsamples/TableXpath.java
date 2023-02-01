package testNGsamples;

import org.testng.annotations.Test;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TableXpath {
	WebDriver driver;

	@Test(priority=1)
	public void verifySearchFunctionalityByUsingClientName() {

		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();

		WebElement clientsClick = driver.findElement(By.xpath("(//a[text()='Clients'])[1]"));
		clientsClick.click();
		//WebElement clientsName = driver.findElement(By.xpath("//input[@id='clientsearch-client_name']"));
		WebElement clientsName = driver.findElement(By.cssSelector("input#clientsearch-client_name"));
		clientsName.sendKeys("sam");
		
		WebElement searchBox= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		searchBox.click();
		WebElement sam = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]"));
		//System.out.println(sam.isSelected());
		String expectedResult="Sam";
		String actualResult=sam.getText();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test(priority=2)
	public void clientDetailsOfTom() {
		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();

		WebElement clientsClick = driver.findElement(By.xpath("(//a[text()='Clients'])[1]"));
		//clientsClick.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;       
		js.executeScript("arguments[0].click();",clientsClick );     //if html code click is not working, use javascript
		
		
		WebElement tom = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[12]"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", tom);    //scroll to an element
		System.out.println(tom.getText());
		Boolean actual=tom.isDisplayed();
		Assert.assertTrue(actual);
		
		
		
	}
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
