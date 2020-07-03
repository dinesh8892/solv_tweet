package com.example.solv_tweet;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetViewHolder> {

    private Context context;
    private List<Status> statuses;

    public TweetAdapter(Context context, List<Status> statuses) {
        this.context = context;
        this.statuses = statuses;
    }

    @NonNull
    @Override
    public TweetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.tweet_item, parent, false);
        return new TweetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TweetViewHolder holder, int position) {
        Status status = statuses.get(position);
        holder.userName.setText(status.getUser().getName());
        holder.screenName.setText(status.getUser().getScreenName());
//        SpannableString spannableString = new SpannableString(status.getFull_text());
//        ForegroundColorSpan blue = new ForegroundColorSpan(Color.BLUE);
//        List<Hashtag> hashtagList = status.getEntities().getHashtags();
//        if (hashtagList.size() != 0) {
//            spannableString.setSpan(blue, hashtagList.get(position).getIndices().get(0)
//                    , hashtagList.get(position).getIndices().get(0), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        }
        holder.TweetText.setText(status.getFull_text());
        holder.favorite.setText(Integer.toString(status.getFavoriteCount()));
        holder.retweet_count.setText(Integer.toString(status.getRetweetCount()));

    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        TextView screenName;
        TextView TweetText;
        TextView favorite;
        TextView retweet_count;

        public TweetViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.tweet_username);
            screenName = itemView.findViewById(R.id.tweet_screenname);
            TweetText = itemView.findViewById(R.id.tweet_text);
            favorite = itemView.findViewById(R.id.favorite_count);
            retweet_count = itemView.findViewById(R.id.retweet_count);
        }
    }
}
