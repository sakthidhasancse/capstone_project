package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	 WebDriver driver;

	    
	    public CheckoutPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    
	     By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	     By registerOrLoginBtn = By.xpath("//a[contains(text(),'Register / Login')]");
	     By addressDetailsSection = By.xpath("//h2[contains(text(),'Address Details')]");
	     By reviewOrderSection = By.xpath("//h2[contains(text(),'Review Your Order')]");
	     By commentTextArea = By.xpath("//textarea[@name='message']");
	     By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
	     By nameOnCard = By.xpath("//input[@name='name_on_card']");
	     By cardNumber = By.xpath("//input[@name='card_number']");
	     By cvc = By.xpath("//input[@name='cvc']");
	     By expiryMonth = By.xpath("//input[@name='expiry_month']");
	     By expiryYear = By.xpath("//input[@name='expiry_year']");
	     By payAndConfirmBtn = By.xpath("//button[contains(text(),'Pay and Confirm Order')]");
	     By successMessage = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
	     By deliveryfirstname = By.xpath("//*[@id=\"address_delivery\"]/li[2]");
	     By billingfirstname = By.xpath("//*[@id=\"address_invoice\"]/li[2]");
	     By dcompany=By.xpath("//*[@id=\"address_delivery\"]/li[3]");
	     By bcompany=By.xpath("//*[@id=\"address_invoice\"]/li[3]");
	     By baddress=By.xpath("//*[@id=\"address_invoice\"]/li[4]");
	     By daddress=By.xpath("//*[@id=\"address_delivery\"]/li[4]");
	    public void clickProceedToCheckout() {
	        driver.findElement(proceedToCheckoutBtn).click();
	    }

	    public void clickRegisterOrLogin() {
	        driver.findElement(registerOrLoginBtn).click();
	    }

	    public boolean verifyAddressDetailsVisible() {
	        return driver.findElement(addressDetailsSection).isDisplayed();
	    }

	    public boolean verifyReviewOrderVisible() {
	        return driver.findElement(reviewOrderSection).isDisplayed();
	    }

	    public void enterComment(String comment) {
	        driver.findElement(commentTextArea).sendKeys(comment);
	    }

	    public void clickPlaceOrder() {
	        driver.findElement(placeOrderBtn).click();
	    }

	    public void enterPaymentDetails(String name, String cardNum, String cvv, String month, String year) {
	        driver.findElement(nameOnCard).sendKeys(name);
	        driver.findElement(cardNumber).sendKeys(cardNum);
	        driver.findElement(cvc).sendKeys(cvv);
	        driver.findElement(expiryMonth).sendKeys(month);
	        driver.findElement(expiryYear).sendKeys(year);
	    }

	    public void clickPayAndConfirm() {
	        driver.findElement(payAndConfirmBtn).click();
	    }

	    public boolean verifyOrderSuccess() {
	        return driver.findElement(successMessage).isDisplayed();
	    }
	    public boolean namesaresame() {
	    	String bname=driver.findElement(billingfirstname).getText();
	    	String dname=driver.findElement(deliveryfirstname).getText();
			return bname.equalsIgnoreCase(dname);
	    	
	    }
	    public boolean samecompany() {
	    	String bilcompany=driver.findElement(bcompany).getText();
	    	String delcompany=driver.findElement(dcompany).getText();
	    	return bilcompany.equalsIgnoreCase(delcompany);
	    }
	    public boolean sameaddress() {
	    	String biladdress=driver.findElement(baddress).getText();
	    	String deladdress=driver.findElement(daddress).getText();
	    	return biladdress.equalsIgnoreCase(deladdress);
	    			
	    }
	    
	   
}
