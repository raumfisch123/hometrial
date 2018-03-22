package de.home.trial;

import de.home.trial.model.Payment;
import de.home.trial.model.PaymentPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PaymentController {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;


    @GetMapping("payments/{id}")
    public Payment findFromTo(
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "from",  required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
            @RequestParam(value = "to", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date to) {

        return paymentService.getPayment(id, from, to);
    }

    @PostMapping("payments/{contractId}")
    public Payment item(@PathVariable("contractId") long contractId, @RequestBody PaymentPost paymentPost) {
        paymentService.createItem(contractId, paymentPost);
        return paymentService.getPayment(contractId, null, null);
    }

    @DeleteMapping("payments/{contractId}/{id}")
    public Payment item(@PathVariable("contractId") long contractId, @PathVariable("id") long id) {
        paymentService.removePayment(contractId, id);
        return paymentService.getPayment(contractId, null, null);
    }

    @PatchMapping("payments/{contractId}/{id}")
    public Payment item(@PathVariable("contractId") long contractId, @PathVariable("id") long id, @RequestBody PaymentPost paymentPost) {
        paymentService.updatePayment(contractId, id, paymentPost);
        return paymentService.getPayment(contractId, null, null);
    }


}
