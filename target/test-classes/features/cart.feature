@Third
Feature: Cart functionality
Background:
  Given user launches the browser
      And user navigates to "http://automationexercise.com"


  Scenario:  Add Products in Cart
    When Clicks product button
    And Hover over first product and click Add to cart
     And Click Continue Shopping button
     And  Hover over second product and click Add to cart
     And Click View Cart button
    Then Verify both products are added to Cart
     And Verify their prices, quantity and total price

Scenario: Verify Product quantity in Cart
When  Click View Product for any product on home page
Then Verify product detail is opened
When  Increase quantity 
When Click Add to cart button
When i Click View Cart button
Then Verify that product is displayed in cart page with exact quantity

Scenario: Remove Products From Cart
When  Hover over second product and click Add to cart
And Click View Cart button
When Click X button corresponding to particular product
Then Verify that product is removed from the cart

Scenario: Add to cart from Recommended items
When Scroll to bottom of page
Then  Verify RECOMMENDED ITEMS are visible
When Click on Add To Cart on Recommended product
And Click on View Cart button
Then Verify that product is displayed in cart page

Scenario: Search Products and Verify Cart After Login
 When Clicks product button
Then Verify user is navigated to ALL PRODUCTS page
When Enter productname in search input and click searchbutton
Then Verify SEARCHED PRODUCTS is visible
When  Add those products to cart
Then Click Cart button and verify that products are visible in cart
When Click Signup Login button and submit login details
When Again go to Cart page
Then Verify that those products are visible in cart after login as well
When Remove all products that have been added
Then Verify Cart is empty! Click here to buy products is visible








