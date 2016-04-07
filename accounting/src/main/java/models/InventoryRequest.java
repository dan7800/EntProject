package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Just a basic POJO to represent the body of a request to the /inventory endpoint.
 */
public class InventoryRequest {

    private double costOfGoods;
    private String description;

    public InventoryRequest(@JsonProperty("costOfGoods") double costOfGoods,
                             @JsonProperty("description") String description) {
        this.costOfGoods = costOfGoods;
        this.description = description;
    }

    public double getCostOfGoods() {
        return costOfGoods;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("pay", costOfGoods)
                .add("description", description)
                .toString();
    }
}
