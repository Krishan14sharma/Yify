package mvp.dagger.yify.yify.api;

import java.util.List;
import java.util.Map;

import mvp.dagger.yify.yify.model.Movie;
import mvp.dagger.yify.yify.model.MovieListWrapper;
import mvp.dagger.yify.yify.model.login.LoginResponse;
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

        @GET("/upcoming.json")
        void getStreams(@Query("limit") int limit, @Query("offset") int offset, Callback<List<Movie>> callback);

        @FormUrlEncoded
        @POST("/register.json")
        void registerUser(@Field("username") String uName, @Field("email") String email,
                          @Field("password") String pass, Callback<String> response);

        @FormUrlEncoded
        @POST("/login.json")
        void LoginUser(@Field("username") String uName, @Field("password") String pass,
                       Callback<LoginResponse> response);


//        @GET("/movie.json")
//        void getMovieDetail(@Query("id") String id, Callback<MovieDetail> response);
    }
}