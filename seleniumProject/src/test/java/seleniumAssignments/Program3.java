 /*prgm 3: Open Url : https://selenium.obsqurazone.com/index.php 
	 Q1. Navigate to Input form page. Click on Radio buttons demo. 
	 Select gender as female, click on Show selected value, then print the getting message.
	 And also very the female radio button is selected or not. */

package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program3 {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
	
			driver.get("https://selenium.obsqurazone.com/index.php");
			driver.manage().window().maximize();
			driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
			
		   WebElement inputForm=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
		   inputForm.click();
		 
		   WebElement radioButtonsDemo=driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
		   radioButtonsDemo.click();
		   
		   WebElement femaleButton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		   femaleButton.click();
		   
		   WebElement showSelectedValue=driver.findElement(By.xpath("//button[@id='button-one']"));
		   showSelectedValue.click();
		  
		   WebElement femaleSelected=driver.findElement(By.xpath("//div[@id='message-one']"));
		   femaleSelected.click();
		 
		   System.out.println(femaleButton.isSelected());
		   System.out.println(femaleSelected.getText());
		   driver.quit();
				 
	}}
