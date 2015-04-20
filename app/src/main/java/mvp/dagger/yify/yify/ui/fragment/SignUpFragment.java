package mvp.dagger.yify.yify.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mvp.dagger.yify.yify.BaseApp;
import mvp.dagger.yify.yify.BaseAppComponent;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.di.component.DaggerSignUpComponent;
import mvp.dagger.yify.yify.di.component.SignUpComponent;
import mvp.dagger.yify.yify.di.module.SignUpModule;
import mvp.dagger.yify.yify.domain.presenter.SignUpPresenter;
import mvp.dagger.yify.yify.ui.activity.LoginActivity;
import mvp.dagger.yify.yify.ui.common.BaseFragment;
import mvp.dagger.yify.yify.ui.view.SignupView;
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

    @Inject
    SignUpPresenter presenter;

    public SignUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.inject(this, rootView);
        setUpDagger();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        presenter = new SignUpPresenterImp(this);//todo remove these with dagger injects
    }

    private void setUpDagger() {
        BaseAppComponent baseAppComponent = (BaseApp.getContext()).getComponent();
        SignUpComponent component =
                DaggerSignUpComponent.builder()
                        .baseAppComponent(baseAppComponent)
                        .signUpModule(new SignUpModule(this))
                        .build();
        component.inject(this);

        presenter = component.getSignUpPresenter();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        presenter.destroy();
    }

    @OnClick(R.id.bt_register)
    public void onRegisterClick() {
        String email = mEtEmail.getText().toString().trim();
        String pass = mEtPassword.getText().toString().trim();
        String userName = mEtUsername.getText().toString().trim();
        presenter.signUpUser(userName, pass, email);
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