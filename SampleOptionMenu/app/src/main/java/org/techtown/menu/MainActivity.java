package org.techtown.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        TextView textView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textView = findViewById(R.id.textView);
            registerForContextMenu(textView);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            int curId = item.getItemId();

            switch (curId) {
                case R.id.menu_refresh:
                    Toast.makeText(this, "새로고침", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_search:
                    Toast.makeText(this, "검색", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_settings:
                    Toast.makeText(this, "설정", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            getMenuInflater().inflate(R.menu.menu_context, menu);
        }

        @Override
        public boolean onContextItemSelected(@NonNull MenuItem item) {

            int curId = item.getItemId();

            switch (curId) {
                case R.id.menu_a:
                    Toast.makeText(this, "Context A", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_b:
                    Toast.makeText(this, "Context B", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_c:
                    Toast.makeText(this, "Context C", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

            return super.onContextItemSelected(item);
        }
    }