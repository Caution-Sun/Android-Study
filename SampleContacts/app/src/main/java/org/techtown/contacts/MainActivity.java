package org.techtown.contacts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == 101){

                try{

                    Uri contactsUri = data.getData();
                    String id = contactsUri.getLastPathSegment();

                    getContacts(id);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseContacts();
            }
        });

        String[] permissions = {
                Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS
        };

        checkPermission(permissions);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 102: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this, "첫 번째 권한 승인됨.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "첫 번째 권한 거부됨.", Toast.LENGTH_SHORT).show();

                return;
            }
        }

    }

    public void checkPermission(String[] permissions){
        ArrayList<String> targetList = new ArrayList<String>();

        for(int i = 0; i < permissions.length; i++){
            String curPermission = permissions[i];
            int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);
            if(permissionCheck == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, curPermission + "권한 있음.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, curPermission + "권한 없음.", Toast.LENGTH_SHORT).show();
                if(ActivityCompat.shouldShowRequestPermissionRationale(this, curPermission)){
                    Toast.makeText(this, curPermission + "권한 설명 필요함.", Toast.LENGTH_SHORT).show();
                }else{
                    targetList.add(curPermission);
                }
            }
        }

        String[] targets = new String[targetList.size()];
        targetList.toArray(targets);

        ActivityCompat.requestPermissions(this, targets, 102);
    }

    public void getContacts(String id){
        Cursor cursor = null;
        String name = "";

        try{

            cursor = getContentResolver().query(
                    ContactsContract.Data.CONTENT_URI,
                    null,
                    ContactsContract.Data.CONTACT_ID + "=?",
                    new String[] { id },
                    null);

            if(cursor.moveToFirst()){
                int cursor_name = cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME);
                name = cursor.getString(cursor_name);
                println("Name : " + name);

                String columns[] = cursor.getColumnNames();
                for(String column : columns){
                    int index = cursor.getColumnIndex(column);
                    String columnOutput = ("#" + index + " -> [" + column + "]  " + cursor.getString(index));
                    println(columnOutput);
                }

                cursor.close();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void chooseContacts() {
        Intent contactPickerIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(contactPickerIntent, 101);
    }

    public void println(String data){
        textView.append(data + "\n");
    }
}