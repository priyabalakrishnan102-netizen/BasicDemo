package genericutility;
import java.io.IOException;
	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.edge.EdgeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxOptions;
	import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import objectrepository.DashboardPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;
	public class BaseClass {
		
		public static WebDriver driver;
		public static ExtentReports report;
		public static ExtentTest test;
		
		public Fileutility fu= new Fileutility();
		public Excelutility eu=new Excelutility();
		public Javautility ju= new Javautility();
		public Listenerutility lu= new Listenerutility();
		public Webdriverutility wu = new Webdriverutility();
		@BeforeSuite
		public void reportConfig() {
			ExtentSparkReporter spark= new ExtentSparkReporter("./HTML_Reports/ExtentReports_"+ju.getSystemTime()+".html");
			report=new ExtentReports();
			report.attachReporter(spark);
		}
		@Parameters("browser")
		@BeforeTest
		public void openBrowser(String browser) throws IOException {
			if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			}else if(browser.equalsIgnoreCase("edge")) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--incognito");
				driver = new EdgeDriver(options);
			}else if(browser.equalsIgnoreCase("forefox")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--incognito");
				driver = new FirefoxDriver(options);
			}else {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			String url = fu.readPropertyData("url");
			driver.get(url);
		}
		@BeforeMethod
		public void login() throws IOException {
//			driver.findElement(By.className("ico-login")).click();
			DashboardPage d= new DashboardPage(driver);
			d.SetLoginLink();
//			driver.findElement(By.id("Email")).sendKeys("admin123@email.com");
//			driver.findElement(By.id("Password")).sendKeys("12345678");
//			driver.findElement(By.className("login-button")).click();
			LoginPage l= new LoginPage(driver);
			String email = fu.readPropertyData("email");
			String pwd = fu.readPropertyData("password");
			
			l.setloginButton(email, pwd);
		}
		@AfterMethod
		public void logout() {
//			driver.findElement(By.linkText("Log out")).click();
			HomePage h= new HomePage(driver);
			h.setLogout();
		}
		@AfterTest
		public void closeBrowser() {
			driver.quit();
		}
		
		@AfterSuite
		public void reportBackup() {
			report.flush();
		

	}


}
