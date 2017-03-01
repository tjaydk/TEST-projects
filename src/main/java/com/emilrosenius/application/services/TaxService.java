package com.emilrosenius.application.services;

import com.emilrosenius.application.exceptions.NegativeTaxAmountException;

public class TaxService {

    public static double calculateTax(double amount) throws NegativeTaxAmountException {

        double tax = 0;

        if (amount < 0) {
            throw new NegativeTaxAmountException("Tax amount must be positive");
        }

        if (amount >= 25000) {
            tax = amount * 0.21;
        }

        if (amount >= 90000) {
            tax *= 1.10;
        }

        if (amount >= 200000) {
            tax *= 1.06;
        }

        if (amount >= 330000) {
            tax *= 1.06;
        }

        if (amount >= 450000) {
            tax *= 1.09;
        }

        return Math.round(tax * 100.0) / 100.0;

    }

}
