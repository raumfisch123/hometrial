package de.home.trial.model;

public class PaymentPost {

    Long contractId;
    String description;
    Long value;

    public PaymentPost(Long contractId, String description, Long value) {
        this.contractId = contractId;
        this.description = description;
        this.value = value;
    }

    public Long getContractId() {
        return contractId;
    }

    public String getDescription() {
        return description;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PaymentPost{" +
                "contractId=" + contractId +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
