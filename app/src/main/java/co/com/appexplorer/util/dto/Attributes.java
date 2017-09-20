
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class Attributes {

    private String height;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
