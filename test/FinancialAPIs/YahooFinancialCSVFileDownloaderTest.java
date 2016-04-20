/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialAPIs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author metehan
 */
public class YahooFinancialCSVFileDownloaderTest {

    public YahooFinancialCSVFileDownloaderTest() {
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
     * Creates a mock YahooFinancialSecurity object for testing
     *
     * @return a YahooFinancialSecurity object consisting one day
     */
    public YahooFinancialSecurity mock1YahooFinancialSecurity() {
        YahooFinancialSecurity security = new YahooFinancialSecurity();
        security.addOneDayToSecurity("2015-12-08", 206.490005, 208.289993,
                205.779999, 206.949997, (long) 103372400, 204.670011);

        return security;
    }

    /**
     * Creates a mock YahooFinancialSecurity object for testing
     *
     * @return a YahooFinancialSecurity object consisting two days
     */
    public YahooFinancialSecurity mock2YahooFinancialSecurity() {
        YahooFinancialSecurity security = new YahooFinancialSecurity();
        security.addOneDayToSecurity("2015-12-08", 206.490005, 208.289993,
                205.779999, 206.949997, (long) 103372400, 204.670011);
        security.addOneDayToSecurity("2015-12-09", 206.190002, 208.679993,
                204.179993, 205.339996, (long) 162401500, 203.077748
        );
        return security;
    }

    /**
     * Test of downloadCsvFileFromYahooFinancial method, of class
     * YahooFinancialCSVFileDownloader. Test Case 1: One day report of a valid
     * security
     */
    @Test
    public void testDownloadCsvFileFromYahooFinancialCase1() {
        YahooFinancialCSVFileDownloader instance
                = new YahooFinancialCSVFileDownloader("SPY", "20151108", "20151108");
        YahooFinancialSecurity expResult = mock1YahooFinancialSecurity();
        YahooFinancialSecurity result = instance.downloadCsvFileFromYahooFinancial();
        assertEquals(true, expResult.equals(result));
    }

    /**
     * Test of downloadCsvFileFromYahooFinancial method, of class
     * YahooFinancialCSVFileDownloader. Test Case 2: Two day report of a valid
     * security
     */
    @Test
    public void testDownloadCsvFileFromYahooFinancialCase2() {
        YahooFinancialCSVFileDownloader instance
                = new YahooFinancialCSVFileDownloader("SPY", "20151108", "20151109");
        YahooFinancialSecurity expResult = mock2YahooFinancialSecurity();
        YahooFinancialSecurity result = instance.downloadCsvFileFromYahooFinancial();
        assertEquals(true, expResult.equals(result));
    }

    /**
     * Test of downloadCsvFileFromYahooFinancial method, of class
     * YahooFinancialCSVFileDownloader. Test Case 3: Invalid security name,
     * valid fromDate, valid toDate
     */
    @Test
    public void testDownloadCsvFileFromYahooFinancialCase3() {
        try {
            YahooFinancialCSVFileDownloader instance
                    = new YahooFinancialCSVFileDownloader("Wrong Security Name", "20151108", "20151108");
            YahooFinancialSecurity result = instance.downloadCsvFileFromYahooFinancial();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Yahoo Financial: CSV File not found error");
        }

    }

    /**
     * Test of downloadCsvFileFromYahooFinancial method, of class
     * YahooFinancialCSVFileDownloader. Test Case 4: Valid security name,
     * invalid fromDate, valid toDate
     */
    @Test
    public void testDownloadCsvFileFromYahooFinancialCase4() {
        try {
            YahooFinancialCSVFileDownloader instance
                    = new YahooFinancialCSVFileDownloader("SPY", "Wrong from date", "20151108");
            YahooFinancialSecurity result = instance.downloadCsvFileFromYahooFinancial();
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    /**
     * Test of downloadCsvFileFromYahooFinancial method, of class
     * YahooFinancialCSVFileDownloader. Test Case 5: Valid security name, valid
     * fromDate, invalid toDate
     */
    @Test
    public void testDownloadCsvFileFromYahooFinancialCase5() {
        try {
            YahooFinancialCSVFileDownloader instance
                    = new YahooFinancialCSVFileDownloader("SPY", "20151108", "Wrong to date");
            YahooFinancialSecurity result = instance.downloadCsvFileFromYahooFinancial();
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    /**
     * Test of getNameOfSecurity method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetNameOfSecurityCase1() {
        YahooFinancialCSVFileDownloader instance = null;
        String expResult = "";
        String result = instance.getNameOfSecurity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFromDate method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetFromDate() {
        System.out.println("getFromDate");
        YahooFinancialCSVFileDownloader instance = null;
        String expResult = "";
        String result = instance.getFromDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getToDate method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetToDate() {
        System.out.println("getToDate");
        YahooFinancialCSVFileDownloader instance = null;
        String expResult = "";
        String result = instance.getToDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDates method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetDates() {
        System.out.println("getDates");
        YahooFinancialCSVFileDownloader instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getDates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpeningPrices method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetOpeningPrices() {
        System.out.println("getOpeningPrices");
        YahooFinancialCSVFileDownloader instance = null;
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getOpeningPrices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighestPrices method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetHighestPrices() {
        System.out.println("getHighestPrices");
        YahooFinancialCSVFileDownloader instance = null;
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getHighestPrices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLowestPrices method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetLowestPrices() {
        System.out.println("getLowestPrices");
        YahooFinancialCSVFileDownloader instance = null;
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getLowestPrices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClosingPrices method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetClosingPrices() {
        System.out.println("getClosingPrices");
        YahooFinancialCSVFileDownloader instance = null;
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getClosingPrices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolumes method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetVolumes() {
        System.out.println("getVolumes");
        YahooFinancialCSVFileDownloader instance = null;
        ArrayList<Long> expResult = null;
        ArrayList<Long> result = instance.getVolumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdjustedClosingPrices method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetAdjustedClosingPrices() {
        System.out.println("getAdjustedClosingPrices");
        YahooFinancialCSVFileDownloader instance = null;
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getAdjustedClosingPrices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
