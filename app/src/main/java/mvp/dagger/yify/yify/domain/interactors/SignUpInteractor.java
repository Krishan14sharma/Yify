package mvp.dagger.yify.yify.domain.interactors;

import mvp.dagger.yify.yify.domain.presenter.OnSignUpFinishListner;

/**
 * Created by Vardan sharma on 10-04-2015.
 */
public interface SignUpInteractor {
    boolean validateFields(String userName, String email, String password, OnSignUpFinishListner onSignUpFinishListner);

    void registerUser(String userName, String email, String password, OnSignUpFinishListner onSignUpFinishListner);
    void destroy();

}
