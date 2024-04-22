package com.example.viewBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.viewBinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    BindingFragment bindingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        bindingFragment = new BindingFragment();
        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), bindingFragment).commit();

    }
}