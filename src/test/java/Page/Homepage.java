package Page;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class Homepage {
	WebDriver driver;
	By Popup=By.cssSelector("body > div:nth-child(8) > div > div.ant-drawer-content-wrapper > div > div > div.ant-drawer-header > button > span > svg");
	By Location=By.cssSelector("body > div:nth-child(9) > div > div.ant-drawer-content-wrapper > div > div > div.ant-drawer-body > div.ant-list.ant-list-split > div > div > ul > li:nth-child(1) > div");
	By login=By.xpath("//*[@id=\"root\"]/div[1]/header/div[3]/a[1]/span[1]");
	By phno=By.xpath("//*[@id=\"phone\"]");
	By otpclose=By.xpath("//*[@id=\"modal-root\"]/div/div/p/span/img");
	By title=By.xpath("//*[@id=\"root\"]/div[1]/header/div[1]/a/img");
	By logo=By.xpath("//*[@id=\"root\"]/div[1]/header/div[1]/a/img");
	By verify=By.xpath("/html/body/div[3]/div/div/form/div[2]/div[1]/button/span");
	By sendotp=By.xpath("/html/body/div[3]/div/div/form/button/span");
	By Shopstatus=By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/ul/li[3]/div/div[2]/p[3]/span");
	By selectshop=By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/ul/li[1]/div/div[2]/h3");
	By alertclose=By.xpath("/html/body/div[7]/div/div[2]/div/div[2]/div/div/div[2]/button/span");
	By Normalpham=By.xpath("/html/body/div[2]/main/div/div[2]/div[2]/div/div/ul/li[1]/div/div[2]/h3");
	By Choosefood1=By.xpath("/html/body/div[2]/main/div/div/div/div[2]/div/div[1]/div/div/div[1]/div[1]/button/span");
	By Selectshop2=By.xpath("/html/body/div[2]/main/div/div[2]/div[2]/div/div/ul/li[5]/div/div[2]/h3");
	By scrollelement=By.xpath("/html/body/div[2]/main/div/div[2]/div[2]/div/div/ul/li[9]/div/div[1]/img");
	By back=By.xpath("//*[@id=\"root\"]/div[1]/header/div[1]/a/span[1]");
	By snacks=By.xpath("//*[@id=\"rc-tabs-1-tab-3\"]");
	By Choosefood2=By.xpath("//*[@id=\"rc-tabs-1-panel-3\"]/div/div/div[2]/div[1]/button/span");
	By cart=By.xpath("//*[@id=\"root\"]/div[1]/header/div[3]/a[2]/span[1]");
	By screenshot=By.xpath("//*[@id='root']/main/div/div[1]/div/div[1]/div/img");
	By checkout=By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[2]/div/div");
	By Name=By.xpath("/html/body/div[2]/main/div/form/div[1]/span/input");
	By Address1=By.xpath("//*[@id=\"address_1\"]");
	By Address2=By.xpath("//*[@id=\"address_2\"]");
	By City=By.xpath("//*[@id=\"city\"]");
	By District=By.xpath("//*[@id=\"district\"]");
	By pincode=By.xpath("//*[@id=\"pin\"]");
	By Phoneno=By.xpath("//*[@id=\"phone\"]");
	By save=By.xpath("//*[@id=\"root\"]/main/div/form/button");
	By profileclick=By.xpath("//*[@id=\"root\"]/div[1]/header/div[3]/a[1]/span[2]");
	By changefulldetails=By.xpath("/html/body/div[2]/main/div/p[1]/a");
	By Email=By.xpath("//*[@id=\"email\"]");
	By Firstname=By.xpath("//*[@id=\"first_name\"]");
	By Lastname=By.xpath("//*[@id=\"last_name\"]");
	By Ph=By.xpath("//*[@id=\"phone\"]");
	By Savedetails=By.xpath("//*[@id=\"root\"]/main/div/form/button");
	By addaddress=By.xpath("//*[@id=\"root\"]/main/div/p[3]/a");
	By confirmadd=By.xpath("//*[@id=\"root\"]/main/div/div[2]/a");
	By addddressdetails=By.xpath("//*[@id='root']/main/div/a");
	By confirmshipngaddress=By.xpath("/html/body/div[2]/main/div/div[2]/a");
	By back1=By.xpath("//*[@id=\"root\"]/div[1]/header/div[1]/a/span[1]");
	By logout=By.xpath("/html/body/div[2]/main/div/a");
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void popUpclick() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(Popup).click();
		Thread.sleep(2000);
		driver.findElement(Location).click();
		Thread.sleep(2000);
		driver.findElement(login).click();		
		Thread.sleep(2000);
		
	}
	
	public void loginsetValue(String no)
	{
		driver.findElement(phno).sendKeys(no);
	}
	public void verifyOtp() throws InterruptedException
	{
		driver.findElement(sendotp).click();
		Thread.sleep(15000);
		driver.findElement(verify).click();
		
	}
	
	public void verifytitle()
	{
		String exp="Foodundo | Order online food from restaurants in Kuttiadi";
		 String actual=driver.getTitle();
		 System.out.println("Title is ----"+actual);
		
		 Assert.assertEquals(exp, actual);
		 
	}
	public void Logo()
	{
		Boolean Logo=driver.findElement(logo).isDisplayed();
		if(Logo)
		{
			System.out.println("Logo is diplayed");
		}
		else
		{
			System.out.println("Logo is not displayed");
		}
	}
