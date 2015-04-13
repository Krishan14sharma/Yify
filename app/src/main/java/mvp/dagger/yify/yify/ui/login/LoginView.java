package mvp.dagger.yify.yify.ui.login;

import mvp.dagger.yify.yify.ui.common.BaseView;

/**
 * Created by HP LAPTOP on 09-04-2015.
 */
public interface LoginView extends BaseView {
    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void showLoginSuccessMsg();

    void showLoginFailureMsg(String msg);

    void disableLoginBtn();

    void enableLoginBtn();
}
