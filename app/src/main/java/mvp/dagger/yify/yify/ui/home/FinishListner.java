package mvp.dagger.yify.yify.ui.home;

import mvp.dagger.yify.yify.model.MovieListWrapper;
import retrofit.RetrofitError;

public interface FinishListner {

        void onSuccess(MovieListWrapper movieListWrapper);
        void onFailure(RetrofitError error);

    }