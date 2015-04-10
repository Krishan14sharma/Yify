package mvp.dagger.yify.yify.ui.sign_up;

import dagger.Module;
import dagger.Provides;

/**
 * Created by krishan on 10/4/15.
 */
@Module
public class SignUpModule {

    public SignUpModule(SignupView signupView) {
        this.signupView = signupView;
    }

    SignupView signupView;

    @Provides
    SignupView provideSignUpView() {
        return signupView;
    }

    @Provides
    public SignUpPresenter provideSignUpPresenter(SignupView SignUpView, SignUpInteractor SignUpInteractor) {
        return new SignUpPresenterImp(SignUpView, SignUpInteractor) {
        };
    }

    @Provides
    public SignUpInteractor provideSignUpInteractor() {
        return new SignUpInteractorImp();
    }


}