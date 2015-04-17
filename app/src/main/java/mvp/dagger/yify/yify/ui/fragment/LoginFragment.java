package mvp.dagger.yify.yify.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import mvp.dagger.yify.yify.BaseApp;
import mvp.dagger.yify.yify.BaseAppComponent;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.di.component.DaggerLoginComponent;
import mvp.dagger.yify.yify.di.component.DaggerSignUpComponent;
import mvp.dagger.yify.yify.di.component.LoginComponent;
import mvp.dagger.yify.yify.di.component.SignUpComponent;
import mvp.dagger.yify.yify.di.module.LoginModule;
import mvp.dagger.yify.yify.di.module.MainModule;
import mvp.dagger.yify.yify.di.module.SignUpModule;
import mvp.dagger.yify.yify.domain.presenter.LoginPresenter;
import mvp.dagger.yify.yify.domain.presenter.LoginPresenterImp;
import mvp.dagger.yify.yify.ui.common.BaseFragment;
import mvp.dagger.yify.yify.ui.activity.MainActivity;
import mvp.dagger.yify.yify.ui.view.LoginView;

import static mvp.dagger.yify.yify.util.CommonUtil.showToast;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends BaseFragment implements LoginView {

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this, rootView);
        setPasswordError();
        setUpDagger();
        return rootView;
    }

    private void setUpDagger() {
        BaseAppComponent baseAppComponent = (BaseApp.getContext()).getComponent();
        LoginComponent loginComponent = DaggerLoginComponent.builder()
                .baseAppComponent(baseAppComponent)
                .loginModule(new LoginModule(this))
                .build();
        loginComponent.inject(this);
        presenter = loginComponent.getLoginPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
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