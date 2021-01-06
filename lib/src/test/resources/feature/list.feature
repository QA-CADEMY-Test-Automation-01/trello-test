Feature: List

  @createBoard @api
  Scenario: create a List into a Board

    Given I have the Endpoint "/1/lists"
    And I set body
    """
    {
      "name": "Example List",
      "idBoard": "(board.id)"
    }
    """
    And I send a "POST" request
    And I expect 200 as status code
    And I validate the response contains "name" is equals than "Example List"

