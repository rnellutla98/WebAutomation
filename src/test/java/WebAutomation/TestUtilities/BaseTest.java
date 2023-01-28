package WebAutomation.TestUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	String browser;	
	
   @BeforeMethod
   public void initDriver() throws IOException {
	   FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\WebAutomation\\GenericUtilities\\General.properties");
		Properties prop=new Properties();
		prop.load(fis);
		browser=prop.getProperty("browser");
		System.out.println(browser);
	   if( browser.equals("chrome")){
	     WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 
	   }
	   else if(browser.equals("firefox")) {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
	   }
	   else if(browser.equals("edge")) {
		   WebDriverManager.edgedriver().setup();
		   driver=new EdgeDriver();
		   
	   }
	   driver.get(prop.getProperty("landingPage"));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   driver.manage().window().maximize();
   }
   @AfterMethod
   public void tearDown() {
	  driver.close(); 
   }
}
