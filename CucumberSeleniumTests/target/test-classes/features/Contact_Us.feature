@contact-us @regression

Feature: WebDriver University - Contact Us page

  Scenario: Validate Successful Submission -Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter unique last name
    And I enter a unique email
    And I enter a comment
    And I click on the submit button
    Then I should get a the successful contact us message

  Scenario: Validate Successful Submission -Specific Data
    Given I access the webdriver university contact us page
    When I enter a specific first name joe
    And I enter specific last name blogs
    And I enter a specific email joe_blog@mail.com
    And I enter a specific comment  "How are you?"
    And I click on the submit button
    Then I should get a the successful contact us message