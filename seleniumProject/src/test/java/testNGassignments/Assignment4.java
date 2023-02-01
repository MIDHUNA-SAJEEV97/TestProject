/*Prg 3 : Go to the url : https://qabible.in/payrollapp/site/login 

username : carol , passwd : 1q2w3e4r

Q1 : verify the successful Login. (For verification, pls use the username "Carol Thomas" on dashboard page, apply explicit wait for the 
		login button) 
Q2 : verify unsuccessful login. (apply explicit wait for the verification text)
Q3 : verify the dashboard page is displayed after login. 
Q4 : verify the creation of new client. 
(Steps : Click on "Clients" tab, click on "Create Client". fill all mandatory field as you like, then verify the created client)
In Q4, pls use scrolling also*/

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

public class Assignment4 {
	WebDriver driver;

	@Test(priority = 1)
	public void successfullLogin() {
		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicitwait
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='login-button']")));

		WebElement carolThomasDashboard = driver.findElement(By.xpath("//a[@href='#']"));
		String actualResult = carolThomasDashboard.getText();
		String expectedResult = "CAROL THOMAS";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 2)
	public void unSuccessfullLogin() {
		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("midhuna");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1234");
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();

		WebElement alertText = driver.findElement(By.xpath("//div[@style='color:#999;margin:1em 0']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicitwait
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@style='color:#999;margin:1em 0']")));

		String actualResult = alertText.getText();
		String expectedResult = "If you forgot your password you can reset it.";
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 3)
	public void dashBoardPageDisplayed() {
		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();

		WebElement dashBoardWelcomeMessage = driver.findElement(By.xpath("(//p[@align='center'])[1]"));
		System.out.println(dashBoardWelcomeMessage.getText());

		Boolean actualResult = dashBoardWelcomeMessage.isDisplayed();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 4)
	public void creationOfNewClient() throws InterruptedException {
		WebElement userName = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login-button']"));
		loginButton.click();
		WebElement clients = driver.findElement(By.xpath("//a[@href='/payrollapp/client/index']"));
		clients.click();
		WebElement createClient = driver.findElement(By.xpath("//a[@href='/payrollapp/client/create']"));
		createClient.click();
		
		WebElement selectPleaseSelectBranch = driver.findElement(By.xpath("//select[@id='client-branch_id']"));
		selectPleaseSelectBranch.click();
		Select select=new Select(selectPleaseSelectBranch);     //dropdown initialization
		select.selectByVisibleText("Alpha_new");
		//System.out.println(selectPleaseSelectBranch.getText());
		Thread.sleep(1000);
		
		WebElement selectPleaseSelectDivision = driver.findElement(By.xpath("//select[@id='client-division_id']"));
		selectPleaseSelectDivision.click();
		Select select1=new Select(selectPleaseSelectDivision);    //dropdown initialization
		select1.selectByVisibleText("NewAlpha");
		Thread.sleep(1000);
		
		WebElement invoiceOrder = driver.findElement(By.xpath("//select[@id='client-invoice_order']"));
		invoiceOrder.click();
		Select select3=new Select(invoiceOrder);    //dropdown initialization
		select3.selectByVisibleText("Single timesheet");
		Thread.sleep(1000);
		
		WebElement invoiceDeliveryMethod = driver.findElement(By.xpath("//select[@id='client-invoice_delivery_method']"));
		invoiceDeliveryMethod.click();
		Select select4=new Select(invoiceDeliveryMethod);    //dropdown initialization
		select4.selectByVisibleText("Electronic");
		Thread.sleep(1000);
		
		WebElement masterDocument = driver.findElement(By.xpath("//select[@id='client-master_document']"));
		masterDocument.click();
		Select select5=new Select(masterDocument);    //dropdown initialization
		select5.selectByVisibleText("PDF");
		Thread.sleep(1000);
	
		WebElement vatRate = driver.findElement(By.xpath("//select[@id='client-vat_rate']"));
		vatRate.click();
		Select select6=new Select(vatRate);    //dropdown initialization
		select6.selectByVisibleText("VAT 5.00%");
		Thread.sleep(1000);
		
		WebElement invoiceContact = driver.findElement(By.xpath("//input[@id='client-invoice_contact']"));
		invoiceContact.sendKeys("123456789");
		Thread.sleep(1000);
		
		WebElement clientName = driver.findElement(By.xpath("//input[@id='client-client_name']"));
		clientName.sendKeys("Midhuna");
		Thread.sleep(1000);
		
		WebElement phone = driver.findElement(By.xpath("//input[@id='client-phone']"));
		phone.sendKeys("9802456712");
		Thread.sleep(1000);
		
		WebElement clientAddress = driver.findElement(By.xpath("//textarea[@id='client-client_address']"));
		clientAddress.sendKeys("ABC Villa,Trivandrum");
		Thread.sleep(1000);
		
		WebElement email = driver.findElement(By.xpath("//input[@id='client-email']"));
		email.sendKeys("abc@gmail.com");
		Thread.sleep(1000);
		
		WebElement settlementDays = driver.findElement(By.xpath("//input[@id='client-settilement_days']"));
		settlementDays.sendKeys("30");
		Thread.sleep(1000);
		
		WebElement postCode = driver.findElement(By.xpath("//input[@id='client-postcode']"));
		postCode.sendKeys("681237");
		Thread.sleep(1000);
		
		WebElement companyReg = driver.findElement(By.xpath("//input[@id='client-company_reg']"));
		companyReg.sendKeys("67895625");
		Thread.sleep(1000);
		
		WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
		//saveButton.click();
		saveButton.submit();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",saveButton);    //scroll to an element
		Thread.sleep(1000);
		
		WebElement headingMidhunaOnTopLeft = driver.findElement(By.xpath("//h1[text()='Midhuna']"));
		System.out.println(headingMidhunaOnTopLeft.isDisplayed());
		Thread.sleep(1000);
		String expected="MIDHUNA";
		String actual=headingMidhunaOnTopLeft.getText();
		Assert.assertEquals(actual, expected);
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
