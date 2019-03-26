package com.example.huda.mvvmandretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.huda.mvvmandretrofit.retrofit.Api;
import com.example.huda.mvvmandretrofit.retrofit.ModelResponce;
import com.example.huda.mvvmandretrofit.retrofit.RetrofitHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.respone_text)
    TextView myText;
    Api apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        callRetrofit();

    }

    private void callRetrofit() {
        apiInterface = RetrofitHelper.getClient().create(Api.class);
        Call<ModelResponce> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<ModelResponce>() {
            @Override
            public void onResponse(Call<ModelResponce> call, Response<ModelResponce> response) {

                ModelResponce modelResponce = response.body();
                myText.setText(modelResponce.page + "" + modelResponce.totalPages + "" + modelResponce.perPage);

            }

            @Override
            public void onFailure(Call<ModelResponce> call, Throwable t) {

            }
        });


    }
}
