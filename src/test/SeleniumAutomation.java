package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import main.BaseClass;


public class SeleniumAutomation extends BaseClass{
	
	

	@Test(dataProvider="Users")
	public void Selenium(String SearchBox,String TestOne)throws Exception
	{
		try
		{
		
		WebDriver driver = new FirefoxDriver();	
		driver.navigate().to(baseurl);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='lst']")).sendKeys(SearchBox);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='lst']")).sendKeys(Keys.TAB);
		boolean value=driver.getPageSource().contains("Google");
		System.out.println("Google is Present or Not ?"+value+"-Google");
		
		driver.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}

	
	


