package WebAutomation.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebAutomation.TestUtilities.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegistration extends BaseTest{

	 @Test
	 public void userRegister() {		 
		 driver.get("https://demo.nopcommerce.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.manage().window().maximize();
		 driver.findElement(By.cssSelector(".ico-register")).click();
		 driver.findElement(By.xpath("//span[@class='male']")).click();
		 driver.findElement(By.id("FirstName")).sendKeys("Rahul");
		 driver.findElement(By.id("LastName")).sendKeys("Nellutla");
		 WebElement dd1=driver.findElement(By.xpath("//*[@name='DateOfBirthDay']"));
		 Select ss1=new Select(dd1);
		 ss1.selectByVisibleText("6");
		 WebElement dd2=driver.findElement(By.xpath("//*[@name='DateOfBirthMonth']"));
		 Select ss2=new Select(dd2);
		 ss2.selectByVisibleText("February");
		 WebElement dd3=driver.findElement(By.xpath("//*[@name='DateOfBirthYear']"));
		 Select ss3=new Select(dd3);
		 ss3.selectByVisibleText("1997");
		 driver.findElement(By.cssSelector("#Email")).sendKeys("torwo@gmail.com");
		 driver.findElement(By.cssSelector("#Company")).sendKeys("opentext");		
		 if(!(driver.findElement(By.cssSelector("#Newsletter")).isSelected())) {
			 driver.findElement(By.cssSelector("#Newsletter")).click();
		 }
		 driver.findElement(By.cssSelector("#Password")).sendKeys("hurtlocker");
		 driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("hurtlocker");
		 driver.findElement(By.name("register-button")).click();
		 String successMessage=driver.findElement(By.cssSelector(".result")).getText();
		 Assert.assertEquals(successMessage,"Your registration completed");
		 driver.findElement(By.cssSelector(".register-continue-button")).click();
	 }
	 
	 @Test(dependsOnMethods= {"userRegister"})
	 public void userLogin() {
		
		 driver.findElement(By.cssSelector(".ico-login")).click();
		 driver.findElement(By.cssSelector(".email")).sendKeys("torwo@gmail.com");
		 driver.findElement(By.cssSelector(".password")).sendKeys("hurtlocker");
		 driver.findElement(By.cssSelector(".login-button")).click();
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ico-account"))));
	 }
	 
}
