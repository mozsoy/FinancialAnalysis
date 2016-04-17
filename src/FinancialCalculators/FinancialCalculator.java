/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialCalculators;

import java.util.ArrayList;

/**
 *
 * @author metehan
 */
public class FinancialCalculator {

    public static Double calculateReturn(Double currentPrice, Double originalPrice) {
        return (currentPrice - originalPrice) / originalPrice;
    }

    public static ArrayList<Double> calculateCumulativeReturn(ArrayList<Double> adjustedClosingPrices) {
        ArrayList<Double> cumulativeReturn = new ArrayList<>();
        for (int i = 0; i < adjustedClosingPrices.size(); i++) {
            cumulativeReturn.add(calculateReturn(adjustedClosingPrices.get(i),
                    adjustedClosingPrices.get(0)));
        }
        return cumulativeReturn;
    }
}
