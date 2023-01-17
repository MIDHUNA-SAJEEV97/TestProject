/* pgrm2: Open Url : https://selenium.obsqurazone.com/index.php 
	Q1. Print the title and url of the page in console. 
	Q2. Navigate to Input form page.
	Click on Checkbook demo. Select the Check box one and Check box three.
	Verify them selected or not. */

package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationProgram2 {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();

			driver.get("https://selenium.obsqurazone.com/index.php");
			driver.manage().window().maximize();
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			
			   WebElement inputForm=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
			   inputForm.click();
			
			   WebElement checkBoxDemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		       checkBoxDemo.click();
		       WebElement multiplecheckBox=driver.findElement(By.xpath("//div[contains(text(),'Multiple')]"));
		       
		       WebElement checkBoxOne=driver.findElement(By.xpath("//input[@id='check-box-one']"));
		       checkBoxOne.click();
		     
		       WebElement checkBoxThree=driver.findElement(By.xpath("//input[@id='check-box-three']"));
		       checkBoxThree.click();
		      
		       System.out.println(checkBoxOne.isSelected());
		       System.out.println(checkBoxThree.isSelected());
			   driver.quit();
		}
	}


