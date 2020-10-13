package com.learning.marketplace.paymentgateway.utils;

public class OrderUtils {
    public static String obfuscateCardNumber(String cardNumber) {
        String lastThreeDigits = cardNumber.substring(cardNumber.length() - 3);
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(lastThreeDigits);
        return sb.toString();
    }
}
