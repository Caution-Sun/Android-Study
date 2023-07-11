package org.techtown.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("AAA", "010-1111-1111"));
        adapter.addItem(new Person("BBB", "010-2222-2222"));
        adapter.addItem(new Person("CCC", "010-3333-3333"));
        adapter.addItem(new Person("DDD", "010-4444-4444"));
        adapter.addItem(new Person("EEE", "010-5555-5555"));
        adapter.addItem(new Person("FFF", "010-6666-6666"));
        adapter.addItem(new Person("GGG", "010-7777-7777"));
        adapter.addItem(new Person("HHH", "010-8888-8888"));
        adapter.addItem(new Person("III", "010-9999-9999"));
        adapter.addItem(new Person("JJJ", "010-0000-0000"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "아이템 선택됨 : " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}