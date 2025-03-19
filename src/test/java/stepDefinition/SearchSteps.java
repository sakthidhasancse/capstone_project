package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.ecommerce.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	 WebDriver driver;
	    ProductPage productpage;
	@Given("user launch the browser")
	public void user_launch_the_browser() {
		driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     productpage = new ProductPage(driver);
		
	}
	@Given("user navigate to {string}")
	public void user_navigate_to(String url) {
		driver.get(url);
		
	}
	@When("Click on Products button")
	public void click_on_products_button() throws InterruptedException {
		productpage.clickproductsbutton();
		Thread.sleep(2000);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("Verify user is navigated to ALL PRODUCTS page successfully")
	public void Verify_user_is_navigated_to_ALL_PRODUCTS_page_successfully() throws InterruptedException {
		Assert.assertTrue( productpage.isProductsPageVisible(),"Products page is not visible!");
		Thread.sleep(2000);
	}
	@When("Click on View Product of first product")
	public void Click_on_View_Product_of_first_product() throws InterruptedException {
		productpage.clickFirstProduct();
		Thread.sleep(2000);
	}
	@Then("Verify product details are visible")
	public void Verify_product_details_are_visible() throws InterruptedException {
		Assert.assertTrue(productpage.isProductDetailVisible(),"Product details are not visible!");
		Thread.sleep(2000);
		driver.quit();
    }
	@When("Enter product name in search input and click search button")
	public void Enter_product_name_in_search_input_and_click_search_button() throws InterruptedException {
		driver.findElement(By.id("search_product")).sendKeys("Men Tshirt");
		productpage.clicksearch();
		Thread.sleep(2000);
	}
	@Then("verify seached products is visible")
	public void verify_seached_products_is_visible() throws InterruptedException {
		WebElement searchedProductsHeader = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]"));
	    Assert.assertTrue(searchedProductsHeader.isDisplayed(),"SEARCHED PRODUCTS is not visible!");
	    Thread.sleep(3000);
	}
	@Then("Verify all the products related to search are visible")
	public void Verify_all_the_products_related_to_search_are_visible() throws InterruptedException {
		List<WebElement> searchedProducts = driver.findElements(By.cssSelector(".features_items .product-image-wrapper"));
		Assert.assertFalse( searchedProducts.isEmpty(),"No products found for the given search!");
		for (WebElement product : searchedProducts) {
	        Assert.assertTrue(product.isDisplayed(),"A searched product is not visible!");
	       
	    }
		Thread.sleep(2000);
		driver.quit();
	}
	@When("scroll down to footer")
	public void scroll_down_to_footer() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement footer = driver.findElement(By.cssSelector("#footer"));
	    js.executeScript("arguments[0].scrollIntoView(true);", footer);
	    Thread.sleep(2000);
	}
	@When("Verify text {string}")
	public void Verify_text(String text) throws InterruptedException {
		String atext=driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).getText();
		Assert.assertEquals(atext, text, "Subscriotion is not present");
		Thread.sleep(2000);
	}
	@When("Enter email address in input and click arrow button")
	public void Enter_email_address_in_input_and_click_arrow_button() throws InterruptedException {
		driver.findElement(By.id("susbscribe_email")).sendKeys("sathis/@email.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#subscribe > i")).click();
	}
	@Then("Verify success message You have been successfully subscribed! is visible")
	public void verify_success_message() throws InterruptedException {
		String emsg="You have been successfully subscribed!";
		String amsg=driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]/div")).getText();
		Assert.assertEquals(amsg, emsg, "Not subscribed");
		System.out.println("Subscribed successfully");
		Thread.sleep(2000);
		driver.quit();
		
	}
	@When("click cart button")
	public void click_cart_button() throws InterruptedException {
		productpage.clickcartbutton();
		Thread.sleep(2000);
	}
	@When("Verify that categories are visible on left side bar")
	public void Verify_that_categories_are_visible_on_left_side_bar() throws InterruptedException {
		productpage.iscategoryvisible();
		Thread.sleep(2000);
	}
	@When("Click on Women category")
	public void Click_on_Women_category() throws InterruptedException {
		productpage.clickwomenbutton();
		Thread.sleep(2000);
	}
	@When("Click on any category link under Women category")
	public void Click_on_any_category_link_under_Women_category() throws InterruptedException {
		productpage.clickdressbtn();
		Thread.sleep(2000);
	}

	@When("On left side bar, click on any sub-category link of Men category")
	public void On_left_side_bar_click_on_any_sub_category_link_of_Men_category() throws InterruptedException {
		productpage.clickmenbtn();
		Thread.sleep(1000);
		productpage.clickmenbtn();
		Thread.sleep(1000);
	}
	@Then("Verify that user is navigated to that category page")
	public void Verify_that_user_is_navigated_to_that_category_page() throws InterruptedException {
		productpage.ismenproductsvisible();
		Thread.sleep(1000);
		driver.quit();
	
	}
	@Then("Verify that Brands are visible on left side bar")
	public void verify_that_brands_are_visible_on_left_side_bar() throws InterruptedException {
        WebElement brandSection = driver.findElement(By.xpath("//div[@class='brands_products']"));
        Assert.assertTrue(brandSection.isDisplayed(),"Brand section is not visible");
        Thread.sleep(2000);

	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("click on any brand name")
	public void click_on_any_brand_name() throws InterruptedException {
		
		WebElement firstBrand = driver.findElement(By.xpath("//div[@class='brands-name']/ul/li[1]/a"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", firstBrand);
		firstBrand.click();
        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Verify that user is navigated to brand page and brand products are displayed")
	public void verify_that_user_is_navigated_to_brand_page_and_brand_products_are_displayed() throws InterruptedException {
		  WebElement brandHeader = driver.findElement(By.xpath("//h2[contains(text(),'Brand')]"));
	        Assert.assertTrue(brandHeader.isDisplayed(),"Brand page is not displayed");
	        Thread.sleep(2000);
	        WebElement productList = driver.findElement(By.xpath("//div[@class='features_items']"));
	        Assert.assertTrue( productList.isDisplayed(),"Brand products are not visible");
	        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("On left side bar click on any other brand link")
	public void on_left_side_bar_click_on_any_other_brand_link() throws InterruptedException {
		 WebElement secondBrand = driver.findElement(By.xpath("//div[@class='brands-name']/ul/li[2]/a"));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", secondBrand);
		 secondBrand.click();
	        Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("Verify that user is navigated to that brand page and can see products")
	public void verify_that_user_is_navigated_to_that_brand_page_and_can_see_products() throws InterruptedException {
		WebElement brandHeader = driver.findElement(By.xpath("//h2[contains(text(),'Brand')]"));
        Assert.assertTrue(brandHeader.isDisplayed(),"Brand page is not displayed for second brand");
        Thread.sleep(2000);
        WebElement productList = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(productList.isDisplayed(),"Brand products are not visible for second brand");

        driver.quit(); 
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Verify Write Your Review is visible")
	public void verify_write_your_review_is_visible() throws InterruptedException {
	    WebElement review=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a"));
	    review.isDisplayed();
	    Thread.sleep(2000);
	    		
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Enter name, email and review")
	public void enter_name_email_and_review() throws InterruptedException {
		 driver.findElement(By.id("name")).sendKeys("sathis");
		    driver.findElement(By.id("email")).sendKeys("sathis/@gmail.com");
		    driver.findElement(By.id("review")).sendKeys("good product");
		    Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("Click Submit button")
	public void click_submit_button() throws InterruptedException {
	    
	    Thread.sleep(2000);
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Verify success message {string}")
	public void verify_success_message(String string) throws InterruptedException {
	    String etext=string;
	    String atext=driver.findElement(By.xpath("//*[@id=\"review-section\"]/div/div/span")).getText();
	    Assert.assertEquals(string, etext, "review not submitted");
	    Thread.sleep(2000);
	    driver.quit();
	    
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	}


