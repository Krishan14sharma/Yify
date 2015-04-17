 package mvp.dagger.yify.yify.domain.presenter;

import mvp.dagger.yify.yify.domain.interactors.UserProfileInterator;
import mvp.dagger.yify.yify.model.user_profile.UserProfileWrapper;
import mvp.dagger.yify.yify.ui.view.UserProfileView;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public class UserProfilePresenterImp implements UserProfilePresenter, OnFetchProfileDataFinishListener {
    UserProfileInterator interator;
    UserProfileView view;

    public UserProfilePresenterImp(UserProfileInterator interator, UserProfileView view) {
        this.interator = interator;
        this.view = view;
    }

    @Override
    public void getProfileData() {
        view.showLoading();
        interator.getUserProfileData(this);
        view.setFieldsNonEditable();
    }

    @Override
    public void onSaveEvent() {
        view.setFieldsNonEditable();
    }

    @Override
    public void updateProfileData(String name, String email, String discription) {
        view.showLoading();
        interator.updateUserProfileData(name, email, discription, this);
    }

    @Override
    public void onEditEvent() {
        view.setFieldsEditable();
    }

    @Override
    public void onSucess(UserProfileWrapper profileWrapper) {
        view.hideLoading();
        String email = profileWrapper.getData().getEmail();
        String desc = profileWrapper.getData().getAboutText();
        String name = profileWrapper.getData().getUsername();
        String url = profileWrapper.getData().getMediumAvatarImage();
        view.setUserEmail(email);
        view.setUsername(name);
        view.setUserProfile(url);
        view.setProfileDesc(desc);
    }

    @Override
    public void onFailure(String error) {
        view.hideLoading();
        view.showErrorMsg(error);
    }
}
