
package model.basket;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dateadd",
    "price",
    "quantity",
    "datechange"
})
public class Success {

    @JsonProperty("dateadd")
    private String dateadd;
    @JsonProperty("price")
    private String price;
    @JsonProperty("quantity")
    private String quantity;
    @JsonProperty("datechange")
    private String datechange;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("dateadd")
    public String getDateadd() {
        return dateadd;
    }

    @JsonProperty("dateadd")
    public void setDateadd(String dateadd) {
        this.dateadd = dateadd;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("quantity")
    public String getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("datechange")
    public String getDatechange() {
        return datechange;
    }

    @JsonProperty("datechange")
    public void setDatechange(String datechange) {
        this.datechange = datechange;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dateadd", dateadd).append("price", price).append("quantity", quantity).append("datechange", datechange).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(datechange).append(price).append(additionalProperties).append(quantity).append(dateadd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Success)) {
            return false;
        }
        Success rhs = ((Success) other);
        return new EqualsBuilder().append(datechange, rhs.datechange).append(price, rhs.price).append(additionalProperties, rhs.additionalProperties).append(quantity, rhs.quantity).append(dateadd, rhs.dateadd).isEquals();
    }

}
