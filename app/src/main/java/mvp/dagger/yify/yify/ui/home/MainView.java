package mvp.dagger.yify.yify.ui.home;

import mvp.dagger.yify.yify.model.MovieListWrapper;
import mvp.dagger.yify.yify.ui.common.BaseView;

/**
 * Created by krishan on 9/4/15.
 */
public interface MainView extends BaseView{
    void showData(MovieListWrapper movieListWrapper);
}
