package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class RegistrationPage {
	WebDriver driver;
	 WebDriverWait wait;

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
     By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
     By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup!')]");
     By nameField = By.name("name");
     By emailField = By.xpath("//input[@data-qa='signup-email']");
     By signupBtn = By.xpath("//button[@data-qa='signup-button']");
     By enterAccountInfoText = By.xpath("//h2[contains(text(),'Enter Account Information')]");
     By titleMr = By.id("id_gender1");
     By passwordField = By.id("password");
     By daysDropdown = By.id("days");
     By monthsDropdown = By.id("months");
     By yearsDropdown = By.id("years");
     By newsletterCheckbox = By.id("newsletter");
     By offersCheckbox = By.id("optin");

    // Address Fields
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By companyField = By.id("company");
    By address1Field = By.id("address1");
    By address2Field = By.id("address2");
    By countryDropdown = By.id("country");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipcodeField = By.id("zipcode");
    By mobileNumberField = By.id("mobile_number");
    
    By createAccountBtn = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");
    By accountCreatedText = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");
    By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");
    By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    By accountDeletedText = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By logoutbtn=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By loginPageIndicator=By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
   // By errorMessage = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");

    // Methods
    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }

    public boolean isNewUserSignupVisible() {
        return driver.findElement(newUserSignupText).isDisplayed();
    }

    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupBtn).click();
    }

    public boolean isEnterAccountInfoVisible() {
        return driver.findElement(enterAccountInfoText).isDisplayed();
    }

    public void fillPersonalDetails() {
        driver.findElement(titleMr).click();
        driver.findElement(passwordField).sendKeys("Test1234");
        driver.findElement(daysDropdown).sendKeys("1");
        driver.findElement(monthsDropdown).sendKeys("January");
        driver.findElement(yearsDropdown).sendKeys("1990");
    }

    public void selectNewsletter() {
        driver.findElement(newsletterCheckbox).click();
    }

    public void selectSpecialOffers() {
        driver.findElement(offersCheckbox).click();
    }

    public void fillAddressDetails(String firstName, String lastName, String company, String address, String address2,
                                   String country, String state, String city, String zipcode, String mobileNumber) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address);
        driver.findElement(address2Field).sendKeys(address2);
        driver.findElement(countryDropdown).sendKeys(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }

    public boolean isAccountCreatedVisible() {
        return driver.findElement(accountCreatedText).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

//    public boolean isLoggedInAsVisible() {
//        return driver.findElement(loggedInAsText).isDisplayed();
//    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountBtn).click();
    }

    public boolean isAccountDeletedVisible() {
        return driver.findElement(accountDeletedText).isDisplayed();
    }
    public void clicklogout() {
    	driver.findElement(logoutbtn).click();
    }
    public boolean isOnLoginPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageIndicator)).isDisplayed();
    }
  
}
    

