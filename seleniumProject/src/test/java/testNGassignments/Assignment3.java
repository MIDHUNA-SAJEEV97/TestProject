/*Prg 2 : Go to the Url : https://selenium.obsqurazone.com/index.php

Go to Alerts and Modals, click on "Javascript Alert", then click on 1st "Click me!" button,
Apply alertsPresent() expectedCondition,then print alert msg in console and accept the alert. */

package testNGassignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Assignment3 {
	WebDriver driver;

  @Test
  public void alertHandling() {
	
	  WebElement alertsAndModals= driver.findElement(By.xpath("//a[@id='alert-modal']"));
	  alertsAndModals.click();
	  WebElement javaScriptAlert= driver.findElement(By.xpath("//a[text()='Javascript Alert']"));
	  javaScriptAlert.click();
	  WebElement firstClickMe= driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	  firstClickMe.click();
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));   //explicitwait
	  wait.until(ExpectedConditions.alertIsPresent());
	  
	  System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().accept();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}