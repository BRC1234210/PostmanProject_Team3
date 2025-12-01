
package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class US_9_10_11 extends BaseTest {

    @Test(priority = 1, description = "Get Movie Genres")
    public void getMovieGenres() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/genre/movie/list")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 2, description = "Get Now Playing Movies")
    public void getNowPlayingMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie/now_playing")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 3, description = "Get Popular Movies")
    public void getPopularMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie/popular")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }
}
