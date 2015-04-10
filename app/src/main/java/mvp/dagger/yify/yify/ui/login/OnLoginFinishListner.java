package mvp.dagger.yify.yify.ui.login;

import mvp.dagger.yify.yify.model.login.LoginResponse;
import retrofit.RetrofitError;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public interface OnLoginFinishListner {
    void onSuccess(LoginResponse data);
    void onUserNameError();
    void onPasswordError();
    void onFailure(RetrofitError error);
}
