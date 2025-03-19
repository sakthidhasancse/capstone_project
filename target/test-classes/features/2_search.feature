
Feature: product search functionality
Background:
  Given user launch the browser
      And user navigate to "http://automationexercise.com"

  Scenario: Verify All Products and product detail page
  
    When Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Click on View Product of first product
    Then Verify product details are visible
 Scenario: Search Product
 When Click on Products button
 And Verify user is navigated to ALL PRODUCTS page successfully
 And Enter product name in search input and click search button
 Then verify seached products is visible
 And Verify all the products related to search are visible
 Scenario:  Verify Subscription in home page
 When scroll down to footer
 And Verify text "SUBSCRIPTION"
 And Enter email address in input and click arrow button
 Then Verify success message You have been successfully subscribed! is visible
 Scenario: Verify Subscription in Cart page
 When click cart button
 And Verify text "SUBSCRIPTION"
 And Enter email address in input and click arrow button
 Then Verify success message You have been successfully subscribed! is visible
Scenario:
When Verify that categories are visible on left side bar
And Click on Women category
And Click on any category link under Women category
And On left side bar, click on any sub-category link of Men category
Then Verify that user is navigated to that category page

Scenario: view brand products
When Click on Products button
Then  Verify that Brands are visible on left side bar
When click on any brand name
Then Verify that user is navigated to brand page and brand products are displayed
When On left side bar click on any other brand link
Then Verify that user is navigated to that brand page and can see products
Scenario:  Add review on product
When Click on Products button
And Click on View Product of first product
And Verify Write Your Review is visible
And Enter name, email and review
And Click Submit button
Then Verify success message "Thank you for your review."


