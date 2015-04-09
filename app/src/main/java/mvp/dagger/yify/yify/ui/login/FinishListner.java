package mvp.dagger.yify.yify.ui.login;

import mvp.dagger.yify.yify.model.login.LoginResponse;
import retrofit.RetrofitError;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public interface FinishListner {
    void onSuccess(LoginResponse data);

    void onFailure(RetrofitError error);
}
