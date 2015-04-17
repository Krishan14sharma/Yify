package mvp.dagger.yify.yify.di.component;

import android.app.Activity;

import dagger.Component;
import mvp.dagger.yify.yify.BaseAppComponent;
import mvp.dagger.yify.yify.di.module.ActivityModule;
import mvp.dagger.yify.yify.di.scope.ActivityScope;

/**
 * Created by krishan on 15/4/15.
 */
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = BaseAppComponent.class)
public interface ActivityComponent {
    Activity getActivity();
}
