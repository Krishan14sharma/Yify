package mvp.dagger.yify.yify.model;

/**
 * Created by Vardan sharma on 02-05-2015.
 */

import java.util.HashMap;

import mvp.dagger.yify.yify.constants.MovieQuality;
import mvp.dagger.yify.yify.constants.OrderBy;
import mvp.dagger.yify.yify.constants.SortByOptions;

/**
 * This class provides the implementation to deal with the filters
 * provided by the yify api
 */


public class MovieListFilter {
    public static final int LIMIT_DEFAULT_VAL = 20;
    public static final int PAGE_NUM_DEFAULT_VAL = 1;
    public static final MovieQuality MOVIE_QUALITY_DEFAULT_VAL = MovieQuality.ALL;
    public static final int MIN_RATING_DEFAULT_VAL = 0;
    public static final SortByOptions SORT_BY_DEFAULT_VALUE = SortByOptions.DATE_ADDED;
    public static final OrderBy ORDER_BY_DEFAULT_VAL = OrderBy.ASCENDING;
    public static final String SEARCH_QUERY_DEFAULT_VAL = null;
    /**
     * The limit of results per page that has been set
     * range 1 to 50
     * default value = 20
     */
    private int mLimit;
    /**
     * Used to see the next page of movies, eg limit=15 and page=2 will show you movies 15-30
     */
    private int mPageNum;

    /**
     * Used to filter by a given quality
     * default value is ALL
     */
    private MovieQuality mQuality;

    /**
     * Used to filter movie by a given minimum IMDb rating
     * range b/w 0 to 9
     */
    private int mMinimumRatings;

    /**
     * Sorts the results by choosen value
     * default date added
     */
    private SortByOptions mSortBy;

    /**
     * Orders the results by either Ascending or Descending order
     * default is ascending order
     */
    private OrderBy mOrderBy;

    /**
     * Used for movie search, matching on: Movie Title/IMDb Code, Actor Name/IMDb Code, Director Name/IMDb Code
     */
    private String mSearchQuery;


    /**
     * Constructor for the filter class whenever we
     * create an object of this class it will initialize
     * all of its value with a default value
     */
    public MovieListFilter() {

        mLimit = LIMIT_DEFAULT_VAL;
        mMinimumRatings = MIN_RATING_DEFAULT_VAL;
        mOrderBy = ORDER_BY_DEFAULT_VAL;
        mPageNum = PAGE_NUM_DEFAULT_VAL;
        mQuality = MOVIE_QUALITY_DEFAULT_VAL;
        mSearchQuery = SEARCH_QUERY_DEFAULT_VAL;
        mSortBy = SORT_BY_DEFAULT_VALUE;
    }

    public int getmLimit() {
        return mLimit;
    }

    public void setmLimit(int mLimit) {
        this.mLimit = mLimit;
    }

    public int getmPageNum() {
        return mPageNum;
    }

    public void setmPageNum(int mPageNum) {
        this.mPageNum = mPageNum;
    }

    public MovieQuality getmQuality() {
        return mQuality;
    }

    public void setmQuality(MovieQuality mQuality) {
        this.mQuality = mQuality;
    }

    public int getmMinimumRatings() {
        return mMinimumRatings;
    }

    public void setmMinimumRatings(int mMinimumRatings) {
        this.mMinimumRatings = mMinimumRatings;
    }

    public SortByOptions getmSortBy() {
        return mSortBy;
    }

    public void setmSortBy(SortByOptions mSortBy) {
        this.mSortBy = mSortBy;
    }

    public OrderBy getmOrderBy() {
        return mOrderBy;
    }

    public void setmOrderBy(OrderBy mOrderBy) {
        this.mOrderBy = mOrderBy;
    }

    public String getmSearchQuery() {
        return mSearchQuery;
    }

    public void setmSearchQuery(String mSearchQuery) {
        this.mSearchQuery = mSearchQuery;
    }

    /**
     * todo create a method that will convert this class object
     * into a hash map used by the webservice
     */
    public HashMap<String, String> provideRequestMap() {
        //todo implement this in future
        return new HashMap<String, String>();
    }
}
