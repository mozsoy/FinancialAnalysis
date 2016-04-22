/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import Securities.Security;
import java.io.FileNotFoundException;
import java.util.HashMap;
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
public class SecuritiesIniFileParserTest {

    // Good formatted ini file path
    final String goodFormattedIniFilePath
            = "C:\\Users\\metehan\\Documents\\LA Capital\\FinancialAnalysis\\config.ini";

    // Bad formatted ini file path
    final String badFormattedIniFilePath
            = "C:\\Users\\metehan\\Documents\\LA Capital\\FinancialAnalysis\\bad.ini";

    public SecuritiesIniFileParserTest() {
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
     * Test of readSecuritiesFromIniFile method, of class
     * SecuritiesIniFileParser. Test Case 1: Null INI file path
     */
    @Test
    public void testReadSecuritiesFromIniFileCase1() {
        try {
            SecuritiesIniFileParser instance = new SecuritiesIniFileParser(null);
            HashMap<String, Security> result = instance.readSecuritiesFromIniFile();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "error: empty path");
        }
    }

    /**
     * Test of readSecuritiesFromIniFile method, of class
     * SecuritiesIniFileParser. Test Case 2: Wrong INI file path
     */
    @Test
    public void testReadSecuritiesFromIniFileCase2() {
        try {
            SecuritiesIniFileParser instance = new SecuritiesIniFileParser("wrong path");
            HashMap<String, Security> result = instance.readSecuritiesFromIniFile();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "error: ini file not found at the specified path");
        }
    }

    /**
     * Test of readSecuritiesFromIniFile method, of class
     * SecuritiesIniFileParser. Test Case 3: A valid INI file path
     */
    @Test
    public void testReadSecuritiesFromIniFileCase3() {
        SecuritiesIniFileParser instance
                = new SecuritiesIniFileParser(goodFormattedIniFilePath);
        HashMap<String, Security> result = instance.readSecuritiesFromIniFile();
        HashMap<String, Security> expResult = new HashMap<>();
        expResult.put("QQQ", new Security("QQQ", "20151001", "20151209"));
        expResult.put("SPY", new Security("SPY", "20151201", "20151209"));
        expResult.put("UCO", new Security("UCO", "20151015", "20151201"));
        assertEquals(result, expResult);
    }

    /**
     * Test of readSecuritiesFromIniFile method, of class
     * SecuritiesIniFileParser. Test Case 4: Mis-formatted INI file
     */
    @Test
    public void testReadSecuritiesFromIniFileCase4() {
        try {
            SecuritiesIniFileParser instance
                    = new SecuritiesIniFileParser(badFormattedIniFilePath);
            HashMap<String, Security> result = instance.readSecuritiesFromIniFile();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "error: ini file mis-formatted");
        }
    }
}
