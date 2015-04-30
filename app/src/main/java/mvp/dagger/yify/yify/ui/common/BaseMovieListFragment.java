package mvp.dagger.yify.yify.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

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
import mvp.dagger.yify.yify.ui.activity.MainActivity;
import mvp.dagger.yify.yify.ui.adapter.MainActivityAdapter;
import mvp.dagger.yify.yify.ui.view.MainView;
import mvp.dagger.yify.yify.util.SpacesItemDecoration;
import mvp.dagger.yify.yify.views.HidingScrollListener;
import retrofit.RetrofitError;
import timber.log.Timber;

import static mvp.dagger.yify.yify.util.CommonUtil.showToast;

/**
 * A placeholder fragment containing a simple view.
 */
public abstract class BaseMovieListFragment extends Fragment implements MainView, MainActivityAdapter.DataFetchEvent {
    @InjectView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    MainPresenter presenter; // should not be private for dagger magic
    @InjectView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @InjectView(R.id.horizontal_bar)
    ProgressBar mHorizontalBar;
    @InjectView(R.id.container)
    RelativeLayout mContainer;
    private MainActivityAdapter mMovieAdapter;
    MOVIE_TYPE type;
    float toolbarHeight;
    float toolbarContainerHeight;
    private boolean isToolbarShown;

    public BaseMovieListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, rootView);
        setUpDagger();
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mMovieAdapter = new MainActivityAdapter(this, new MovieListWrapper());
        mRecyclerView.setAdapter(mMovieAdapter);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.item_spacing)));
        return rootView;
    }

    public MOVIE_TYPE getType() {
        return type;
    }

    public void setType(MOVIE_TYPE type) {
        this.type = type;
    }

    private void setUpDagger() {
        BaseAppComponent baseAppComponent = (BaseApp.getContext()).getComponent();
        MainComponent component = DaggerMainComponent.builder()
                .baseAppComponent(baseAppComponent)
                .mainModule(new MainModule(this, type))//todo
                .build();
        component.inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.fetchInitialData(getType());
        toolbarHeight = ((MainActivity) getActivity()).getToolbarSizeInpixels();
        toolbarContainerHeight = (int) ((MainActivity) getActivity()).getToolbarContainerHeight();

        mRecyclerView.setOnScrollListener(new HidingScrollListener(getActivity()) {
            @Override
            public void onMoved(int distance) {
                ((MainActivity) getActivity()).getToolbarContainer().setTranslationY(-distance);
            }

            @Override
            public void onShow() {
                ((MainActivity) getActivity()).getToolbarContainer().animate()
                        .translationY(0)
                        .setInterpolator(new DecelerateInterpolator(2)).start();
                isToolbarShown = true;
            }

            @Override
            public void onHide() {
                ((MainActivity) getActivity()).getToolbarContainer().animate().
                        translationY(-toolbarHeight).
                        setInterpolator(new AccelerateInterpolator(2)).start();
                isToolbarShown = false;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // check if the toolbar is invisible if so then
        Timber.d("mRecyclerView.getScrollY()   = " + mRecyclerView.getScrollY());
        if (!isToolbarShown && mRecyclerView.getScaleY() == 0) {
            mRecyclerView.scrollBy(0, -(int) toolbarHeight);
            Timber.d(" condition met :)");

        }
    }

    @Override
    public void showData(MovieListWrapper movieListWrapper) {
        showToast(movieListWrapper.getData().getMovies().size() + "");
        mMovieAdapter.concatContent(movieListWrapper);

    }

    @Override
    public void showLazyLoading() {
        mHorizontalBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLazyLoading() {
        mHorizontalBar.setVisibility(View.GONE);
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

    public void updateData() {
        presenter.fetchInitialData(getType());
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
        presenter.fetchMoreData();
    }
}