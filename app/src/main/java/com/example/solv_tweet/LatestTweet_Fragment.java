package com.example.solv_tweet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LatestTweet_Fragment extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public LatestTweet_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.latesttweet_fragment, container, false);
        recyclerView = v.findViewById(R.id.latest_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getRecentTweets();
    }

    public void getRecentTweets(){
        String query = getActivity().getIntent().getExtras().getString("query");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("tweet_mode", "extended");
        queryParameters.put("count", String.valueOf(100));
        queryParameters.put("result_type", "recent");
        queryParameters.put("q", query);
        Call<TweetList> tweetList = TwitterApiInterface.getTrendTopics().getLatesttweets(queryParameters);
        tweetList.enqueue(new Callback<TweetList>() {
            @Override
            public void onResponse(Call<TweetList> call, Response<TweetList> response) {
                TweetList list = response.body();
                List<Status> statusList = list.getStatuses();
                adapter = new TweetAdapter(getContext(), statusList);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TweetList> call, Throwable t) {
                Toast.makeText(getContext(), "Failed" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
