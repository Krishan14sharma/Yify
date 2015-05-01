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

import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.bus.BusProvider;
import mvp.dagger.yify.yify.bus.ImageRecievedEvent;
import mvp.dagger.yify.yify.bus.OpenImagePickerEvent;
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
    private File imageFile;

    public UserProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.inject(this, view);
        presenter = new UserProfilePresenterImp(new UserProfileInteractorImp(), this); // todo remove this with dagger
        BusProvider.getInstance().register(this);
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
        String desc = mEdtUserDesc.getText().toString().trim();
        presenter.updateProfileData(desc, imageFile);
    }


    @OnClick(R.id.bt_edit)
    public void onEditBtnClicked() {
        presenter.onEditEvent();
    }

    @OnClick(R.id.img_user_image_edit)
    public void onUserImageClicked() {
        presenter.onUserImageEvent();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        presenter.destroy();
        BusProvider.getInstance().unregister(this);
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
        Picasso.with(getActivity()).load(url).into(mImvUserImage);
    }

    @Override
    public void setProfileDesc(String desc) {
        mEdtUserDesc.setText(desc);
    }


    @Override
    public void setFieldsEditable() {
        mEdtUserDesc.setInputType(InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE);
        mImgUserImageEdit.setVisibility(View.VISIBLE);
        mEdtUserDesc.setBackgroundResource(R.drawable.bg_edittext);

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

    @Override
    public void toggleSaveOrEdit() {
        if (mBtEdit.getVisibility() == View.VISIBLE) {
            mBtSave.setVisibility(View.VISIBLE);
            mBtEdit.setVisibility(View.GONE);
        } else {
            mBtEdit.setVisibility(View.VISIBLE);
            mBtSave.setVisibility(View.GONE);
        }
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void setFieldsNonEditable() {
        mEdtUserDesc.setBackground(null);
        mEdtUserDesc.setInputType(InputType.TYPE_NULL);
        mImgUserImageEdit.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMsg(String msg) {
        showToast(msg);
    }

    @Override
    public void showImagePicker() {
        BusProvider.getInstance().post(new OpenImagePickerEvent());
    }

    @Subscribe
    public void onImageRecieved(ImageRecievedEvent event) {
        mImvUserImage.setImageBitmap(event.getBitmap());
        imageFile = event.getFile();
    }
}
