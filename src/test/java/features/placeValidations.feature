Feature: Validating Place APIs

  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with Post http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

Examples:
    | name         |  language   | address                   |
    |AAhouse       |  English    | World cross center        |
    |Home #1       |  Swedish    | Sweden, Malmo, Borg st.15 |
    |IronForge gym |  English-US | USA, TX, North Rocks, 24  |
