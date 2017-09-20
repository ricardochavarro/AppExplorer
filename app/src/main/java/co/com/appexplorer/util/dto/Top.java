package co.com.appexplorer.util.dto;

/**
 * Created by ricardo.chavarro on 19/09/2017.
 */

public final class Top {
    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    private Feed feed;

    public Top(Feed feed){
        this.feed = feed;
    }
}