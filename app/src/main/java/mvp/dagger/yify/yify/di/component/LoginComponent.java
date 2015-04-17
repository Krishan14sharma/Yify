package mvp.dagger.yify.yify.di.component;

import dagger.Component;
import mvp.dagger.yify.yify.BaseAppComponent;
import mvp.dagger.yify.yify.di.module.LoginModule;
import mvp.dagger.yify.yify.di.scope.ActivityScope;
import mvp.dagger.yify.yify.domain.presenter.LoginPresenter;
import mvp.dagger.yify.yify.ui.fragment.LoginFragment;

/**
 * Created by vardaan sharma on 17/4/15.
 */
@ActivityScope
@Component(dependencies = BaseAppComponent.class, modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginFragment fragment);

    LoginPresenter getLoginPresenter();

}
