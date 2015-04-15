package mvp.dagger.yify.yify.di.component;

import dagger.Component;
import mvp.dagger.yify.yify.BaseAppComponent;
import mvp.dagger.yify.yify.di.scope.ActivityScope;
import mvp.dagger.yify.yify.di.module.MainModule;
import mvp.dagger.yify.yify.ui.activity.MainActivity;
import mvp.dagger.yify.yify.domain.presenter.MainPresenter;

/**
 * Created by krishan on 10/4/15.
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = BaseAppComponent.class)
public interface MainComponent {

    void inject(MainActivity.PlaceholderFragment fragment);

    MainPresenter getMainPresenter(); // Exposing the methods providing injections
}
