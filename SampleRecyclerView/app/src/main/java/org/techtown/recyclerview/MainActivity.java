package org.techtown.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("AAA", "010-1111-1111"));
        adapter.addItem(new Person("BBB", "010-2222-2222"));
        adapter.addItem(new Person("CCC", "010-3333-3333"));

        recyclerView.setAdapter(adapter);
    }
}