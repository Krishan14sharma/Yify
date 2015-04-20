package mvp.dagger.yify.yify.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import mvp.dagger.yify.yify.domain.interactors.MainInteractor;
import mvp.dagger.yify.yify.domain.interactors.MainInteractorReleasedImpl;
import mvp.dagger.yify.yify.domain.interactors.MainInteractorUpcomingImpl;
import mvp.dagger.yify.yify.domain.presenter.MainPresenter;
import mvp.dagger.yify.yify.domain.presenter.MainPresenterImpl;
import mvp.dagger.yify.yify.model.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.view.MainView;

/**
 * Created by krishan on 10/4/15.
 */
@Module
public class MainModule {

    public MainModule(MainView mainView,MOVIE_TYPE movie_type) {
        this.mainView = mainView;
    }

    MainView mainView;

    MOVIE_TYPE movie_type;
    @Provides
    MainView provideMainView() {
        return mainView;
    }

    /**
     * here main view are dependencies of this method which are also provided by this module
     *
     * @param mainView
     * @param mainInteractor
     * @return
     */
    @Provides
    public MainPresenter provideMainPresenter(MainView mainView, MainInteractor mainInteractor) {
        return new MainPresenterImpl(mainView, mainInteractor);
    }

    @Provides @Named("released")
    public MainInteractor provideMainInteractorReleased() {
        return new MainInteractorReleasedImpl();
    }

    @Provides @Named("upcoming")
    public MainInteractor provideMainInteractorUpcoming() {
        return new MainInteractorUpcomingImpl();
    }

}
