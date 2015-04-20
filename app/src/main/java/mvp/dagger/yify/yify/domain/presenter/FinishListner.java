package mvp.dagger.yify.yify.domain.presenter;

import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;
import retrofit.RetrofitError;

public interface FinishListner {

    void onSuccess(MovieListWrapper movieListWrapper);

    void onFailure(RetrofitError error);

}