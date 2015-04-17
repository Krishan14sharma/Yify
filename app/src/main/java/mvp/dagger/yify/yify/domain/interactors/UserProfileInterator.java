package mvp.dagger.yify.yify.domain.interactors;

import mvp.dagger.yify.yify.domain.presenter.OnFetchProfileDataFinishListener;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public interface UserProfileInterator {
    void getUserProfileData(OnFetchProfileDataFinishListener listener);

    void updateUserProfileData(String name, String email, String desc, OnFetchProfileDataFinishListener listenerInter);
}
