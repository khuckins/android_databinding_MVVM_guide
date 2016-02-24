package com.example.mvvmsampleproject.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

public class MainViewModel extends BaseObservable implements ViewModel {
    private Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }

    //Cleanup
    @Override
    public void destroy() {
        context = null;


    }

}