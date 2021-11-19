package com.vienna.rentacar.api;

import com.vienna.rentacar.pojos.Login;
import com.vienna.rentacar.pojos.Rents;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestPlaceholder {



    @POST("login")
    Call<Login> login(@Body Login login);

    @GET("get-all-rentals")
    Call <List<Rents>> getAllRents(@Query("t") String t, @Query("u") String u);

}

