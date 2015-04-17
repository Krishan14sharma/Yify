package mvp.dagger.yify.yify.di.module;

import dagger.Module;
import dagger.Provides;
import mvp.dagger.yify.yify.domain.interactors.LoginInteractor;
import mvp.dagger.yify.yify.domain.interactors.LoginInteractorImp;
import mvp.dagger.yify.yify.domain.presenter.LoginPresenter;
import mvp.dagger.yify.yify.domain.presenter.LoginPresenterImp;
import mvp.dagger.yify.yify.ui.view.LoginView;

/**
 * Created by vardaan sharma on 17/4/15.
 */
@Module
public class LoginModule {

    LoginView LoginView;

    public LoginModule(LoginView loginView) {
        LoginView = loginView;
    }

    @Provides
    LoginView provideLoginView() {
        return LoginView;
    }

    @Provides
    public LoginPresenter provideLoginPresenter(LoginView LoginView, LoginInteractor LoginInteractor) {
        return new LoginPresenterImp(LoginView, LoginInteractor);
    }

    @Provides
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractorImp();
    }
}
