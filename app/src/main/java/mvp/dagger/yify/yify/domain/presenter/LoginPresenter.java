package mvp.dagger.yify.yify.domain.presenter;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public interface LoginPresenter extends OnLoginFinishListner {
    void loginUser(String email, String pass);

    void destroy();
}
