package mvp.dagger.yify.yify.ui.sign_up;

/**
 * Created by Vardan sharma on 10-04-2015.
 */
public interface SignUpInteractor {
    boolean validateFields(String userName, String email, String password);

    void registerUser(String userName, String email, String password);
}
