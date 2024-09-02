package stepDefinitions;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        AddPlaceStepDefinition stepDefinition = new AddPlaceStepDefinition();
        stepDefinition.add_place_payload_with("HouseHold", "Montenegrin", "Podgorica, 13.Jula");
        stepDefinition.user_calls_with_post_http_request("addPlaceAPI", "POST");
        stepDefinition.verify_place_id_created_maps_to_using("HouseHold", "POST");
    }
}
