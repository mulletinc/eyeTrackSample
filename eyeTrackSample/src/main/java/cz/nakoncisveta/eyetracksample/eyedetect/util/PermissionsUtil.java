package cz.nakoncisveta.eyetracksample.eyedetect.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

/**
 * Created by luke on 30/09/17.
 */

public class PermissionsUtil {

    public static boolean cameraPermissionGranted(Context context) {
        return ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;
    }
}
