package mvp.dagger.yify.yify.domain.interactors;

import mvp.dagger.yify.yify.domain.presenter.FinishListner;
import mvp.dagger.yify.yify.constants.MOVIE_TYPE;

/**
 * Created by krishan on 20/4/15.
 */
public class MainInteractorUpcomingImpl implements FetchMovieListInteractor {

    @Override
    public void fetchData(int pageNum, MOVIE_TYPE mMovieType, FinishListner finishListner) {

    }

    @Override
    public void destroy() {

    }
}
