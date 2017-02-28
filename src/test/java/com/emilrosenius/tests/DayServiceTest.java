package com.emilrosenius.tests;


import com.emilrosenius.exercises.exception.InvalidMonthException;
import com.emilrosenius.exercises.exception.InvalidYearException;
import com.emilrosenius.exercises.service.DayService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class DayServiceTest {

    @Parameterized.Parameter(0)
    public int month;

    @Parameterized.Parameter(1)
    public int year;

    @Parameterized.Parameter(2)
    public int expectedResult;

    @Parameterized.Parameter(3)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Iterable<Object[]> setupTestData() {
        return Arrays.asList(new Object[][]{

                // Month - Invalid equivalences
                {0, 2017, -1, InvalidMonthException.class},
                {13, 2017, -1, InvalidMonthException.class},

                // Year - Invalid equivalences
                {1, -1, -1, InvalidYearException.class},
                {1, Integer.MAX_VALUE + 1, -1, InvalidYearException.class},

                // Equivalence classes
                {1, 2019, 31, null},
                {1, 2020, 31, null},
                {2, 2019, 28, null},
                {2, 2020, 29, null},
                {3, 2019, 31, null},
                {3, 2020, 31, null},
                {4, 2019, 30, null},
                {4, 2020, 30, null},
                {5, 2019, 31, null},
                {5, 2020, 31, null},
                {6, 2019, 30, null},
                {6, 2020, 30, null},
                {7, 2019, 31, null},
                {7, 2020, 31, null},
                {8, 2019, 31, null},
                {8, 2020, 31, null},
                {9, 2019, 30, null},
                {9, 2020, 30, null},
                {10, 2019, 31, null},
                {10, 2020, 31, null},
                {11, 2019, 30, null},
                {11, 2020, 30, null},
                {12, 2019, 31, null},
                {12, 2020, 31, null},

                // Boundary values
                {2, 400, 29, null},
                {2, 500, 28, null},
                {2, 800, 29, null},
                {2, 900, 28, null},
                {2, 4, 28, null},
                {2, 5, 29, null}
        });
    }

    @Test
    public void testGetNumDaysInMonth() throws InvalidYearException, InvalidMonthException {
        if (expectedException != null) {
            thrown.expect(expectedException);
        }

        DayService.getNumDaysInMonth(month, year);
    }
}