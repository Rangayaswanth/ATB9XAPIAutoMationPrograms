package com.yaswanth.tests.Sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingSample {

    //Create a booking , Create a Token
    //Verify that Get booking
    //Update the booking
    //Delete the booking
    @Owner("Yaswanth")
    @Test(groups = "qa" , priority = 1)
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void test_CreateBooking(){
        Assert.assertTrue(true);
    }
    @Owner("Yaswanth")
    @Test(groups = "qa" , priority = 2)
    @Description("TC#INT1 - Step 2. Verify that the Booking can be Created")
    public void test_VerifyBooking(){
        Assert.assertTrue(true);
    }
    @Owner("Yaswanth")
    @Test(groups = "qa" , priority = 3)
    @Description("TC#INT1 - Step 3. Verify that the Update Booking can be Created")
    public void test_UpdateBooking(){
        Assert.assertTrue(true);
    }
    @Owner("Yaswanth")
    @Test(groups = "qa" , priority = 4)
    @Description("TC#INT1 - Step 4. Verify that the Delete Booking can be Created")
    public void test_DeleteBooking(){
        Assert.assertTrue(true);
    }
















}
