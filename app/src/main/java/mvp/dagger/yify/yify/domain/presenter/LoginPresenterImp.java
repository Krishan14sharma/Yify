package mvp.dagger.yify.yify.domain.presenter;

import mvp.dagger.yify.yify.domain.interactors.LoginInteractor;
import mvp.dagger.yify.yify.ui.view.LoginView;

/**
 * Created by vardan sharma  on 10-04-2015.
 *
 */
public class LoginPresenterImp implements LoginPresenter, OnLoginFinishListner {
    LoginView view;
    LoginInteractor interactor;

    public LoginPresenterImp(LoginView view, LoginInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }


    @Override
    public void loginBtnClicked(String email, String pass) {
        view.showLoading();
        view.disableLoginBtn();
        if (interactor.validateFields(email, pass, this)) {
            view.showLoading();
            interactor.loginUser(email, pass, this);
        }
    }

    @Override
    public void destroy() {
        interactor.destroy();
    }

    @Override
    public void onSuccess() {
        // todo save data to shared prefs etc
        view.showLoginSuccessMsg();
        view.hideLoading();
        view.navigateToHome();
        view.enableLoginBtn();
    }

    @Override
    public void onUserNameError() {
        view.setUsernameError();
        view.hideLoading();
        view.enableLoginBtn();
    }

    @Override
    public void onPasswordError() {
        view.setPasswordError();
        view.hideLoading();
        view.enableLoginBtn();
    }

    @Override
    public void onFailure(String error) {
        view.hideLoading();
        view.showLoginFailureMsg(error);
        view.enableLoginBtn();
    }
}
