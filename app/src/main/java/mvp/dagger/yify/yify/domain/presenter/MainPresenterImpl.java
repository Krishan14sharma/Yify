package mvp.dagger.yify.yify.domain.presenter;

import mvp.dagger.yify.yify.domain.interactors.MainInteractor;
import mvp.dagger.yify.yify.model.MovieListWrapper;
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
    public void onViewload() {
        mainView.showLoading();
        mainInteractor.fetchData(this);
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
    public void onFailure(RetrofitError error) {
        mainView.hideLoading();
        mainView.showError(error);
    }
}
