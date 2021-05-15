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

public class restAssuredTests {
    @Test
    public void simpleRestAssuredTest1() {
        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "";

        //setup Request Object
        RequestSpecification request = given();

        //setup Response Object
        Response response = request.request(Method.GET, endpoint);

        //Get Response Status Code
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }

    @Test
    public void simpleRestAssuredTest1_2() {

        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body();


    }

    @Test
    public void simpleRestAssuredTest2() {
        String expectedValue = "{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\"," +
                "\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":" +
                "\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server " +
                "costs are appreciated!\"}}";

        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/users/2";

        //setup Request Object
        RequestSpecification request = given();

        //setup Response Object
        Response response = request.request(Method.GET, endpoint);

        //Get Response Status Code
        int statusCode = response.getStatusCode();

        //Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
        Assert.assertEquals(responseBody, expectedValue);
    }

    @Test
    public void simpleRestAssuredTest2_2() {

        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"));


    }

    @Test
    public void serializationTest() {
        Gson gson = new Gson();
        ProjectLombokBuilder project = ProjectLombokBuilder.builder()
                .name("name")
                .type(ProjectType.SINGLE_FOR_ALL_CASES)
                .isShowAnnouncement(true)
                .announcement("test announsement")
                .build();
        String result = gson.toJson(project);
        System.out.println(result);

    }

    @Test
    public void deserializationTest() {

        Gson gson = new Gson();
        String jsonString = "{\"name\":\"name\",\"announcement\":\"test announsement\",\"isShowAnnouncement\":true,\"type\":\"SINGLE_FOR_ALL_CASES\"}";


        ProjectLombokBuilder project = gson.fromJson(jsonString, ProjectLombokBuilder.class);

        System.out.println(project.toString());
    }

    @Test
    public void equalTest() {
        ProjectLombokBuilder expectedProject = ProjectLombokBuilder.builder()
                .name("name")
                .type(ProjectType.SINGLE_FOR_ALL_CASES)
                .isShowAnnouncement(true)
                .announcement("test announsement")
                .build();

        Gson gson = new Gson();
        String jsonString = "{\"name\":\"name\",\"announcement\":\"test announsement\",\"isShowAnnouncement\":true,\"type\":\"SINGLE_FOR_ALL_CASES\"}";


        ProjectLombokBuilder actualProject = gson.fromJson(jsonString, ProjectLombokBuilder.class);

        System.out.println(actualProject.toString());
        Assert.assertTrue(expectedProject.equals(actualProject));
    }


    @Test
    public void registerSuccessfulTest() {

        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/register";
        String bodyJson = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body();

    }
    @Test
    public void registerUnSuccessfulTest() {

        RestAssured.baseURI = "http://reqres.in";
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
        System.out.println();

    }

    @Test
    public void simpleRestAssuredTest3_1() {
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        int projectID = given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body()
                .extract().jsonPath().getInt("id");


        System.out.println(projectID);

    }
}
