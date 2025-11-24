package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class US_345 extends BaseTest{

    private int MediaId;

    @Test(priority = 1, description = ("The movie has been added to favorites"))
    public void addFavorite(){

        String addFavoriteBody= """
            {
              "media_type":"movie",
              "media_id":550,
              "favorite":true
            }
          """;

        Response response = given()
                .spec(request)
                .body(addFavoriteBody)

                .pathParams("account_id","22484351")
                .when()
                .post("/account/{account_id}/favorite")

                .then()
                .statusCode(201)
                .body("status_code", equalTo(1))
                .body("status_message", equalTo("Success."))
                .extract().response();

        System.out.println("Favorite Result = " + response.path("status_message"));
    }
    }
/*
    @Test(priority = 2,description = "")
    public void addToWatchlist(){

    }


 */