package trello;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class trelloDemo {
	
	Logger log = Logger.getLogger("trelloDemo");
	public String BaseUrl = "https://trello.com/";
	public WebDriver driver;
	public WebDriverWait wait;
	public Faker faker;
	public  String winHan;
	public Actions actions;
	public String Expected="" ,Actual="";
	
	@BeforeTest
	public void Main() {
		//System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Ramish\\Desktop\\eclipse\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get(BaseUrl);
		PropertyConfigurator.configure("log4j.properties");
		driver.manage().window().maximize();
		
		//Create objects
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));						
	}
	
	
	//Quick Access Funtion
	public  WebElement WaitXpath(String xpath) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element;
		}
	
	public void ActionsClick(WebElement element) {
		actions.click(element).perform();		
	}
	
	public void SubmitButtonClick() {
		WebElement submitBut = WaitXpath("//button[@type='submit']");
		ActionsClick(submitBut);
	}
	
	
	@Test(priority=0)
	public void login() {
		WebElement Login = WaitXpath("//a[text()='Log in']");
		ActionsClick(Login);
	
		WebElement Email = WaitXpath("//input[@placeholder='Enter email']");
		Email.sendKeys("ramishshabbir1005@gmail.com");
		WaitXpath("//input[@id='login']").click();
			
		WebElement Password = WaitXpath("//input[@name='password']");
		Password.sendKeys("alquraish25");
		SubmitButtonClick();
		
		WebElement getTextElem = WaitXpath("//h3[@class='boards-page-section-header-name']");
		Actual = getTextElem.getText();
		Expected="YOUR WORKSPACES";
		Assert.assertEquals(Actual, Expected,"Not Loggedin Properly");	
		log.info("Login Successfull");
	}
	
	
	@Test(priority=1)
	public void CreateBoard() {
		
		WebElement Board = WaitXpath("//span[text()='Create new board']");
		ActionsClick(Board);
							
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		WebElement Btitle = WaitXpath("//input[@data-testid='create-board-title-input']");
		Btitle.sendKeys(faker.color().name());
		
		WebElement Cre_Board = WaitXpath("//button[text()='Create']");
		ActionsClick(Cre_Board);
		
		WebElement getTextElem = WaitXpath("//h2[text()='Workspace views ']");
		Actual = getTextElem.getText();
		Expected="Workspace views";
		Assert.assertEquals(Actual, Expected,"Board not created Properly");
		log.info("Board created successfully");
											
	}
	
	@Test(priority=2)
	public void makeList() {
				
		for(int i=0; i<2; i++){
			String ListName = RandomStringUtils.randomAlphabetic(8);
			WebElement Listname = WaitXpath("//input[@class='list-name-input']");
			Listname.sendKeys(ListName);
			
			WebElement AddList = WaitXpath("//input[@value='Add list']");
			ActionsClick(AddList);
			
       }
		/*WebElement getTextElem = WaitXpath("//span[text()='Add another list']");
		Actual = getTextElem.getText();
		Expected="Add another list";
		Assert.assertEquals(Actual, Expected,"Lists not created Properly");		*/
		log.info("lists are created successfully");
	}
	
	@Test(priority=3)
	public void AddCard() {
		
		WebElement AddCard = WaitXpath("(//span[@class='js-add-a-card'])[1]");
		ActionsClick(AddCard);
		
		String Cardname = RandomStringUtils.randomAlphabetic(8);
		WebElement CardName = WaitXpath("//textarea[@placeholder='Enter a title for this card…']");
		CardName.sendKeys(Cardname);
		CardName.sendKeys(Keys.ENTER);
		log.info("Card has been created");
	}
	
	@Test(priority=4)
	public void MoveCard() {
		Actions builder = new Actions(driver);
		WebElement from = WaitXpath("//span[@class='list-card-title js-card-name']");
		WebElement to = WaitXpath("(//span[@class='js-add-a-card'])[2]");
		builder.dragAndDrop(from, to).perform();
		log.info("card has been moved to list2");
		
	}
	
	@Test(priority=5)
	public void Editname() {
		
		WebElement card = WaitXpath("//span[@class='list-card-title js-card-name']");
		ActionsClick(card);
		
		WebElement nameClick = WaitXpath("//textarea[@class='mod-card-back-title js-card-detail-title-input']");
		ActionsClick(nameClick);
		nameClick.clear();
		nameClick.sendKeys("What you want to send");
		nameClick.sendKeys(Keys.ENTER);
		
		WebElement CancelBtn = WaitXpath("//a[@class='icon-md icon-close dialog-close-button js-close-window']");
		ActionsClick(CancelBtn);
		
		/*WebElement getTextElem = WaitXpath("//textarea[@class='mod-card-back-title js-card-detail-title-input']");
		Actual = getTextElem.getText();
		Expected="What you want to send";
		Assert.assertEquals(Actual, Expected,"Names are not updated Properly");*/
		log.info("crad name has been updated");
						
	}
	
	@Test(priority=6)
	public void DltCard() {
		WebElement card = WaitXpath("//span[@class='list-card-title js-card-name']");
		ActionsClick(card);
		
		WebElement archieve = WaitXpath("//a[@title='Archive']");
		ActionsClick(archieve);
		
		WebElement Delete = WaitXpath("//a[@title='Delete']");
		ActionsClick(Delete);
		
		WebElement Cnfrm = WaitXpath("(//input[@type='submit'])[6]");
		ActionsClick(Cnfrm);
		
	/*	WebElement getTextElem = WaitXpath("//p[text()='Trello Workspace']");
		Actual = getTextElem.getText();
		Expected="Trello Workspace";
		Assert.assertEquals(Actual, Expected,"Cards not deleted Properly"); */
		log.info("card has been deleted successfully");
		
	}
	
	
	
	@AfterTest
	public void CloseUrl() {
		//driver.close();
	}
	
}







//int size = driver.findElements(By.tagName("iframe")).size();
		//System.out.println(size);

//String uuid = UUID.randomUUID().toString();
		//String s = RandomStringUtils.randomAlphabetic(8);
		//Now this uuid enter to your text box
