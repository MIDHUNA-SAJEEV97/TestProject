package testNGsamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WaitsInSelenium {
	WebDriver driver;
	@Test
	public void verifySearchFunctionalityByUsingClientName() {

		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();

		WebElement clientsTab = driver.findElement(By.xpath("(//a[text()='Clients'])[1]"));
		//explicitWait
		
		//clientsTab=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Clients'])[1]")));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clientsTab));
		clientsTab.click();
		//WebElement clientsName = driver.findElement(By.xpath("//input[@id='clientsearch-client_name']"));
		WebElement clientsName = driver.findElement(By.cssSelector("input#clientsearch-client_name"));
		clientsName.sendKeys("sam");
		
		WebElement searchBox= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		searchBox.click();
		WebElement sam = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]"));
		//explicitwait
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]")));
		//System.out.println(sam.isSelected());
		
		//fluentwait
		
		Wait<WebDriver> fWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		fWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]")));
		
		String expectedResult="Sam";
		String actualResult=sam.getText();
		Assert.assertEquals(actualResult, expectedResult);
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
