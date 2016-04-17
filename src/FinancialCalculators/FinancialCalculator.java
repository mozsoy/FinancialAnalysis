/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialCalculators;

/**
 *
 * @author metehan
 */
public class FinancialCalculator {

    public static Double calculateCumulativeReturn(Double currentPrice, Double originalPrice) {
        return (currentPrice - originalPrice) / originalPrice;
    }
}
