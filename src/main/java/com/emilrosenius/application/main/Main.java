package com.emilrosenius.application.main;

import com.emilrosenius.application.exceptions.NegativeTaxAmountException;
import com.emilrosenius.application.services.TaxService;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(TaxService.calculateTax(89999));
        } catch (NegativeTaxAmountException e) {
            System.out.println(e.getMessage());
        }
    }

}
