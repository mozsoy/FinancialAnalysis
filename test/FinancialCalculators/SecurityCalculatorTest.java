package FinancialCalculators;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test class for FinancialCalculators.SecurityCalculator.java
 *
 * @author metehan
 */
public class SecurityCalculatorTest {

    // Degree to which two double numbers are accepted as equal.
    private final static double DELTA = 1e-10;

    public SecurityCalculatorTest() {
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
     * Test of calculateReturn method, of class FinancialCalculator. Test Case 1
     */
    @Test
    public void testCalculateReturnCase1() {
        double currentPrice = 1.00;
        double originalPrice = 1.00;
        double expResult = 0.00;
        double result = SecurityCalculator.calculateReturn(currentPrice, originalPrice);
        assertEquals(expResult, result, DELTA);
    }

    /**
     * Test of calculateReturn method, of class FinancialCalculator. Test Case 2
     */
    @Test
    public void testCalculateReturnCase2() {
        double currentPrice = 15.84;
        double originalPrice = 10.56;
        double expResult = 0.50;
        double result = SecurityCalculator.calculateReturn(currentPrice, originalPrice);
        assertEquals(expResult, result, DELTA);

    }

    /**
     * Test of calculateReturn method, of class FinancialCalculator. Test Case 3
     */
    @Test
    public void testCalculateReturnCase3() {
        double currentPrice = 3.45;
        double originalPrice = 6.76;
        double expResult = -0.489644970414;
        double result = SecurityCalculator.calculateReturn(currentPrice, originalPrice);
        assertEquals(expResult, result, DELTA);

    }

    /**
     * Test of calculateReturn method, of class FinancialCalculator. Test Case
     * 4: Divide by zero error case
     */
    @Test
    public void testCalculateReturnCase4() {
        try {
            double currentPrice = 3.45;
            double originalPrice = 0.00;
            double expResult = -0.489644970414;
            double result = SecurityCalculator.calculateReturn(currentPrice, originalPrice);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().equals("Security Calculator: Dividing by zero error"));
        }
    }

    /**
     * Test of calculateCumulativeReturn method, of class FinancialCalculator.
     * Test Case 1
     */
    @Test
    public void testCalculateCumulativeReturnCase1() {
        ArrayList<Double> adjustedClosingPrices = new ArrayList<>();
        adjustedClosingPrices.add(1.00);
        adjustedClosingPrices.add(1.00);
        adjustedClosingPrices.add(1.00);
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(0.00);
        expResult.add(0.00);
        expResult.add(0.00);
        ArrayList<Double> result = SecurityCalculator.calculateCumulativeReturn(adjustedClosingPrices);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCumulativeReturn method, of class FinancialCalculator.
     * Test Case 2
     */
    @Test
    public void testCalculateCumulativeReturnCase2() {
        ArrayList<Double> adjustedClosingPrices = new ArrayList<>();
        adjustedClosingPrices.add(5.00);
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(0.00);
        ArrayList<Double> result = SecurityCalculator.calculateCumulativeReturn(adjustedClosingPrices);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCumulativeReturn method, of class FinancialCalculator.
     * Test Case 3
     */
    @Test
    public void testCalculateCumulativeReturnCase3() {
        ArrayList<Double> adjustedClosingPrices = new ArrayList<>();
        adjustedClosingPrices.add(1.00);
        adjustedClosingPrices.add(2.00);
        adjustedClosingPrices.add(3.00);
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(0.00);
        expResult.add(1.00);
        expResult.add(2.00);
        ArrayList<Double> result = SecurityCalculator.calculateCumulativeReturn(adjustedClosingPrices);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCumulativeReturn method, of class FinancialCalculator.
     * Test Case 4
     */
    @Test
    public void testCalculateCumulativeReturnCase4() {
        ArrayList<Double> adjustedClosingPrices = new ArrayList<>();
        adjustedClosingPrices.add(3.00);
        adjustedClosingPrices.add(2.00);
        adjustedClosingPrices.add(1.00);
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(0.00);
        expResult.add(-0.3333333333333333);
        expResult.add(-0.6666666666666666);
        ArrayList<Double> result = SecurityCalculator.calculateCumulativeReturn(adjustedClosingPrices);
        assertEquals(expResult, result);
    }
}
