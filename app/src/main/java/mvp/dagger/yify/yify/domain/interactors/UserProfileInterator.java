package mvp.dagger.yify.yify.domain.interactors;

import java.io.File;

import mvp.dagger.yify.yify.domain.presenter.OnFetchProfileDataFinishListener;
import mvp.dagger.yify.yify.domain.presenter.OnUserProfileUpdateFinishListener;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public interface UserProfileInterator {
    void getUserProfileData(OnFetchProfileDataFinishListener listener);

    void updateUserProfileData(String desc, File userImageFile, OnUserProfileUpdateFinishListener listener);

    void destroy();

}
