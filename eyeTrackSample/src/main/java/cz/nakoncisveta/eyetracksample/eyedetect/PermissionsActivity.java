package cz.nakoncisveta.eyetracksample.eyedetect;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by luke on 30/09/17.
 */

public class PermissionsActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CAMERA = 99;

    private boolean requestingPermission;

    @Override
    protected void onResume() {
        super.onResume();
        if (!requestingPermission) {
            requestCameraPermission();
        }
    }

    private void requestCameraPermission() {
        requestingPermission = true;
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA},
                REQUEST_CODE_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_CAMERA && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startActivity(new Intent(this, FdActivity.class));
            finish();
        } else {
            requestCameraPermission();
        }
    }
}
