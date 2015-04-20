package mvp.dagger.yify.yify.domain.interactors;

import mvp.dagger.yify.yify.domain.presenter.OnLoginFinishListner;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public interface LoginInteractor {
    boolean validateFields(String username, String pass, OnLoginFinishListner listner);

    void loginUser(String username, String pass, OnLoginFinishListner listner);

    void destroy();
}
