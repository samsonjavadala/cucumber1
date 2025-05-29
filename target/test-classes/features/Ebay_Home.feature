Feature: Ebay Home Page Scenarios

  @p1
  Scenario: Advanced Search Link
    Given I am on Ebay Home Page
    When I click on Advanced Link
    Then I navigate to Advanced Search page
    Then I read excel data
   # Then I update excel sheet "filePath""sheetName"5,6"value"
    Then I update excel sheet "excel updated" in row 2 and column 1 of "Sheet1" in file "src/test/resources/data.xlsx"
    Then i update samson branch
    

  @p3
  Scenario: searching mach book
    
    //parameterising  the test  cse

    Given I am on Ebay Home Page
    When I serach for 'mac book'
    Then I validate atleast 5000 search items present

  @p3
  Scenario: searching i phone 14
    Given I am on Ebay Home Page
    When I serach for 'i phone 14'
    Then I validate atleast 5000 search items present

  @p40
  Scenario: search an item in category
    Given I am on Ebay Home Page
    When I serach for 'soap' in 'Baby' category

  # *********************Data table**************************************
  @p55
  Scenario Outline: Home page links
    Given I am on Ebay Home Page
    When I click on '<links>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples: 
      | links       | url                                                                | title       |
      | Motors      | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334     | ebay motors |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124                   | Electronics |
      | Fashion     | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Fashion     |
