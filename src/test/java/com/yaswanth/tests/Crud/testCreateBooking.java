package com.yaswanth.tests.Crud;

import com.yaswanth.base.BaseTest;
import com.yaswanth.endpoints.APIConstants;
import com.yaswanth.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import  io. restassured. specification. RequestSpecification;



public class testCreateBooking extends BaseTest {

    @Owner("Ysawanth")
    @Issue("JIRA_RBT-4")
    @Description("Verify the POST Request is working fine ")
    @Test(groups = "qa")
    public void testVerifyCreateBookingPOST01(ITestContext iTestContext){


        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);


        response = RestAssured.given(requestSpecification)
                .when().body(payLoadManager.CreatePayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        BookingResponse bookingResponse= payLoadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeys(bookingResponse.getBooking().getFirstname(),"Yaswanth");



    }











}
