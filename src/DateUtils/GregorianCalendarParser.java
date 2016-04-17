/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateUtils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author metehan
 */
public class GregorianCalendarParser {
    
    public static GregorianCalendar parseStringToGregorianCalendar(String date) {
        
        GregorianCalendar gregorianDate = new GregorianCalendar();
        gregorianDate.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
        gregorianDate.set(Calendar.MONTH, Integer.parseInt(date.substring(4, 6)));
        gregorianDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(6)));
        
        return gregorianDate;
    }
}
