package com.emilrosenius.test;

import com.emilrosenius.application.exceptions.NegativeTaxAmountException;
import com.emilrosenius.application.services.TaxService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TaxServiceTest {

    @Parameterized.Parameter(0)
    public double amount;

    @Parameterized.Parameter(1)
    public double expectedResult;

    @Parameterized.Parameter(2)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Iterable<Object[]> setupTestData() {
        return Arrays.asList(new Object[][]{
                // Test non positive number
                {-1, 0, NegativeTaxAmountException.class},
                {0, 0, null},
                {24999, 0, null},
                {25000, 5250, null},
                {89999, 18899.79, null},
                {90000, 20790, null},
                {199999, 46199.77, null},
                {200000, 48972, null},
                {329999, 80803.56, null},
                {330000, 85652.03, null},
                {449999, 116797.96, null},
                {450000, 127310.06, null},
        });
    }

    @Test
    public void testCalculateTax() throws NegativeTaxAmountException {
        if (expectedException != null) {
            thrown.expect(expectedException);
        }

        Assert.assertEquals(TaxService.calculateTax(amount), expectedResult, 0.00);
    }
}
