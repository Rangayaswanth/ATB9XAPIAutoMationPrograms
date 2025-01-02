package com.yaswanth.base;

import com.yaswanth.asserts.AssertActions;
import com.yaswanth.endpoints.APIConstants;
import com.yaswanth.modules.PayLoadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;


public class BaseTest {



   public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayLoadManager payLoadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeTest
    public void setUp() {

        payLoadManager = new PayLoadManager();
        assertActions = new AssertActions();

        requestSpecification = RestAssured
                .given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON)
                .log().all();

        System.out.println(requestSpecification);

    }

        public String gettoken () {
            requestSpecification = RestAssured.given()
                    .baseUri(APIConstants.BASE_URL)
                    .basePath(APIConstants.AUTH_URL);
            System.out.println(requestSpecification);

            String payload = payLoadManager.setAuthPayLoad();
            response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();
            String token = payLoadManager.getTokenFromJson(response.asString());
            return token;


        }











}






