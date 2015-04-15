package mvp.dagger.yify.yify.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

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
import mvp.dagger.yify.yify.model.MovieListWrapper;
import mvp.dagger.yify.yify.ui.common.BaseToolBarActivity;
import mvp.dagger.yify.yify.ui.view.MainView;
import retrofit.RetrofitError;


public class MainActivity extends BaseToolBarActivity {

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(), "tag")
                    .commit();
        }
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements MainView {

        @InjectView(R.id.progressBar)
        ProgressBar progressBar;

        @Inject
        MainPresenter presenter; // should not be private for dagger magic

        public PlaceholderFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.inject(this, rootView);
            setUp();
            return rootView;
        }

        private void setUp() {
            BaseAppComponent baseAppComponent = (BaseApp.getContext()).getComponent();
            MainComponent component = DaggerMainComponent.builder()
                    .baseAppComponent(baseAppComponent)
                    .mainModule(new MainModule(this))
                    .build();
            component.inject(this);
//            presenter=component.getMainPresenter(); // one other way to get the object
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            presenter.onViewload();
        }

        @Override
        public void showData(MovieListWrapper movieListWrapper) {
            Toast.makeText(getActivity().getApplicationContext(), movieListWrapper.getData().getMovies().size() + "", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(getActivity().getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
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
    }
}
