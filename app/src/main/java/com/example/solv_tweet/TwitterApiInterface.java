package com.example.solv_tweet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public class TwitterApiInterface {

    private static final String bearer_token = "AAAAAAAAAAAAAAAAAAAAABZMFQEAAAAA3Yp2VKFhAuog167xZmnBeYVdo64%3DKbYVDqEQRDk2RN7LGo35HiUlENSrIKXA6yWF2Rv7V0vuvjS5HD";
    private static final String url = "https://api.twitter.com/1.1/";
    private static final String id = "23424848";


    public static TrendTopics trendTopics= null;

    public static TrendTopics getTrendTopics(){
        if (trendTopics == null){
            OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newrequest = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + bearer_token)
                            .build();
                    return chain.proceed(newrequest);
                }
            }).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            trendTopics = retrofit.create(TrendTopics.class);
        }
        return trendTopics;
    }

    public interface TrendTopics{
//        @Headers({"Authorization:  Bearer " + bearer_token})
        @GET("trends/place.json?id="+id)
        Call<ArrayList<Trendingtopic>> getTrendingtopics();

        @GET("search/tweets.json?")
        Call<TweetList> getPopulartweets(@QueryMap(encoded = true) Map<String, String> Popular_query);

        @GET("search/tweets.json?")
        Call<TweetList> getLatesttweets(@QueryMap(encoded = true) Map<String, String> Recent_query);

    }



}
