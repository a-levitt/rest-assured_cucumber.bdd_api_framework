package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceBase;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class AddPlaceStepDefinition {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;

    @Given("Add Place Payload")
    public void add_place_payload() {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        AddPlaceBase addPlaceBody = new AddPlaceBase();
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlaceBody.setLocation(location);
        addPlaceBody.setAccuracy(50);
        addPlaceBody.setName("Frontline house");
        addPlaceBody.setPhone_number("(+91) 983 893 3937");
        addPlaceBody.setAddress("29, side layout, cohen 09");
        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        addPlaceBody.setWebsite("https://rahulshettyacademy.com");
        addPlaceBody.setLanguage("French-IN");

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build()
        ;

        resspec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build()
        ;

        res = given()
                .spec(req)
                .body(addPlaceBody)
        ;
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String string) {

        response =
        res.when()
            .post("/maps/api/place/add/json").
        then().
                spec(resspec)
                .extract().response()
        ;
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(), 200);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        assertEquals(js.get(keyValue).toString(), expectedValue);
    }

}
