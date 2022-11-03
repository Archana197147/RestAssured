import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class PostRequestPayload {
    public static void main(String[] args) {
        RestAssured.proxy("165.225.106.40", 9400);
        RestAssured.baseURI = "http://restapi.adequateshop.com";
        RestAssured.useRelaxedHTTPSValidation();
       String response= given().log().all().header("Content-Type", "application/json")
                .body(payload.AddTourist())
                .when().post("/api/Tourist")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();
       JsonPath js= new JsonPath(response);
       String tourid=js.getString("id");
       System.out.println(tourid);

        given().when().get("/api/Tourist/"+tourid+"").then().log().all().assertThat().statusCode(200);

    }
}
