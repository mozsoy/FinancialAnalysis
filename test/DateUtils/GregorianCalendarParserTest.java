/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateUtils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author metehan
 */
public class GregorianCalendarParserTest {

    public GregorianCalendarParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parseStringToGregorianCalendar method, of class
     * GregorianCalendarParser. Test Case 1: Invalid date
     */
    @Test
    public void testParseStringToGregorianCalendarCase1() {
        try {
            String date = "20151310"; // Invalid month = 13
            GregorianCalendar result = GregorianCalendarParser.parseStringToGregorianCalendar(date);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "error: illegal date");
        }
    }

    /**
     * Test of parseStringToGregorianCalendar method, of class
     * GregorianCalendarParser. Test Case 2: Valid date
     */
    @Test
    public void testParseStringToGregorianCalendarCase2() {
        String date = "20151210"; // Invalid month = 13
        GregorianCalendar result = GregorianCalendarParser.parseStringToGregorianCalendar(date);
        assertEquals(result.get(Calendar.YEAR), 2015);
        assertEquals(result.get(Calendar.MONTH), 11);
        assertEquals(result.get(Calendar.DAY_OF_MONTH), 10);
    }
}
