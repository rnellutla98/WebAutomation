package WebAutomation.Testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebAutomation.PageObjects.HomePage;
import WebAutomation.PageObjects.LoginPage;
import WebAutomation.PageObjects.MyCartPage;
import WebAutomation.TestUtilities.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddingToCart extends BaseTest {
	@Test
	public void AddItemToCart() {
		LoginPage lpage = landingPage.clickOnLogin();
		HomePage hpage = lpage.userLogin("eywaa@gmail.com", "hurtlocker");
		Assert.assertTrue(hpage.getLoginStatus());
		hpage.searchElementWithName("htc one");
		hpage.selectElementByName("HTC One Mini Blue");
		hpage.getToastMessage();
		Assert.assertEquals(hpage.getToastMessage(), prop.getProperty("addedToCartMessage"));
		hpage.waitForElementToDisappear(hpage.toastMessage);
		MyCartPage mcpage = hpage.goToCart();
		Assert.assertEquals(mcpage.getProduct(), "HTC One Mini Blue");
	}
}
