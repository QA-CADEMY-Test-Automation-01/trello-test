Feature: Trello get boards


  Scenario: Verify the status code is 200 from all boards
    Given I have the Endpoint "/1/members/me/boards"
    When I send a "GET" request
    Then I expect 200 as status code

  @this
  Scenario: Verify the status code is 200 from all boards
    Given I have the Endpoint "/1/members/me/boards"
    When I send a "GET" request
    Then I expect 200 as status code

  @this
  Scenario: Verify the status code is 200 from all boards
    Given I have the Endpoint "/1/members/me/boards"
    When I send a "GET" request
    Then I expect 200 as status code
