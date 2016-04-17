/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialAPIs;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author metehan
 */
public class YahooFinancialSecurity {

    private ArrayList<YahooFinancialSecurityDaily> dailySecurity;
    private int numberOfDays;

    public YahooFinancialSecurity() {
        dailySecurity = new ArrayList<>();
        numberOfDays = 0;
    }

    public void addOneDayToDailySecurity(String mDate,
            Double mOpeningPrice, Double mHighestPrice,
            Double mLowestPrice, Double mClosingPrice,
            Long mVolume, Double mAdjustedClosingPrice) {

        YahooFinancialSecurityDaily newDayForThisSecurity
                = new YahooFinancialSecurityDaily(mDate, mOpeningPrice,
                        mHighestPrice, mLowestPrice, mClosingPrice,
                        mVolume, mAdjustedClosingPrice);

        getDailySecurity().add(newDayForThisSecurity);
        numberOfDays++;
    }

    /**
     * @return the dailySecurity
     */
    public ArrayList<YahooFinancialSecurityDaily> getDailySecurity() {
        return dailySecurity;
    }

    /**
     * @return the numberOfDays
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    class YahooFinancialSecurityDaily {

        private String date;
        private Double openingPrice;
        private Double highestPrice;
        private Double lowestPrice;
        private Double closingPrice;
        private Long volume;
        private Double adjustedClosingPrice;

        public YahooFinancialSecurityDaily(String mDate,
                Double mOpeningPrice, Double mHighestPrice, Double mLowestPrice,
                Double mClosingPrice, Long mVolume, Double mAdjustedClosingPrice) {

            this.date = mDate;
            this.openingPrice = mOpeningPrice;
            this.highestPrice = mHighestPrice;
            this.lowestPrice = mLowestPrice;
            this.closingPrice = mClosingPrice;
            this.volume = mVolume;
            this.adjustedClosingPrice = mAdjustedClosingPrice;

        }

        /**
         * @return the date
         */
        public String getDate() {
            return date;
        }

        /**
         * @param date the date to set
         */
        public void setDate(String date) {
            this.date = date;
        }

        /**
         * @return the openingPrice
         */
        public Double getOpeningPrice() {
            return openingPrice;
        }

        /**
         * @param openingPrice the openingPrice to set
         */
        public void setOpeningPrice(Double openingPrice) {
            this.openingPrice = openingPrice;
        }

        /**
         * @return the highestPrice
         */
        public Double getHighestPrice() {
            return highestPrice;
        }

        /**
         * @param highestPrice the highestPrice to set
         */
        public void setHighestPrice(Double highestPrice) {
            this.highestPrice = highestPrice;
        }

        /**
         * @return the lowestPrice
         */
        public Double getLowestPrice() {
            return lowestPrice;
        }

        /**
         * @param lowestPrice the lowestPrice to set
         */
        public void setLowestPrice(Double lowestPrice) {
            this.lowestPrice = lowestPrice;
        }

        /**
         * @return the closingPrice
         */
        public Double getClosingPrice() {
            return closingPrice;
        }

        /**
         * @param closingPrice the closingPrice to set
         */
        public void setClosingPrice(Double closingPrice) {
            this.closingPrice = closingPrice;
        }

        /**
         * @return the volume
         */
        public Long getVolume() {
            return volume;
        }

        /**
         * @param volume the volume to set
         */
        public void setVolume(Long volume) {
            this.volume = volume;
        }

        /**
         * @return the adjustedClosingPrice
         */
        public Double getAdjustedClosingPrice() {
            return adjustedClosingPrice;
        }

        /**
         * @param adjustedClosingPrice the adjustedClosingPrice to set
         */
        public void setAdjustedClosingPrice(Double adjustedClosingPrice) {
            this.adjustedClosingPrice = adjustedClosingPrice;
        }
    }
}
