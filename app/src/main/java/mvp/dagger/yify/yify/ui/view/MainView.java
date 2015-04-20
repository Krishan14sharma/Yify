package mvp.dagger.yify.yify.ui.view;

import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;
import mvp.dagger.yify.yify.ui.common.BaseView;

/**
 * Created by krishan on 9/4/15.
 */
public interface MainView extends BaseView {
    void showData(MovieListWrapper movieListWrapper);
}
