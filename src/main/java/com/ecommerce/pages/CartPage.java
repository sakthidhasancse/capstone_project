package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
        this.driver = driver;
    }
	By addtocartbtn=By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button");
	By xbtn=By.cssSelector("#product-2 > td.cart_delete > a > i");
	public void clickaddtocartbtn() {
		driver.findElement(addtocartbtn).click();
	}
	public void clickxbtn() {
		driver.findElement(xbtn).click();
	}
}
