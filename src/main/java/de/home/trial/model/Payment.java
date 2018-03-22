package de.home.trial.model;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    Long sum = 0L;
    List<Item> items;

    public Payment(Long sum, List<Item> items) {
        this.sum = sum;
        this.items = items;
    }

    public Payment(List<Item> items) {
        if (items == null)
            this.items = new ArrayList<>();
        else
            this.items = items;

        if (this.items.size() > 0 )
            this.sum = this.items.stream().filter(item -> !item.getDeleted()).map(item -> item.value).reduce(Long::sum).orElse(0L);
    }

    public Long getSum() {
        return sum;
    }

    public List<Item> getItems() {
        return items;
    }
}
