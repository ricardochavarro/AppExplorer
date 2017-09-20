
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class Link {

    private Attributes___ attributes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Attributes___ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes___ attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
