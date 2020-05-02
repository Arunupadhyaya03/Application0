package com.example.myapplication0.ui.meterdetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MeterDetailsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MeterDetailsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Enter Meter Details");
    }

    public LiveData<String> getText() {
        return mText;
    }
}