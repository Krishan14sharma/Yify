package mvp.dagger.yify.yify.domain.presenter;

import javax.inject.Inject;

import mvp.dagger.yify.yify.domain.interactors.SignUpInteractor;
import mvp.dagger.yify.yify.domain.interactors.SignUpInteractorImp;
import mvp.dagger.yify.yify.ui.view.SignupView;

/**
 * Created by Vardan sharma on 10-04-2015.
 */
public class SignUpPresenterImp implements SignUpPresenter, OnSignUpFinishListner {

    SignUpInteractor signUpInteractor;
    SignupView signupView;

    public SignUpPresenterImp(SignupView signUpView, SignUpInteractor interactor) {
        this.signupView = signUpView;
        this.signUpInteractor = interactor;
    }

    @Override
    public void signUpUser(String username, String pass, String email) {
        signupView.disableRegisterBtn();
        signupView.showLoading();
        if (signUpInteractor.validateFields(username, email, pass, this)) {
            signUpInteractor.registerUser(username, email, pass, this);
        }
    }

    @Override
    public void destroy() {
        signUpInteractor.destroy();
    }

    @Override
    public void onSuccess() {
        signupView.hideLoading();
        signupView.showSignUpSuccessMsg();
        signupView.navigateToLogin();
    }

    @Override
    public void onUserNameError(String msg) {
        signupView.hideLoading();
        signupView.enableRegisterBtn();
        signupView.showUsernameError(msg);
    }

    @Override
    public void onPasswordError(String msg) {
        signupView.hideLoading();
        signupView.enableRegisterBtn();
        signupView.showPasswordError(msg);
    }

    @Override
    public void onUserEmailError(String msg) {
        signupView.hideLoading();
        signupView.enableRegisterBtn();
        signupView.showEmailError(msg);
    }

    @Override
    public void onFailure(String error) {
        signupView.hideLoading();
        signupView.enableRegisterBtn();
        signupView.showSignUpFailureMsg(error);
    }
}
