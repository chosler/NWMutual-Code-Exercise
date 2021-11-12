package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletePage {
	
	WebDriver driver;

	public OrderCompletePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By completeMsg = By.cssSelector("h2[class='complete-header']");
	
	public String verifyCompletedMsg() {
		return driver.findElement(completeMsg).getText();
	}

}
