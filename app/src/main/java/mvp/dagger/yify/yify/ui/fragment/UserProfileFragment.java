package mvp.dagger.yify.yify.ui.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.domain.interactors.UserProfileInteractorImp;
import mvp.dagger.yify.yify.domain.presenter.UserProfilePresenter;
import mvp.dagger.yify.yify.domain.presenter.UserProfilePresenterImp;
import mvp.dagger.yify.yify.ui.common.BaseFragment;
import mvp.dagger.yify.yify.ui.view.UserProfileView;

import static mvp.dagger.yify.yify.util.CommonUtil.showToast;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserProfileFragment extends BaseFragment implements UserProfileView {

    UserProfilePresenter presenter;
    @InjectView(R.id.imv_user_image)
    ImageView mImvUserImage;
    @InjectView(R.id.edt_user_name)
    EditText mEdtUserName;
    @InjectView(R.id.edt_user_email)
    EditText mEdtUserEmail;
    @InjectView(R.id.edt_user_desc)
    EditText mEdtUserDesc;
    @InjectView(R.id.img_user_image_edit)
    ImageView mImgUserImageEdit;
    @InjectView(R.id.bt_edit)
    Button mBtEdit;
    @InjectView(R.id.bt_save)
    Button mBtSave;

    public UserProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.inject(this, view);
        presenter = new UserProfilePresenterImp(new UserProfileInteractorImp(), this); // todo remove this with dagger
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getProfileData();

    }

    @OnClick(R.id.bt_save)
    public void onSaveBtnClicked() {
        presenter.onSaveEvent();
        String email = mEdtUserEmail.getText().toString().trim();
        String name = mEdtUserName.getText().toString().trim();
        String desc = mEdtUserDesc.getText().toString().trim();
        presenter.updateProfileData(name, email, desc);
    }


    @OnClick(R.id.bt_edit)
    public void onEditBtnClicked() {
        presenter.onEditEvent();
    }

    @Override

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void setUsername(String name) {
        mEdtUserName.setText(name);
    }

    @Override
    public void setUserEmail(String email) {
        mEdtUserEmail.setText(email);
    }

    @Override
    public void setUserProfile(String url) {
        Picasso.with(getActivity())
                .load(url)
//                .transform(new CircleTransform()).
                .into(mImvUserImage);
    }

    @Override
    public void setProfileDesc(String desc) {
        mEdtUserDesc.setText(desc);
    }

    @Override
    public void setFieldsEditable() {
        mEdtUserEmail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        mEdtUserName.setInputType(InputType.TYPE_CLASS_TEXT);
//        mEdtUserDesc.setInputType(InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE);
        mImgUserImageEdit.setVisibility(View.VISIBLE);
//        mEdtUserEmail.setBackgroundResource(R.drawable.bg_edittext);
//        mEdtUserName.setBackgroundResource(R.drawable.bg_edittext);
//        mEdtUserDesc.setBackgroundResource(R.drawable.bg_edittext);

    }

    @Override
    public void hideEditBtn() {
        mBtEdit.setVisibility(View.GONE);
    }

    @Override
    public void hideSaveBtn() {
        mBtSave.setVisibility(View.GONE);

    }

    @Override
    public void showEditBtn() {
        mBtEdit.setVisibility(View.VISIBLE);

    }

    @Override
    public void showSaveBtn() {
        mBtSave.setVisibility(View.VISIBLE);

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void setFieldsNonEditable() {
//        mEdtUserEmail.setBackground(null);
//        mEdtUserName.setBackground(null);
//        mEdtUserDesc.setBackground(null);

        mEdtUserEmail.setInputType(InputType.TYPE_NULL);
        mEdtUserName.setInputType(InputType.TYPE_NULL);
        mEdtUserDesc.setInputType(InputType.TYPE_NULL);
        mImgUserImageEdit.setVisibility(View.GONE);

    }

    @Override
    public void showErrorMsg(String msg) {
        showToast(msg);
    }
}
