package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutLandingPage;
import pages.LoginPage;
import pages.OrderCompletePage;
import pages.ProductPage;
import pages.PurchasePage;

public class CheckOut_TC1 {

WebDriver driver=new ChromeDriver();
	
	@BeforeClass
	public void initialize() throws Exception {
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void verifyLoginPageLoaded() {
		
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test
	public void verifyItemsAddedToCart() {
		
		LoginPage login = new LoginPage(driver);
		
		ProductPage product = new ProductPage(driver);
		
		CartPage cart = new CartPage(driver);
		
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		
		product.sortHighToLow();
		product.selectFirstItems();
		product.goToCart();
		
		String expectedFleeceMsg = "Sauce Labs Fleece Jacket";
		String actualFleeceMsg = cart.verifyFleece();
		Assert.assertEquals(actualFleeceMsg, expectedFleeceMsg);
		
		String expectedBoltTshirtMsg = "Sauce Labs Bolt T-Shirt";
		String actualBoltTshirtMsg = cart.verifyBoltTshirt();
		Assert.assertEquals(actualBoltTshirtMsg, expectedBoltTshirtMsg);
		
	}
	
	@Test
	public void verifyItemsAndTotalAtCheckout() {
		
		ProductPage product = new ProductPage(driver);
		
		CartPage cart = new CartPage(driver);
		
		CheckoutLandingPage checkout = new CheckoutLandingPage(driver);
		
		PurchasePage purchase = new PurchasePage(driver);
		
		cart.removeBoltTshirt();
		cart.clickContinueShoppingBtn();
		
		product.selectBikeLight();
		product.goToCart();
		
		cart.clickCheckoutBtn();
		
		checkout.enterFirstName("John");
		checkout.enterLastName("Smith");
		checkout.enterZipCode("54321");
		checkout.clickContinueBtn();
		
		String expectedFleecePurchaseMsg = "Sauce Labs Fleece Jacket";
		String actualFleecePurchaseMsg = purchase.verifyFleecePurchase();
		Assert.assertEquals(actualFleecePurchaseMsg, expectedFleecePurchaseMsg);
		
		String expectedBikeLightPurchaseMsg = "Sauce Labs Bike Light";
		String actualBikeLightPurchaseMsg = purchase.verifyBikeLightPurchase();
		Assert.assertEquals(actualBikeLightPurchaseMsg, expectedBikeLightPurchaseMsg);
		
		String expectedTotalPriceMsg = "Total: $64.78";
		String actualTotalPriceMsg = purchase.verifyTotalPrice();
		Assert.assertEquals(actualTotalPriceMsg, expectedTotalPriceMsg);
		
		purchase.clickFinishBtn();
		
	}
	
	@Test
	public void verifyOrderCompleted() {
		
		OrderCompletePage complete = new OrderCompletePage(driver);
		
		String expectedOrderCompleteMsg = "THANK YOU FOR YOUR ORDER";
		String actualOrderCompleteMsg = complete.verifyCompletedMsg();
		Assert.assertEquals(actualOrderCompleteMsg, expectedOrderCompleteMsg);
		
	}
	
	@AfterClass
	public void TeardownTest() {
        driver.quit();
    }
	
}
