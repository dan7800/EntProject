package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Just a basic POJO to represent the body of a request to the /payroll endpoint.
 */
public class PayrollRequest {

    private double pay;
    private String description;

    public PayrollRequest(@JsonProperty("pay") double pay,
                          @JsonProperty("description") String description) {
        this.pay = pay;
        this.description = description;
    }

    public double getPay() {
        return pay;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("pay", pay)
                .add("description", description)
                .toString();
    }
}
