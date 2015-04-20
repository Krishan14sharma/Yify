package mvp.dagger.yify.yify.domain.presenter;

/**
 * Created by krishan on 9/4/15.
 */
public interface MainPresenter {
    /**
     * Fetches the movie data from the server
     *
     * @param pageNum page Num of the movielist to be fetched
     */
    void fetchMovieData(int pageNum);

    void destroy();
}
