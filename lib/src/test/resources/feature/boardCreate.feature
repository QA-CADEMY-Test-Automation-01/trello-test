Feature: Create Board

  @otherTag @api
  Scenario: create a new Board
    Given I have the Endpoint "/1/boards"
    And I set body
    """
    {
      "name": "Board Name",
      "desc" : "this is a description"
    }
    """
    When I send a "POST" request
    Then I validate the response contains "name" is equals than "Board Name"
    Then I validate the response contains "desc" is equals than "this is a description"
    And I save the response as "B"