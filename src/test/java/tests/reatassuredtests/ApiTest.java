package tests.reatassuredtests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.parser.JSONParser;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test(enabled = false)
    public void apiDeleteProject() {
        apiGetAllProjectsTemp2();

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .and()
                .headers("Accept", "application/json")
                .header("Token", "037c02547e8e0a99dc18f5e766e4c93905fc0c66")
                .when()
                .delete(String.format("https://api.qase.io/v1/project/%s", "df"))
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("status", equalTo(true));
    }

    @Test
    public void apiGetAllProjects() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .and()
                .headers("Accept", "application/json")
                .header("Token", "037c02547e8e0a99dc18f5e766e4c93905fc0c66")
                .when()
                .get("https://api.qase.io/v1/project")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("status", equalTo(true));
    }

    @Test(enabled = false)
    public void apiGetAllProjectsTemp2() {
        RequestSpecification request = RestAssured.given();
        request
                .contentType(ContentType.JSON)
                .log()
                .all()
                .and()
                .headers("Accept", "application/json")
                .header("Token", "037c02547e8e0a99dc18f5e766e4c93905fc0c66");
        Response response = request.get("https://api.qase.io/v1/project?limit=100&offset=0");


        try {
            FileWriter file = new FileWriter("src/test/resources/apiprojectlist.json");
            file.write(response.getBody().prettyPrint());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        response.body
//        getBody("result.entities[1].code").;

    }

//    @Test
//    public void apiGetAllProjectsTemp() {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://api.qase.io/v1/project")
//                .get()
//                .addHeader("Accept", "application/json")
//                .addHeader("Token", "037c02547e8e0a99dc18f5e766e4c93905fc0c66")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        response.body()
//    }

}