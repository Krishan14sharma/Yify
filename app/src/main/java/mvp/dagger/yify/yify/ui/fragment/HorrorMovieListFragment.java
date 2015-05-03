package mvp.dagger.yify.yify.ui.fragment;

import android.app.Fragment;

import mvp.dagger.yify.yify.constants.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.common.BaseMovieListFragment;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HorrorMovieListFragment extends BaseMovieListFragment {
    public HorrorMovieListFragment() {
        setType(MOVIE_TYPE.HORROR);

    }

    public static HorrorMovieListFragment newInstance() {
        HorrorMovieListFragment fragment = new HorrorMovieListFragment();
        return fragment;
    }

}
