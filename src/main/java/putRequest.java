import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class putRequest {
    public static void main(String[] args) {
        RestAssured.proxy("165.225.106.40", 9400);
        RestAssured.baseURI = "http://restapi.adequateshop.com";
        RestAssured.useRelaxedHTTPSValidation();
        given().log().all().header("Content-Type", "application/json; charset=utf-8")
                .body("\"tourist_name\":\"bbbb\",\n" +
                        "    \"tourist_email\":\"bbb890099@gmail.com\",\n" +
                        "    \"tourist_location\":\"London\"")
                .when().put("/api/Tourist/ 173496")
                .then().log().all().assertThat().statusCode(200);
    }
}
