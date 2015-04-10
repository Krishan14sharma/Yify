package mvp.dagger.yify.yify.interactors;

import mvp.dagger.yify.yify.ui.home.FinishListner;

/**
 * Created by krishan on 9/4/15.
 */
public interface MainInteractor {

    void fetchData(FinishListner finishListner);
    void destroy();
    
}
