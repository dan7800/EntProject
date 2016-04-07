package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class Transaction {

    private long id;

    public Transaction(@JsonProperty("id") long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .toString();
    }
}
