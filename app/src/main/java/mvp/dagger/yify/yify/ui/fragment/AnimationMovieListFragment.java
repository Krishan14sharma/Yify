package mvp.dagger.yify.yify.ui.fragment;

import android.app.Fragment;

import mvp.dagger.yify.yify.constants.MOVIE_TYPE;
import mvp.dagger.yify.yify.ui.common.BaseMovieListFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AnimationMovieListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimationMovieListFragment extends BaseMovieListFragment {
    public AnimationMovieListFragment() {
        setType(MOVIE_TYPE.ANIMATION);

    }

    public static AnimationMovieListFragment newInstance() {
        AnimationMovieListFragment fragment = new AnimationMovieListFragment();
        return fragment;
    }


}
