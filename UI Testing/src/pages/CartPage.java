package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		this.driver = driver;

	}
	
	By fleeceJacket = By.xpath(".//*[text()='Sauce Labs Fleece Jacket']");
	By boltTshirt = By.xpath(".//*[text()='Sauce Labs Bolt T-Shirt']");
	By removeBoltTshirtBtn = By.cssSelector("button[id='remove-sauce-labs-bolt-t-shirt']");
	By continueShoppingBtn = By.cssSelector("button[id='continue-shopping']");
	By checkoutBtn = By.cssSelector("button[id='checkout']");
	
	public void verifyItems() {
		System.out.println(driver.findElement(fleeceJacket).getText());
		System.out.println(driver.findElement(boltTshirt).getText());
	}
	
	public String verifyFleece() {
		return driver.findElement(fleeceJacket).getText();
	}
	
	public String verifyBoltTshirt() {
		return driver.findElement(boltTshirt).getText();
	}
	
	public void removeBoltTshirt() {
		driver.findElement(removeBoltTshirtBtn).click();
	}
	
	public void clickContinueShoppingBtn() {
		driver.findElement(continueShoppingBtn).click();
	}
	
	public void clickCheckoutBtn() {
		driver.findElement(checkoutBtn).click();
	}

}
