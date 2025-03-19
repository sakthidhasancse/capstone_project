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
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	 CartPage cartpage;
	 ProductPage productpage;
	 RegistrationPage registrationPage;
	 @Given("user launches the browser")
		public void user_launches_the_browser() {
			driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     cartpage =new CartPage(driver);
	     registrationPage=new RegistrationPage(driver);
	     productpage = new ProductPage(driver);
	     actions = new Actions(driver);
			
		}
	 @Given("user navigates to {string}")
		public void user_navigates_to(String url) {
			driver.get(url);
			
		}
	@When("Clicks product button")
	public void clicks_product_button() throws InterruptedException {
		
		productpage.clickproductsbutton();
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("Hover over first product and click Add to cart")
	public void hover_over_first_product_and_click_add_to_cart() throws InterruptedException {
		 
		WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='productinfo text-center'])[1]")));
	        actions.moveToElement(firstProduct).perform();
	        WebElement addToCartButton = driver.findElement(By.xpath("//a[@data-product-id='1']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
	        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click Continue Shopping button")
	public void click_continue_shopping_button() {
		WebElement continueShopping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']")));
        continueShopping.click();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Hover over second product and click Add to cart")
	public void hover_over_second_product_and_click_add_to_cart() {
		  WebElement secondProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='productinfo text-center'])[2]")));
	        actions.moveToElement(secondProduct).perform();
	        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/a"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
	        //driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[2]")).click();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click View Cart button")
	public void click_view_cart_button() {
	    WebElement viewcart= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")));
	    viewcart.click();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Verify both products are added to Cart")
	public void verify_both_products_are_added_to_cart() throws InterruptedException {
		 WebElement firstProductInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='cart_description'])[1]")));
	        WebElement secondProductInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='cart_description'])[2]")));
	        assert firstProductInCart.isDisplayed();
	        assert secondProductInCart.isDisplayed();
	        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Verify their prices, quantity and total price")
	public void verify_their_prices_quantity_and_total_price() {
		WebElement price1 = driver.findElement(By.xpath("(//td[@class='cart_price'])[1]"));
        WebElement price2 = driver.findElement(By.xpath("(//td[@class='cart_price'])[2]"));
        WebElement quantity1 = driver.findElement(By.xpath("(//td[@class='cart_quantity'])[1]"));
        WebElement quantity2 = driver.findElement(By.xpath("(//td[@class='cart_quantity'])[2]"));
        WebElement total1 = driver.findElement(By.xpath("(//td[@class='cart_total'])[1]"));
        WebElement total2 = driver.findElement(By.xpath("(//td[@class='cart_total'])[2]"));

        assert price1.isDisplayed();
        assert price2.isDisplayed();
        assert quantity1.getText().equals("1");
        assert quantity2.getText().equals("1");
        assert total1.isDisplayed();
        assert total2.isDisplayed();
        
        driver.quit();
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click View Product for any product on home page")
	public void click_view_product_for_any_product_on_home_page() throws InterruptedException {
		productpage.clickFirstProduct();
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify product detail is opened")
	public void verify_product_detail_is_opened() throws InterruptedException {
		Assert.assertTrue(productpage.isProductDetailVisible(),"Product details are not visible!");
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("Increase quantity")
	public void increase_quantity() throws InterruptedException {
		driver.findElement(By.id("quantity")).clear();
		driver.findElement(By.id("quantity")).sendKeys("4");
		Thread.sleep(2000);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click Add to cart button")
	public void click_add_to_cart_button() throws InterruptedException {
	   cartpage.clickaddtocartbtn();
	   Thread.sleep(2000);
	}
	@When("i Click View Cart button")
	public void i_Click_View_Cart_button() {
		
	
	  driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")).click();
	    
	}
	@Then("Verify that product is displayed in cart page with exact quantity")
	public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
		 WebElement ProductInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='cart_description'])[1]")));
		 assert ProductInCart.isDisplayed();
		 WebElement quantity = driver.findElement(By.xpath("(//td[@class='cart_quantity'])[1]"));
		 assert quantity.getText().equals("4");
		 driver.quit();
		// Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
	}
	@When("Click X button corresponding to particular product")
	public void Click_X_button_corresponding_to_particular_product() throws InterruptedException {
		cartpage.clickxbtn();
		Thread.sleep(20000);
	}
	@Then("Verify that product is removed from the cart")
	public void Verify_that_product_is_removed_from_the_cart() {
		try {
            WebElement cartItem = driver.findElement(By.xpath("//tbody/tr"));
            Assert.assertFalse(cartItem.isDisplayed(),"Product is still in the cart!");
        } catch (Exception e) {
            System.out.println("Product successfully removed from the cart.");
        }
		driver.quit();
	}
	@When("Scroll to bottom of page")
	public void scroll_to_bottom_of_page() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Verify RECOMMENDED ITEMS are visible")
	public void verify_recommended_items_are_visible() throws InterruptedException {
		WebElement recommendedSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='recommended items']")));
        Assert.assertTrue(recommendedSection.isDisplayed(),"RECOMMENDED ITEMS section is not visible!");
        Thread.sleep(2000);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click on Add To Cart on Recommended product")
	public void click_on_add_to_cart_on_recommended_product() throws InterruptedException {
		 WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='recommended_items']//a[contains(@class,'add-to-cart')])[1]")));
	        addToCartButton.click();
	        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("Click on View Cart button")
	public void click_on_view_cart_button() throws InterruptedException {
		WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='View Cart']")));
        viewCartButton.click();
        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify that product is displayed in cart page")
	public void verify_that_product_is_displayed_in_cart_page() {
		WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='cart_info_table']//tr")));
        Assert.assertTrue(cartItem.isDisplayed(),"Product is not displayed in cart!");
	   driver.quit();
        // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Verify user is navigated to ALL PRODUCTS page")
	public void verify_user_is_navigated_to_all_products_page() throws InterruptedException {
		Assert.assertTrue( productpage.isProductsPageVisible(),"Products page is not visible!");
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Enter productname in search input and click searchbutton")
	public void enter_productname_in_search_input_and_click_searchbutton() throws InterruptedException {
		driver.findElement(By.id("search_product")).sendKeys("Men Tshirt");
		productpage.clicksearch();
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Verify SEARCHED PRODUCTS is visible")
	public void verify_searched_products_is_visible() throws InterruptedException {
		WebElement searchedProductsHeader = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]"));
	    Assert.assertTrue(searchedProductsHeader.isDisplayed(),"SEARCHED PRODUCTS is not visible!");
	    Thread.sleep(3000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("Add those products to cart")
	public void add_those_products_to_cart() {
		WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='productinfo text-center']//a[contains(text(),'Add to cart')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Click Cart button and verify that products are visible in cart")
	public void click_cart_button_and_verify_that_products_are_visible_in_cart() throws InterruptedException {
		WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")));
        viewCartButton.click();
        Thread.sleep(2000);
        WebElement ProductInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='cart_description'])[1]")));
		 assert ProductInCart.isDisplayed();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("Click Signup Login button and submit login details")
	public void click_signup_login_button_and_submit_login_details() throws InterruptedException {
		registrationPage.clickSignupLogin();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("sakthi21@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("sakthi");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button")).click();
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("Again go to Cart page")
	public void again_go_to_cart_page() throws InterruptedException {
		productpage.clickcartbutton();
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify that those products are visible in cart after login as well")
	public void verify_that_those_products_are_visible_in_cart_after_login_as_well() throws InterruptedException {
		WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='cart_info_table']//tr")));
        Assert.assertTrue(cartItem.isDisplayed(),"Product is not displayed in cart!");
        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Remove all products that have been added")
	public void remove_all_products_that_have_been_added() throws InterruptedException {
		cartpage.clickxbtn();
		Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify Cart is empty! Click here to buy products is visible")
	public void verify_is_visible() {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement emptyCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"empty_cart\"]/p")));
        Assert.assertTrue(emptyCartMessage.isDisplayed(),"Cart empty message is not visible!");
	    driver.quit();
		// Write code here that turns the phrase above into concrete actions
		
	   // throw new io.cucumber.java.PendingException();
	}

}
