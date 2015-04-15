package mvp.dagger.yify.yify.ui.view;

import mvp.dagger.yify.yify.ui.common.BaseView;

/**
 * Created by vardan sharma on 10-04-2015.
 */
public interface SignupView extends BaseView {
    void showUsernameError(String msg);

    void showPasswordError(String msg);

    void showEmailError(String msg);

    void disableRegisterBtn();

    void enableRegisterBtn();

    void showSignUpSuccessMsg();

    void showSignUpFailureMsg(String msg);

    void navigateToLogin();
}
