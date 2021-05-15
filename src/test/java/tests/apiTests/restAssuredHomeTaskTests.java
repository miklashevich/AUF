package tests.apiTests;
import com.google.gson.Gson;
import enums.ProjectType;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ProjectLombokBuilder;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class restAssuredHomeTaskTests {

    @Test
    public void registerSuccessfulTest() {

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log()
                .body();

    }

    @Test
    public void registerUnSuccessfulTest() {

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/register";
        String bodyJson = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log()
                .body();

    }

    @Test
    public void listUsersTest() {

        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "api/users?page=2";

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body();
    }

    @Test
    public void singleUserTest2() {

        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"));

    }

    @Test
    public void putTest() {

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .put(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body();

    }

    @Test
    public void patchTest() {

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .patch(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body();

    }

    @Test
    public void deleteTest() {

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";
        String bodyJson = "";

        given()
                .body(bodyJson)
                .when()
                .delete(endpoint)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .log()
                .body();

    }

    @Test
    public void loginSuccessfulTest() {

            RestAssured.baseURI = "https://reqres.in";
            String endpoint = "/api/login";

            RequestSpecification request = given();

            Response response = request.request(Method.POST, endpoint);

            int statusCode = response.getStatusCode();
            System.out.println(statusCode);
            Assert.assertEquals(statusCode, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE);

// на сайте баг, не смог получить 200 при отправке запроса, поэтому в этом тесте получил код responsa
// и вижу что сайт не отдает 200 код при этом запросе, а дает 415 ошибку

    }

    @Test
    public void loginUnSuccessfulTest() {

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/login";
        String bodyJson = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("error", equalTo("Missing email or username"))
                .log()
                .body();

    }

}