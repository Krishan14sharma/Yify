package mvp.dagger.yify.yify.ui.home;

import mvp.dagger.yify.yify.interactors.MainInteractor;
import mvp.dagger.yify.yify.interactors.MainInteractorImpl;
import mvp.dagger.yify.yify.model.MovieListWrapper;
import retrofit.RetrofitError;

/**
 * Created by krishan on 9/4/15.
 */
public class MainPresenterImpl implements MainPresenter, FinishListner {

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    MainView mainView;
    MainInteractor mainInteractor;

    @Override
    public void onViewload() {
        mainView.showLoading();
        mainInteractor = new MainInteractorImpl(this);
        mainInteractor.fetchData();
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
