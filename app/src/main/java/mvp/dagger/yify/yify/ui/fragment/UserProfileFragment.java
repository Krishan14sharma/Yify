package mvp.dagger.yify.yify.ui.fragment;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
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
        mEdtUserDesc.setInputType(InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE);
        mImgUserImageEdit.setVisibility(View.VISIBLE);
    }

    @Override
    public void setFieldsNonEditable() {
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
