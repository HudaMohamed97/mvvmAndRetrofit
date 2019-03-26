package com.example.huda.mvvmandretrofit;

import android.arch.lifecycle.MutableLiveData;

import com.example.huda.mvvmandretrofit.retrofit.Api;
import com.example.huda.mvvmandretrofit.retrofit.ModelResponce;
import com.example.huda.mvvmandretrofit.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Huda on 3/26/2019.
 */

public class Reporsitory {
    Api apiInterface;

    public Reporsitory() {
        apiInterface = RetrofitHelper.getClient().create(Api.class);

    }

    public MutableLiveData<ModelResponce> callRetrofit() {
        final MutableLiveData<ModelResponce> data = new MutableLiveData<>();

        Call<ModelResponce> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<ModelResponce>() {
            @Override
            public void onResponse(Call<ModelResponce> call, Response<ModelResponce> response) {

                if (response.isSuccessful()) {
                    ModelResponce modelResponce = response.body();
                    data.setValue(modelResponce);

                }

            }

            @Override
            public void onFailure(Call<ModelResponce> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

}
