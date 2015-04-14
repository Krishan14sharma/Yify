package mvp.dagger.yify.yify.ui.home;

import dagger.Component;
import mvp.dagger.yify.yify.BaseAppComponent;
import mvp.dagger.yify.yify.ui.common.ActivityScope;

/**
 * Created by krishan on 10/4/15.
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = BaseAppComponent.class)
public interface MainComponent {

    void inject(MainActivity.PlaceholderFragment fragment);

    MainPresenter getMainPresenter(); // Exposing the methods providing injections
}
