Feature: Background test

  Background:
    Given I have the Endpoint "/1/boards"
    And I set body
    """
    {
      "name": "Board Name"
    }
    """
    And I send a "POST" request
    And I save the response as "B"


  @otherTag @api
  Scenario: Test Create List
    Given I have the Endpoint "/1/lists"
    And I set body
    """
    {
      "name": "Example List",
      "idBoard": "(B.id)"
    }
    """
    And I send a "POST" request
    And I expect 200 as status code
