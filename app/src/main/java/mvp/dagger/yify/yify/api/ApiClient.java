package mvp.dagger.yify.yify.api;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import mvp.dagger.yify.yify.BaseApp;
import mvp.dagger.yify.yify.api.util.StringConverter;
import mvp.dagger.yify.yify.model.movie_list.MovieListWrapper;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by vardan sharma  on 29-11-2014.
 */
public class ApiClient {
    private static ApiInterface apiInterface;
    private static ApiInterface apiInterfaceWithStringConverter;
    public static final String API_END_POINT = "https://yts.im/api/v2";

    public static ApiInterface getApiClient() {

        if (apiInterface == null) {
            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            File cacheDirectory = new File(BaseApp.getContext().getCacheDir().getAbsolutePath(), "HttpCache");
            Cache cache = null;
            try {
                cache = new Cache(cacheDirectory, cacheSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
            OkHttpClient client = new OkHttpClient();
            client.setCache(cache);
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_END_POINT)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setClient(new OkClient(client))
                    .build();
            apiInterface = restAdapter.create(ApiInterface.class);
        }

        return apiInterface;
    }

    public static ApiInterface getApiClientWithStringConverter() {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        File cacheDirectory = new File(BaseApp.getContext().getCacheDir().getAbsolutePath(), "HttpCache");
        Cache cache = null;
        try {
            cache = new Cache(cacheDirectory, cacheSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OkHttpClient client = new OkHttpClient();
        client.setCache(cache);
        if (apiInterfaceWithStringConverter == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://yts.im/api/v2")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(new StringConverter())
                    .setClient(new OkClient(client))
                    .build();
            apiInterfaceWithStringConverter = restAdapter.create(ApiInterface.class);
        }
        return apiInterfaceWithStringConverter;
    }

    public interface ApiInterface {


        @GET("/list_movies.json")
        @Headers("cache-control: public, max-age=60 *60,")
        void getMovieList(
                @QueryMap Map<String, String> options,
                Callback<MovieListWrapper> callback
        );

//        @GET("/upcoming.json")
//        void getStreams(@Query("limit") int limit, @Query("offset") int offset, Callback<List<Movie>> callback);

        @FormUrlEncoded
        @POST("/user_register.json.json")
        void registerUser(@Field("username") String uName, @Field("email") String email,
                          @Field("password") String pass, @Field("application_key") String appKey, Callback<String> response);

        @FormUrlEncoded
        @POST("/user_get_key.json")
        void LoginUser(@Field("username") String uName, @Field("password") String pass
                , @Field("application_key") String appKey, Callback<String> response);

        @GET("/user_profile.json")
        void getUserProfile(@Query("user_key") String userKey, Callback<String> userProfileWrapperCallback);

//        @GET("/movie.json")
//        void getMovieDetail(@Query("id") String id, Callback<MovieDetail> response);
    }
}