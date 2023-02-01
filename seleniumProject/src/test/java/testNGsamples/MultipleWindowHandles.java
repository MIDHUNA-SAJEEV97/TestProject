package testNGsamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class MultipleWindowHandles {
	WebDriver driver;

	@Test
	public void multipleWindowHandling() throws InterruptedException {

		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window handle is " + parentWindow);
		WebElement openNewWindowButton = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='newWindowBtn']"))); // explicit wait
		//JavascriptExecutor js = (JavascriptExecutor) driver;                //scrolling 
		//js.executeScript("arguments[0].scrollIntoView();", openNewWindowButton);
		openNewWindowButton.click();

		Set<String> childWindows = driver.getWindowHandles();
		System.out.println("child Window handles : " + childWindows);
		Iterator<String> iterator = childWindows.iterator();
		while(iterator.hasNext())
		{
			String child=iterator.next();
			
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.manage().window().maximize();
				
				WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
				firstName.sendKeys("midhuna");
				Thread.sleep(5000);	 
				driver.close();			//if needed to close child here
			}
			
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
        
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
