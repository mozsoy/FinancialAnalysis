package FinancialAPIs;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;

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
            Double mOpeningPrice, Double mHighestPrice,
            Double mLowestPrice, Double mClosingPrice,
            Long mVolume, Double mAdjustedClosingPrice) {

        // Construct a YahooFinancialSecurityDaily object
        YahooFinancialSecurityDaily newDayForThisSecurity
                = new YahooFinancialSecurityDaily(mDate, mOpeningPrice,
                        mHighestPrice, mLowestPrice, mClosingPrice,
                        mVolume, mAdjustedClosingPrice);
        dailySecurityReports.add(newDayForThisSecurity);
        numberOfDays++;
    }

    /**
     * @return the dailySecurityReports
     */
    public ArrayList<YahooFinancialSecurityDaily> getDailySecurityReports() {
        return dailySecurityReports;
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
            if (this.dailySecurityReports.get(i).equals(newSecurity.getDailySecurityReports().get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Implements one day report of a security
     */
    class YahooFinancialSecurityDaily {

        private String date;
        private Double openingPrice;
        private Double highestPrice;
        private Double lowestPrice;
        private Double closingPrice;
        private Long volume;
        private Double adjustedClosingPrice;

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
            if (!Objects.equals(this.openingPrice, newSecurityDaily.openingPrice)) {
                return false;
            }
            if (!Objects.equals(this.highestPrice, newSecurityDaily.highestPrice)) {
                return false;
            }
            if (!Objects.equals(this.lowestPrice, newSecurityDaily.lowestPrice)) {
                return false;
            }
            if (!Objects.equals(this.closingPrice, newSecurityDaily.closingPrice)) {
                return false;
            }
            if (!Objects.equals(this.volume, newSecurityDaily.volume)) {
                return false;
            }
            if (!Objects.equals(this.adjustedClosingPrice, newSecurityDaily.adjustedClosingPrice)) {
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
