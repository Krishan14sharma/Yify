package mvp.dagger.yify.yify.domain.presenter;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public interface OnSignUpFinishListner {
    void onSuccess();

    void onUserNameError(String msg);

    void onPasswordError(String msg);

    void onUserEmailError(String msg);

    void onFailure(String error);
}
