
Feature: scroll functionality
Background:
Given launches the browser
    And navigates to the "http://automationexercise.com"
 
  Scenario:  Verify Scroll Up using Arrow button and Scroll Down functionality
  
    When  Scroll down page to bottom
   Then Verify SUBSCRIPTION is visible
    When Click on arrow at bottom right side to move upward
    
    Then  Verify that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen
 
  Scenario:   Verify Scroll Up without 'Arrow' button and Scroll Down functionality
   When  Scroll down page to bottom
   Then Verify SUBSCRIPTION is visible
   When scroll up page to top
   Then  Verify that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen

  
