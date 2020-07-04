
package com.example.solv_tweet.tweet_model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TweetList {

    @SerializedName("statuses")
    @Expose
    private List<Status> statuses = null;
    @SerializedName("search_metadata")
    @Expose
    private SearchMetadata searchMetadata;

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public SearchMetadata getSearchMetadata() {
        return searchMetadata;
    }

    public void setSearchMetadata(SearchMetadata searchMetadata) {
        this.searchMetadata = searchMetadata;
    }

}
