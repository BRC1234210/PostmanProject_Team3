package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class US_6_7_8_18 extends BaseTest{

        int accountID=22484351;
        int movieID = 550;

    @Test(priority = 1, description = "US_06 Get Favourite Movies")
    public void test06_GetFavouriteMovies(){

        Response response =
                given()
                        .spec(request)
                        .param("account_id", accountID)
                        .when()
                        .get("/account/" +  accountID + "/favorite/movies")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.prettyPrint();
    }

    @Test( priority = 2, description = "US_07 Get Rated Movies")
public void test07_GetRatedMovies() {

        Response response =
                given()
                        .spec(request)
                        .param("account_id", accountID)
                        .when()
                        .get("/account/" + accountID + "/rated/movies")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.prettyPrint();
    }

    @Test(priority = 3, description = "Get Watchlist Movies")
    public void test08_GetWatchListMovies(){

        Response response =
                given()
                        .spec(request)
                        .param("account_id", accountID)
                        .when()
                        .get("/account/" + accountID + "/watchlist/movies")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.prettyPrint();

    }

    @Test (priority = 4, description = "Delete Movie Rating")
    public void test18_DeleteMovieRating(){
        Response response =
                given()
                        .spec(request)
                        .param("movie_id", movieID)
                        .when()
                        .delete("/movie/" +  movieID + "/rating")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.prettyPrint();
    }
}
