package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecommerce.pages.Scrollpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scroll {
	WebDriver driver ;
	WebDriverWait wait;
	Scrollpage scroll;
	@Given("launches the browser")
	public void launch_the_browser() {
		 driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     scroll=new Scrollpage(driver);
	}
	@Given("navigates to the {string}")
	public void navigates_to(String url) throws InterruptedException {
	    driver.get(url);
	    Thread.sleep(2000);
	}
	@When("Scroll down page to bottom")
	public void scroll_down_page_to_bottom() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement footer = driver.findElement(By.cssSelector("#footer"));
	    js.executeScript("arguments[0].scrollIntoView(true);", footer);
	    Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify SUBSCRIPTION is visible")
	public void verify_subscription_is_visible() {
		String atext=driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).getText();
		String etext="SUBSCRIPTION";
		Assert.assertEquals(atext, etext, "Subscriotion is not present");
		
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click on arrow at bottom right side to move upward")
	public void click_on_arrow_at_bottom_right_side_to_move_upward() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('aswift_3_host').style.display='none';");
		driver.findElement(By.cssSelector("#scrollUp > i")).click();
	    Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify that page is scrolled up and {string} text is visible on screen")
	public void verify_that_page_is_scrolled_up_and_text_is_visible_on_screen(String msg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2")));
		String actualText = element.getText();
		Assert.assertEquals(actualText, msg);
	   driver.quit();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("scroll up page to top")
	public void scroll_up_page_to_top() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
	}
}
