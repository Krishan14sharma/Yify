package mvp.dagger.yify.yify.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mvp.dagger.yify.yify.BaseApp;
import mvp.dagger.yify.yify.BaseAppComponent;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.di.component.DaggerMainComponent;
import mvp.dagger.yify.yify.di.component.MainComponent;
import mvp.dagger.yify.yify.di.module.MainModule;
import mvp.dagger.yify.yify.domain.presenter.MainPresenter;
import mvp.dagger.yify.yify.model.MOVIE_TYPE;
import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;
import mvp.dagger.yify.yify.ui.adapter.CommonPagerAdapter;
import mvp.dagger.yify.yify.ui.adapter.MainActivityAdapter;
import mvp.dagger.yify.yify.ui.adapter.TabData;
import mvp.dagger.yify.yify.ui.common.BaseToolBarActivity;
import mvp.dagger.yify.yify.ui.view.MainView;
import mvp.dagger.yify.yify.util.SpacesItemDecoration;
import mvp.dagger.yify.yify.views.SlidingTabLayout;
import retrofit.RetrofitError;
import timber.log.Timber;

import static mvp.dagger.yify.yify.util.CommonUtil.showToast;


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
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment(), "tag")
//                    .commit();
//        }
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
        datas.add(new TabData(getString(R.string.movies), PlaceholderFragment.newInstance(1)));
        datas.add(new TabData(getString(R.string.upcomingmov), PlaceholderFragment.newInstance(2)));
        mViewpager.setAdapter(new CommonPagerAdapter(getSupportFragmentManager(), datas));
        mSlidingTabs.setDistributeEvenly(true);
        mSlidingTabs.setViewPager(mViewpager);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements MainView, MainActivityAdapter.DataFetchEvent {
        private static final String POSITION_KEY = "position";
        int pageNumRequested = 1;
        @InjectView(R.id.progressBar)
        ProgressBar progressBar;

        @Inject
        MainPresenter presenter; // should not be private for dagger magic
        @InjectView(R.id.recycler_view)
        RecyclerView mRecyclerView;
        private MainActivityAdapter mMovieAdapter;
        MOVIE_TYPE type;

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int position) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle bd = new Bundle();
            bd.putInt(POSITION_KEY, position);
            fragment.setArguments(bd);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.inject(this, rootView);
            setUpDagger();
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            mRecyclerView.addItemDecoration(new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.item_spacing)));
            return rootView;
        }

        private void setUpDagger() {
            int position = getArguments().getInt(POSITION_KEY);
            type = (position == 1) ? MOVIE_TYPE.RELEASED : MOVIE_TYPE.UPCOMING;
            BaseAppComponent baseAppComponent = (BaseApp.getContext()).getComponent();
            MainComponent component = DaggerMainComponent.builder()
                    .baseAppComponent(baseAppComponent)
                    .mainModule(new MainModule(this, type))
                    .build();
            component.inject(this);
//            presenter=component.getMainPresenter(); // one other way to get the object
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            presenter.fetchMovieData(pageNumRequested);
        }

        @Override
        public void showData(MovieListWrapper movieListWrapper) {
            showToast(movieListWrapper.getData().getMovies().size() + "");
            if (pageNumRequested != 1) {
                mMovieAdapter.concatContent(movieListWrapper);
//                mProgressBar1.setVisibility(View.GONE);

            } else {
                mMovieAdapter = new MainActivityAdapter(this, movieListWrapper);
                mRecyclerView.setAdapter(mMovieAdapter);
            }
        }

        @Override
        public void showLoading() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void hideLoading() {
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void showError(RetrofitError error) {
            showToast("error");// todo change this to show a meaningful message
        }

        @Override
        public void onHideError() {

        }


        @Override
        public void onDestroyView() {
            super.onDestroyView();
            ButterKnife.reset(this);
            presenter.destroy();
        }

        @Override
        public void endOfListReachedEvent() {
            Timber.d("event triggered successfully");
            pageNumRequested++;
//            mProgressBar1.setVisibility(View.VISIBLE);
            presenter.fetchMovieData(pageNumRequested);
        }
    }
}
