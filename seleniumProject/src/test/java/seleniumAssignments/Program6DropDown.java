/*Go to the URL "http://omayo.blogspot.com/".

  Prgm 2 : Select values Swift, Hyundai, and Audi from "Multi Selection box drop down".
then deselect all selected values by using deselectAll(). 
(Note : pls use all 3 selection methods to take values.)*/

package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program6DropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();

		WebElement multiSelectionboxDropDown = driver.findElement(By.xpath("//select[@id='multiselect1']"));
		Select obj = new Select(multiSelectionboxDropDown);
		obj.selectByIndex(2);
		obj.selectByValue("swiftx");
		obj.selectByVisibleText("Audi");
		obj.deselectAll();

		/*
		  WebElement msg=driver.findElement(By.xpath("//option[contains(text(),'Swift')]"));
		  System.out.println(msg.getText());
		 */
		driver.close();
	}
}
