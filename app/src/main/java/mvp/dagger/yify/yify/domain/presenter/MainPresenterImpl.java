package mvp.dagger.yify.yify.domain.presenter;

import android.support.annotation.Nullable;

import mvp.dagger.yify.yify.domain.interactors.MainInteractor;
import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;
import mvp.dagger.yify.yify.ui.view.MainView;
import retrofit.RetrofitError;

/**
 * Created by krishan on 9/4/15.
 */
public class MainPresenterImpl implements MainPresenter, FinishListner {

    public MainPresenterImpl(MainView mainView, MainInteractor mainInteractor) {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }

    MainView mainView;
    MainInteractor mainInteractor;

    @Override
    public void fetchMovieData(int pageNum) {
        mainView.showLoading();
        mainInteractor.fetchData(pageNum, this);
    }

    @Override
    public void destroy() {
        mainInteractor.destroy();
    }


    @Override
    public void onSuccess(MovieListWrapper movieListWrapper) {
        mainView.hideLoading();
        mainView.showData(movieListWrapper);
    }

    @Override
    public void onFailure(@Nullable RetrofitError error) {
        if (error != null) error.printStackTrace();
        mainView.hideLoading();
        mainView.showError(error);
    }
}
