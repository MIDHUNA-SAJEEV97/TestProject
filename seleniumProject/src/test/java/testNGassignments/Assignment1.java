/*url : https://demo.guru99.com/test/newtours/index.php Test case 


 * 1 : verify the application is correctly opens while hiting the url. 
 * Test case 2 : verify the logo (Mercury Tours) is displayed or not.
 *  Test case 3 : verify the successful SIGN-ON 
 *  Test case 4 : verify the Sign-in by using invalid username and password in home page
 *   Test case 5 : verify the REGISTER lnk is clickable or not 
 *   Test case 6 : verify the "One Way" radio button is selected by default or not 
 *   (Steps : click on Flights, then verify the test case)
 */

package testNGassignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assignment1 {
	WebDriver driver;

	@Test(priority=1)
	public void verifyApplicationCorrectlyOpensWhileGitingUrl() {

		String expectedText = "https://demo.guru99.com/test/newtours/index.php";
		// System.out.println(driver.getCurrentUrl());
		String actualText = driver.getCurrentUrl();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority=2)
	public void verifyLogoDisplayedOrNot() {

		WebElement mercuryLogo = driver.findElement(By.xpath("//img[@src='images/logo.gif']"));
		System.out.println(mercuryLogo.isDisplayed());
		Boolean actualResult = mercuryLogo.isDisplayed();
		Assert.assertTrue(actualResult);

	}

	@Test(priority=3)
	public void verifySuccessfulSignOn() {

		WebElement signOn = driver.findElement(By.xpath("//a[text()='SIGN-ON']"));
		signOn.click();
		WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
		userName.sendKeys("anna");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("1234");
		WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
		submit.click();
		
		//WebElement successfullLoginMsg = driver.findElement(By.xpath("//*[text()='Login Successfully']"));
		//WebElement successfullLoginMsg = driver.findElement(By.xpath("// table[@border='0' and @width='492']//tr[1]//td[1]"));
		WebElement successfullLoginMsg = driver.findElement(By.xpath("// table[@width='492']//tr[1]//td[1]"));
		System.out.println(successfullLoginMsg.isDisplayed());
		Boolean actualResult = successfullLoginMsg.isDisplayed();
		Assert.assertTrue(actualResult);
 
	}

	@Test(priority=5)
	public void registerLinkClickableOrNot() {

		WebElement registerButton = driver.findElement(By.xpath("//a[text()='REGISTER']"));
		registerButton.click();

		String expectedText = "https://demo.guru99.com/test/newtours/register.php";
		// System.out.println(driver.getCurrentUrl());
		String actualText = driver.getCurrentUrl();
		Assert.assertEquals(actualText, expectedText);

	}

	@Test(priority=6)
	public void oneWayRadioButtonSelectedbyDefaultOrnot() {

		WebElement flights = driver.findElement(By.xpath("//a[text()='Flights']"));
		flights.click();
		// driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
		WebElement flightsOneWayButton = driver.findElement(By.xpath("(//input[@name='tripType'])[2]"));
		// flightsOneWayButton.click();
		Boolean actualResult = flightsOneWayButton.isSelected();
		Assert.assertFalse(actualResult);                //by default oneway is not enabled, so false condition check

	}

	@Test(priority=4)
	public void signInUsingInvalidUsernameAndPasswordinHomepage() {

		WebElement userNameinCorrect = driver.findElement(By.xpath("//input[@name='userName']"));
		userNameinCorrect.sendKeys("chinnu");
		WebElement passwordinCorrect = driver.findElement(By.xpath("//input[@name='password']"));
		passwordinCorrect.sendKeys("1234");
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
		submitButton.click();
		WebElement incorrectLoginMsg = driver.findElement(By.xpath("(//table[@width='100%'])[2]//tr[3]//td[2]//span"));
		
		Boolean actualResult = incorrectLoginMsg.isDisplayed();
		Assert.assertTrue(actualResult);
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
