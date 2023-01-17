package testNGsamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class WebElementCommands {
	WebDriver driver;

	@Test
	public void inputFormClickGetMessage() {

		WebElement inputForm = driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
		inputForm.click();
		WebElement messageTextBox = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		messageTextBox.sendKeys("hiii");
		WebElement buttonShowMessage = driver.findElement(By.xpath("//button[@id='button-one']"));
		buttonShowMessage.click();

		WebElement yourMessageText = driver.findElement(By.xpath("//div[@id='message-one']"));
		// System.out.println(yourMessageText.getText());
		String expectedText = "Your Message : hiii";
		String actualText = yourMessageText.getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}

}
