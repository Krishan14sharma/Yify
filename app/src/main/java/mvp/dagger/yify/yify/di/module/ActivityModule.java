package mvp.dagger.yify.yify.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import mvp.dagger.yify.yify.di.scope.ActivityScope;

/**
 * Created by krishan on 15/4/15.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return activity;
    }

}
