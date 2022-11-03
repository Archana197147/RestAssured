import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postRequest {
    public static void main(String[] args) {
        RestAssured.proxy("165.225.106.40", 9400);
        RestAssured.baseURI = "http://restapi.adequateshop.com";
        RestAssured.useRelaxedHTTPSValidation();
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "\n" +
                        "                \"tourist_name\": \"Mike\",\n" +
                        "                \"tourist_email\": \"mike1677790778@gmail.com\",\n" +
                        "                \"tourist_location\": \"Paris\"\n" +
                        "}")
                .when().post("/api/Tourist")
                .then().log().all().assertThat().statusCode(201);
    }

}
