package Securities;

/**
 * The Security class implements a security as a financial instrument
 * .
 * @author metehan
 */
public class Security {

    private String name;
    private String fromDate;
    private String toDate;

    /**
     * Constructs a Security object
     *
     * @param mName the name of the security.
     * @param mFromDate the starting date of the security
     * @param mToDate the ending date of the security.
     */
    public Security(String mName, String mFromDate, String mToDate) {
        this.name = mName;
        this.fromDate = mFromDate;
        this.toDate = mToDate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     *
     * @return a string representation of this security
     */
    @Override
    public String toString() {
        String securityAsString = "Name of Security: " + this.name
                + "\nFrom Date: " + this.fromDate
                + "\nTo Date: " + this.toDate;
        return securityAsString;
    }
}
