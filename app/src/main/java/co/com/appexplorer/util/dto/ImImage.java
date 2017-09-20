
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class ImImage {

    private String label;
    private Attributes attributes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
