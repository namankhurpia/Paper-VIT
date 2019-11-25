package com.namankhurpia.paper.view.Retrofit_service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit=null;
    private static String BASE_URL="http://namankhurpia.pythonanywhere.com/";

    public static paperDataService getService()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(paperDataService.class);
    }

}
