package mvp.dagger.yify.yify.ui.sign_up;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.ui.BaseFragment;
import mvp.dagger.yify.yify.ui.login.LoginActivity;
import mvp.dagger.yify.yify.views.QuickEditText;

import static mvp.dagger.yify.yify.util.CommonUtil.showToast;

/**
 * todo add a discripyion too tired ryt now :P.
 */
public class SignUpFragment extends BaseFragment implements SignupView {

    @InjectView(R.id.et_uname_reg)
    QuickEditText mEtUsername;
    @InjectView(R.id.et_email_reg)
    QuickEditText mEtEmail;
    @InjectView(R.id.et_pass_reg)
    QuickEditText mEtPassword;
    @InjectView(R.id.bt_register)
    Button mBtRegister;
    @InjectView(R.id.container_register)
    ScrollView mContainerRegister;
    @InjectView(R.id.progressBar)
    ProgressBar mProgressBar;

    SignUpPresenter presenter;

    public SignUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void showUsernameError(String msg) {
        mEtUsername.setError(msg);
    }

    @Override
    public void showPasswordError(String msg) {
        mEtPassword.setError(msg);
    }

    @Override
    public void showEmailError(String msg) {
        mEtEmail.setError(msg);
    }

    @Override
    public void disableRegisterBtn() {
        mBtRegister.setClickable(false);
    }

    @Override
    public void enableRegisterBtn() {
        mBtRegister.setClickable(true);
    }

    @Override
    public void showSignUpSuccessMsg() {
        showToast(R.string.register_success_msg);
    }

    @Override
    public void showSignUpFailureMsg(String msg) {
        showToast(msg);
    }

    @Override
    public void navigateToLogin() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

}