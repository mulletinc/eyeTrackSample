package cz.nakoncisveta.eyetracksample.eyedetect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import cz.nakoncisveta.eyetracksample.eyedetect.util.PermissionsUtil;

/**
 * Created by luke on 30/09/17.
 */

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        if (PermissionsUtil.cameraPermissionGranted(this)) {
            startActivity(new Intent(this, FdActivity.class));
        } else {
            startActivity(new Intent(this, PermissionsActivity.class));
        }
        finish();
    }
}
