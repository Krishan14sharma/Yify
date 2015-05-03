package mvp.dagger.yify.yify.domain.presenter;

import android.support.annotation.Nullable;

import mvp.dagger.yify.yify.domain.interactors.FetchMovieListInteractor;
import mvp.dagger.yify.yify.constants.MOVIE_TYPE;
import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;
import mvp.dagger.yify.yify.ui.view.MainView;
import retrofit.RetrofitError;

/**
 * Created by krishan on 9/4/15.
 */
public class MainPresenterImpl implements MainPresenter, FinishListner {
    public static final int INTIAL_PAGE_NUM = 1;
    private int mPageNum = INTIAL_PAGE_NUM;
    private MOVIE_TYPE mMovieType = MOVIE_TYPE.ALL;

    public MainPresenterImpl(MainView mainView, FetchMovieListInteractor fetchMovieListInteractor) {
        this.mainView = mainView;
        this.fetchMovieListInteractor = fetchMovieListInteractor;
    }

    MainView mainView;
    FetchMovieListInteractor fetchMovieListInteractor;

    @Override
    public void fetchMoreData() {
        mPageNum++;
        mainView.showLazyLoading();
        fetchMovieListInteractor.fetchData(mPageNum, mMovieType, this);
    }

    @Override
    public void fetchInitialData(MOVIE_TYPE type) {
        mainView.showLoading();
        mMovieType = type;
        fetchMovieListInteractor.fetchData(INTIAL_PAGE_NUM, mMovieType, this);// todo add requestMap instead of these params
    }

    @Override
    public void destroy() {
        fetchMovieListInteractor.destroy();
    }


    @Override
    public void onSuccess(MovieListWrapper movieListWrapper) {
        mainView.hideLoading();
        mainView.hideLazyLoading();
        mainView.showData(movieListWrapper);
    }

    @Override
    public void onFailure(@Nullable RetrofitError error) {
        if (error != null) error.printStackTrace();
        mainView.hideLoading();
        mainView.hideLazyLoading();
        mainView.showError(error);
    }
}
