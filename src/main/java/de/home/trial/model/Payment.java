package de.home.trial.model;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private Long sum = 0L;
    private List<Item> items;

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
            this.sum = this.items.stream().filter(item -> !item.getDeleted()).map(Item::getValue).reduce(Long::sum).orElse(0L);
    }

    public Long getSum() {
        return sum;
    }

    public List<Item> getItems() {
        return items;
    }
}
