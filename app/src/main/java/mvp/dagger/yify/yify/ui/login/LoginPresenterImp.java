package mvp.dagger.yify.yify.ui.login;

import mvp.dagger.yify.yify.model.login.LoginResponse;
import retrofit.RetrofitError;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public class LoginPresenterImp implements LoginPresenter, OnLoginFinishListner {
    LoginView view;
    LoginInteractor interactor;

    public LoginPresenterImp(LoginView view) {
        this.view = view;
    }


    @Override
    public void loginUser(String email, String pass) {
        view.showLoading();
        if (interactor.validateFields(email, pass)) {
            view.showLoading();
            interactor.loginUser(email, pass);
        }
    }

    //todo  check this krishan is this the right way ??


    @Override
    public void onSuccess(LoginResponse data) {
        // todo save data to shared prefs etc
        view.showLoginSuccessMsg();
        view.hideLoading();
        view.navigateToHome();
    }

    @Override
    public void onUserNameError() {
        view.setUsernameError();
        view.hideLoading();
    }

    @Override
    public void onPasswordError() {
        view.setPasswordError();
        view.hideLoading();
    }

    @Override
    public void onFailure(RetrofitError error) {
        view.hideLoading();
    }
}
