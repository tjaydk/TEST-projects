package testex;

import exception.InvalidTimezoneException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {

    /**
     * The Date object.
     */
    private Date date;

    /**
     * The SimpleDateFormat object.
     */
    private SimpleDateFormat simpleDateFormat;

    /**
     * Constructs the DateFormatter object.
     *
     * @param date              The Date object.
     * @param simpleDateFormat  The SimpleDateFormat object.
     */
    public DateFormatter(Date date, SimpleDateFormat simpleDateFormat) {
        this.date = date;
        this.simpleDateFormat = simpleDateFormat;
    }

    /**
     * Returns a formatted string representing NOW, adjusted to the time zone string passed in.
     *
     * @param timeZone          Must be a valid time zone as returned by:TimeZone.getAvailableIDs().
     * @return                  The timeZone String formatted like ("dd MMM yyyy hh:mm aa") and adjusted to the provided time zone.
     * @throws JokeException    If the timeZone string is not a valid string.
     */
    public String getFormattedDate(String timeZone) throws InvalidTimezoneException {
        simpleDateFormat.setTimeZone(getTimeZone(timeZone));

        return simpleDateFormat.format(date);
    }

    /**
     * Returns a TimeZone object, adjusted to the timeZone string passed in.
     *
     * @param timeZone          A valid timezone as returned by TimeZone.getAvailableIDs().
     * @return                  The TimeZone adjudsted to the provided timezone.
     * @throws JokeException    If the timeZone is invalid.
     */
    private TimeZone getTimeZone(String timeZone) throws InvalidTimezoneException {
        if (!Arrays.asList(TimeZone.getAvailableIDs()).contains(timeZone))
            throw new InvalidTimezoneException("Illegal Time Zone String");

        return TimeZone.getTimeZone(timeZone);
    }

    /**
     * Returns the internal Date object.
     *
     * @return                  The internal Date object.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the internal Date object to the Date passed in.
     *
     * @param date              The Date to set the internal Date object to.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the internal SimpleDateFormat object.
     *
     * @return                  The internal SimpleDateFormat object.
     */
    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    /**
     * Sets the internal SimpleDateFormat object to the SimpleDateFormat passed in.
     *
     * @param simpleDateFormat  The SimpleDateFormat to set the internal SimpleDateFormat to.
     */
    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }
}
