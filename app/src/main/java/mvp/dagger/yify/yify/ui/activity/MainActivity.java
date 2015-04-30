package mvp.dagger.yify.yify.ui.activity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.ui.adapter.CommonPagerAdapter;
import mvp.dagger.yify.yify.ui.adapter.TabData;
import mvp.dagger.yify.yify.ui.common.BaseToolBarActivity;
import mvp.dagger.yify.yify.ui.fragment.ActionMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.AdventureMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.AllMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.RomanceMovielistFragment;
import mvp.dagger.yify.yify.views.SlidingTabLayout;


public class MainActivity extends BaseToolBarActivity {
    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @InjectView(R.id.viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        ArrayList<TabData> datas = new ArrayList<>();
        datas.add(new TabData("All", AllMovieListFragment.newInstance()));
        datas.add(new TabData("Action", ActionMovieListFragment.newInstance()));
        datas.add(new TabData("Adventure", AdventureMovieListFragment.newInstance()));
        datas.add(new TabData("Romance", RomanceMovielistFragment.newInstance()));
        mViewpager.setOffscreenPageLimit(4);
        mViewpager.setBackgroundColor(Color.WHITE);
        mViewpager.setAdapter(new CommonPagerAdapter(getSupportFragmentManager(), datas));
        mSlidingTabs.setDistributeEvenly(true);
        mSlidingTabs.setViewPager(mViewpager);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


}
