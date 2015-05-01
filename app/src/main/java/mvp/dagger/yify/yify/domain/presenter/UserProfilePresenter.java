package mvp.dagger.yify.yify.domain.presenter;

import java.io.File;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public interface UserProfilePresenter {
    void getProfileData();

    void onSaveEvent();

    void updateProfileData(String abtMeTxts, File userImage);

    void onEditEvent();

    void onUserImageEvent();

    void destroy();
}
