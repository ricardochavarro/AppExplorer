
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class Attributes____ {

    private String imId;
    private String imBundleId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getImBundleId() {
        return imBundleId;
    }

    public void setImBundleId(String imBundleId) {
        this.imBundleId = imBundleId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
