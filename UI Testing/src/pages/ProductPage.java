package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		
		this.driver = driver;

	}
	
	By sortButton = By.cssSelector("select[class='product_sort_container']");
	By sortHighToLow = By.cssSelector("option[value='hilo']");
	By fleeceJacket = By.cssSelector("button[id$='fleece-jacket']");
	By boltTshirt = By.cssSelector("button[id$='bolt-t-shirt']");
	By bikeLight = By.cssSelector("button[id$='bike-light']");
	By cartButton = By.cssSelector("a[class='shopping_cart_link']");
	
	public void sortHighToLow() {
		driver.findElement(sortButton).click();
		driver.findElement(sortHighToLow).click();
	}
	
	public void selectFirstItems() {
		driver.findElement(fleeceJacket).click();
		driver.findElement(boltTshirt).click();
	}
	
	public void goToCart() {
		driver.findElement(cartButton).click();
	}
	
	public void selectBikeLight() {
		driver.findElement(bikeLight).click();
	}

}
