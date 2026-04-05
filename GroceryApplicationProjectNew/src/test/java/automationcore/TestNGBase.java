package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtilities;

public class TestNGBase {

	public WebDriver driver;
	Properties prop;
	FileInputStream f;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")   
	public void browserLaunch(String browser) throws Exception {
		prop=new Properties();
		f=new FileInputStream(Constant.configfile);
		prop.load(f);

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {   
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} 
		else {
			throw new Exception("Invalid Browser");
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenshotUtilities screenShot = new ScreenshotUtilities();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}