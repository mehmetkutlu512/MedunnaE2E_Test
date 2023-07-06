package stepdefinitions.e2e_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.RoomPojo;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.e2e_test.MedunnaRoomStepDefs.roomId;
import static stepdefinitions.e2e_test.MedunnaRoomStepDefs.roomNumberFaker;

public class ApiRoomStepDefs {

    Response response;
    RoomPojo expectedData;


    @Given("send get request")
    public void send_get_request() {
        //Set the url --> https://medunna.com/api/rooms?sort=createdDate,desc
        spec.pathParams("first", "api", "second", "rooms").queryParams("sort","createdDate,desc");

        //Set the expected data

        //Send the request and get the response
        response = given(spec).get("{first}/{second}");
        //response.prettyPrint();

    }
    @Then("validate body")
    public void validate_body() {
        //Groovy ile kendi oluşturduğumuz roomNumber kullanarak oluşturduğumuz odayı filtreliyoruz.
        Object roomType = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.roomType").get(0);//Groovy Language
        Object status = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.status").get(0);//Groovy Language
        Object price = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.price").get(0);//Groovy Language
        Object description = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.description").get(0);//Groovy Language
        Object roomNumber = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.roomNumber").get(0);//Groovy Language

        assertEquals(200,response.statusCode());
        assertEquals("SUITE", roomType);
        assertEquals(true, status);
        assertEquals("123.0", price+"");
        assertEquals("Created For End To End Test", description);
        assertEquals(roomNumberFaker, roomNumber);
    }


    @Given("send get request by id")
    public void sendGetRequestById() {
        //set the url -->https://medunna.com/api/rooms/60545
        spec.pathParams("first", "api","second", "rooms","third",roomId);

        //set the expected data
        expectedData = new RoomPojo(roomNumberFaker,"SUITE",true,123.0,"Created For End To End Test");

        //Send the request and get the response
        response = given(spec).get("{first}/{second}/{third}");
        //response.prettyPrint();

    }

    @Then("validate response body")
    public void validateResponseBody() throws JsonProcessingException {
        //Do assertion
        RoomPojo actualData = new ObjectMapper().readValue(response.asString(), RoomPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(),actualData.getRoomType());
        assertEquals(expectedData.getPrice(),actualData.getPrice());
        assertEquals(expectedData.getDescription(),actualData.getDescription());
        assertEquals(expectedData.getStatus(),actualData.getStatus());

    }


}
