package mvp.dagger.yify.yify.domain.presenter;

/**
 * Created by vardaan sharma on 1/5/15.
 */
public interface OnUserProfileUpdateFinishListener {
    void onUpdateSuccess();// todo returns some object

    void onUpdateFailure(String error);
}
