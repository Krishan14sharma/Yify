package mvp.dagger.yify.yify.ui.fragment;

import android.app.Fragment;

import mvp.dagger.yify.yify.constants.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.common.BaseMovieListFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComedyMovieListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComedyMovieListFragment extends BaseMovieListFragment {
    public ComedyMovieListFragment() {
        setType(MOVIE_TYPE.COMEDY);

    }

    public static ComedyMovieListFragment newInstance() {
        ComedyMovieListFragment fragment = new ComedyMovieListFragment();
        return fragment;
    }

}
