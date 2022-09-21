import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class DemoReports {

	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\"+"ExtentReportResults.html");
	test = report.startTest("DemoReports");
	}

	@BeforeTest
	public void InitializeD()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Deepa K laptop\\Readability S\\chromedriver.exe");
		 driver = new ChromeDriver();
		
	}
	@Test
	public void extentReportsDemo()
	{
	
		driver.get("https://www.yahoo.co.in");
		driver.manage().window().maximize();
		if(driver.getTitle().equals("Google"))
		{
			test.log(LogStatus.PASS, "navigated to the correct url");
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Test Failed");
			try {
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	@Test
	public void extentReportsDemoForG()
	{
	
		driver.get("https://www.yahoo.co.in");
		driver.manage().window().maximize();
		if(driver.getTitle().equals("Google"))
		{
			test.log(LogStatus.PASS, "navigated to the correct url");
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Test Failed");
			try {
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

@AfterClass
public static void endTest()
{
report.endTest(test);
report.flush();
}
public static String capture(WebDriver driver) throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File("D:\\Deepa K laptop\\Readability S\\" + System.currentTimeMillis()+ ".png");
	String errflpath = Dest.getAbsolutePath();
	Files.copy(scrFile, Dest);
	return errflpath;
	}
}
