package mvp.dagger.yify.yify.ui.login;

import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import mvp.dagger.yify.yify.api.ApiClient;
import mvp.dagger.yify.yify.model.login.login_failure.LoginFailWrapper;
import mvp.dagger.yify.yify.model.login.login_success.LoginSuccessWrapper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static mvp.dagger.yify.yify.util.CommonUtil.*;

/**
 * Created by vardan sharma on 10-04-2015.
 */
public class LoginInteractorImp implements LoginInteractor {
     OnLoginFinishListner listner;

    public LoginInteractorImp(OnLoginFinishListner listner) {

        this.listner = listner;
    }

    @Override
    public boolean validateFields(String email, String pass) {
        //Check against empty username
        if (TextUtils.isEmpty(email))
            listner.onUserNameError();
            //check against empty password
        else if (TextUtils.isEmpty(pass))
            listner.onUserNameError();
        else {
            return true;
        }
        return false;
    }

    @Override
    public void loginUser(String username, String pass) {
        ApiClient.getApiClientWithStringConverter().LoginUser(username, pass, getAppKey(), new Callback<String>() {
            @Override
            public void success(String loginResponse, Response response) {
                try {
                    JSONObject jsonObject = new JSONObject(loginResponse);
                    String status = jsonObject.getString("status");
                    if (status.equals("error")) {
                        Gson gson = new Gson();
                        LoginFailWrapper errorObj = gson.fromJson(loginResponse, LoginFailWrapper.class);
                        listner.onFailure(errorObj.getStatusMessage());
                    } else {
                        // Login successful use diff object to parse data and get the user id
                        LoginSuccessWrapper loginSuccessWrapper = new Gson().fromJson(loginResponse, LoginSuccessWrapper.class);
                        String userKey = loginSuccessWrapper.getData().getUserKey();
                        showToast(userKey);
                        listner.onSuccess();//todo change this
                    }
                } catch (JSONException e) {
                    listner.onFailure("Parsing failed");
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                listner.onFailure(error.getMessage());

            }
        });
    }
}
