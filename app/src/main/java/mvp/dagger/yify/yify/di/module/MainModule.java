package mvp.dagger.yify.yify.di.module;

import dagger.Module;
import dagger.Provides;
import mvp.dagger.yify.yify.domain.interactors.FetchMovieListInteractor;
import mvp.dagger.yify.yify.domain.interactors.FetchMovieListInteractorImpl;
import mvp.dagger.yify.yify.domain.presenter.MainPresenter;
import mvp.dagger.yify.yify.domain.presenter.MainPresenterImpl;
import mvp.dagger.yify.yify.model.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.view.MainView;

/**
 * Created by krishan on 10/4/15.
 */
@Module
public class MainModule {

    public MainModule(MainView mainView, MOVIE_TYPE movie_type) {
        this.mainView = mainView;
    }

    MainView mainView;

    @Provides
    MainView provideMainView() {
        return mainView;
    }

    /**
     * here main view are dependencies of this method which are also provided by this module
     *
     * @param mainView
     * @param fetchMovieListInteractor
     * @return
     */
    @Provides
    public MainPresenter provideMainPresenter(MainView mainView, FetchMovieListInteractor fetchMovieListInteractor) {
        return new MainPresenterImpl(mainView, fetchMovieListInteractor);
    }


    @Provides
    public FetchMovieListInteractor provideMainInteractorReleased() {
        return new FetchMovieListInteractorImpl();
    }
//todo there is some problem in the
//    @Provides @Named("upcoming")
//    public MainInteractor provideMainInteractorUpcoming() {
//        return new MainInteractorUpcomingImpl();
//    }


}
