
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class Category {

    private Attributes______ attributes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Attributes______ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes______ attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object obCategory){
        Category category = (Category) obCategory;
        return this.attributes.getImId().equals(category.getAttributes().getImId());
    }

}
