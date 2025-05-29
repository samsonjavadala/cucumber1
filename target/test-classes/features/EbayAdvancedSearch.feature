Feature: Ebay Home Page Scenarios

  @p2
  Scenario: Advanced Search Link
   Given I am on  Ebay Advanced Search Page
   When I click on Ebay Logo
   Then I am navigated to Ebay Home Page
    
  #step data table  
  @p11
  Scenario: Advanced search an item
 Given I am on  Ebay Advanced Search Page 
 When I advanced search an item
  | Keyword |exclude|min|max|
  | iphone11|refurbished|300|900| 
    