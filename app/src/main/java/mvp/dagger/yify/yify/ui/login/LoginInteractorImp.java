package mvp.dagger.yify.yify.ui.login;

import android.text.TextUtils;

import mvp.dagger.yify.yify.api.ApiClient;
import mvp.dagger.yify.yify.model.login.LoginResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

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
        //
        ApiClient.getYifyApiClient().LoginUser(username, pass, new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse loginResponse, Response response) {
                listner.onSuccess(loginResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listner.onFailure(error);

            }
        });
    }
}
