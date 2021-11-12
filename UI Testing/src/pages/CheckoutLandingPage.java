package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutLandingPage {
	
	WebDriver driver;

	public CheckoutLandingPage(WebDriver driver) {
		
		this.driver = driver;

	}
	
	By firstNameBox = By.cssSelector("input[id='first-name']");
	By lastNameBox = By.cssSelector("input[id='last-name']");
	By zipCodeBox = By.cssSelector("input[id='postal-code']");
	By continueBtn = By.cssSelector("input[id='continue']");
	
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameBox).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameBox).sendKeys(lastName);
	}
	
	public void enterZipCode(String zipcode) {
		driver.findElement(zipCodeBox).sendKeys(zipcode);
	}
	
	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}

}
