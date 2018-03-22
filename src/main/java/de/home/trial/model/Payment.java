package de.home.trial.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            this.sum = this.items.stream().filter(item -> !item.getDeleted()).map(item -> item.value).reduce(Long::sum).get();
    }

    public void addItem(Item item) {
        this.sum += item.value;
        this.items.add(item);
    }

    public void removeItem(Long id) {
        Optional<Item> itemToRemove = this.items.stream().filter(item -> item.id.equals(id)).findFirst();
        Item item = itemToRemove.get();
        this.sum = this.sum - item.value;
        items.remove(itemToRemove.get());
    }

    public Long getSum() {
        return sum;
    }

    public List<Item> getItems() {
        return items;
    }
}
