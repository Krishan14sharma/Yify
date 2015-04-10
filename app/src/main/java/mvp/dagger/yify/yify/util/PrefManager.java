package mvp.dagger.yify.yify.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by vardan sharma on 27-12-2014.
 * Serves as the helper class for shared preferences
 */
public class PrefManager {


    /**
     * @return the instance of the shared preference
     */
    public SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(Constants.PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Returns the hash value stored in preferences
     */
    public String getHash() {
        return CommonUtil.getPreferences().getString(Constants.USER_PREF_HASH, "");
    }

    /**
     * Returns the user name value stored in preferences
     */

    public String getUserName() {
        return CommonUtil.getPreferences().getString(Constants.USER_PREF_UNAME, "");
    }

    /**
     * Returns the user id value stored in preferences
     */
    public String getUserId() {
        return CommonUtil.getPreferences().getString(Constants.USER_PREF_ID, "");
    }
}
