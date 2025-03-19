package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	WebDriver driver;


    By productsHeader = By.xpath("//h2[contains(text(),'All Products')]");
    By firstProductViewButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    By productDetail = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
    By productbtn=By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a"); 
    By searchbtn=By.id("submit_search");
    By cartbtn=By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
    By category=By.xpath("//div[@class='left-sidebar']/h2[contains(text(),'Category')]");
  
   By jeansbtn=By.cssSelector("#Men > div > ul > li:nth-child(2) > a");
   By menjeanshead=By.xpath("//a[contains(text(),'Jeans')]");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
   public void clickproductsbutton() {
	   driver.findElement(productbtn).click();
   }
    
    public boolean isProductsPageVisible() {
        return driver.findElement(productsHeader).isDisplayed();
    }

    public void clickFirstProduct() {
    	WebElement viewProduct = driver.findElement(By.xpath("//a[contains(text(),'View Product')]"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewProduct);
    	//driver.findElement(firstProductViewButton).click();
    }

    public boolean isProductDetailVisible() {
        return driver.findElement(productDetail).isDisplayed();
    }
    public void clicksearch() {
    	driver.findElement(searchbtn).click();
    }
    public void clickcartbutton() {
    	driver.findElement(cartbtn).click();
    }
    public boolean iscategoryvisible() {
    	 WebElement categoriesHeader = driver.findElement(category);
    	return categoriesHeader.isDisplayed();
    }
    public void clickwomenbutton() {
    	WebElement womenCategory = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", womenCategory);
        womenCategory.click();
    }
    public void clickdressbtn() {
    	WebElement dressCategory = driver.findElement(By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a"));
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", dressCategory);
        dressCategory.click();
    }
    public void clickmenbtn() {
    	WebElement menCategory = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", menCategory);
        menCategory.click();
    }
    public void clicktshirtbtn() {
    	WebElement tshirtCategory = driver.findElement(By.xpath("//*[@id=\"Men\"]/div/ul/li[1]/a"));
        tshirtCategory.click();
    }
    public boolean ismenproductsvisible() {
    	WebElement menCategoryTitle = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        return menCategoryTitle.isDisplayed();
    }
	
}

