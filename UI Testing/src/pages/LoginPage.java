package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;

	}
	
	By usernameBox = By.cssSelector("input[id='user-name']");
	By passwordBox = By.cssSelector("input[id='password']");
	By loginButton = By.cssSelector("input[id='login-button']");

	public void enterUsername(String username) {
		driver.findElement(usernameBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordBox).sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(loginButton).sendKeys(Keys.RETURN);
	}
}
