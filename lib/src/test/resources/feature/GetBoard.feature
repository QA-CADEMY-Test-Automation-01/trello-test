Feature: GEt Board

  @createBoard @api
  Scenario: Get a Board
    Given I have the Endpoint "/1/boards/(board.id)"
    When I send a "GET" request
    Then I expect 200 as status code
    And I validate the response contains "name" is equals than "testAAA"
