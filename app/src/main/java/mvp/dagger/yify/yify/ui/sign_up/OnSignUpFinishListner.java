package mvp.dagger.yify.yify.ui.sign_up;

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
