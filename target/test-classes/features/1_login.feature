
Feature: Register User

 Feature: User Registration and Account Deletion
 Background:
      Given I launch the browser
      And I navigate to "http://automationexercise.com"
 
Scenario Outline: Register a new user and delete the account

    When I click on Signup / Login button
   
    And I enter name "<Name>" and email "<Email>"
    And I click Signup button
   
    And I fill details: Title, Name, Email, Password, Date of birth
    And I select Sign up for our newsletter!
    And I select Receive special offers from our partners!
    And I fill address details with:
      | FirstName  | LastName  | Company  | Address    | Address2  | Country  | State  | City  | Zipcode  | MobileNumber  |
      | <FirstName> | <LastName> | <Company> | <Address> | <Address2> | <Country> | <State> | <City> | <Zipcode> | <MobileNumber> |
    And I click Create Account button
   Then I verify that ACCOUNT CREATED! is visible
    When I click Continue button
     
    When I click Delete Account button
    Then I verify that ACCOUNT DELETED! is visible and click Continue button

Examples:
    | Name  | Email              | FirstName | LastName | Company  | Address      | Address2 | Country  | State  | City   | Zipcode | MobileNumber |
    | sakthi  | sakthi313456@example.com   | sakthi      | Dhasan      | Sd Ltd  | 1 Street   | Apt 3   | India    | Tamilnadu    | Chennai    | 600001   | 9922330011  |

Scenario: login user with correct credentials
     When user click signup/login button
     And enter email and password 
     And click login button
     Then verify that logged in as username is visible
     
Scenario: login user with incorrect credentials
     When user click signup/login button
     And enter incorrect email and password 
     And click login button
     Then Verify error Your email or password is incorrect! is visible

Scenario: logout user
      When user click signup/login button
     And enter email and password 
     And click login button
     And click logut button
     Then  Verify that user is navigated to login page
 Scenario: Register User with existing email
      When I click on Signup / Login button
      And enter name and already registered email
      And I click Signup button
      Then Verify error Email Address already exist! is visible
 Scenario: Contact Us Form
      When Click on Contact Us button
      And enter name email subject and message
      And upload file "/Users/sakthi/Downloads/demofile.pdf"
      And click submit button
      Then Verify success message Success Your details have been submitted successfully is visible
 Scenario: verify test case page
      When click the test cases button
      Then verify user navigated succesfully to test cases page
      
      
      
      
        
     
    