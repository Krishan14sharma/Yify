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
public class RomanceMovielistFragment extends BaseMovieListFragment {

    public RomanceMovielistFragment() {
        setType(MOVIE_TYPE.ROMANCE);

    }

    public static RomanceMovielistFragment newInstance() {
        RomanceMovielistFragment fragment = new RomanceMovielistFragment();
        return fragment;
    }


}
