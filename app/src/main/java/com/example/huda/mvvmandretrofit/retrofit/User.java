package com.example.huda.mvvmandretrofit.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Huda on 3/26/2019.
 */

public class User {

    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

}
