package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class PostmanEchoTest {
    @Test
    public void shouldPostmanEchoTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("I hope you are allright")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("I hope you are allright"))

                .body("headers.content-length", equalTo("23"));
        ;
    }
}