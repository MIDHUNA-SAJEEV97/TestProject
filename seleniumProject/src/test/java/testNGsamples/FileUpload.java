package testNGsamples;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FileUpload {
	WebDriver driver;
  @Test
  public void fileUploadUsingSendKeys() throws InterruptedException  {
	  WebElement chooseFile = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
	  
	  chooseFile.sendKeys("C:\\Users\\user\\Documents\\selenium notes midhuna.docx");
	  
	  WebElement acceptTerms = driver.findElement(By.xpath("//input[@id='terms']"));
	  acceptTerms.click();
	  WebElement submitButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
	  submitButton.click();
	  Thread.sleep(1000);
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  WebElement successFullMsg = driver.findElement(By.xpath("//h3[@id='res' and @class='demo']"));
		
	  //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@id='res' and @class='demo']")));   //explicit wait
	  Boolean actual=successFullMsg.isDisplayed();
	  Assert.assertTrue(actual);
	  /*SoftAssert softassert=new SoftAssert();
		softassert.assertTrue(actual);
		softassert.assertAll();*/
	  		
  }
  @Test
  public void fileUploadUsingRobotClass() throws AWTException, InterruptedException {
	  driver.navigate().to("https://resume.naukri.com/resume-quality-score");
	  driver.navigate().refresh();
	
	  WebElement browse=driver.findElement(By.xpath("//*[text()='Browse']"));
	  browse.click();
	  Thread.sleep(3000);
	  
	  Robot robot=new Robot();
	  
	  StringSelection filePath=new StringSelection("C:\\Users\\user\\Documents\\MIdhunaseleniummm.docx");  //to store filepath to stringselection class
	  
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);  //copy above path code
	  
	  robot.keyPress(KeyEvent.VK_CONTROL);   //control key pressing
	  Thread.sleep(3000);
	  robot.keyPress(KeyEvent.VK_V);    //v key pressing
	  
	  robot.keyRelease(KeyEvent.VK_CONTROL);  //controll key release
	  Thread.sleep(3000);
	  robot.keyRelease(KeyEvent.VK_V);  //v releasing 
	  
	  robot.keyPress(KeyEvent.VK_ENTER);  //enter key press
	  Thread.sleep(3000);
	  robot.keyRelease(KeyEvent.VK_ENTER); // enter key release
	  
	  System.out.println("fileUploaded successfully");
	  
	  
	  
  }
  @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
