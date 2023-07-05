package org.techtown.receiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permissions = {Manifest.permission.RECEIVE_SMS};

        checkPermissions(permissions);
    }

    public void checkPermissions(String[] permissions) {
        ArrayList<String> targetList = new ArrayList<String>();

        for(int i = 0; i < permissions.length; i++) {
            String curPermission = permissions[i];
            int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);

            if(permissionCheck == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, curPermission + " 권한 있음.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, curPermission + " 권한 없음.", Toast.LENGTH_SHORT).show();

                if(ActivityCompat.shouldShowRequestPermissionRationale(this, curPermission)) {
                    Toast.makeText(this, curPermission + " 권한 설명 필요함.", Toast.LENGTH_SHORT).show();
                } else {
                    targetList.add(curPermission);
                }
            }
        }

        String[] targets = new String[targetList.size()];
        targetList.toArray(targets);

        if(targets.length > 0)
            ActivityCompat.requestPermissions(this, targets, 101);
    }

}
