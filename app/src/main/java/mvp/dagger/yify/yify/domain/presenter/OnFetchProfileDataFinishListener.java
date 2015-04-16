package mvp.dagger.yify.yify.domain.presenter;

import mvp.dagger.yify.yify.model.user_profile.UserProfileWrapper;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public interface OnFetchProfileDataFinishListener {
    void onSucess(UserProfileWrapper profileWrapper);

    void onFailure(String error);
}
