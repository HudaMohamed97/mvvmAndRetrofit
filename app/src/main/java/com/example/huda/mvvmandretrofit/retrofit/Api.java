package com.example.huda.mvvmandretrofit.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Huda on 3/26/2019.
 */

public interface Api {
    @GET("/api/unknown")
    Call<ModelResponce> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);


}
