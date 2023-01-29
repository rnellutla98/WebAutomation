package WebAutomation.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import WebAutomation.PageObjects.HomePage;
import WebAutomation.PageObjects.LoginPage;
import WebAutomation.TestUtilities.BaseTest;

public class CommunityPollTest extends BaseTest {
	@Test
	public void communityPollwithoutLogin() {
		String message = landingPage.getPollErrorMessage("Excellent");
		Assert.assertEquals(message, prop.getProperty("pollErrorMessage"));
	}
	
	@Test
	public void communityPollwithLogin() {
		LoginPage lpage = landingPage.clickOnLogin();
		HomePage hpage = lpage.userLogin("eywaa@gmail.com", "hurtlocker");
		String message = hpage.getPollMessage("Excellent");
		Assert.assertTrue(message.contains("vote"));
	}
	
	

}
