
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class Link_ {

    private Attributes________ attributes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Attributes________ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes________ attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
