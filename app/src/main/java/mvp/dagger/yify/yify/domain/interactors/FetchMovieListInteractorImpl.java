package mvp.dagger.yify.yify.domain.interactors;

import java.util.HashMap;

import mvp.dagger.yify.yify.api.ApiClient;
import mvp.dagger.yify.yify.api.util.CancelableCallback;
import mvp.dagger.yify.yify.domain.presenter.FinishListner;
import mvp.dagger.yify.yify.model.MOVIE_TYPE;
import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by krishan on 9/4/15.
 */
public class FetchMovieListInteractorImpl implements FetchMovieListInteractor {


    CancelableCallback<MovieListWrapper> callback;


    @Override
    public void fetchData(int pageNum, MOVIE_TYPE mMovieType, final FinishListner listner) {
        HashMap<String, String> requestMap = new HashMap<>();
        requestMap.put("page", String.valueOf(pageNum));
        String movieType = null;
        switch (mMovieType) {
            case ALL:
                movieType = null;
                break;
            case ACTION:
                movieType = "Action";
                break;
            case ADVENTURE:
                movieType = "Adventure";
                break;
            case ANIMATION:
                movieType = "Animation";
                break;
            case COMEDY:
                movieType = "Comedy";
                break;
            case HORROR:
                movieType = "Horror";
                break;
            case ROMANCE:
                movieType = "Romance";
                break;
            case SCI_FI:
                movieType = "Sci-fi";
                break;
            case THRILLER:
                movieType = "Thriller";
                break;
        }
        if (mMovieType != null)
            requestMap.put("genre", movieType);
        ApiClient.getApiClient().getMovieList(requestMap, callback = new CancelableCallback<>(new Callback<MovieListWrapper>() {
            @Override
            public void success(MovieListWrapper movieListWrapper, Response response) {
                listner.onSuccess(movieListWrapper);
            }

            @Override
            public void failure(RetrofitError error) {
                listner.onFailure(error);
            }
        }));
    }

    @Override
    public void destroy() {
        if (callback != null) {
            callback.cancel();
            callback = null;
        }
    }
}
