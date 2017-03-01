package com.emilrosenius.tests;

import com.emilrosenius.exercises.exception.InvalidMonthException;
import com.emilrosenius.exercises.exception.InvalidYearException;
import com.emilrosenius.exercises.exception.ReimbursementNotValidException;
import com.emilrosenius.exercises.service.DayService;
import com.emilrosenius.exercises.service.ReimbursementService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ReimbursementServiceTest {

    @Parameterized.Parameter(0)
    public double deductible;

    @Parameterized.Parameter(1)
    public double bill;

    @Parameterized.Parameter(2)
    public ReimbursementService.Facility facility;

    @Parameterized.Parameter(3)
    public double expectedResult;

    @Parameterized.Parameter(4)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Iterable<Object[]> setupTestData() {
        return Arrays.asList(new Object[][]{
                {1000, 1000, ReimbursementService.Facility.DOCTORS_OFFICE, 500, null},
                {1000, 1000, ReimbursementService.Facility.HOSPITAL, 800, null},
                {999, 1000, ReimbursementService.Facility.DOCTORS_OFFICE, 0, ReimbursementNotValidException.class},
                {999, 1000, ReimbursementService.Facility.HOSPITAL, 0, ReimbursementNotValidException.class}
        });
    }

    @Test
    public void testCalculateReimbursement() throws ReimbursementNotValidException {
        if (expectedException != null) {
            thrown.expect(expectedException);
        }

        ReimbursementService.calculateReimbursement(deductible, bill, facility);
    }
}