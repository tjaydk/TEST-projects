package test;

import exception.InvalidTimezoneException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testex.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class DateFormatterTests {

    @Parameterized.Parameter(0)
    public String timeZone;

    @Parameterized.Parameter(1)
    public String expectedResult;

    @Parameterized.Parameter(2)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Iterable<Object> setupTestData() {
        return Arrays.asList(new Object[][]{
                {"Europe/Copenhagen", "01 Jan 2017 12:00 AM", null},
                {"Europe/London", "31 Dec 2016 11:00 PM", null},
                {"Europe/Invalid", "01 Jan 2017 12:00 AM", InvalidTimezoneException.class}
        });
    }

    @Test
    public void testGetFormattedDate() throws InvalidTimezoneException {

        if (expectedException != null) {
            thrown.expect(expectedException);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 0, 1, 0, 0);
        Date date = calendar.getTime();

        DateFormatter dateFormatter = new DateFormatter(date, simpleDateFormat);
        assertThat(dateFormatter.getFormattedDate(timeZone), is(expectedResult));
    }
}
