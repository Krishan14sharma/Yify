package mvp.dagger.yify.yify.di.component;

import dagger.Component;
import mvp.dagger.yify.yify.BaseAppComponent;
import mvp.dagger.yify.yify.di.module.SignUpModule;
import mvp.dagger.yify.yify.di.scope.ActivityScope;
import mvp.dagger.yify.yify.domain.presenter.SignUpPresenter;
import mvp.dagger.yify.yify.ui.fragment.SignUpFragment;

/**
 * Created by vardaan sharma on 16/4/15.
 */

@ActivityScope
@Component(modules = SignUpModule.class, dependencies = BaseAppComponent.class)
public interface SignUpComponent {
    void inject(SignUpFragment fragment);

    SignUpPresenter getSignUpPresenter(); // Exposing the methods providing injections
}
