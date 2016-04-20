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
     * Test of calculateReturn method, of class FinancialCalculator. 
     * Test Case 1
     */
    @Test
    public void testCalculateReturnCase1() {
        System.out.println("calculateReturn");
        Double currentPrice = 1.00;
        Double originalPrice = 1.00;
        Double expResult = 0.00;
        Double result = SecurityCalculator.calculateReturn(currentPrice, originalPrice);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateReturn method, of class FinancialCalculator. 
     * Test Case 2
     */
    @Test
    public void testCalculateReturnCase2() {
        System.out.println("calculateReturn");
        Double currentPrice = 15.84;
        Double originalPrice = 10.56;
        Double expResult = 0.50;
        Double result = SecurityCalculator.calculateReturn(currentPrice, originalPrice);
        assertEquals(expResult, result, DELTA);

    }

    /**
     * Test of calculateReturn method, of class FinancialCalculator. 
     * Test Case 3
     */
    @Test
    public void testCalculateReturnCase3() {
        System.out.println("calculateReturn");
        Double currentPrice = 3.45;
        Double originalPrice = 6.76;
        Double expResult = -0.489644970414;
        Double result = SecurityCalculator.calculateReturn(currentPrice, originalPrice);
        assertEquals(expResult, result, DELTA);

    }

    /**
     * Test of calculateCumulativeReturn method, of class FinancialCalculator.
     * Test Case 1
     */
    @Test
    public void testCalculateCumulativeReturnCase1() {
        System.out.println("calculateCumulativeReturn");
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
        System.out.println("calculateCumulativeReturn");
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
        System.out.println("calculateCumulativeReturn");
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
        System.out.println("calculateCumulativeReturn");
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

    /**
     * Test of calculateReturn method, of class SecurityCalculator.
     */
    @Test
    public void testCalculateReturn() {
        System.out.println("calculateReturn");
        Double currentPrice = null;
        Double originalPrice = null;
        Double expResult = null;
        Double result = SecurityCalculator.calculateReturn(currentPrice, originalPrice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCumulativeReturn method, of class SecurityCalculator.
     */
    @Test
    public void testCalculateCumulativeReturn() {
        System.out.println("calculateCumulativeReturn");
        ArrayList<Double> adjustedClosingPrices = null;
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = SecurityCalculator.calculateCumulativeReturn(adjustedClosingPrices);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
