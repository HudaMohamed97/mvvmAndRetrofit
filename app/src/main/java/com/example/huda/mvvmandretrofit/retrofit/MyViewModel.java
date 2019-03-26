package com.example.huda.mvvmandretrofit.retrofit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.widget.LinearLayout;

import com.example.huda.mvvmandretrofit.Reporsitory;

import java.util.List;

/**
 * Created by Huda on 3/26/2019.
 */

public class MyViewModel extends ViewModel {
    private MutableLiveData<ModelResponce> List;
    Reporsitory reporsitory;

    public LiveData<ModelResponce> geData() {
        //if the list is null
        if (List == null) {
            List = new MutableLiveData<ModelResponce>();
            reporsitory = new Reporsitory();
            List = reporsitory.callRetrofit();
        }
        return List;
    }

}
