
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.Map;

public class Attributes_ {

    private String amount;
    private String currency;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
