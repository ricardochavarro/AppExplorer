
package co.com.appexplorer.util.dto;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Attributes______ {

    @SerializedName("im:id")
    private String imId;

    private String term;
    private String scheme;
    private String label;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
