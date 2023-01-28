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

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import WebAutomation.PageObjects.HomePage;
import WebAutomation.PageObjects.LandingPage;
import WebAutomation.PageObjects.LoginPage;
import WebAutomation.PageObjects.RegistrationConfirmationPage;
import WebAutomation.PageObjects.RegistrationPage;
import WebAutomation.TestUtilities.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegistration extends BaseTest{

	 @Test
	 public void userRegister() {		 
		 RegistrationPage rpage=landingPage.clickOnRegister();
		 RegistrationConfirmationPage cpage=rpage.performRegistration("male","Rahul","Nellutla","6","February","1997","eywaa@gmail.com","OpenText","hurtlocker","hurtlocker");
		 String actualMessage=cpage.getMessage();
		 Assert.assertEquals(actualMessage,prop.getProperty("registerSuccess"));
		 cpage.continueButton.click();
	 }
	 
	 @Test(dependsOnMethods= {"userRegister"})
	 public void userLogin() {
		 LoginPage lpage = landingPage.clickOnLogin();
		 HomePage hpage = lpage.userLogin("eywaa@gmail.com", "hurtlocker");
		 Assert.assertTrue(hpage.getLoginStatus());
	 }
	 
}
