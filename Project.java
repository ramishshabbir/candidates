package HomeProject;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Project {

	Logger log = Logger.getLogger("trelloDemo");
	public String BaseUrl = "https://galaxy.pk/";
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	public String Expected="" ,Actual="";


@BeforeTest
public void Main() {
	driver = new ChromeDriver();		
	driver.get(BaseUrl);
	PropertyConfigurator.configure("log4j.properties");
	driver.manage().window().maximize();
	
	//Create objects
	actions = new Actions(driver);
	wait = new WebDriverWait(driver, Duration.ofSeconds(5));						
}
@AfterTest
public void CloseUrl() {
	//driver.close();
}

//Quick Access Funtion
	public  WebElement WaitXpath(String xpath) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element;
		}
	
	public void ActionsClick(WebElement element) {
		actions.click(element).perform();		
	}
@Test(priority=0)
public void HomePage() throws InterruptedException {
	//Hover on Products
	WebElement Products = WaitXpath("//ul[@id='menu-all-departments-1']//parent::div");
	actions.moveToElement(Products).perform();
	
	//Hover on Laptops and then click 
	WebElement Laptops = WaitXpath("//ul[@id='menu-all-departments-1']//child::li[@id='menu-item-4761']");
	actions.moveToElement(Laptops).perform();
	Thread.sleep(3000);
	ActionsClick(Laptops);
	
	//Back to Home
	WebElement Home = WaitXpath("//a[text()='Home']");
	ActionsClick(Home);
}

@Test(priority=0)
public void Tablets()  {
	WebElement Tablets = WaitXpath("//ul[@id='menu-all-departments-1']//child::a[@title='Tablet/Watches']");
	ActionsClick(Tablets);
	
}




}
