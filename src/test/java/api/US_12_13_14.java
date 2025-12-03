package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class US_12_13_14 extends BaseTest{

    int accountID=22496308; // beklemede

    @Test(priority = 1,description = "US-12 get top rated movie")
        public void getTopRatedMovie(){
        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie" + "/top_rated")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.prettyPrint();
    }

    @Test(priority = 2,description = "US-13 get upcoming movies")
    public void getUpcomingMovies(){
        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie" + "/upcoming")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.prettyPrint();
    }

    @Test(priority = 3,description = "US-14 search movie")
    public void getSearchMovie(){
        String queryValue = "Altered";
        Response response =
                given()
                        .spec(request)
                        .queryParam("query",queryValue)
                        .when()
                        .get("/search" + "/movie")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.prettyPrint();
    }

}
