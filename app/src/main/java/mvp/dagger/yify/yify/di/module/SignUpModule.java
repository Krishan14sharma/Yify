package mvp.dagger.yify.yify.di.module;

import dagger.Module;
import dagger.Provides;
import mvp.dagger.yify.yify.domain.interactors.SignUpInteractor;
import mvp.dagger.yify.yify.domain.presenter.SignUpPresenter;
import mvp.dagger.yify.yify.domain.presenter.SignUpPresenterImp;
import mvp.dagger.yify.yify.ui.view.SignupView;

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
        return new SignUpPresenterImp(SignUpView) {
        };
    }
//
//    @Provides
//    public SignUpInteractor provideSignUpInteractor() {
//        return new SignUpInteractorImp(provideSignUpPresenter());
//    }
//
//    @Provides
//    public OnSignUpFinishListner onSignUpFinishListner
//
//    {
//        return new OnSignUpFinishListner() {
//            @Override
//            public void onSuccess() {
//
//            }
//
//            @Override
//            public void onUserNameError() {
//
//            }
//
//            @Override
//            public void onPasswordError() {
//
//            }
//
//            @Override
//            public void onUserEmailError() {
//
//            }
//
//            @Override
//            public void onFailure(String error) {
//
//            }
//        };
//    }

}
