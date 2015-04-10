package mvp.dagger.yify.yify;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by krishan on 9/4/15.
 */
@Module
public class BaseAppModule {
    BaseApp baseApp;

    public BaseAppModule(BaseApp baseApp) {
        this.baseApp = baseApp;
    }


    @Provides @Singleton
    public BaseApp provideApplication() {
        return baseApp;
    }
}
