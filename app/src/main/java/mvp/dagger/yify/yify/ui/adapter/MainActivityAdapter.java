package mvp.dagger.yify.yify.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mvp.dagger.yify.yify.BaseApp;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;


/**
 * Created by krishan on 15/4/15.
 */
public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder> {
    public static final int ITEM_TYPE_SMALL = 1;
    public static final int ITEM_TYPE_LARGE = 2;
    public static final int ITEM_TYPE_PROGRESS_BAR = 3;


    private DataFetchEvent event;

    public MainActivityAdapter(Fragment fragment, MovieListWrapper movieListWrapper) {
        this.movieListWrapper = movieListWrapper;
        event = (DataFetchEvent) fragment;
    }

    private MovieListWrapper movieListWrapper;

    @Override
    public MainActivityViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView;
        switch (viewType) {
            case ITEM_TYPE_SMALL:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_spannable_grid1, viewGroup, false);
                return new MainActivityViewHolder(itemView);
            case ITEM_TYPE_LARGE:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_spannable_grid2, viewGroup, false);
                return new MainActivityViewHolder(itemView);
//            case ITEM_TYPE_PROGRESS_BAR:
//                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.include_progress_bar, viewGroup, false);
//                return new MainActivityViewHolder(itemView);

            default:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_spannable_grid2, viewGroup, false);
                return new MainActivityViewHolder(itemView);

        }
    }

    public void concatContent(MovieListWrapper wrapper) {
        if (movieListWrapper.getData() != null)
            movieListWrapper.getData().getMovies().addAll(wrapper.getData().getMovies());
        else
            movieListWrapper = wrapper;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == getItemCount() - 1)
//            return ITEM_TYPE_PROGRESS_BAR;

        return position % 2;
    }

    @Override
    public void onBindViewHolder(MainActivityViewHolder mainActivityViewHolder, int i) {
        Picasso.with(BaseApp.getContext()).load(movieListWrapper.getData().getMovies().get(i).getMediumCoverImage()).into(mainActivityViewHolder.mImageView);
        mainActivityViewHolder.mTextView.setText(movieListWrapper.getData().getMovies().get(i).getTitle() + "");
        if (i == getItemCount() - 1) {
            event.endOfListReachedEvent();
        }
    }

    @Override
    public int getItemCount() {
        return (movieListWrapper.getData() == null) ? 0 :
                movieListWrapper.getData().getMovies().size();
    }


    static class MainActivityViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.imageView)
        ImageView mImageView;

        @InjectView(R.id.textView)
        TextView mTextView;

        MainActivityViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }

    }

    public interface DataFetchEvent {
        void endOfListReachedEvent();
    }
}
