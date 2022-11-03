
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class getrequest {
    public static void main(String[] args){
        RestAssured.proxy("165.225.106.40",9400);
        RestAssured.baseURI= "https://reqres.in/api/users?page=2";
        RestAssured.useRelaxedHTTPSValidation();
        given().when().get().then().log().all().assertThat().statusCode(200)
              .body("data[0].email", equalTo("george.bluth@reqres.in"))
               .header("Content-Type","application/json; charset=utf-8");
    }
}
