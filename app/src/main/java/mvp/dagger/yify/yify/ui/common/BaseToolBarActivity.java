package mvp.dagger.yify.yify.ui.common;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.sriramramani.droid.inspector.server.ViewServer;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;
import mvp.dagger.yify.yify.BuildConfig;
import mvp.dagger.yify.yify.R;

/**
 * Created by Krishan on 17/12/14.
 * Contains the logic for Toolbar.In order to use the Toolbar you need to remove the Action Bar using styles and include include_toolbar layout in your main xml.
 */
public class BaseToolBarActivity extends ActionBarActivity{


    @Optional
    @InjectView(R.id.toolbar)
    public Toolbar mToolbar;


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ButterKnife.inject(this); // here because the setcontent view lies in onCreate of child classes.

        if(BuildConfig.ENABLE_VIEW_SERVER) ViewServer.get(this).addWindow(this);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//            mToolbar.setNavigationOnClickListener(this);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(BuildConfig.ENABLE_VIEW_SERVER)ViewServer.get(this).removeWindow(this);
    }

//    private void showParentActivity(Intent upIntent) {
//        if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
//            // This activity is NOT part of this app's task, so create a new task
//            // when navigating up, with a synthesized back stack.
//            TaskStackBuilder.create(this)
//                    // Add all of this activity's parents to the back stack
//                    .addNextIntentWithParentStack(upIntent)
//                            // Navigate up to the closest parent
//                    .startActivities();
//        } else {
//            // This activity is part of this app's task, so simply
//            // navigate up to the logical parent activity.
//            NavUtils.navigateUpTo(this, upIntent);
//        }
//    }

    @Override
    protected void onResume() {
        super.onResume();
        if(BuildConfig.ENABLE_VIEW_SERVER) ViewServer.get(this).setFocusedWindow(this);
    }

//    @Override
//    public void onClick(View v) {
//        Intent upIntent = NavUtils.getParentActivityIntent(this);
//        if (upIntent != null) {
//            showParentActivity(upIntent);
//        } else {
//            // no parent defined
//            Timber.e("No parent Activity defined in manifest!");
//            finish();
//        }
//    }
}