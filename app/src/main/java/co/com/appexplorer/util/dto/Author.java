
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class Author {

    private Name name;
    private Uri uri;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
