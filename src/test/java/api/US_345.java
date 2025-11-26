package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.*;

public class US_345 extends BaseTest {


    @Test(priority = 1, description = "get account details")
    public void getAccountDetails() {

        Response response =
                given()
                        .spec(request)
                        .when()
                        .get("/account/22484351")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.body().prettyPrint();

    }



    @Test(priority = 2,description = "add to Favorite movies")
    public void addFavoriteMovie() {

        Map<String, String> addRating = new HashMap<>();
        addRating.put("value", "8,5");

        Response response =
                given()
                        .spec(request)
                        .body(addRating)
                        .when()
                        .post("movie/550/rating")
                        .then()
                        .statusCode(201)

                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 3, description = "add to watchlist movie")
    public void addToWatchlist() {

        String addWatchlistBody = """
                
                {
                "media_type":"movie",
                 "media_id":11,
                 "watchlist":true
                 }
                """;
        Response response =
                given()
                        .spec(request)
                        .body(addWatchlistBody)
                        .when()
                        .post("/account/11/watchlist")
                        .then()
                        .statusCode(201)
                        .extract().response();

        response.body().prettyPrint();

    }
}


