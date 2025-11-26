package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class US_15_16_17_19 extends BaseTest {

    int movieID = 550;

    @Test(priority = 1, description = "US_15 - Get Movie Details")
    public void test15_getMovieDetails() {
        Response response =
                given()
                        .spec(request)
                        .when()
                        .get("/movie/" + movieID)
                        .then()
                        .statusCode(200)
                        .body("id", equalTo(movieID))
                        .body("title", notNullValue())
                        .extract().response();

        response.prettyPrint();
    }

    @Test(priority = 2, description = "Search for movie by keywords")
    public void test16_searchForKeywords() {

        String queryValue = "Fight Club";

        given()
                .spec(request)
                .queryParam("query", queryValue)
                .when()
                .get("/search/movie")
                .then()
                .statusCode(200)
                .body("results.size()", greaterThan(0))
                .body("results[0].title.toLowerCase()", containsString("fight"));
    }

    @Test(priority = 3, description = "Add rating to a movie")
    public void test17_addMovieRating() {

        String ratingBody = """
                {
                   "value": 8.5
                }
                """;
        Response response =
                given()
                        .spec(request)
                        .body(ratingBody)
                        .when()
                        .post("/movie/" + movieID + "/rating")
                        .then()
                        .statusCode(201)
                        .body("status_message", containsString("success"))
                        .extract()
                        .response();

        response.prettyPrint();
    }

    @Test(priority = 4, description = "Unauthorized access when adding a movie to a list")
    public void test19_unauthorizedAccess() {

        String requestBody = """
                {
                   "media_id": 18
                }
                """;

        Response response = given()
                .spec(request)
                .queryParam("session_id", "invalid123456")
                .body(requestBody)
                .when()
                .post("/list/1/add_item")
                .then()
                .statusCode(401)
                .body("status_code", equalTo(3))
                .body("status_message", containsString("Authentication failed"))
                .extract().response();

        response.prettyPrint();
    }
}
