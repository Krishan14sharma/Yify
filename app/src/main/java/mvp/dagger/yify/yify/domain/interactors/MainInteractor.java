package mvp.dagger.yify.yify.domain.interactors;

import mvp.dagger.yify.yify.domain.presenter.FinishListner;

/**
 * Created by krishan on 9/4/15.
 */
public interface MainInteractor {

    void fetchData(FinishListner finishListner);

    void destroy();

}
