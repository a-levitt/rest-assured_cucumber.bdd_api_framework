Feature: Validating Place APIs

  @AddPlace
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "addPlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
    | name         |  language   | address                   |
#    |AAhouse       |  English    | World cross center        |
 #   |Home #1       |  Swedish    | Sweden, Malmo, Borg st.15 |
    |IronForge gym |  English-US | USA, TX, North Rocks, 24  |


  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given Delete Place Payload
    When user calls "deletePlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
