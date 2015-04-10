package mvp.dagger.yify.yify.ui.home;

import dagger.Module;
import dagger.Provides;
import mvp.dagger.yify.yify.interactors.MainInteractor;
import mvp.dagger.yify.yify.interactors.MainInteractorImpl;

/**
 * Created by krishan on 10/4/15.
 */
@Module
public class MainModule {

    public MainModule(MainView mainView) {
        this.mainView = mainView;
    }

    MainView mainView;

    @Provides
    MainView provideMainView() {
        return mainView;
    }

    @Provides
    public MainPresenter provideMainPresenter(MainView mainView,MainInteractor mainInteractor) {
        return new MainPresenterImpl(mainView,mainInteractor);
    }

    @Provides
    public MainInteractor provideMainInteractor(){
        return new MainInteractorImpl();
    }


}
