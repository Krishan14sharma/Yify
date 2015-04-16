package mvp.dagger.yify.yify.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.ui.common.BaseFragment;
import mvp.dagger.yify.yify.ui.view.UserProfileView;
import mvp.dagger.yify.yify.util.CommonUtil;

import static mvp.dagger.yify.yify.util.CommonUtil.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserProfileFragment extends BaseFragment implements UserProfileView {


    @InjectView(R.id.imv_user_image)
    ImageView mImvUserImage;
    @InjectView(R.id.edt_user_name)
    EditText mEdtUserName;
    @InjectView(R.id.edt_user_email)
    EditText mEdtUserEmail;
    @InjectView(R.id.edt_user_desc)
    EditText mEdtUserDesc;

    public UserProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.inject(this, view);
        return view;
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
        Picasso.with(getActivity()).load(url).into(mImvUserImage);
    }

    @Override
    public void setProfileDesc(String desc) {
        mEdtUserDesc.setText(desc);
    }

    @Override
    public void setFieldsEditable() {
        mEdtUserEmail.setEnabled(true);
        mEdtUserName.setEnabled(true);
        mEdtUserDesc.setEnabled(true);
    }

    @Override
    public void setFieldsNonEditable() {
        mEdtUserEmail.setEnabled(false);
        mEdtUserName.setEnabled(false);
        mEdtUserDesc.setEnabled(false);
    }

    @Override
    public void showErrorMsg(String msg) {
        showToast(msg);
    }
}
