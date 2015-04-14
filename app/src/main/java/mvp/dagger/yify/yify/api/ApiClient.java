package mvp.dagger.yify.yify.api;

import java.util.List;
import java.util.Map;

import mvp.dagger.yify.yify.api.util.StringConverter;
import mvp.dagger.yify.yify.model.Movie;
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
 * Created by vardan sharma  on 29-11-2014.
 */
public class ApiClient {
    private static ApiInterface apiInterface;
    private static ApiInterface apiInterfaceWithStringConverter;

    public static ApiInterface getApiClient() {
        if (apiInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://yts.im/api/v2")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            apiInterface = restAdapter.create(ApiInterface.class);
        }

        return apiInterface;
    }

    public static ApiInterface getApiClientWithStringConverter() {
        if (apiInterfaceWithStringConverter == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://yts.im/api/v2")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(new StringConverter())
                    .build();
            apiInterfaceWithStringConverter = restAdapter.create(ApiInterface.class);
        }
        return apiInterfaceWithStringConverter;
    }

    public interface ApiInterface {
        @GET("/list_movies.json")
        void getMovieList(
                @QueryMap Map<String, String> options,
                Callback<MovieListWrapper> callback
        );

        @GET("/upcoming.json")
        void getStreams(@Query("limit") int limit, @Query("offset") int offset, Callback<List<Movie>> callback);

        @FormUrlEncoded
        @POST("/user_register.json.json")
        void registerUser(@Field("username") String uName, @Field("email") String email,
                          @Field("password") String pass, @Field("application_key") String appKey, Callback<String> response);

        @FormUrlEncoded
        @POST("/user_get_key.json")
        void LoginUser(@Field("username") String uName, @Field("password") String pass
                , @Field("application_key") String appKey, Callback<String> response);


//        @GET("/movie.json")
//        void getMovieDetail(@Query("id") String id, Callback<MovieDetail> response);
    }
}