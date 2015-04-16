package mvp.dagger.yify.yify.ui.common;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.ui.common.BaseView;
import retrofit.RetrofitError;

import static mvp.dagger.yify.yify.util.CommonUtil.showToast;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements BaseView {

    //    @InjectView(R.id.progressBar)
    ProgressDialog dialog;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(getActivity());
        setUpDialog();
    }

    private void setUpDialog() {
        dialog = new ProgressDialog(getActivity());
        dialog.setIndeterminate(false);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
    }

    //todo push both the showLoading and hide loading into the base fragment or activity
    @Override
    public void showLoading() {
        dialog.show();
    }


    @Override
    public void hideLoading() {
        dialog.dismiss();
    }


    @Override
    public void showError(RetrofitError error) {
        showToast(error.getMessage());
    }

    @Override
    public void onHideError() {
        //todo what to do here??
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dialog != null) {
            dialog.cancel();
            dialog = null;
        }
    }
}
