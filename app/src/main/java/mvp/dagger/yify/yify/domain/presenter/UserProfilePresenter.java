package mvp.dagger.yify.yify.domain.presenter;

/**
 * Created by vardaan sharma on 16/4/15.
 */
public interface UserProfilePresenter {
    void getProfileData();

    void onSaveEvent(String action);

    void updateProfileData(String name, String email, String discription);

    void onEditEvent();
}
