package util;

import exception.InvalidTimezoneException;

import java.util.TimeZone;

public interface IDateFormatter {

    String getFormattedDate(String timeZone) throws InvalidTimezoneException;

    TimeZone getTimeZone(String timeZone) throws InvalidTimezoneException;

}
