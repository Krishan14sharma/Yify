package mvp.dagger.yify.yify;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;

import mvp.dagger.yify.yify.ui.activity.MainActivity;

/**
 * Created by krishan on 15/4/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class Mainc {

    @Before
    public void setUp() throws Exception {
        // setup
    }

    @Test
    public void testSomething() throws Exception {
        // test
        Activity activity = Robolectric.buildActivity(MainActivity.class)
                .create()
//                .restoreInstanceState(savedInstanceState)
                .get();
        activity.findViewById(R.id.container);
    }

}
