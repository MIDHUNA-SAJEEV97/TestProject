/*Go to the URL "http://omayo.blogspot.com/".

Prgm 1 : Select "doc 2" from "Older Newsletters drop down". 
*/

package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program5DropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement oldNewsLetterDropDown=driver.findElement(By.xpath("//select[@id='drop1']"));
		oldNewsLetterDropDown.click();
	    Select obj=new Select(oldNewsLetterDropDown);
	    //obj.selectByIndex(2);
	    obj.selectByValue("ghi");
	   // obj.selectByVisibleText("doc 2");
	    
	    WebElement msg=driver.findElement(By.id("ironman3"));
	    System.out.println(msg.getText());
	    driver.close();
	    
}}
