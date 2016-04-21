package FinancialCalculators;

import java.util.ArrayList;

/**
 * The SecurityCalculator class is a financial calculator class consisting of
 * static methods
 *
 * @author metehan
 */
public class SecurityCalculator {

    /**
     * Calculates the return of the security
     *
     * @param currentPrice current price of the security
     * @param originalPrice original price of the security
     * @return return of the security
     */
    public static double calculateReturn(double currentPrice, double originalPrice) {
        if (originalPrice == 0.00) {
            throw new ArithmeticException("Security Calculator: Dividing by zero error");
        }
        return (currentPrice - originalPrice) / originalPrice;
    }

    /**
     * Calculates the cumulative return of the security
     *
     * @param adjustedClosingPrices an ArrayList of adjusted closing prices
     * @return cumulative return of the security
     */
    public static ArrayList<Double> calculateCumulativeReturn(ArrayList<Double> adjustedClosingPrices) {
        ArrayList<Double> cumulativeReturn = new ArrayList<>();
        for (int i = 0; i < adjustedClosingPrices.size(); i++) {
            cumulativeReturn.add(calculateReturn(adjustedClosingPrices.get(i),
                    adjustedClosingPrices.get(0)));
        }
        return cumulativeReturn;
    }
}
