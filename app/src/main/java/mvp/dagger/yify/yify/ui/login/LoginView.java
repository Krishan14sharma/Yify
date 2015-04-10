package mvp.dagger.yify.yify.ui.login;

import mvp.dagger.yify.yify.ui.common.BaseView;

/**
 * Created by HP LAPTOP on 09-04-2015.
 */
public interface LoginView extends BaseView {
    public void setUsernameError();

    public void setPasswordError();

    public void navigateToHome();

    public void showLoginSuccessMsg();

    //todo public void show showLoginFailureMsg();
}
