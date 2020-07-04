
package com.example.solv_tweet.tweet_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sizes {

    @SerializedName("medium")
    @Expose
    private Medium_ medium;
    @SerializedName("thumb")
    @Expose
    private Thumb thumb;
    @SerializedName("small")
    @Expose
    private Small small;
    @SerializedName("large")
    @Expose
    private Large large;

    public Medium_ getMedium() {
        return medium;
    }

    public void setMedium(Medium_ medium) {
        this.medium = medium;
    }

    public Thumb getThumb() {
        return thumb;
    }

    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

}