public void screenshot() throws IOException
	
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("D://Foodundo2.png"));
	WebElement button=driver.findElement(screenshot);
	File buttonscreenshot=button.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(buttonscreenshot, new File("./Screenshot//foodundoimage2.png"));
	}
	
	public void scollDown()
	{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,200)","");
	//js.executeScript("arguments[0].scrollIntoView();", scrollelement);
	}
	public void shop() throws InterruptedException 
	{
		Thread.sleep(1000);
		WebElement shopstatus=driver.findElement(Shopstatus);
		String shopstatustext=shopstatus.getText();
		
		if(shopstatustext.equalsIgnoreCase("Not taking orders now"))
{
		
			driver.findElement(selectshop).click(); 
		System.out.println("shop is closed");
		Thread.sleep(1000);
		driver.findElement(alertclose).click();
	
}
else if(shopstatustext.equalsIgnoreCase("Taking orders"))
{
	System.out.println("shop  selected");
	//Thread.sleep(3000);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
	wait.until(ExpectedConditions.visibilityOfElementLocated(Normalpham));
	

	driver.findElement(Normalpham).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Choosefood1));
	//Thread.sleep(2000);
	driver.findElement(Choosefood1).click();
	driver.findElement(back).click();
	
	driver.findElement(Selectshop2).click();
	Thread.sleep(4000);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(snacks)).click();
	driver.findElement(snacks).click();
	driver.findElement(Choosefood2).click();
	Alert a=driver.switchTo().alert();
	a.accept();
	
}
	}
	
	public void cart()
	{
		driver.findElement(cart).click();
		driver.findElement(checkout).click();
		//driver.findElement(addddressdetails).click();
	}

	
	public void setAddress(String name,String addres1,String adress2,String city,String dist,String pin,String ph) throws InterruptedException
	{
		//Thread.sleep(2000);
		
		
		driver.findElement(Name).sendKeys(name);
		driver.findElement(Address1).sendKeys(addres1);
		driver.findElement(Address2).sendKeys(adress2);
		driver.findElement(City).sendKeys(city);
		driver.findElement(District).sendKeys(dist);
		driver.findElement(pincode).sendKeys(pin);
		driver.findElement(Phoneno).sendKeys(ph);
	}
	public void save()
	{
		driver.findElement(save).click();
	}
	public void confirmaddaddress() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(confirmshipngaddress).click();
		driver.findElement(back1).click();
	}
	public void profile() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		//Thread.sleep(2000);
		driver.findElement(profileclick).click();
		//Thread.sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-200)","");
		driver.findElement(changefulldetails).click();
	driver.findElement(Firstname).clear();
	WebElement firstname=driver.findElement(Firstname);
				firstname.sendKeys("Vrinda");
				driver.findElement(Lastname).clear();
		WebElement lastname=driver.findElement(Lastname);
		Actions act=new Actions(driver);
		act.keyDown(firstname,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(firstname,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(lastname,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.perform();
		
		driver.findElement(Savedetails).click();
	//	Thread.sleep(2000);
		driver.findElement(profileclick).click();
		driver.findElement(logout).click();
		System.out.println("Logged out sucesssfully");
	}
	
	
	
}
	