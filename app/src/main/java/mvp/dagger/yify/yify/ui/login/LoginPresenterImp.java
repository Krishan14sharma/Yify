package mvp.dagger.yify.yify.ui.login;

import android.text.TextUtils;

import mvp.dagger.yify.yify.model.login.LoginResponse;
import retrofit.RetrofitError;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public class LoginPresenterImp implements LoginPresenter {
    LoginView view;
    LoginInteractor interactor;

    public LoginPresenterImp(LoginView view) {
        this.view = view;
    }


    @Override
    public void loginUser(String email, String pass) {
        view.showLoading();
        if (validateFields(email, pass))
            interactor.loginUser(email, pass);
    }

    //todo  check this krishan is this the right way ??
    private boolean validateFields(String email, String pass) {
        //Check against empty username
        if (TextUtils.isEmpty(email))
            view.setUsernameError();
            //check against empty password
        else if (TextUtils.isEmpty(pass))
            view.setPasswordError();
        else {
            return true;
        }
        return false;
    }

    @Override
    public void onSuccess(LoginResponse data) {
        // todo save data to shared prefs etc
        view.showLoginSuccessMsg();
        view.hideLoading();
        view.navigateToHome();
    }

    @Override
    public void onFailure(RetrofitError error) {
        view.hideLoading();
    }
}
