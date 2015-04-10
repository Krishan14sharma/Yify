package mvp.dagger.yify.yify.ui.login;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public interface LoginPresenter extends OnLoginFinishListner {
    public void loginUser(String email, String pass);
}
