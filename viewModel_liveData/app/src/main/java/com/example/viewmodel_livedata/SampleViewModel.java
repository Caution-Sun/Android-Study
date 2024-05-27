package com.example.viewmodel_livedata;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleViewModel extends ViewModel {

    private MutableLiveData<String> _text = new MutableLiveData<>();
    LiveData<String> text = _text;
    private MutableLiveData<String> _button = new MutableLiveData<>();
    LiveData<String> button = _button;

    public SampleViewModel(String text, String button) {
        _text.setValue(text);
        _button.setValue(button);
    }

    public void onButtonClicked(View view) {
        _button.setValue(_button.getValue() + "+");
    }

    public void onTextChanged(CharSequence s, int start, int before, int count){
        _text.setValue(s.toString());
    }
}
