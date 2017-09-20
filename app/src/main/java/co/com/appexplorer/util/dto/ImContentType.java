
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class ImContentType {

    private Attributes__ attributes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Attributes__ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes__ attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
