package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification request;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3";

        request = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YjY5ZmEzNDIwY2Q1MTJhM2FhOWRmY2JiMDhkNzQ5YSIsIm5iZiI6MTc2MzU2MDQzNi4wNTEsInN1YiI6IjY5MWRjYmY0Mjc0NTc1MmRmMjJlMWFjNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.iHYwcFA4x8HO6VqKtXmQX_QrujNVjwdoCMz1xh2Yazc");

    }
}
