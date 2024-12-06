package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class sigin {

	static  WebDriver driver;
	static Actions act;
	WebDriverWait wait;
	static WebElement sigin;
	private static final Logger logger = LogManager.getLogger(sigin.class);
	
	@Given("Open the link")
    public void open_the_link() {
      
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");
        act = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

	
	
	@Then("Click on sigin")
	public void click_on_sigin() {
		 sigin = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
		sigin.click();
	    
	}

	@Then("Enter email id  {string}")
	public void enter_email_id(String emailid) {
	    WebElement mail = driver.findElement(By.cssSelector("#email"));
	    mail.sendKeys(emailid);
	}

	@And("Enter passsword  {string}")
	public void enter_passsword(String paas) {
		 WebElement passwords = driver.findElement(By.name("login[password]"));
		    passwords.sendKeys(paas);
		    JavascriptExecutor js = (JavascriptExecutor)driver;
			  js.executeScript("window.scrollBy(0,1000)");
	}

	@Then("Click on login button")
	public void click_on_login_button() {
	    WebElement log = driver.findElement(By.xpath("(//button[@id='send2'])[1]"));
	    log.click();
	}

	@And("then verify if logged in or not for valid users")
	public void then_verify_if_logged_in_or_not_for_valid_users() {
	    try {
		
		WebElement varify = driver.findElement(By.className("logged-in"));
	    if(varify.isDisplayed()) {
	    	logger.info("Login successfull!!!!!!!!!!!!!!!");
	    }else {
	    	logger.error("unsuccessfull!!!!!!!!!!!!!");
	    }
	    
	} catch (Exception e) {
		// TODO: handle exception
		logger.error("Invalid login test: " + e.getMessage());
	}
	}
	    @Then("close the window")
		public void close_the_window() {
		    driver.close();
		  
	   
	}

	

}
