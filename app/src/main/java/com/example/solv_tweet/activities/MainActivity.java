package com.example.solv_tweet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.solv_tweet.R;
import com.example.solv_tweet.trendingtopicmodel.Trend;
import com.example.solv_tweet.adapter.TrendingTopicAdapter;
import com.example.solv_tweet.trendingtopicmodel.Trendingtopic;
import com.example.solv_tweet.api_interface.TwitterApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.trending_recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        gettrends();

    }

    private void gettrends(){

        Call<ArrayList<Trendingtopic>> trendingtopics = TwitterApiInterface.getTrendTopics().getTrendingtopics();
        trendingtopics.enqueue(new Callback<ArrayList<Trendingtopic>>() {
            @Override
            public void onResponse(Call<ArrayList<Trendingtopic>> call, Response<ArrayList<Trendingtopic>> response) {
                ArrayList<Trendingtopic> topics = response.body();
                List<Trend> trendList = topics.get(0).getTrends();
                adapter = new TrendingTopicAdapter(MainActivity.this, trendList);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

//                Toast.makeText((MainActivity.this), "success" + trendList, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<Trendingtopic>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed" + t, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
