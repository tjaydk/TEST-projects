package com.emilrosenius.exercises.service;

import com.emilrosenius.exercises.exception.InvalidMonthException;
import com.emilrosenius.exercises.exception.InvalidYearException;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DayService {

    public static int getNumDaysInMonth(int month, int year) throws InvalidMonthException, InvalidYearException {

        if (month < 1 || month > 12) {
            throw new InvalidMonthException("");
        }

        if (year < 0 || year > Integer.MAX_VALUE) {
            throw new InvalidYearException("");
        }

        Calendar calendar = new GregorianCalendar(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
