package WebAutomation.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import WebAutomation.TestUtilities.BaseTest;

public class CurrencyConversion extends BaseTest{
	
     @Test
     public void currencyConvTest() {
    	 landingPage.selectCurrency("US Dollar");
    	 Assert.assertEquals(landingPage.getCurrencySymbol(),'$');
     }
	
}
