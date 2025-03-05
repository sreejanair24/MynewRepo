package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProductDetailsPage //using page object model
{
WebDriver driver;
By addtocartbtn=By.xpath("(//input[@name='submit.add-to-cart'])[2]");








public AmazonProductDetailsPage(WebDriver driver) //calling driver from testcase page 
{
	this.driver=driver;
}








public WebElement addTocartButton()
{
	return(driver.findElement(addtocartbtn));
	}














}
