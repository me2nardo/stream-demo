package org.github.stream.beta.model;

/**
 * Created by vlevash on 7/27/17.
 */
public class Feed {

    private String feedName;

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "feedName='" + feedName + '\'' +
                '}';
    }
}
