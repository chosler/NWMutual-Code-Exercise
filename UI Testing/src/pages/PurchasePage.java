package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {
	
	WebDriver driver;

	public PurchasePage(WebDriver driver) {
		
		this.driver = driver;

	}
	
	By fleeceJacket = By.xpath(".//*[text()='Sauce Labs Fleece Jacket']");
	By bikeLight = By.xpath(".//*[text()='Sauce Labs Bike Light']");
	By totalPrice = By.cssSelector("div[class='summary_total_label']");
	By finishBtn = By.cssSelector("button[id='finish']");
	
	public String verifyFleecePurchase() {
		return driver.findElement(fleeceJacket).getText();
	}
	
	public String verifyBikeLightPurchase() {
		return driver.findElement(bikeLight).getText();
	}
	
	public String verifyTotalPrice() {
		return driver.findElement(totalPrice).getText();
	}
	
	public void clickFinishBtn() {
		driver.findElement(finishBtn).click();
	}

}
