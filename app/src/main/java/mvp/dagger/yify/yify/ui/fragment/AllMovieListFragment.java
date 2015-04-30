package mvp.dagger.yify.yify.ui.fragment;

import android.app.Fragment;

import mvp.dagger.yify.yify.model.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.common.BaseMovieListFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class AllMovieListFragment extends BaseMovieListFragment {
    public AllMovieListFragment() {
        setType(MOVIE_TYPE.ALL);
    }

    public static AllMovieListFragment newInstance() {
        AllMovieListFragment fragment = new AllMovieListFragment();
        return fragment;
    }

}
