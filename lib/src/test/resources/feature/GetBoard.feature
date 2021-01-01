Feature: GEt Board

  @createBoardd
  Scenario: Create a card
    Given I have the Endpoint "/1/boards/[board.id]"
    When I send a "GET" request
    Then I expect 200 as status code
