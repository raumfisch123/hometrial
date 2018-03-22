package de.home.trial;

import de.home.trial.model.Item;
import de.home.trial.model.Payment;
import de.home.trial.model.PaymentPost;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private long idCounter = 0;
    private final HashMap<Long, List<Item>> payments = new HashMap<>();

    public Payment getPayment(Long contractId, Date from, Date to) {
        if(from == null || to == null)
            return new Payment(
                    payments.get(contractId));

        List<Item> items = payments.get(contractId)
                .stream().filter(item -> item.getCreatedAt().after(from) && item.getCreatedAt().before(to)).collect(Collectors.toList());
        return new Payment(items);
    }

    public void updatePayment(Long contractId, Long itemId){

    }

    public void removePayment(Long contractId, Long itemId) {
        Optional<Item> item = payments.get(contractId)
                .stream().filter(item1 -> item1.getId().equals(itemId)).findFirst();
        item.ifPresent(item1 -> item1.setDeleted(true));
    }

    public void createItem(Long contractId, PaymentPost paymentPost) {
        Date currentDate = new Date();
        Item item = new Item(getNewItemId(), contractId, paymentPost.getDescription(), paymentPost.getValue(),
                currentDate, false, currentDate, currentDate, false);

        if (payments.get(contractId) == null)
            payments.put(contractId, new ArrayList<>());

        payments.get(contractId).add(item);
    }

    synchronized private long getNewItemId() {
        return idCounter++;
    }


}
