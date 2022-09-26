package OppFi.Take_Home_Exercise;

import OppFi.utils.BasePage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import OppFi.utils.ConfigurationReader;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Take_Home_Exercise extends BasePage {

    @BeforeEach  //@Before in Junit 4
    public void setUp() {
        baseURI = ConfigurationReader.getProperty("TARGET_URL");
    }

    @DisplayName("Positive Test Result")
    @Test
    public void acceptedTestResult () {
        Map<String, ?> responseBodyInfo = given().accept(ContentType.JSON)
                .and().header("x-api-key", ConfigurationReader.getProperty("API_KEY"))
                .and().body(BasePage.requestBody)
                .when().post()
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().extract().body().as(Map.class);

        System.out.println("Status = " + responseBodyInfo.get("status"));
        System.out.println("Accepted = " + responseBodyInfo.get("accepted"));
        System.out.println("Code = " + responseBodyInfo.get("code"));
        System.out.println(responseBodyInfo);


        System.out.println();

        assertThat ("Acceptation verification is failed", responseBodyInfo.get("accepted"), is(true));
        assertThat(responseBodyInfo.get("status"), is("APPROVED"));
        assertThat(responseBodyInfo.get("code"), is(201));
        assertTrue(responseBodyInfo.get("offers").toString().contains("Because you deserve more than a payday loan!"));


    }

    @DisplayName("Negative Test Result!")
    @Test
    public void declineTestResult () {
        Map<String, ?> responseBodyInfo = given().accept(ContentType.JSON)
                .and().header("x-api-key", ConfigurationReader.getProperty("API_KEY"))
                .and().body(BasePage.requestBody)
                .when().post()
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().extract().body().as(Map.class);

        System.out.println("Status = " + responseBodyInfo.get("status"));
        System.out.println("Accepted = " + responseBodyInfo.get("accepted"));
        System.out.println("Code = " + responseBodyInfo.get("code"));

        assertThat ("Acceptation verification is failed", responseBodyInfo.get("accepted"), is(false));
        assertThat(responseBodyInfo.get("status"), is("DECLINED"));
        assertThat(responseBodyInfo.get("code"), is(315));
    }



    @DisplayName("Request JSON Fields")
    @Test
    public void jsonFieldsTestResult () {
        Response response = given().accept(ContentType.JSON)
                .and().header("x-api-key", ConfigurationReader.getProperty("API_KEY"))
                .and().body(BasePage.requestBody)
                .and().contentType(ContentType.JSON)
                .when().post();

        JsonPath jsonPath = response.jsonPath();

        System.out.println("Status = " + jsonPath.get("status"));
        System.out.println("Accepted = " + jsonPath.get("accepted"));
        System.out.println("Code = " + jsonPath.get("code"));

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertThat ("Acceptation verification is failed", jsonPath.get("accepted"), is(false));
        assertThat(jsonPath.get("status"), is("DECLINED"));
        assertThat(jsonPath.get("code"), is(402));
    }


}
