
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class Example {

    private Feed feed;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
