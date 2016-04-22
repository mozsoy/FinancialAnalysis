/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialAPIs;

import java.util.ArrayList;
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
public class YahooFinancialCSVFileDownloaderTest {

    // A YahooFinancialCSVFileDownloader object to be used in getter methods
    YahooFinancialCSVFileDownloader instanceToBeUsedInGetterTests;

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
        instanceToBeUsedInGetterTests
                = new YahooFinancialCSVFileDownloader("SPY", "20151208", "20151209");
        instanceToBeUsedInGetterTests.downloadCsvFileFromYahooFinancial();
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
        security.addOneDayToSecurity("2015-12-09", 206.190002, 208.679993,
                204.179993, 205.339996, (long) 162401500, 203.077748
        );
        security.addOneDayToSecurity("2015-12-08", 206.490005, 208.289993,
                205.779999, 206.949997, (long) 103372400, 204.670011);
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
                = new YahooFinancialCSVFileDownloader("SPY", "20151208", "20151208");
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
                = new YahooFinancialCSVFileDownloader("SPY", "20151208", "20151209");
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
                    = new YahooFinancialCSVFileDownloader("Wrong Security Name", "20151208", "20151208");
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
                    = new YahooFinancialCSVFileDownloader("SPY", "Wrong from date", "20151208");
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
                    = new YahooFinancialCSVFileDownloader("SPY", "20151208", "Wrong to date");
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
        YahooFinancialCSVFileDownloader instance
                = new YahooFinancialCSVFileDownloader("SPY", "20151208", "20151209");
        String expResult = "SPY";
        String result = instance.getNameOfSecurity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFromDate method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetFromDate() {
        YahooFinancialCSVFileDownloader instance
                = new YahooFinancialCSVFileDownloader("SPY", "20151208", "20151209");
        String expResult = "20151208";
        String result = instance.getFromDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getToDate method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetToDate() {
        YahooFinancialCSVFileDownloader instance
                = new YahooFinancialCSVFileDownloader("SPY", "20151208", "20151209");
        String expResult = "20151209";
        String result = instance.getToDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDates method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetDates() {
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("2015-12-08");
        expResult.add("2015-12-09");
        ArrayList<String> result = instanceToBeUsedInGetterTests.getDates();
        assertEquals(true, expResult.equals(result));
    }

    /**
     * Test of getOpeningPrices method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetOpeningPrices() {
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(206.490005);
        expResult.add(206.190002);
        ArrayList<Double> result = instanceToBeUsedInGetterTests.getOpeningPrices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHighestPrices method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetHighestPrices() {
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(208.289993);
        expResult.add(208.679993);
        ArrayList<Double> result = instanceToBeUsedInGetterTests.getHighestPrices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLowestPrices method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetLowestPrices() {
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(205.779999);
        expResult.add(204.179993);
        ArrayList<Double> result = instanceToBeUsedInGetterTests.getLowestPrices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClosingPrices method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetClosingPrices() {
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(206.949997);
        expResult.add(205.339996);
        ArrayList<Double> result = instanceToBeUsedInGetterTests.getClosingPrices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVolumes method, of class YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetVolumes() {
        ArrayList<Long> expResult = new ArrayList<>();
        expResult.add((long) 103372400);
        expResult.add((long) 162401500);
        ArrayList<Long> result = instanceToBeUsedInGetterTests.getVolumes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdjustedClosingPrices method, of class
     * YahooFinancialCSVFileDownloader.
     */
    @Test
    public void testGetAdjustedClosingPrices() {
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(204.670011);
        expResult.add(203.077748);
        ArrayList<Double> result = instanceToBeUsedInGetterTests.getAdjustedClosingPrices();
        assertEquals(expResult, result);
    }

}
