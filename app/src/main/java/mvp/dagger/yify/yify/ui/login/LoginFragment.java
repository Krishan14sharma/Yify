package mvp.dagger.yify.yify.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.ui.home.MainActivity;
import retrofit.RetrofitError;

import static mvp.dagger.yify.yify.util.CommonUtil.showToast;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment implements LoginView {

    @InjectView(R.id.et_uname_login)
    EditText mEtUserName;
    @InjectView(R.id.et_pass_login)
    EditText mEtPasswprd;
    @InjectView(R.id.tv_forgot_pass)
    TextView mTvForgotPass;
    @InjectView(R.id.bt_login)
    Button mBtLogin;
    @InjectView(R.id.bt_register_login)
    TextView mBtRegister;

    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    LoginPresenter presenter;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new LoginPresenterImp(this); // todo inject this using Dagger
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    //todo push both the showLoading and hide loading into the base fragment or activity
    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    // todo change this from retrofit error to a string error
    @Override
    public void showError(RetrofitError error) {

    }

    @Override
    public void onHideError() {

    }

    @Override
    public void setUsernameError() {
        mEtUserName.setError("Username not correct");
    }

    @Override
    public void setPasswordError() {
        mEtUserName.setError("Passwors is invalid");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    @Override
    public void showLoginSuccessMsg() {
        showToast("Login success");
    }

    @Override
    public void showLoginFailureMsg(String msg) {
        showToast(msg);
    }

    @Override
    public void disableLoginBtn() {
        mBtLogin.setClickable(false);
    }

    @Override
    public void enableLoginBtn() {
        mBtLogin.setClickable(true);

    }

    @OnClick(R.id.bt_login)
    public void loginClicked() {
        // todo validate fields that too using the method inside presenter
        String email = mEtUserName.getText().toString().trim();
        String pass = mEtPasswprd.getText().toString().trim();
        presenter.loginUser(email, pass);
    }
}