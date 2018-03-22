package de.home.trial.model;

import java.util.Date;

public class Item {

      Long id;
      Long contractId;
      String description;
      Long value;
      Date time;
      Boolean isImported;
      Date createdAt;
      Date updateAt;
      Boolean isDeleted;

      public Item(Long id, Long contractId, String description, Long value, Date time, Boolean isImported,
                  Date createdAt, Date updateAt, Boolean isDeleted) {
            this.id = id;
            this.contractId = contractId;
            this.description = description;
            this.value = value;
            this.time = time;
            this.isImported = isImported;
            this.createdAt = createdAt;
            this.updateAt = updateAt;
            this.isDeleted = isDeleted;
      }

      public Long getId() {
            return id;
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

      public Date getTime() {
            return time;
      }

      public Boolean getImported() {
            return isImported;
      }

      public Date getCreatedAt() {
            return createdAt;
      }

      public Date getUpdateAt() {
            return updateAt;
      }

      public Boolean getDeleted() {
            return isDeleted;
      }

      public void setDeleted(Boolean deleted) {
            isDeleted = deleted;
      }

      @Override
      public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", contractId=" + contractId +
                    ", description='" + description + '\'' +
                    ", value=" + value +
                    ", time=" + time +
                    ", isImported=" + isImported +
                    ", createdAt=" + createdAt +
                    ", updateAt=" + updateAt +
                    ", isDeleted=" + isDeleted +
                    '}';
      }
}
