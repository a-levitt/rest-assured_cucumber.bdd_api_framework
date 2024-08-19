Feature: Validating Place APIs

  Scenario: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload
    When user calls AddPlaceAPI with Post http request
    Then the API call is successful with status code 200
    And status in response body is OK