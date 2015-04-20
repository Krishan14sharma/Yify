
package mvp.dagger.yify.yify.model.movie_list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("movie_count")
    @Expose
    private int movieCount;
    @Expose
    private int limit;
    @SerializedName("page_number")
    @Expose
    private int pageNumber;
    @Expose
    private List<Movie> movies = new ArrayList<Movie>();

    /**
     * @return The movieCount
     */
    public int getMovieCount() {
        return movieCount;
    }

    /**
     * @param movieCount The movie_count
     */
    public void setMovieCount(int movieCount) {
        this.movieCount = movieCount;
    }

    /**
     * @return The limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit The limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @return The pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber The page_number
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return The movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies The movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
