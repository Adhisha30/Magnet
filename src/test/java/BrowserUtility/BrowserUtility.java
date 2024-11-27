package BrowserUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtility {

	
	private WebDriver wd;
	private WebDriverWait wait;
	
	

	public BrowserUtility(WebDriver wd, WebDriverWait wait) {
		super();
		this.wd = wd;
		this.wait = wait;
	}

	
	
	public void getURL(String URL) {
		wd.get(URL);
	}
	
	public void click(By locator) {
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
		
	}
	
	public void sendkeys(By locator, String Key) {
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(Key);
	}
	
	public void popup(By locator, String Key) {
		 
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys(Key);
	}
	
	public void close() {
		
		wd.close();
	}
	
	public void Hovering(By locator) {
		
		Actions action = new Actions(wd);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		action.moveToElement(element).perform();
		
		
	}
	
	public void Key(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(Keys.PAGE_DOWN);
	}
	
	public void clic_perform(By locator) {
		
		Actions action = new Actions(wd);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		action.moveToElement(element).perform();
		
		
		
		
		
	}
	
}
