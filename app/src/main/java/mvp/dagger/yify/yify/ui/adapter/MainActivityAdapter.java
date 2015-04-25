package mvp.dagger.yify.yify.ui.adapter;

import android.app.Activity;
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
import mvp.dagger.yify.yify.model.MovieListWrapper;


/**
 * Created by krishan on 15/4/15.
 */
public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder> {

    private EOLReached reached;

    public MainActivityAdapter(Activity activity, MovieListWrapper movieListWrapper) {
        this.movieListWrapper = movieListWrapper;
        this.reached = (EOLReached) activity;
    }

    private MovieListWrapper movieListWrapper;

    @Override
    public MainActivityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView;
        switch (i) {
            case 0:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_spannable_grid1, viewGroup, false);
                return new MainActivityViewHolder(itemView);
            default:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_spannable_grid2, viewGroup, false);
                return new MainActivityViewHolder(itemView);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            //todo call through interface or event bus to fetch more items from the web service
        }
        return position % 2;
    }

    @Override
    public void onBindViewHolder(MainActivityViewHolder mainActivityViewHolder, int i) {
        Picasso.with(BaseApp.getContext()).load(movieListWrapper.getData().getMovies().get(i).getMediumCoverImage()).into(mainActivityViewHolder.mImageView);
        mainActivityViewHolder.mTextView.setText(movieListWrapper.getData().getMovies().get(i).getTitle() + "");
    }

    @Override
    public int getItemCount() {
        return movieListWrapper.getData().getMovies().size();
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

    public void updateData(MovieListWrapper wrapper) {
        this.movieListWrapper.getData().getMovies().addAll(wrapper.getData().getMovies());
    }

    public interface EOLReached {
        void loadMoreData();
    }
}
