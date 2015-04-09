package mvp.dagger.yify.yify;

import android.test.ActivityInstrumentationTestCase2;

import mvp.dagger.yify.yify.ui.home.MainActivity;

/**
 * Created by krishan on 9/4/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;
    MainActivity.PlaceholderFragment placeholderFragment;

    public MainActivityTest() {
        super(MainActivity.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        placeholderFragment = (MainActivity.PlaceholderFragment) mainActivity.getSupportFragmentManager().findFragmentByTag("tag");
    }
}
