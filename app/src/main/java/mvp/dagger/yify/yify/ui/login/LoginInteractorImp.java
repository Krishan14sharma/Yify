package mvp.dagger.yify.yify.ui.login;

import mvp.dagger.yify.yify.api.ApiClient;
import mvp.dagger.yify.yify.model.login.LoginResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by vardan sharma on 10-04-2015.
 */
public class LoginInteractorImp implements LoginInteractor {
    FinishListner listner;

    public LoginInteractorImp(FinishListner listner) {
        this.listner = listner;
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
