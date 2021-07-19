package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import main.BaseClass;
import main.ConstantClass;



public class SearchHelloWorld extends BaseClass{
	
	WebDriver driver;
	

	
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
		boolean searchboxpath=driver.findElement(By.xpath(ConstantClass.searchbox)).isDisplayed();
	    System.out.println("SearchBox is Present?:"+searchboxpath);
		Setvalue(ConstantClass.searchbox,valuefromdatasheet,"xpath");
		String Text=driver.findElement(By.className("gssb_m")).getText();
		boolean verify=Text.contains(valuefromdatasheet.toLowerCase().toString());
		System.out.println(valuefromdatasheet+" is Present or Not ?"+verify);		
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

	
	


