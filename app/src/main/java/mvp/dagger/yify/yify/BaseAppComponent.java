package mvp.dagger.yify.yify;


import dagger.Component;

/**
 * Created by krishan on 9/4/15.
 */

@Component(modules = BaseAppModule.class)
public interface BaseAppComponent {

    void inject(BaseApp app);

}