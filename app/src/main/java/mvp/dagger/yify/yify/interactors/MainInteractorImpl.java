package mvp.dagger.yify.yify.interactors;

import java.util.HashMap;

import mvp.dagger.yify.yify.api.ApiClient;
import mvp.dagger.yify.yify.model.MovieListWrapper;
import mvp.dagger.yify.yify.ui.home.FinishListner;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by krishan on 9/4/15.
 */
public class MainInteractorImpl implements MainInteractor {

    public MainInteractorImpl(FinishListner listner) {
        this.listner = listner;
    }

    FinishListner listner;


    @Override
    public void fetchData() {
        ApiClient.getYifyApiClient().getMovieList(new HashMap<String, String>(), new Callback<MovieListWrapper>() {
            @Override
            public void success(MovieListWrapper movieListWrapper, Response response) {
                listner.onSuccess(movieListWrapper);
            }

            @Override
            public void failure(RetrofitError error) {
                listner.onFailure(error);
            }
        });
    }


}
