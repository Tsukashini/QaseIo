package tests.reatassuredtests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.NewProjectAPIModel;
import org.testng.annotations.Test;
import staticdata.Secret;
import testdata.NewProjectAPIData;

import static org.hamcrest.Matchers.equalTo;

public class CreateNewProjectAPITest {

    @Test(priority = 4)
    @Description("RestAssured test when user create a new project with API token")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://app.qase.io/projects")
    public void apiCreateNewProjects() {
        NewProjectAPIModel apiModel = NewProjectAPIData.getNewProjectAPIData();
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .and()
                .headers("Accept", "application/json")
                .header("Token", Secret.API_TOKEN_MANUAL)
                .body(apiModel)
                .when()
                .post("https://api.qase.io/v1/project")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("status", equalTo(true))
                .body("result.code", equalTo(apiModel.getCode()));
    }
}
