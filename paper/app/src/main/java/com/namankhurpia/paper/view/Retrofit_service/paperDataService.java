package com.namankhurpia.paper.view.Retrofit_service;

import com.namankhurpia.paper.view.Models.Schema;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface paperDataService {


    @GET("catone/")
    Call<List<Schema>> GetCatone();

    @GET("cattwo/")
    Call<List<Schema>> GetCattwo();

    @GET("fat/")
    Call<List<Schema>> GetFat();
}
