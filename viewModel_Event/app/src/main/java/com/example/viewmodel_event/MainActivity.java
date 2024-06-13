package com.example.viewmodel_event;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodel_event.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Data Binding 설정
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // viewModel 생성
        SampleViewModel viewModel = new ViewModelProvider(this).get(SampleViewModel.class);

        // viewModel을 레이아웃에 바인딩
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        // Observer 설정
        viewModel.getNextActivityEvent().observe(this, new Observer<Event<String>>() {
            @Override
            public void onChanged(Event<String> voidEvent) {
                if(voidEvent != null && voidEvent.getContentIfNotHandled() != null){
                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}