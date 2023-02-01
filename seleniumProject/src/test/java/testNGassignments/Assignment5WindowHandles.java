/*  Url : https://www.hyrtutorials.com/p/window-handles-practice.html 
TC 1 : verify the correct window is opened while clicking Open New Window button. 
TC 2 : verify the registration is successful or not
TC 3 : verify the correct window is opened while clicking Open New Tab button.
TC 4 : verify the simple alert is accepted or not while clicking 1st Click me button.
TC 5 : verify the propmt alert is accepted or not while clicking 3rd Click me button.*/

package testNGassignments;

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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assignment5WindowHandles {
	WebDriver driver;

	@Test(priority = 1)
	public void correctWindowOpenedWhileClickingOpenNewWindowButton() throws InterruptedException {

		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window handle is " + parentWindow);
		WebElement openNewWindowButton = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='newWindowBtn']"))); // explicit wait
		openNewWindowButton.click();
		Thread.sleep(1000);

		Set<String> childWindows = driver.getWindowHandles();
		System.out.println("child Window handles : " + childWindows);
		Iterator<String> iterator = childWindows.iterator();
		while (iterator.hasNext()) {
			String child = iterator.next();

			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.manage().window().maximize();

				WebElement basicControsHeading = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
				String expected = "Basic Controls";
				String actual = basicControsHeading.getText();
				Assert.assertEquals(actual, expected);
			}

		}

		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void registrationSuccessfulOrNot() throws InterruptedException {

		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window handle is " + parentWindow);
		WebElement openNewWindowButton = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='newWindowBtn']"))); // explicit wait
		// JavascriptExecutor js = (JavascriptExecutor) driver; //scrolling
		// js.executeScript("arguments[0].scrollIntoView();", openNewWindowButton);
		openNewWindowButton.click();

		Set<String> childWindows = driver.getWindowHandles();
		System.out.println("child Window handles : " + childWindows);
		Iterator<String> iterator = childWindows.iterator();
		while (iterator.hasNext()) {
			String child = iterator.next();

			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.manage().window().maximize();

				WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
				firstName.sendKeys("midhuna");

				WebElement genderFemale = driver.findElement(By.xpath("//input[@id='femalerb']"));
				genderFemale.click();

				WebElement registerButton = driver.findElement(By.xpath("//button[@id='registerbtn']"));
				registerButton.click();
				Thread.sleep(3000);
				WebElement successFullMsg = driver.findElement(By.xpath("//label[@id='msg']"));
				Thread.sleep(3000);
				System.out.println(successFullMsg.getText());
				String expected = "Registration is Successful";
				String actual = successFullMsg.getText();
				Assert.assertEquals(actual, expected);

				Thread.sleep(3000);
				driver.close(); // if needed to close child here
			}

		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void verifyCorrectWindowOpenedWhileClickingOpenNewTabButton() throws InterruptedException {

		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window handle is " + parentWindow);
		WebElement openNewTabButton = driver.findElement(By.xpath("//button[@id='newTabBtn']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='newTabBtn']"))); // explicit wait
		openNewTabButton.click();
		Thread.sleep(1000);

		Set<String> childWindows = driver.getWindowHandles();
		System.out.println("child Window handles : " + childWindows);
		Iterator<String> iterator = childWindows.iterator();
		while (iterator.hasNext()) {
			String child = iterator.next();

			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.manage().window().maximize();

				WebElement alertsDemoHeading = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
				System.out.println(alertsDemoHeading.getText());
				String expected = "AlertsDemo";
				String actual = alertsDemoHeading.getText();
				Assert.assertEquals(actual, expected);
			}

		}

		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void verifySimpleAlertAcceptedOrNotWhileClicking1stClickMeButton() throws InterruptedException {

		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window handle is " + parentWindow);
		WebElement openNewTabButton = driver.findElement(By.xpath("//button[@id='newTabBtn']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='newTabBtn']"))); // explicit wait
		openNewTabButton.click();

		Set<String> childWindows = driver.getWindowHandles();
		System.out.println("child Window handles : " + childWindows);
		Iterator<String> iterator = childWindows.iterator();
		while (iterator.hasNext()) {
			String child = iterator.next();

			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.manage().window().maximize();

				WebElement firstClickMeButton = driver.findElement(By.xpath("//button[@id='alertBox']"));

				// WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='alertBox']"))); // explicit
																											// wait
				firstClickMeButton.click();

				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();

				WebElement youSelectedAlertPopUpMsg = driver.findElement(By.xpath("//div[@id='output']"));
				JavascriptExecutor js = (JavascriptExecutor) driver; // scrolling
				js.executeScript("arguments[0].scrollIntoView();", youSelectedAlertPopUpMsg);

				System.out.println(youSelectedAlertPopUpMsg.getText());

				String expected = "You selected alert popup";
				String actual = youSelectedAlertPopUpMsg.getText();
				Assert.assertEquals(actual, expected);

				driver.close();
			}

		}

		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);

	}

	@Test(priority = 5)
	public void verifyPromptAlertAcceptedOrNotWhileClicking3stClickMeButton() throws InterruptedException {

		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window handle is " + parentWindow);
		WebElement openNewTabButton = driver.findElement(By.xpath("//button[@id='newTabBtn']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='newTabBtn']"))); // explicit wait
		openNewTabButton.click();
		Thread.sleep(1000);

		Set<String> childWindows = driver.getWindowHandles();
		System.out.println("child Window handles : " + childWindows);
		Iterator<String> iterator = childWindows.iterator();
		while (iterator.hasNext()) {
			String child = iterator.next();

			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.manage().window().maximize();

				WebElement thirdClickMeButtonPrompt = driver.findElement(By.xpath("//button[@id='promptBox']"));
				// WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='alertBox']"))); // explicit
																											// wait

				thirdClickMeButtonPrompt.click();

				driver.switchTo().alert().sendKeys("midhuna");
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();

				WebElement enteredPopUpMsgDisplay = driver.findElement(By.xpath("//div[@id='output']"));
				JavascriptExecutor js = (JavascriptExecutor) driver; // scrolling
				js.executeScript("arguments[0].scrollIntoView();", enteredPopUpMsgDisplay);

				System.out.println(enteredPopUpMsgDisplay.getText());

				String expected = "You entered text midhuna in propmt popup";
				String actual = enteredPopUpMsgDisplay.getText();
				Assert.assertEquals(actual, expected);
			}

		}

		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);

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
