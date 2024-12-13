package net.szymonsawicki;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class BookEntityControllerTest {
  @Test
  void testHelloEndpoint() {
    given().when().get("/books/").then().statusCode(200);
  }
}
