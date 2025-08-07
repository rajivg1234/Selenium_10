package GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Objectrepository.HomePage;
import Objectrepository.LoginPage;
import Objectrepository.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports ereport;
	public static ExtentTest test;
	
	public JavaUtility jutil=new JavaUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public FileUtility futil=new FileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	
	@BeforeSuite
	public void reportCnfig() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/ExtentReport_"+jutil.getSystemTime()+".html");
		ereport=new ExtentReports();
		ereport.attachReporter(spark);
	}
	@BeforeClass
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		wutil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(futil.getDatafromProperty("url"));
	}
	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp=new WelcomePage(driver);
		wp.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getEmailTextField().sendKeys(futil.getDatafromProperty("email"));
		lp.getPasswordTextField().sendKeys(futil.getDatafromProperty("password"));
		lp.getLoginButton().click();	
	}
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogout().click();
		
	}
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogout().click();
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}	
	@AfterSuite
	public void reportBackup() {
		ereport.flush();
	}
}

