package mvp.dagger.yify.yify;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by krishan on 10/12/14.
 */

/**
 * This is the Base application class that provides global application instance.This class also provides logging in only debug mode.
 * Avoid initializing big objects here may slow the application startup.
 */
public class BaseApp extends Application {

    private static BaseApp instance;

    public BaseAppComponent getComponent() {
        return component;
    }

    private BaseAppComponent component;

    public static BaseApp getContext() {
        return instance;
    }

    private static final String TAG = "BaseApp";


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerBaseAppComponent.builder().baseAppModule(new BaseAppModule(this)).build();
        component.inject(this);
        if (BuildConfig.LOG_HTTP_REQUESTS) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }


    }

    /**
     * A tree which logs important information for crash reporting.This is where you should report to remote logging server.
     */
    private static class CrashReportingTree extends Timber.HollowTree {

        @Override
        public void i(String message, Object... args) { /* TODO e.g., Crashlytics.log(String.format(message, args)); */ }

        @Override
        public void i(Throwable t, String message, Object... args) {
            i(message, args);
        }

        @Override
        public void e(String message, Object... args) { /*Crashlytics.log(message);*/
            i("ERROR: " + message, args);
        }

        @Override
        public void e(Throwable t, String message, Object... args) { /*Crashlytics.logException(t);*/ }

        @Override
        public void d(String message, Object... args) {
            super.d(message, args);
        }
    }
}