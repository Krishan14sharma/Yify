package mvp.dagger.yify.yify.domain.interactors;

import com.google.gson.Gson;

import mvp.dagger.yify.yify.domain.presenter.FinishListner;
import mvp.dagger.yify.yify.model.MOVIE_TYPE;
import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;

import static mvp.dagger.yify.yify.util.CommonUtil.loadJSONFromAsset;

/**
 * Created by krishan on 9/4/15.
 */
public class MockMovieListInteractorImpl implements FetchMovieListInteractor {

//    @Override
//    public void fetchData(int pageNum, FinishListner listner) {
//
//    }

    @Override
    public void fetchData(int pageNum, MOVIE_TYPE mMovieType, FinishListner finishListner) {
        String str = loadJSONFromAsset("movielist.json");
        finishListner.onSuccess(new Gson().fromJson(str, MovieListWrapper.class));
    }

    @Override
    public void destroy() {

    }
}
