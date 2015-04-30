package mvp.dagger.yify.yify.domain.interactors;

import mvp.dagger.yify.yify.domain.presenter.FinishListner;
import mvp.dagger.yify.yify.model.MOVIE_TYPE;

/**
 * Created by krishan on 9/4/15.
 */
public interface FetchMovieListInteractor {

    void fetchData(int pageNum, MOVIE_TYPE mMovieType, FinishListner finishListner);

    void destroy();

}
