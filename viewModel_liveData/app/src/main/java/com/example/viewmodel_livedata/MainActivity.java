package com.example.viewmodel_livedata;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodel_livedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SampleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        //viewModel = new ViewModelProvider(this).get(SampleViewModel.class);
        viewModel = new ViewModelProvider(this, new SampleViewModelFactory("InitText", "InitButton")).get(SampleViewModel.class);
        binding.setData(viewModel);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel.button.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.button.setText(s);
            }
        });

        viewModel.text.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textView.setText(s);
            }
        });

    }
}