package com.yaswanth.asserts;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class AssertActions {
    public void verifyResponseBody(String actual, String expected,String description){
        assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(int actual, int expected,String description){
        assertEquals(actual,expected,description);
    }
    public void verifyStatusBody(Response response,Integer expected){
        assertEquals(response.getStatusCode(),expected);
    }

    public void verifyStringKeys(String KeyExpect, String KeyActual){
        assertThat(KeyExpect).isNotNull();
        assertThat(KeyExpect).isNotNull().isNotBlank();
        assertThat(KeyExpect).isEqualTo(KeyActual);
    }





}
