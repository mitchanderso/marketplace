package com.learning.marketplace.bank;

import com.learning.marketplace.paymentgateway.model.BankOrderResponse;
import com.learning.marketplace.paymentgateway.model.NewOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    DummyBank dummyBank;

    public BankController() {
        this.dummyBank = new DummyBank();
    }

    @PostMapping("/executeOrder")
    public ResponseEntity<BankOrderResponse> executeOrder(@RequestBody NewOrderRequest newOrderRequest) {
        return ResponseEntity.ok(dummyBank.processOrderSuccessfully(newOrderRequest));
    }
}
