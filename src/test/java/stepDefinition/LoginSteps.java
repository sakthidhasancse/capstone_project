package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecommerce.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class LoginSteps {
	  WebDriver driver;
	    RegistrationPage registrationPage;
	@Given("I launch the browser")
	public void i_launch_the_browser() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Given("I navigate to {string}")
	public void i_navigate_to(String url) {
		driver.get(url);
		// Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
	}
//	@Then("I verify that the home page is visible")
//	public void i_verify_that_the_home_page_is_visible() {
//		assert registrationPage.isLoggedInAsVisible();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	//}
	@When("I click on Signup \\/ Login button")
	public void i_click_on_signup_login_button() {
		registrationPage.clickSignupLogin();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("I verify New User Signup! is visible")
	public void i_verify_new_user_signup_is_visible() {
		assert registrationPage.isNewUserSignupVisible();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("I enter name {string} and email {string}")
	public void i_enter_name_and_email(String name, String email) {
		registrationPage.enterNameAndEmail(name, email);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("I click Signup button")
	public void i_click_signup_button() {
		 registrationPage.clickSignup();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
//	@Then("I verify that ENTER ACCOUNT INFORMATION is visible")
//	public void i_verify_that_enter_account_information_is_visible() {
//		 assert registrationPage.isEnterAccountInfoVisible();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	//}
	@Then("I fill details: Title, Name, Email, Password, Date of birth")
	public void i_fill_details_title_name_email_password_date_of_birth() throws InterruptedException {
		registrationPage.fillPersonalDetails();
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("I select Sign up for our newsletter!")
	public void i_select_sign_up_for_our_newsletter() {
		
		registrationPage.selectNewsletter();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("I select Receive special offers from our partners!")
	public void i_select_receive_special_offers_from_our_partners() {
		 registrationPage.selectSpecialOffers();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("I fill address details with:")
	public void i_fill_address_details_with(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		    
		    for (Map<String, String> row : data) {
		        registrationPage.fillAddressDetails(
		            row.get("FirstName"), row.get("LastName"), row.get("Company"), 
		            row.get("Address"), row.get("Address2"), row.get("Country"), 
		            row.get("State"), row.get("City"), row.get("Zipcode"), row.get("MobileNumber")
		        );
		    }
		    Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("I click Create Account button")
	public void i_click_create_account_button() {
		registrationPage.clickCreateAccount();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("I verify that ACCOUNT CREATED! is visible")
	public void i_verify_that_account_created_is_visible() {
		 assert registrationPage.isAccountCreatedVisible();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("I click Continue button")
	public void i_click_continue_button() {
		registrationPage.clickContinue();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
//	@Then("I verify that Logged in as username is visible")
//	public void i_verify_that_logged_in_as_username_is_visible() {
//		assert registrationPage.isLoggedInAsVisible();
//		// Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
	@When("I click Delete Account button")
	public void i_click_delete_account_button() {
	 registrationPage.clickDeleteAccount();
		// Write code here that turns the phrase above into concrete actions
	   //throw new io.cucumber.java.PendingException();
	}
	@Then("I verify that ACCOUNT DELETED! is visible and click Continue button")
	public void i_verify_that_account_deleted_is_visible_and_click_continue_button() {
		assert registrationPage.isAccountDeletedVisible();
        driver.quit();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("user click signup\\/login button")
	public void user_click_signup_login_button() {
		registrationPage.clickSignupLogin();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("enter email and password")
	public void enter_email_email_and_password() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("sathis/@email.com");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("sathis");
		Thread.sleep(1000);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("click login button")
	public void click_login_button() {
		driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button")).click();
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("verify that logged in as username is visible")
	public void verify_that_logged_in_as_username_is_visible() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement loggedInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]")));
		    
		    String loggedInText = loggedInElement.getText();
	    Assert.assertTrue(loggedInText.contains("Logged in as"), "Expected 'Logged in as username' but got: " + loggedInText);
	    driver.quit();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("enter incorrect email and password")
	public void enter_incorrect_email_and_password() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("shivas@email.com");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("shiva");
		Thread.sleep(1000);
	}
	@Then("Verify error Your email or password is incorrect! is visible")
	public void verify_error_your_email_or_password_is_incorrect_is_visible() {
	  String eText=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText();
	  String aText="Your email or password is incorrect!";
	  Assert.assertEquals(eText, aText);
	  driver.quit();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("click logut button")
	public void click_logut_button() {
		registrationPage.clicklogout();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	@Then("Verify that user is navigated to login page")
	public void Verify_that_user_is_navigated_to_login_page() {
		Assert.assertTrue(registrationPage.isOnLoginPage(),"User is not redirected to login page!");
        driver.quit();
       
	}
	@When("enter name and already registered email")
	public void enter_name_and_already_registered_email() {
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("sakthi");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("sathis/@email.com");
		
	}
	@Then("Verify error Email Address already exist! is visible")
	public void Verify_error_Email_Address_already_exist_is_visible(){
	String expectederrormsg="Email Address already exist!";
	String actualerrormsg=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p")).getText();
	Assert.assertEquals(actualerrormsg, expectederrormsg,"Error msg did not match");
	driver.quit();
	}
	@When("Click on Contact Us button")
	public void Click_on_Contact_us_button() throws InterruptedException {
		driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a")).click();
		Thread.sleep(2000);
		
		}
	@When("enter name email subject and message")
	public void enter_name_email_subject_and_message() {
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys("sathis");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys("sathis/@email.com");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("product info");
		driver.findElement(By.id("message")).sendKeys("i need to find the product");
	}
	@When("upload file {string}")
	public void upload_file(String filepath) throws InterruptedException {
		 WebElement uploadElement = driver.findElement(By.name("upload_file"));
	        uploadElement.sendKeys(filepath);
	        Thread.sleep(2000);
		
	}
	@When("click submit button")
	public void click_submit_button() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(7) > input")).click();
//		Thread.sleep(2000);
		WebElement submitButton = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(7) > input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		Thread.sleep(1000); // Optional: Wait a moment before clicking
		submitButton.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
	}
	@Then("Verify success message Success Your details have been submitted successfully is visible")
	public void Verify_success_message_Success_Your_details_have_been_submitted_successfully_is_visible() {
		String actualText=driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")).getText();
		String expectedText="Success! Your details have been submitted successfully.";
		Assert.assertEquals(actualText, expectedText);
		driver.quit();
	}
	@When("click the test cases button")
	public void click_the_test_cases_button() throws InterruptedException {
		driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a")).click();
		Thread.sleep(2000);
	}
	@Then("verify user navigated succesfully to test cases page")
	public void verify_user_navigated_succesfully_to_test_cases_page() {
		String currentURL = driver.getCurrentUrl();
        Assert.assertTrue( currentURL.contains("test_cases"),"User is not on Test Cases page!");
        System.out.println("successfully navigated to test cases page");
        driver.quit();
	}
}
