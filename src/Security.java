/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author metehan
 */
public class Security {

    private String tickerName;
    private String fromDate;
    private String toDate;

    /**
    * Constructs a Security object with the specified ticker name, from the
    * date mFromDate to date mToDate.
    * @param mTickerName the ticker name of the security.
    * @param mFromDate the starting date of the security
    * @param mToDate the ending date of the security.
    */
    public Security(String mTickerName, String mFromDate, String mToDate) {
        this.tickerName = mTickerName;
        this.fromDate = mFromDate;
        this.toDate = mToDate;
    }

    /**
     * @return the tickerName
     */
    public String getTickerName() {
        return tickerName;
    }

    /**
     * @param tickerName the tickerName to set
     */
    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }

    /**
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
