package com.example.solv_tweet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TredingTopicAdapter extends RecyclerView.Adapter<TredingTopicAdapter.TrendingTopicViewHolder> {

    private Context context;
    private List<Trend> trends;

    public TredingTopicAdapter(Context context, List<Trend> trends) {
        this.context = context;
        this.trends = trends;
    }

    @NonNull
    @Override
    public TrendingTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.trend_itemview, parent, false);
        return new TrendingTopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingTopicViewHolder holder, int position) {
        Trend trend = trends.get(position);
        holder.topicTitle.setText(trend.getName());
        holder.topicTweetVolume.setText(Integer.toString(trend.getTweetVolume()));

    }

    @Override
    public int getItemCount() {
        return trends.size();
    }

    public class TrendingTopicViewHolder extends RecyclerView.ViewHolder{

        TextView topicTitle;
        TextView topicTweetVolume;
        public TrendingTopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topicTitle = itemView.findViewById(R.id.trending_topic_title);
            topicTweetVolume = itemView.findViewById(R.id.trending_topic_Volume);
        }
    }

}
