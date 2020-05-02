package com.example.myapplication0.ui.feederdetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FeederDetailsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FeederDetailsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}