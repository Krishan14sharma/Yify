package mvp.dagger.yify.yify.util;


import java.io.IOException;
import java.io.InputStream;

import mvp.dagger.yify.yify.ui.common.BaseApp;

import static mvp.dagger.yify.yify.ui.common.BaseApp.*;


/**
 * Created by krishan on 1/4/15.
 */
public class CommonUtil {
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

