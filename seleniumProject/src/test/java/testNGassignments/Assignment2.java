/*Prg 1 : Go to the Url : https://selenium.obsqurazone.com/index.php

Q1 : Go to TABLE page, Print the all details of the person "Tiger Nixon" in the console and verify that.
Q2 : Go to TABLE page, Click on Table sort and search. Search name as "Dai Rios" in the search box. Then very the searched name is display or not.
(use explicit wait in "Dai Rios")
Q3 : Apply explicit wait (visibilityOfElementLocated) on the element "HOME", then verify the HOME Tab is displayed or not */

package testNGassignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assignment2 {
	
	WebDriver driver;
  @Test(priority=1)
  public void printTheDetailsOfTigerNixon() {
	  WebElement table = driver.findElement(By.xpath("//a[@href='table-pagination.php']"));
	  table.click();
	  WebElement tigerNixon = driver.findElement(By.xpath("//table[@id='dtBasicExample']//tr[@class='odd']"));
	  System.out.println(tigerNixon.getText());
	  Boolean actualResult=tigerNixon.isDisplayed();
	  Assert.assertTrue(actualResult); 
  }
  @Test(priority=2)
  public void searchedNameDisplayedOrNot() throws InterruptedException {
	  WebElement table = driver.findElement(By.xpath("//a[@href='table-pagination.php']"));
	  table.click();
	  WebElement tableSortAndSearch= driver.findElement(By.xpath("//a[text()='Table Sort And Search']"));
	  tableSortAndSearch.click();
	
	  WebElement search= driver.findElement(By.xpath("//input[@type='search']"));
	  search.sendKeys("Dai Rios");
	  Thread.sleep(1000);
	
	  WebElement daiRios= driver.findElement(By.xpath("//table[@id='dtBasicExample']//tr[1]//td[1]"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));   //explicitwait
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='dtBasicExample']//tr[1]//td[1]")));
	  Boolean actualResult= daiRios.isDisplayed();
	  Assert.assertTrue(actualResult); 
  }
  @Test(priority=3)
  public void explicitWaitOnHomeElement() {
	  WebElement home = driver.findElement(By.xpath("//a[text()='Home']"));
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));   //explicitwait
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Home']")));
	  System.out.println(home.isDisplayed());
	  
	  Boolean actualResult=home.isDisplayed();
	  Assert.assertTrue(actualResult); 
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
