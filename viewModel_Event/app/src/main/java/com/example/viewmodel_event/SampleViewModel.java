package com.example.viewmodel_event;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleViewModel extends ViewModel {

    private final MutableLiveData<Event<String>> nextActivityEvent = new MutableLiveData<>();
    public LiveData<Event<String>> getNextActivityEvent() {
        return nextActivityEvent;
    }

    public void onButtonClicked(View view) {
        nextActivityEvent.setValue(new Event<String>("event"));
    }

}
