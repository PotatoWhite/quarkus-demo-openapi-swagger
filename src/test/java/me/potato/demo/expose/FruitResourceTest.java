package me.potato.demo.expose;

import io.quarkus.test.junit.QuarkusTest;
import me.potato.demo.model.Fruit;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class FruitResourceTest {

  @Test
  public void testList() {
    given()
            .when()
            .get("/fruits")
            .then()
            .statusCode(SC_OK)
            .body("$.size()", is(2),
                  "name", containsInAnyOrder("Apple", "Pineapple"),
                  "description", containsInAnyOrder("Winter fruit", "Tropical fruit"));
  }

  @Test
  public void testAdd() {
    var testFruit=new Fruit("Pear", "Delicious fruit");

    given()
            .body(testFruit)
            .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .when()
            .post("/fruits")
            .then()
            .statusCode(SC_OK)
            .body("$.size()", is(3),
                  "name", containsInAnyOrder("Apple", "Pineapple", "Pear"),
                  "description", containsInAnyOrder("Winter fruit", "Tropical fruit", "Delicious fruit"));

    given()
            .body(testFruit)
            .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .when()
            .delete("/fruits")
            .then()
            .statusCode(SC_OK)
            .body("$.size()", is(2),
                  "name", containsInAnyOrder("Apple", "Pineapple"),
                  "description", containsInAnyOrder("Winter fruit", "Tropical fruit"));


  }


}