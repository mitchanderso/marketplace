package com.learning.marketplace.services;

import com.learning.marketplace.model.BankOrderResponse;
import com.learning.marketplace.model.NewOrderRequest;
import com.learning.marketplace.model.OrderStatus;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DummyBank {

    private Set<String> previouslyGeneratedIds = new HashSet<>(); // Dont want to accidentally generate the same ID twice

    public BankOrderResponse processOrderSuccessfully(NewOrderRequest newOrderRequest){
        // We dont really care what the order request is, we are only simulating a bank
        return new BankOrderResponse("ORD-" + generateRandomOrderId(), OrderStatus.SUCCESS);
    }

    public String generateRandomOrderId() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 3;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(() -> new StringBuilder(), (sb, val) -> sb.appendCodePoint(val), (sb,sb2) -> sb.append(sb2) )
                .toString();

        while (previouslyGeneratedIds.contains(generatedString)) {
            generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(() -> new StringBuilder(), (sb, val) -> sb.appendCodePoint(val), (sb,sb2) -> sb.append(sb2) )
                    .toString();
        }

        previouslyGeneratedIds.add(generatedString);

        return generatedString.toUpperCase();
    }
}
