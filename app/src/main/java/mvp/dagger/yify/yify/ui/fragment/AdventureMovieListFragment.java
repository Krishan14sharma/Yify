package mvp.dagger.yify.yify.ui.fragment;

import android.app.Fragment;

import mvp.dagger.yify.yify.constants.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.common.BaseMovieListFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class AdventureMovieListFragment extends BaseMovieListFragment {
    public AdventureMovieListFragment() {
        setType(MOVIE_TYPE.ADVENTURE);

    }

    public static AdventureMovieListFragment newInstance() {
        AdventureMovieListFragment fragment = new AdventureMovieListFragment();
        return fragment;
    }

}
