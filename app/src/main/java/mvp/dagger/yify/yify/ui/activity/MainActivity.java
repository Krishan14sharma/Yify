package mvp.dagger.yify.yify.ui.activity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.bus.BusProvider;
import mvp.dagger.yify.yify.bus.ShowMovieListDialog;
import mvp.dagger.yify.yify.ui.adapter.CommonPagerAdapter;
import mvp.dagger.yify.yify.ui.adapter.TabData;
import mvp.dagger.yify.yify.ui.common.BaseToolBarActivity;
import mvp.dagger.yify.yify.ui.dialogs.MovieListFilterFragment;
import mvp.dagger.yify.yify.ui.fragment.ActionMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.AdventureMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.AllMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.AnimationMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.ComedyMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.HorrorMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.RomanceMovielistFragment;
import mvp.dagger.yify.yify.ui.fragment.SciFiMovieListFragment;
import mvp.dagger.yify.yify.ui.fragment.ThrillerMovieListFragment;
import mvp.dagger.yify.yify.util.CommonUtil;
import mvp.dagger.yify.yify.util.view_pager_utils.RotationPageTransformer;
import mvp.dagger.yify.yify.views.SlidingTabLayout;


public class MainActivity extends BaseToolBarActivity implements ViewPager.OnPageChangeListener {

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @InjectView(R.id.viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    @InjectView(R.id.toolbar_container)
    LinearLayout mToolbarContainer;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setUpNavDrawer();
        ArrayList<TabData> datas = getTabsData();

        mViewpager.setOffscreenPageLimit(4);
        mViewpager.setAdapter(new CommonPagerAdapter(getSupportFragmentManager(), datas));
        mSlidingTabs.setDistributeEvenly(true);
        mSlidingTabs.setmTabTitleColor(Color.WHITE);
        mSlidingTabs.setViewPager(mViewpager);
        mSlidingTabs.setOnPageChangeListener(this);
        mViewpager.setPageTransformer(true, new RotationPageTransformer(112));
        BusProvider.getInstance().register(this);

    }

    private void setUpNavDrawer() {
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
    }

    private ArrayList<TabData> getTabsData() {
        ArrayList<TabData> datas = new ArrayList<>();
        datas.add(new TabData("All", AllMovieListFragment.newInstance()));
        datas.add(new TabData("Action", ActionMovieListFragment.newInstance()));
        datas.add(new TabData("Adventure", AdventureMovieListFragment.newInstance()));
        datas.add(new TabData("Romance", RomanceMovielistFragment.newInstance()));
        datas.add(new TabData("Animation", AnimationMovieListFragment.newInstance()));
        datas.add(new TabData("Comedy", ComedyMovieListFragment.newInstance()));
        datas.add(new TabData("Horror", HorrorMovieListFragment.newInstance()));
        datas.add(new TabData("Sci-fi", SciFiMovieListFragment.newInstance()));
        datas.add(new TabData("Thriller", ThrillerMovieListFragment.newInstance()));
        return datas;
    }

    @Subscribe
    public void eventShowFilterDialog(ShowMovieListDialog filter) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        // Create and show the dialog.
        MovieListFilterFragment newFragment = MovieListFilterFragment.newInstance();
        newFragment.show(ft, "dialog");
    }

    public View getToolbarContainer() {
        return mToolbarContainer;
    }

    public float getToolbarContainerHeight() {
        return CommonUtil.convertDpToPixel(104);
    }

    public View getContainer() {
        return mSlidingTabs;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
