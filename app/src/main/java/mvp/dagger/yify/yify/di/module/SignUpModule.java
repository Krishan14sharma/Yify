package mvp.dagger.yify.yify.di.module;

import dagger.Module;
import dagger.Provides;
import mvp.dagger.yify.yify.domain.interactors.SignUpInteractor;
import mvp.dagger.yify.yify.domain.interactors.SignUpInteractorImp;
import mvp.dagger.yify.yify.domain.presenter.OnSignUpFinishListner;
import mvp.dagger.yify.yify.domain.presenter.SignUpPresenter;
import mvp.dagger.yify.yify.domain.presenter.SignUpPresenterImp;
import mvp.dagger.yify.yify.ui.view.SignupView;

/**
 * Created by krishan on 10/4/15.
 */
@Module
public class SignUpModule {
    SignupView signupView;

    public SignUpModule(SignupView signupView) {
        this.signupView = signupView;
    }


    @Provides
    SignupView provideSignUpView() {
        return signupView;
    }

    @Provides
    public SignUpInteractor provideSignUpInteractor() {
        return new SignUpInteractorImp();
    }

    @Provides
    public SignUpPresenter provideSignUpPresenter(SignupView SignUpView, SignUpInteractor SignUpInteractor) {
        return new SignUpPresenterImp(SignUpView, SignUpInteractor);
    }
}