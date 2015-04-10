package mvp.dagger.yify.yify.util;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import mvp.dagger.yify.yify.BaseApp;

import static mvp.dagger.yify.yify.BaseApp.getContext;


/**
 * Created by krishan on 1/4/15.
 */
public class CommonUtil {

    // Dummy private constructor in order to avoid initialization of class
    private CommonUtil() {
    }

    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    public static int getAppVersion() {
        try {
            Context context = getContext();
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    /**
     * @return Gets the instance of shared preferences
     */

    public static SharedPreferences getPreferences() {
        return getContext().getSharedPreferences(Constants.PREFERENCE_FILE_NAME,
                Context.MODE_PRIVATE);
    }


    /**
     * @param message message to be displayed in Toast.
     */
    public static void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param fromActivity the activity from where we want to switch
     * @param toActivity   the class name of the  activity where we are switching to
     */

    public static void switchActivity(Activity fromActivity, Class toActivity) {
        Intent intent = new Intent(fromActivity, toActivity);
        fromActivity.startActivity(intent);
    }

    public static boolean hasGps() {
        LocationManager locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


    public static String loadJSONFromAsset(String filepath) {
        String json = null;
        try {

            InputStream is = getContext().getAssets().open(filepath);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}

