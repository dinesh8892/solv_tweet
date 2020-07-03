package com.example.solv_tweet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TredingTopicAdapter extends RecyclerView.Adapter<TredingTopicAdapter.TrendingTopicViewHolder> {

    private Context context;
    private List<Trend> trends;
    private RecyclerView mRecyclerView;



    public TredingTopicAdapter(Context context, List<Trend> trends) {
        this.context = context;
        this.trends = trends;
    }

    @NonNull
    @Override
    public TrendingTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.trend_itemview, parent, false);
        view.setOnClickListener(myonClickListener);
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

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    private final View.OnClickListener myonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int itemPosition = mRecyclerView.getChildAdapterPosition(v);
            Trend trend = trends.get(itemPosition);
//            Toast.makeText(context, "itemPosition :" + itemPosition + ": " + trend, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, DisplayTweetActivity.class);
            intent.putExtra("query", trends.get(itemPosition).getQuery());
            context.startActivity(intent);

        }
    };

}
