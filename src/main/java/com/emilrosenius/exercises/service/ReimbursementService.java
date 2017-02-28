package com.emilrosenius.exercises.service;

import com.emilrosenius.exercises.exception.ReimbursementNotValidException;

public class ReimbursementService {

    public enum Facility {
        DOCTORS_OFFICE, HOSPITAL
    }

    public static double calculateReimbursement(double deductible, double bill, Facility facility) throws ReimbursementNotValidException {

        if (deductible < 1000) {
            throw new ReimbursementNotValidException("The deductible has not been met");
        }

        if (facility == Facility.DOCTORS_OFFICE) {
            return bill * 0.5;
        } else {
            return bill * 0.8;
        }
    }
}
