package mvp.dagger.yify.yify.domain.interactors;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import mvp.dagger.yify.yify.api.ApiClient;
import mvp.dagger.yify.yify.api.util.CancelableCallback;
import mvp.dagger.yify.yify.domain.presenter.OnFetchProfileDataFinishListener;
import mvp.dagger.yify.yify.domain.presenter.OnUserProfileUpdateFinishListener;
import mvp.dagger.yify.yify.model.error.ErrorWrapper;
import mvp.dagger.yify.yify.model.user_profile.UserProfileWrapper;
import mvp.dagger.yify.yify.util.CommonUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;
import timber.log.Timber;

import static mvp.dagger.yify.yify.util.CommonUtil.releaseCallback;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public class UserProfileInteractorImp implements UserProfileInterator {

    private CancelableCallback<String> mGetDataCallback;

    // todo we need a way to avoid writing these code
    @Override
    public void getUserProfileData(final OnFetchProfileDataFinishListener listener) {
        String key = "43e34c1945e4404588248d3cb164d660";//TODO Get these from the preferences
        ApiClient.getApiClientWithStringConverter().getUserProfile(key, mGetDataCallback = new CancelableCallback<String>(new Callback<String>() {
            @Override
            public void success(String data, Response response) {

                // Todo change this with a custom serializer
                try {
                    JSONObject jsonObject = new JSONObject(data);
                    String status = jsonObject.getString("status");
                    if (status.equals("error")) {
                        Gson gson = new Gson();
                        ErrorWrapper errorObj = gson.fromJson(data, ErrorWrapper.class);
                        listener.onFailure(errorObj.getStatusMessage());
                    } else {
                        // Login successful use diff object to parse data and get the user id
                        UserProfileWrapper userProfileData = new Gson().fromJson(data, UserProfileWrapper.class);
                        listener.onSucess(userProfileData);
                    }
                } catch (JSONException e) {
                    listener.onFailure("Parsing failed");
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(error.getMessage());
            }
        }));
    }

    @Override
    public void updateUserProfileData(String desc, File userImageFile, final OnUserProfileUpdateFinishListener listener) {
        String key = "43e34c1945e4404588248d3cb164d660"; // todo get the key from preferences
        TypedFile image = new TypedFile("image/jpeg", userImageFile);
        ApiClient.getApiClientWithStringConverter().editUserProfile(CommonUtil.getAppKey(), key, null, desc, image, new CancelableCallback<String>(new Callback<String>() {
            @Override
            public void success(String data, Response response) {
                try {
                    JSONObject jsonObject = new JSONObject(data);
                    String status = jsonObject.getString("status");
                    if (status.equals("error")) {
                        Gson gson = new Gson();
                        ErrorWrapper errorObj = gson.fromJson(data, ErrorWrapper.class);
                        listener.onUpdateFailure(errorObj.getStatusMessage());
                    } else {
                        // todo parse the data to recieve info
                        Timber.d("Response is", data);
                        listener.onUpdateSuccess();
                    }
                } catch (JSONException e) {
                    listener.onUpdateFailure("Parsing failed");
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onUpdateFailure(error.getMessage());
            }
        }));
    }


    @Override
    public void destroy() {
        releaseCallback(mGetDataCallback);
    }
}
