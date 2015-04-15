package mvp.dagger.yify.yify.domain.interactors;

/**
 * Created by HP LAPTOP on 10-04-2015.
 */
public interface LoginInteractor {
    boolean validateFields(String username,String pass);
    void loginUser(String username,String pass);
}
