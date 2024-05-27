package com.example.viewmodel_livedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SampleViewModelFactory implements ViewModelProvider.Factory {
    private String mText;
    private String mButton;


    public SampleViewModelFactory(String mText, String mButton) {
        this.mText = mText;
        this.mButton = mButton;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SampleViewModel(mText, mButton);
    }
}
