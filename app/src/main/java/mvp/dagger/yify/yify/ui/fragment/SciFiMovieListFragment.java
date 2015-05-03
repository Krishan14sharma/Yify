package mvp.dagger.yify.yify.ui.fragment;

import android.app.Fragment;

import mvp.dagger.yify.yify.constants.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.common.BaseMovieListFragment;

/**
 * A simple {@link Fragment} subclass.
 * <p/>
 * Use the {@link SciFiMovieListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SciFiMovieListFragment extends BaseMovieListFragment {
    public SciFiMovieListFragment() {
        setType(MOVIE_TYPE.SCI_FI);

    }

    public static SciFiMovieListFragment newInstance() {
        SciFiMovieListFragment fragment = new SciFiMovieListFragment();
        return fragment;
    }


}
