package mvp.dagger.yify.yify.ui.fragment;

import mvp.dagger.yify.yify.model.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.common.BaseMovieListFragment;

/**
 */
public class ActionMovieListFragment extends BaseMovieListFragment {

    public ActionMovieListFragment() {
        setType(MOVIE_TYPE.ACTION);
    }

    public static ActionMovieListFragment newInstance() {
        ActionMovieListFragment fragment = new ActionMovieListFragment();
        return fragment;
    }

}
