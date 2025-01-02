package com.yaswanth.tests.integration;

import com.yaswanth.base.BaseTest;
import com.yaswanth.endpoints.APIConstants;
import com.yaswanth.pojos.Booking;
import com.yaswanth.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class TestIntegrationFlow extends BaseTest {

    @Description("TC#INT1 - STEP 1. Verify that the Booking can be Created")
    @Owner("Yaswanth")
    @Test(groups = "qa",priority = 1)
    public void testCreateBooking(ITestContext iTestContext){

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(payLoadManager.CreatePayloadBookingAsString()).post();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        BookingResponse bookingResponse = payLoadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeys(bookingResponse.getBooking().getFirstname(),"Yaswanth");

        System.out.println(bookingResponse.getBookingid());

        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());

    }
    @Owner("Yaswanth")
    @Test(groups = "qa",priority = 2)
    @Description("TC#INT1 - STEP 2. Verify that the Booking By ID")
    public void testVerifyBookingId(ITestContext iTestContext){
        System.out.println(iTestContext.getAttribute("bookingid"));
        //This can be a string, we need to type cast
        Integer bookingid =(Integer) iTestContext.getAttribute("bookingid");

        //GET Request - to verify that the first name after creation is yaswanth
        String basePathGet = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePathGet);

        requestSpecification.basePath(basePathGet);
        response=RestAssured
                .given(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking = payLoadManager.getResponseFromJson(response.asString());
        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Yaswanth");

    }


    @Owner("Yaswanth")
    @Test(groups = "qa",priority = 3)
    @Description("TC#INT1 - STEP 3. Verify that the Update Booking")
    public void testUpdateBookingById(ITestContext iTestContext){
        System.out.println(iTestContext.getAttribute("bookingid"));
        Integer bookingid =(Integer) iTestContext.getAttribute("bookingid");
        String token = gettoken();
        iTestContext.setAttribute("token",token);
        String basePathPUTPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePathPUTPATCH);

        requestSpecification.basePath(basePathPUTPATCH);
        response= RestAssured
                .given(requestSpecification).cookie("token",token)
                .when().body(payLoadManager.fullUpdatePayloadAsString()).put();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking = payLoadManager.getResponseFromJson(response.asString());
        assertThat(booking.getFirstname()).isNotBlank().isNotNull();
        assertThat(booking.getLastname()).isNotBlank().isNotNull();
        assertThat(booking.getLastname()).isEqualTo("Ranga");

    }
    @Owner("Yaswanth")
    @Test(groups = "qa",priority = 4)
    @Description("TC#INT1 - STEP 4. Verify that the Delete Booking")
    public void testDeleteBookingById(ITestContext iTestContext){
            String token = (String)iTestContext.getAttribute("token");
            Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

            String basePathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
            requestSpecification.basePath(basePathDelete).cookie("token",token);
            validatableResponse= RestAssured.given().spec(requestSpecification)
                    .when().delete().then().log().all();
            validatableResponse.statusCode(201);

    }


























}
