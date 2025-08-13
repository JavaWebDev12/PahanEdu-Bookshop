package com.pahana.edu.bookshop.service;

public class BillingService {
    public static double calculateAmount(int unitsConsumed) {
        // Tiered rate example
        int remaining = unitsConsumed;
        double amount = 0.0;
        int tier1 = Math.min(remaining, 100);
        amount += tier1 * 10.0; // first 100 units at 10.0
        remaining -= tier1;
        if (remaining > 0) {
            int tier2 = Math.min(remaining, 100);
            amount += tier2 * 8.0; // next 100 units at 8.0
            remaining -= tier2;
        }
        if (remaining > 0) {
            amount += remaining * 5.0; // rest at 5.0
        }
        return amount;
    }
}

