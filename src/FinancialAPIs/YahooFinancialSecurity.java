package FinancialAPIs;

import java.util.ArrayList;

/**
 * The YahooFinancialSecurity class implements a security class with the
 * features as in Yahoo Financial Web Site. The features of a
 * YahooFinancialSecurity are date, opening price, highest price, lowest price,
 * closing price, volume, and adjusted closing price.
 *
 * @author metehan
 */
public class YahooFinancialSecurity {

    // An ArrayList of daily reports of this security
    private ArrayList<YahooFinancialSecurityDaily> dailySecurityReports;
    // Total number of days in the report of this security
    private int numberOfDays;

    /**
     * Constructs a YahooFinancialSecurity object.
     */
    public YahooFinancialSecurity() {
        dailySecurityReports = new ArrayList<>();
        numberOfDays = 0;
    }

    /**
     * Adds the report of a new day to the list of dailySecurityReports
     *
     * @param mDate
     * @param mOpeningPrice
     * @param mHighestPrice
     * @param mLowestPrice
     * @param mClosingPrice
     * @param mVolume
     * @param mAdjustedClosingPrice
     */
    public void addOneDayToSecurity(String mDate,
            double mOpeningPrice, double mHighestPrice,
            double mLowestPrice, double mClosingPrice,
            long mVolume, double mAdjustedClosingPrice) {

        // Construct a YahooFinancialSecurityDaily object
        YahooFinancialSecurityDaily newDayForThisSecurity
                = new YahooFinancialSecurityDaily(mDate, mOpeningPrice,
                        mHighestPrice, mLowestPrice, mClosingPrice,
                        mVolume, mAdjustedClosingPrice);
        dailySecurityReports.add(0, newDayForThisSecurity);
        numberOfDays++;
    }

    /**
     * @return the numberOfDays
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Compares two YahooFinancialSecurity objects
     *
     * @param obj to be compared
     * @return a boolean result of the comparison
     */
    @Override
    public boolean equals(Object obj) {
        if (!YahooFinancialSecurity.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        YahooFinancialSecurity newSecurity = (YahooFinancialSecurity) obj;
        for (int i = 0; i < this.getNumberOfDays(); i++) {
            if (this.dailySecurityReports.get(i).equals(newSecurity.dailySecurityReports.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Implements one day report of a security
     */
    private class YahooFinancialSecurityDaily {

        private String date;
        private double openingPrice;
        private double highestPrice;
        private double lowestPrice;
        private double closingPrice;
        private long volume;
        private double adjustedClosingPrice;

        /**
         * Constructs a YahooFinancialSecurityDaily object
         *
         * @param mDate
         * @param mOpeningPrice
         * @param mHighestPrice
         * @param mLowestPrice
         * @param mClosingPrice
         * @param mVolume
         * @param mAdjustedClosingPrice
         */
        public YahooFinancialSecurityDaily(String mDate,
                double mOpeningPrice, double mHighestPrice, double mLowestPrice,
                double mClosingPrice, long mVolume, double mAdjustedClosingPrice) {

            this.date = mDate;
            this.openingPrice = mOpeningPrice;
            this.highestPrice = mHighestPrice;
            this.lowestPrice = mLowestPrice;
            this.closingPrice = mClosingPrice;
            this.volume = mVolume;
            this.adjustedClosingPrice = mAdjustedClosingPrice;

        }

        /**
         * Compares two YahooFinancialSecurityDaily objects
         *
         * @param obj to be compared
         * @return a boolean result of the comparison
         */
        @Override
        public boolean equals(Object obj) {
            if (!YahooFinancialSecurityDaily.class.isAssignableFrom(obj.getClass())) {
                return false;
            }
            YahooFinancialSecurityDaily newSecurityDaily = (YahooFinancialSecurityDaily) obj;
            if (this.date == null ? newSecurityDaily.date != null : !this.date.equals(newSecurityDaily.date)) {
                return false;
            }
            if (this.openingPrice != newSecurityDaily.openingPrice) {
                return false;
            }
            if (this.highestPrice != newSecurityDaily.highestPrice) {
                return false;
            }
            if (this.lowestPrice != newSecurityDaily.lowestPrice) {
                return false;
            }
            if (this.closingPrice != newSecurityDaily.closingPrice) {
                return false;
            }
            if (this.volume != newSecurityDaily.volume) {
                return false;
            }
            if (this.adjustedClosingPrice != newSecurityDaily.adjustedClosingPrice) {
                return false;
            }
            return true;
        }

        /**
         * @return the date
         */
        public String getDate() {
            return date;
        }

        /**
         * @return the openingPrice
         */
        public Double getOpeningPrice() {
            return openingPrice;
        }

        /**
         * @return the highestPrice
         */
        public Double getHighestPrice() {
            return highestPrice;
        }

        /**
         * @return the lowestPrice
         */
        public Double getLowestPrice() {
            return lowestPrice;
        }

        /**
         * @return the closingPrice
         */
        public Double getClosingPrice() {
            return closingPrice;
        }

        /**
         * @return the volume
         */
        public Long getVolume() {
            return volume;
        }

        /**
         * @return the adjustedClosingPrice
         */
        public Double getAdjustedClosingPrice() {
            return adjustedClosingPrice;
        }
    }
}
