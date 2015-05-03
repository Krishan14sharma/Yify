package mvp.dagger.yify.yify.ui.fragment;

import android.app.Fragment;

import mvp.dagger.yify.yify.constants.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.common.BaseMovieListFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThrillerMovieListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThrillerMovieListFragment extends BaseMovieListFragment {

    public ThrillerMovieListFragment() {
        setType(MOVIE_TYPE.THRILLER);
    }

    public static ThrillerMovieListFragment newInstance() {
        ThrillerMovieListFragment fragment = new ThrillerMovieListFragment();
        return fragment;
    }

}
