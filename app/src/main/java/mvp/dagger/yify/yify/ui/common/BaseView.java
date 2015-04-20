package mvp.dagger.yify.yify.ui.common;

import retrofit.RetrofitError;

/**
 * Created by krishan on 9/4/15.
 */
public interface BaseView {
    void showLoading();

    void hideLoading();

    void showError(RetrofitError error);

    void onHideError();

}
