package mvp.dagger.yify.yify.ui.sign_up;

import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import mvp.dagger.yify.yify.BaseApp;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.api.ApiClient;
import mvp.dagger.yify.yify.api.util.CancelableCallback;
import mvp.dagger.yify.yify.model.error.ErrorWrapper;
import mvp.dagger.yify.yify.model.login.login.LoginSuccessWrapper;
import mvp.dagger.yify.yify.model.register.RegisterWrapper;
import mvp.dagger.yify.yify.util.CommonUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static mvp.dagger.yify.yify.util.CommonUtil.isValidEmail;
import static mvp.dagger.yify.yify.util.CommonUtil.showToast;

/**
 * Created by Vardan sharma on 10-04-2015.
 */
public class SignUpInteractorImp implements SignUpInteractor {
    OnSignUpFinishListner onSignUpFinishListner;

    public SignUpInteractorImp(OnSignUpFinishListner onSignUpFinishListner) {
        this.onSignUpFinishListner = onSignUpFinishListner;
    }

    @Override
    public boolean validateFields(String userName, String email, String password) {
        if (TextUtils.isEmpty(userName))
            onSignUpFinishListner.onUserNameError(BaseApp.getContext().getString(R.string.user_name_empty_error));
        else if (TextUtils.isEmpty(email))
            onSignUpFinishListner.onUserEmailError(BaseApp.getContext().getString(R.string.email_empty_error));
        else if (TextUtils.isEmpty(password))
            onSignUpFinishListner.onPasswordError("Password cannot be empty");
        else if (userName.length() < 5)
            onSignUpFinishListner.onUserNameError("Username cannot be less than 5 characters");
        else if (password.length() < 6)
            onSignUpFinishListner.onPasswordError("Password cannot be less than 5 characters");
        else if (!isValidEmail(email))
            onSignUpFinishListner.onUserEmailError("Not a valid email");
        else
            return true;
        return false;
    }

    @Override
    public void registerUser(String userName, String email, String password) {
        ApiClient.getApiClientWithStringConverter().registerUser(userName, email, password,
                CommonUtil.getAppKey(), new CancelableCallback<String>(new Callback<String>() {
                    @Override
                    public void success(String signUpResponse, Response response) {
                        try {
                            JSONObject jsonObject = new JSONObject(signUpResponse);
                            String status = jsonObject.getString("status");
                            if (status.equals("error")) {
                                Gson gson = new Gson();
                                ErrorWrapper errorObj = gson.fromJson(signUpResponse, ErrorWrapper.class);
                                onSignUpFinishListner.onFailure(errorObj.getStatusMessage());
                            } else {
                                // Login successful use diff object to parse data and get the user id
                                RegisterWrapper registerWrapper = new Gson().fromJson(signUpResponse, RegisterWrapper.class);
                                String userKey = registerWrapper.getData().getUserKey();//todo may save perhaps ??
                                onSignUpFinishListner.onSuccess();
                            }
                        } catch (JSONException e) {
                            onSignUpFinishListner.onFailure("Parsing failed");
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //todo use a custom error handler here
                        onSignUpFinishListner.onFailure("Unable to connect");
                    }
                }));
    }
}