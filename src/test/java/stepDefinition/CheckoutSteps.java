package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
	WebDriver driver;
	WebDriverWait wait;
	CheckoutPage checkout;
	CartPage cartpage;
	 ProductPage productpage;
	 RegistrationPage registrationPage;
	 Actions actions;
	@Given("launch the browser")
	public void launch_the_browser() {
		driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     cartpage =new CartPage(driver);
	     registrationPage=new RegistrationPage(driver);
	     productpage = new ProductPage(driver);
	     checkout=new CheckoutPage(driver);
	     actions = new Actions(driver);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Given("navigates to {string}")
	public void navigates_to(String url) {
	    driver.get(url);
		// Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
	}
	@When("Add products to cart")
	public void add_products_to_cart() throws InterruptedException {
		WebElement Product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='productinfo text-center'])[1]")));
        actions.moveToElement(Product).perform();
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@data-product-id='1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("clicks cart button")
	public void clicks_cart_button() throws InterruptedException {
		 WebElement viewcart= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")));
		    viewcart.click();
		    Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("Click Proceed To Checkout")
	public void click_proceed_to_checkout() throws InterruptedException {
	   WebElement checkout=driver.findElement(By.cssSelector("#do_action > div.container > div > div > a"));
	   checkout.click();
	   Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("click Register\\/login button")
	public void click_register_login_button() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a")).click();
	  Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("Fill all details in Signup and create account")
	public void fill_all_details_in_signup_and_create_account() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("sakthi");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("sakthi313269213@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button")).click();
		Thread.sleep(2000);
		registrationPage.fillPersonalDetails();
		Thread.sleep(2000);
		registrationPage.selectNewsletter();
		registrationPage.selectSpecialOffers();
		Thread.sleep(2000);
		driver.findElement(By.id("first_name")).sendKeys("sakthi");
		driver.findElement(By.id("last_name")).sendKeys("B");
		driver.findElement(By.id("address1")).sendKeys("No:12,12th street,chennai");
		driver.findElement(By.id("state")).sendKeys("Tamil nadu");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.id("zipcode")).sendKeys("123456");
		driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
		Thread.sleep(2000);
		registrationPage.clickCreateAccount();
		Thread.sleep(2000);
		
		
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify ACCOUNT CREATED! and click Continue button")
	public void verify_account_created_and_click_continue_button() throws InterruptedException {
		registrationPage.isAccountCreatedVisible();
		Thread.sleep(2000);
		registrationPage.clickContinue();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("Click Cart button")
	public void click_cart_button() throws InterruptedException {
		productpage.clickcartbutton();
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click Proceed To Checkout button")
	public void click_proceed_to_checkout_button() throws InterruptedException {
	    checkout.clickProceedToCheckout();
	    Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Enter description in comment text area {string} and click Place Order")
	public void enter_description_in_comment_text_area_and_click_place_order(String comment) throws InterruptedException {
	   checkout.enterComment(comment);
	   Thread.sleep(2000);
	   checkout.clickPlaceOrder();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Enter payment details Name on Card, Card Number, CVC, Expiration date")
	public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() throws InterruptedException {
	   checkout.enterPaymentDetails("sakthi", "123456789021", "313", "01", "2020");
	   Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click Pay and Confirm Order button")
	public void click_pay_and_confirm_order_button() throws InterruptedException {
	   checkout.clickPayAndConfirm();
	   Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Verify success message Congratulations! Your order has been confirmed!")
	public void verify_success_message_congratulations_your_order_has_been_confirmed() throws InterruptedException {
	   checkout.verifyOrderSuccess();
	   Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click the Delete Account button")
	public void click_the_delete_account_button() throws InterruptedException {
		registrationPage.clickDeleteAccount();
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify ACCOUNT DELETED! and click Continue button")
	public void verify_account_deleted_and_click_continue_button() {
		registrationPage.isAccountDeletedVisible();
		driver.quit();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click Signup\\/Loginbutton")
	public void click_signup_loginbutton() throws InterruptedException {
	    registrationPage.clickSignupLogin();
	    Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Fill email password and click login button")
	public void Fill_email_password_and_click_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("sathis/@email.com");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("sathis");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button")).click();
		Thread.sleep(2000);
	}
	@Then("close the website")
	public void close_the_website() {
		driver.quit();
		
	}
	@When("Click Download Invoice button and verify invoice is downloaded successfully")
	public void Click_Download_Invoice_button_and_verify_invoice_is_downloaded_successfully() throws InterruptedException {
		driver.findElement(By.cssSelector("#form > div > div > div > a")).click();
		Thread.sleep(2000);
		
	}
	@When("Click the Continue button")
	public void Click_the_Continue_button() throws InterruptedException {
		driver.findElement(By.cssSelector("#form > div > div > div > div > a")).click();
		Thread.sleep(2000);
	}
	 @Then ("verify billing address and deliivery address are same")
	 public void verify_billing_address_and_deliivery_address_are_same() {
		  Assert.assertTrue(checkout.namesaresame());
		  Assert.assertTrue(checkout.sameaddress());
		  Assert.assertTrue(checkout.samecompany());
	 }
	
}
