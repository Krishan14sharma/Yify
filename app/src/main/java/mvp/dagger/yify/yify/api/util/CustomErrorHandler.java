package mvp.dagger.yify.yify.api.util;




import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.ui.common.BaseApp;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * This handles most common network related errors.Throws them if unknown.
 */
public class CustomErrorHandler implements ErrorHandler {

    @Override
    public Throwable handleError(RetrofitError retrofitError) {
        String message = BaseApp.getContext().getString(R.string.something_went);
        String title = "Oops!";
        if (retrofitError.isNetworkError()) {
            title = "No Internet Connection!";
            message = BaseApp.getContext().getString(R.string.network_failed);
        } else {
            try {
                Response r = retrofitError.getResponse();
                if (r != null && r.getStatus() == 408) {
                    title = "Alert!";
                    message = BaseApp.getContext().getString(R.string.timed_out);
                } else if (r.getStatus() == 500) {
                    message = BaseApp.getContext().getString(R.string.internal_error);
                    title = "Sorry!";
                } else if (r.getStatus() == 404) {
                    title = BaseApp.getContext().getString(R.string.alert);
                    message = BaseApp.getContext().getString(R.string.something_went);
                }
            } catch (Exception exception) {
                // something went wrong
                message = BaseApp.getContext().getString(R.string.something_went);
                title = BaseApp.getContext().getString(R.string.alert);
            }
        }

        return new Exception(message + "-" + title);
    }
}

