package FinancialAPIs;

import java.util.ArrayList;
import java.util.GregorianCalendar;

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
    public void addOneDayToDailySecurity(String mDate,
            Double mOpeningPrice, Double mHighestPrice,
            Double mLowestPrice, Double mClosingPrice,
            Long mVolume, Double mAdjustedClosingPrice) {

        // Construct a YahooFinancialSecurityDaily object
        YahooFinancialSecurityDaily newDayForThisSecurity
                = new YahooFinancialSecurityDaily(mDate, mOpeningPrice,
                        mHighestPrice, mLowestPrice, mClosingPrice,
                        mVolume, mAdjustedClosingPrice);

        getDailySecurityReports().add(newDayForThisSecurity);
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
