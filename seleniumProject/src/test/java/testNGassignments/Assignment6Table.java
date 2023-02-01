/*
 url : https://qalegend.com/restaurant/login    
 credentials : username : admin, password : password 
	Q 1 : Go to Product tab, add a new product as you like, then verify the added product is available or not in the table
	Q 2 : verify the edit funtionality of the added product
	 Steps to follow in
	Q2  1. Go to product tab.
		2. search the product name that is recently added. 
		3. Click on 'Edit' button in 'Action' column of the searched product (use following-sibling to find the xpath of the edit btn).
		4. Edit tax field (1st clear the tax field that having any value, then only enter new value). then submit.
		5. Again search the same product 
		6. print all row values in the console
		7. verify the edited tax is displayed or not*/

package testNGassignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assignment6Table {
	WebDriver driver;

	@Test(priority = 1)
	public void verifyAddedProductIsAvailableOrNotInTheTable() throws InterruptedException {
		
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("password");
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		loginButton.click();

		WebElement productTab = driver.findElement(By.xpath("(//span[@class='menu-text'])[2]"));
		//WebElement productTab = driver.findElement(By.xpath("//li[@class='flat-box waves-effect waves-block']/following-sibling::li[1]"));
		productTab.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='menu-text'])[2]"))); // explicit
		
		
		
		WebElement addProduct = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-add btn-lg']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;																									// wait
		js.executeScript("arguments[0].scrollIntoView()", addProduct);
		addProduct.click();
		WebElement productCode = driver.findElement(By.xpath("//input[@id='ProductCode']")); // add our own product
		productCode.sendKeys("pr001");
		WebElement productName = driver.findElement(By.xpath("//input[@id='ProductName']"));
		productName.sendKeys("dragonfruit");

		WebElement categoryDropDown = driver.findElement(By.xpath("//select[@id='Category']"));
		categoryDropDown.click();
		Select selectCategory = new Select(categoryDropDown);
		selectCategory.selectByVisibleText("fruits");
		WebElement price = driver.findElement(By.xpath("//input[@id='Price']"));
		price.sendKeys("180");
		Thread.sleep(1000);

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", price);
       // driver.navigate().refresh();
        		
		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
		js.executeScript("arguments[0].scrollIntoView()", submitButton);
		submitButton.click();
  		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']"))); // explicit
		js.executeScript("arguments[0].click();", submitButton);																									// wait
		 

		WebElement submitClick2 = driver.findElement(By.xpath("(//button[text()='submit'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='submit'])[2]"))); // explicit
																														// wait
		 //submitClick2.click();
		js.executeScript("arguments[0].click();", submitClick2);
        driver.navigate().refresh();
		WebElement searchbox = driver.findElement(By.xpath("//input[@type='search']"));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']"))); // explicit
		searchbox.sendKeys("dragonfruit");

		WebElement productNameDragonFruit = driver.findElement(By.xpath("//table[@id='Table']//tr//td[2]"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='Table']//tr//td[2]"))); // explicit
																														// wait
		//System.out.println(productNameDragonFruit.getText());

		Boolean acutal = productNameDragonFruit.isDisplayed();
		Assert.assertTrue(acutal);

	}

	@Test(priority = 2)
	public void verifyTheEditFuntionalityOfTheAddedProduct() {
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("password");
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		loginButton.click();

		// WebElement productTab =driver.findElement(By.xpath("(//span[@class='menu-text'])[2]"));
		WebElement productTab = driver.findElement(By.xpath("//li[@class='flat-box waves-effect waves-block']/following-sibling::li[1]"));
		productTab.click();
		WebElement search = driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
		search.sendKeys("dragonfruit");

		WebElement editButtonInAction = driver.findElement(By.xpath("(//a[@class='btn btn-default']/following-sibling::a[2])[1]"));
		editButtonInAction.click();
		WebElement tax = driver.findElement(By.xpath("//input[@id='Tax']"));
		tax.clear();
		tax.sendKeys("15");
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement searchBox = driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
		searchBox.sendKeys("dragonfruit");

		WebElement productNameDragonFruit = driver.findElement(By.xpath("//table[@id='Table']//tbody//tr"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='Table']//tbody//tr"))); // explicit
																														// wait
		System.out.println(productNameDragonFruit.getText());

		WebElement fromTableTaxDisplayed = driver.findElement(By.xpath("//table[@id='Table']//tbody//tr"));
		Boolean acutal = fromTableTaxDisplayed.isDisplayed();
		Assert.assertTrue(acutal);

	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qalegend.com/restaurant/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
