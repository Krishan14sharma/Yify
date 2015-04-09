package mvp.dagger.yify.yify.api;

import java.util.Map;

import mvp.dagger.yify.yify.api.util.CustomErrorHandler;
import mvp.dagger.yify.yify.model.MovieListWrapper;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by krishan on 29-11-2014.
 */
public class ApiClient {
    private static YifyApiInterface sMovieListService;

    public static YifyApiInterface getYifyApiClient() {
        if (sMovieListService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://yts.im/api/v2")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setErrorHandler(new CustomErrorHandler())
                    .build();
            sMovieListService = restAdapter.create(YifyApiInterface.class);
        }
        return sMovieListService;
    }

    public interface YifyApiInterface {
        @GET("/list_movies.json")
        void getMovieList(
                @QueryMap Map<String, String> options,
                Callback<MovieListWrapper> callback
        );
    }
}