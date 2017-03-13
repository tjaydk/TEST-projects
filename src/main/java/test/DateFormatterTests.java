package test;

import exception.InvalidTimezoneException;
import org.junit.Test;
import testex.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateFormatterTests {

    @Test
    public void testGetFormattedDate() throws InvalidTimezoneException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 0, 1, 0, 0);

        Date date = calendar.getTime();
        String timeZone = "Europe/Copenhagen";

        DateFormatter dateFormatter = new DateFormatter(date, simpleDateFormat);


        assertThat(dateFormatter.getFormattedDate(timeZone), is("01 Jan 2017 12:00 AM"));
    }

    @Test(expected = InvalidTimezoneException.class)
    public void testGetFormattedDateException() throws InvalidTimezoneException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 0, 1, 12, 0);

        Date date = calendar.getTime();
        String timeZone = "Euwoop/Kopenhagun";

        DateFormatter dateFormatter = new DateFormatter(date, simpleDateFormat);
        dateFormatter.getFormattedDate(timeZone);

    }

}
