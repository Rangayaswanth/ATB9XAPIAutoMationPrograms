package com.yaswanth.modules;

import com.google.gson.Gson;
import com.yaswanth.pojos.*;


public class PayLoadManager {
    Gson gson;


    public String CreatePayloadBookingAsString() {


        Booking booking = new Booking();
        booking.setFirstname("Yaswanth");
        booking.setLastname("Ranga");
        booking.setTotalprice(124);
        booking.setDepositpaid(true);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-02");
        bookingdates.setCheckout("2025-05-03");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");


        gson = new Gson();
        String jsonStringpayLoad = gson.toJson(booking);
        System.out.println(jsonStringpayLoad);
        return jsonStringpayLoad;
    }

        public BookingResponse bookingResponseJava(String responseString) {
            gson = new Gson();
            BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
            return bookingResponse;
        }

        public Booking getResponseFromJson(String getResponse){
            gson = new Gson();
            Booking booking = gson.fromJson(getResponse,Booking.class);
            return booking;
        }




        public  String setAuthPayLoad(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
            System.out.println("payload set to ->"+jsonPayloadString );
            return jsonPayloadString;

    }


    public String getTokenFromJson(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();


    }

    public String fullUpdatePayloadAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Bhaggat");
        booking.setLastname("Ranga");
        booking.setTotalprice(124);
        booking.setDepositpaid(true);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-02");
        bookingdates.setCheckout("2025-05-03");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");
        return gson.toJson(booking);
    }



    }

