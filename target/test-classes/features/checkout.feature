@Fourth
Feature: Checkout functionality
Background:
Given launch the browser
    And navigates to "http://automationexercise.com"
  
  Scenario: Place Order: Register while Checkout
    When Add products to cart
    And clicks cart button
    And Click Proceed To Checkout
    
    And click Register/login button
    And Fill all details in Signup and create account
    Then  Verify ACCOUNT CREATED! and click Continue button
    When Click Cart button
    When Click Proceed To Checkout button
    And Enter description in comment text area "order this" and click Place Order
    And Enter payment details Name on Card, Card Number, CVC, Expiration date
        
    And  Click Pay and Confirm Order button
    Then  Verify success message Congratulations! Your order has been confirmed!
    When Click the Delete Account button
    Then  Verify ACCOUNT DELETED! and click Continue button

Scenario:  Place Order: Register before Checkout
When Click Signup/Loginbutton
 And Fill all details in Signup and create account
 Then  Verify ACCOUNT CREATED! and click Continue button
  When Add products to cart
 And clicks cart button
  When Click Proceed To Checkout button
   And Enter description in comment text area "order this" and click Place Order
   And Enter payment details Name on Card, Card Number, CVC, Expiration date
    And  Click Pay and Confirm Order button
    Then  Verify success message Congratulations! Your order has been confirmed!
    When Click the Delete Account button
    Then  Verify ACCOUNT DELETED! and click Continue button
 
 Scenario: Place Order: Login before Checkout
 When Click Signup/Loginbutton
 And Fill email password and click login button
   When Add products to cart
 And clicks cart button
  When Click Proceed To Checkout button
   And Enter description in comment text area "order this" and click Place Order
   And Enter payment details Name on Card, Card Number, CVC, Expiration date
    And  Click Pay and Confirm Order button
    Then  Verify success message Congratulations! Your order has been confirmed!
    And close the website

 Scenario: Download Invoice after purchase order
 When Add products to cart
    And clicks cart button
    And Click Proceed To Checkout
    
    And click Register/login button
    And Fill all details in Signup and create account
    Then  Verify ACCOUNT CREATED! and click Continue button
    When Click Cart button
    When Click Proceed To Checkout button
    And Enter description in comment text area "order this" and click Place Order
    And Enter payment details Name on Card, Card Number, CVC, Expiration date
        
    And  Click Pay and Confirm Order button
    Then  Verify success message Congratulations! Your order has been confirmed!
    When Click Download Invoice button and verify invoice is downloaded successfully
    And  Click the Continue button
     When Click the Delete Account button
    Then  Verify ACCOUNT DELETED! and click Continue button

    Scenario: Verify address details in checkout page
    When Click Signup/Loginbutton
 And Fill all details in Signup and create account
 Then  Verify ACCOUNT CREATED! and click Continue button
  When Add products to cart
 And clicks cart button
  When Click Proceed To Checkout button
    Then verify billing address and deliivery address are same
     When Click the Delete Account button
    Then  Verify ACCOUNT DELETED! and click Continue button
    
    
    
 
 
   
 
   


    
        
    
    
    
   

  
