package mvp.dagger.yify.yify.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import mvp.dagger.yify.yify.model.MovieListWrapper;
import mvp.dagger.yify.yify.ui.common.BaseToolBarActivity;
import retrofit.RetrofitError;


public class MainActivity extends BaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(), "tag")
                    .commit();
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements MainView {

        @InjectView(R.id.progressBar)
        ProgressBar progressBar;

        MainPresenter presenter;

        public PlaceholderFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.inject(this, rootView);
            setUp();
//            presenter=component.getMainPresenter();
//            presenter = new MainPresenterImpl(this);
            return rootView;
        }

        private void setUp() {
            BaseAppComponent baseAppComponent = (BaseApp.getContext()).getComponent();
            MainComponent component = DaggerMainComponent.builder()
                    .baseAppComponent(baseAppComponent)
                    .mainModule(new MainModule(this))
                    .build();
            component.inject(this);
            presenter=component.getMainPresenter();
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
