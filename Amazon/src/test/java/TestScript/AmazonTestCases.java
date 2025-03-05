package TestScript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageClasses.AmazonHomePage;
import PageClasses.AmazonProductDetailsPage;
import PageClasses.AmazonProductListingPage;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonTestCases extends BaseClass{
	public WebDriver driver;
	AmazonHomePage homepage;
	AmazonProductListingPage listingpage;
	AmazonProductDetailsPage detailsPage;//object declaration
	@BeforeMethod
	public void browserInitialization() throws Exception
	{
		driver= initializeMethod("Chrome");
		driver.get("https://selenium.qabible.in/");
		driver.manage().window().maximize();
		homepage=new AmazonHomePage(driver);
		listingpage=new AmazonProductListingPage(driver);
		detailsPage =new AmazonProductDetailsPage(driver);//creating object 
		
	System.out.println("Before method");
	
	}
@Test
	public void TC01()
	{
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("(//div[@class='flex flex-auto items-center relative']//child::button)[2]")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Smart TV");
		driver.findElement(By.xpath("(//div[@class='flex flex-auto items-center relative']//child::button)[2]")).click();
		//driver.findElement(By.className("a-button-input")).click();
		//driver.findElement(By.tagName("input")).click();//tagname
		//driver.findElement(By.linkText("Conditions of Use")).click();//link text 
		//driver.findElement(By.partialLinkText("Privacy")).click();//partial link text
	}
	@Test
	public void TC02() throws InterruptedException
	
	{
	driver.navigate().to("https://www.amazon.ca/");	
	//driver.navigate().back();
	//Thread.sleep(4000);
	//driver.navigate().forward();
	//Thread.sleep(4000);
	//driver.navigate().refresh();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement dropdown=driver.findElement(By.id("s-result-sort-select"));
		//Select obj=new Select(dropdown);
		//obj.selectByValue("price-asc-rank");
		//obj.selectByVisibleText("Best Sellers");
		//obj.selectByIndex(0);
		List<WebElement> products=driver.findElements(By.xpath("//h2[@class='a-size-base-plus -spacing-none a-color-base a-text-normal']//child::span"));
	System.out.println(products.size());// will get the size of array list
	driver.quit();//used to close browser
	}
	@Test(priority = 3)
	public void TC03()
	{
	String	s=driver.findElement(By.xpath("//div[@class='container']//p")).getText();
	System.out.println(s);
	String k=driver.findElement(By.xpath("//div[@class='top-logo']//img")).getAttribute("src");
	System.out.println(k);
	String a=driver.findElement(By.xpath("//div[@class='top-logo']//img")).getTagName();
	System.out.println(a);
	driver.close();//used to close tab if we have more than one tab
	}
	@Test(priority  =1)
public void TC04() throws InterruptedException
{
		SoftAssert softassert=new SoftAssert();//object of Softassert
	driver.navigate().to("https://selenium.qabible.in/javascript-alert.php");
	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().dismiss();
	driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	driver.switchTo().alert().sendKeys("sreeja");
	driver.switchTo().alert().accept();
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='btn btn-warning']"))));
	boolean status=driver.findElement(By.xpath("//button[@class='btn btn-warning']")).isDisplayed();//Soft assertion is uesd by creating object
	AssertJUnit.assertEquals(status, true);
	driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
	String p=driver.switchTo().alert().getText();
	System.out.println(p);
	softassert.assertAll();
}
@Test
public void TC05()
{
	driver.navigate().to("https://selenium.qabible.in/drag-drop.php");
	 Actions action=new Actions(driver);
	 WebElement source=driver.findElement(By.xpath("(//div[@id='todrag']//child::span)[1]"));
	 WebElement destination=driver.findElement(By.xpath("//div[@id='mydropzone']"));
	// action.dragAndDrop(source, destination).build().perform();
	 //action.moveToElement(driver.findElement(By.id("others"))).build().perform();
	// action.contextClick().build().perform();
	 action.doubleClick(driver.findElement(By.id("others"))).build().perform();
		/*
		 * action.keyDown(Keys.ENTER).build(); action.keyUp(Keys.ENTER).build();
		 * action.build().perform();
		 */
	 driver.navigate().to("https://www.amazon.in/");
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	boolean buttonstatus= driver.findElement(By.id("nav-search-submit-button")).isDisplayed();
AssertJUnit.assertEquals(buttonstatus, true);
	boolean status= driver.findElement(By.id("nav-search-submit-button")).isEnabled();
	AssertJUnit.assertEquals(status, true);
	
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]")).click();
		String parent=driver.getWindowHandle();
		Set<String> tabes=driver.getWindowHandles();//to find all tabs in website
		for(String actual:tabes)
		{
		if(!actual.equalsIgnoreCase(parent))
		{
			driver.switchTo().window(actual);
			WebElement element=driver.findElement(By.xpath("(//input[@name='submit.add-to-cart'])[2]"));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",element);//Scrolling the page)
		//element.submit();//same as click
		js.executeScript("arguments[0].click();",element);//to click on the hidden element
		}
		driver.switchTo().window(parent);
		}
}
		@Test
		public void TC06() throws InterruptedException
		{
				SoftAssert softassert=new SoftAssert();//object of Softassert
			driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
			driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("sreeja");
			driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();//Soft assertion is used by creating object
			String  status=driver.findElement(By.xpath("//div[@id='message-one']")).getText();//Soft assertion is used by creating object
			
			
			driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys("5");
			driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys("3");
			WebElement element=driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]"));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",element);
			
			driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();//Soft assertion is used by creating object
			String total=driver.findElement(By.id("message-two")).getText();
			AssertJUnit.assertEquals(total,"Total A + B : 8");
			softassert.assertAll();
			
			
}
		@Test
		public void TC07() throws InterruptedException	
		{
			 driver.navigate().to("https://www.amazon.in/");
			homepage.searchProduct("iphone");
			listingpage.firstProduct().click();
		
		
		String parent=driver.getWindowHandle();
		Set<String> tabes=driver.getWindowHandles();//to find all tabs in website
		for(String actual:tabes)
		{
		if(!actual.equalsIgnoreCase(parent))
		{
			driver.switchTo().window(actual);
			WebElement element=detailsPage.addTocartButton();
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",element);//Scrolling the page)
		//element.submit();//same as click
		js.executeScript("arguments[0].click();",element);//to click on the hidden element
		}
		driver.switchTo().window(parent);
		}
			
		}
		@Test(dataProvider = "testdatas")
		public void TC08(String A, String B) throws InterruptedException	
		{
			driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
			driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys(A);
			driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys(B);
			WebElement element=driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]"));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",element);
			
			driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
			
		}
		@DataProvider(name="testdatas")//name of data provider
		public Object[][] testDataFeed()
		{
			Object [][] testdata=new Object[2][2];
			testdata[0][0]="10";
			testdata[0][1]="12";
			testdata[1][0]="15";
			testdata[1][1]="18";
			return testdata;
		}
		
		
@BeforeSuite
public void beforeSuite() 
{
	System.out.println("BeforeSuite");

	}
@AfterSuite
public void afterSuite()
{
	System.out.println("AfterSuite");
	}
@BeforeTest
public void beforeTest()
{
	System.out.println("BeforeTestmethod");
	}
@AfterTest
public void afterTest()
{
	System.out.println("afterTestmethod");
	}
@AfterMethod

public void tearDown()
{
	//driver.quit();
	System.out.println("after method");
	}
@BeforeClass
public void beforeClass()
{
	
	System.out.println("before class");
	}
@AfterClass
public void afterClass()
{
	
	System.out.println("after class");

}
@BeforeGroups
public void beforeGroup()
{
	System.out.println("beforegroup");
	}
@AfterGroups
public void afterGroup()
{
	System.out.println("aftergroup");
	}
}

