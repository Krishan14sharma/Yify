package mvp.dagger.yify.yify.domain.presenter;

import java.io.File;

import mvp.dagger.yify.yify.domain.interactors.UserProfileInterator;
import mvp.dagger.yify.yify.model.user_profile.UserProfileWrapper;
import mvp.dagger.yify.yify.ui.view.UserProfileView;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public class UserProfilePresenterImp implements UserProfilePresenter, OnFetchProfileDataFinishListener, OnUserProfileUpdateFinishListener {
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
        view.toggleSaveOrEdit();
    }

    @Override
    public void updateProfileData(String abtMeTxt, File userImageFile) {
        view.showLoading();
        interator.updateUserProfileData(abtMeTxt, userImageFile, this);
    }

    @Override
    public void onEditEvent() {
        view.setFieldsEditable();
        view.toggleSaveOrEdit();
    }

    @Override
    public void onUserImageEvent() {
        view.showImagePicker();
    }

    @Override
    public void destroy() {
        interator.destroy();
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
        view.setFieldsNonEditable();
    }

    @Override
    public void onFailure(String error) {
        view.hideLoading();
        view.showErrorMsg(error);
    }

    @Override
    public void onUpdateSuccess() {
        view.hideLoading();
    }

    @Override
    public void onUpdateFailure(String error) {
        view.hideLoading();
        view.showErrorMsg(error);
    }
}
