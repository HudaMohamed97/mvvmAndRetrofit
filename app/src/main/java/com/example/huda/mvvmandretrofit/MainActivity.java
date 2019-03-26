package com.example.huda.mvvmandretrofit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.huda.mvvmandretrofit.retrofit.ModelResponce;
import com.example.huda.mvvmandretrofit.retrofit.MyViewModel;

public class MainActivity extends AppCompatActivity {
    TextView myText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView) findViewById(R.id.respone_text);
        callViewModel();
    }

    private void callViewModel() {
        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);

        model.geData().observe(this, new Observer<ModelResponce>() {
            @Override
            public void onChanged(ModelResponce myList) {
                myText.setText(myList.data.get(0).name + "" + myList.perPage);
            }
        });
    }


}
