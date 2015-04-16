package mvp.dagger.yify.yify.domain.interactors;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import mvp.dagger.yify.yify.api.ApiClient;
import mvp.dagger.yify.yify.api.util.CancelableCallback;
import mvp.dagger.yify.yify.domain.presenter.OnFetchProfileDataFinishListener;
import mvp.dagger.yify.yify.model.error.ErrorWrapper;
import mvp.dagger.yify.yify.model.login.login.LoginSuccessWrapper;
import mvp.dagger.yify.yify.model.user_profile.UserProfileWrapper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static mvp.dagger.yify.yify.util.CommonUtil.showToast;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public class UserProfileInteractorImp implements UserProfileInterator {

    // todo we need a way to avoid writing these code
    @Override
    public void getUserProfileData(final OnFetchProfileDataFinishListener listener) {
        String key = "d260ac8680e24780abb9a4c9e9f3255a";
        ApiClient.getApiClientWithStringConverter().getUserProfile(key, new CancelableCallback<String>(new Callback<String>() {
            @Override
            public void success(String data, Response response) {
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
    public void updateUserProfileData() {

    }
}
