package mvp.dagger.yify.yify.ui.view;

import mvp.dagger.yify.yify.ui.common.BaseView;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public interface UserProfileView extends BaseView {
    void setUsername(String name);

    void setUserEmail(String email);

    void setUserProfile(String url);

    void setProfileDesc(String desc);

    void setFieldsEditable();

    void hideEditBtn();

    void hideSaveBtn();

    void showEditBtn();

    void showSaveBtn();

    void toggleSaveOrEdit();

    void setFieldsNonEditable();

    void showErrorMsg(String msg);

    void showImagePicker();
}
