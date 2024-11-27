package Pages;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class signup {

	static  WebDriver wd;
	static Actions act;
	WebDriverWait wait;
	

	@Given("Open the browser")
	public void open_the_browser() {
	    wd = new EdgeDriver();
	    wd.manage().window().maximize();
	    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    wd.get("https://magento.softwaretestingboard.com/customer/account/create/");
	    act= new Actions(wd);
	    wait= new WebDriverWait(wd, Duration.ofSeconds(50));
	    
	}

	@And("Enter first name")
	public void enter_first_name() {
	    WebElement first_name = wd.findElement(By.id("firstname"));
	    first_name.sendKeys("Athira");
	   
	}

	@Then("Enter last name")
	public void enter_last_name() {
		WebElement last_name = wd.findElement(By.id("lastname"));
	   last_name.sendKeys("Sharath");
	}

	@Then("Enter Email id")
	public void enter_email_id() {
		WebElement email = wd.findElement(By.id("email_address"));
		   email.sendKeys("athira30@gmail.com");
	}

	@Then("scroll down")
	public void scroll_down() {
	  JavascriptExecutor js = (JavascriptExecutor)wd;
	  js.executeScript("window.scrollBy(0,1000)");
	  
	  
	}
	
	@Then("Enter Password")
	public void enter_password() {
		WebElement pass = wd.findElement(By.cssSelector("input[type='password']"));
		   pass.sendKeys("Sharath@30");
		   
			/*
			 * act.keyDown(Keys.CONTROL); act.sendKeys("a"); act.keyUp(Keys.CONTROL);
			 * act.build().perform();
			 * 
			 * act.keyDown(Keys.CONTROL); act.sendKeys("c"); act.keyUp(Keys.CONTROL);
			 * act.build().perform();
			 * 
			 * act.keyDown(Keys.TAB).build().perform(); act.keyUp(Keys.TAB);
			 * 
			 * act.keyDown(Keys.CONTROL); act.sendKeys("v"); act.keyUp(Keys.CONTROL);
			 * act.build().perform();
			 */
	}

	@Then("Copy paste Password")
	public void copy_paste_password() {
	  
		WebElement passcon = wd.findElement(By.id("password-confirmation"));
		   passcon.sendKeys("Sharath@30");
		   
		   JavascriptExecutor js = (JavascriptExecutor)wd;
			  js.executeScript("window.scrollBy(0,1000)");
	 
	  
	}

	@And("Click on Create button")
	public void click_on_create_button() {
	  
		//WebElement submittt = wd.findElement(By.xpath("//button[@type='submit']"));
		
		WebElement submittt = wd.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/form/div/div[1]/button"));
		//WebElement submittt = wd.findElement(By.className("action submit primary"));
		wait.until(ExpectedConditions.elementToBeClickable(submittt));
	    submittt.click();
	}



}
