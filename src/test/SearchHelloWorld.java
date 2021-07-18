package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import main.BaseClass;
import main.ConstantClass;


<<<<<<< Updated upstream:src/test/SeleniumAutomation.java
public class SeleniumAutomation extends BaseClass
{
	WebDriver driver;
=======
public class SearchHelloWorld extends BaseClass{
	
>>>>>>> Stashed changes:src/test/SearchHelloWorld.java
	
	@BeforeTest(alwaysRun=true)
	public void initializebrowser()
	{
		if(BaseClass.browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
	}

	@Test(dataProvider="Users")
	public void Selenium(String valuefromdatasheet)throws Exception
	{
	
		try
		{
		System.out.println("Started TestRun");
		driver.navigate().to(baseurl);
		boolean verify=driver.getPageSource().contains("Google");
		System.out.println("Google is Present or Not ?"+verify);
		Setvalue(ConstantClass.searchbox,ConstantClass.value,"xpath");
		System.out.println("Completed TestRun");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@AfterTest(alwaysRun=true)
	public void closebrowser()
	{
		driver.close();
	}
	
	

	//Set Value Function
	public void Setvalue(String locatorvalue,String valuetoset,String locatortype)
	{
		if(locatortype.equalsIgnoreCase("xpath"))
		{
		driver.findElement(By.xpath(locatorvalue)).sendKeys(valuetoset);
		}
	}
	

}

	
	


