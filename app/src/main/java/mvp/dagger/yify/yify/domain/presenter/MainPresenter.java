package mvp.dagger.yify.yify.domain.presenter;

import mvp.dagger.yify.yify.constants.MOVIE_TYPE;

/**
 * Created by krishan on 9/4/15.
 */
public interface MainPresenter {
    /**
     * Fetches the movie data from the server
     */

    void fetchMoreData();

    void fetchInitialData(MOVIE_TYPE type);

    void destroy();


}
