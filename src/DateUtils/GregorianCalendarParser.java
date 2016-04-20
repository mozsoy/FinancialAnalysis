package DateUtils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The GregorianCalenderParser class is a date utility class
 *
 * @author metehan
 */
public class GregorianCalendarParser {

    /**
     * Parses a date in String format yyyymmdd to a GregorianCalendar date
     *
     * @param date String representation of the date as yyyymmdd
     * @return GregorianCalendar date representation of the date
     */
    public static GregorianCalendar parseStringToGregorianCalendar(String date) {

        GregorianCalendar gregorianDate = new GregorianCalendar();
        gregorianDate.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
        gregorianDate.set(Calendar.MONTH, Integer.parseInt(date.substring(4, 6)));
        gregorianDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(6)));

        return gregorianDate;
    }
}
