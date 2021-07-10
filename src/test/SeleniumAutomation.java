package test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.BaseClass;
import main.ConstantClass;

public class SeleniumAutomation extends BaseClass{
	
WebDriver driver;

@Parameters("browser")
@BeforeTest
public void browsertype(String browser)
{
	
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\Kirthiga\\Java Play Ground\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","D:\\Kirthiga\\Java Play Ground\\geckodriver.exe");
		driver=new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver","D:\\Kirthiga\\Java Play Ground\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
}

	@Test(dataProvider="Users")
	public void Selenium(String SearchBox,String TestOne)throws Exception
	{
		
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
		driver.navigate().to(baseurl);
		Thread.sleep(3000);
		driver.findElement(By.xpath(ConstantClass.searchbox)).sendKeys(SearchBox);
		Thread.sleep(3000);
		driver.findElement(By.xpath(ConstantClass.searchbox)).sendKeys(Keys.TAB);
		boolean value=driver.getPageSource().contains("Google");
		System.out.println("Google is Present or Not ?"+value);
		driver.findElement(By.xpath(ConstantClass.link)).click();
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	

}

	
	


