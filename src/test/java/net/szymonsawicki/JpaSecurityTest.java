package net.szymonsawicki;

import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import net.szymonsawicki.persistence.BookEntity;

@QuarkusTest
class JpaSecurityTest {

  @Test
  void shouldAccessPublicWhenAnonymousByFindAll() {
    get("/books").then().statusCode(HttpStatus.SC_OK);
  }

  @Test
  void shouldNotAccessWhenAnonymousByAddBook() {

    var exampleBook = new BookEntity();
    exampleBook.setTitle("test title");

    given()
        .body(exampleBook)
        .header("Content-Type", "application/json")
        .when()
        .post("/books/")
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED);
  }

  @Test
  void shouldReturn403errorByDeleteBookWhenWrongUser() {

    var exampleBook = new BookEntity();
    exampleBook.setTitle("test title");

    given()
        .auth()
        .preemptive()
        .basic("user", "user")
        .body(exampleBook)
        .header("Content-Type", "application/json")
        .when()
        .delete("/books-panache/")
        .then()
        .statusCode(HttpStatus.SC_FORBIDDEN);
  }

  @Test
  void shouldCreateBookWhenAdminAuthenticated() {

    var exampleBook = new BookEntity();
    exampleBook.setTitle("test title");

    given()
        .auth()
        .preemptive()
        .basic("admin", "admin")
        .body(exampleBook)
        .header("Content-Type", "application/json")
        .when()
        .get("/books/")
        .then()
        .statusCode(HttpStatus.SC_OK);
  }

  @Test
  void shouldReturnErrorWhenAdminNotAuthenticated() {

    given()
        .auth()
        .preemptive()
        .basic("admin", "wfgewrrg")
        .header("Content-Type", "application/json")
        .when()
        .get("/books/")
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED);
  }
}
