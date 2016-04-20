package FinancialAPIs;

import DateUtils.GregorianCalendarParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The YahooFinancialCSVFileDownloader class downloads a csv file from Yahoo
 * Financial Web Site consisting of the information regarding a security between
 * the dates specified. The csv file contains the following information of the
 * security: Name of The Security, Starting Date, Ending Date, Opening Prices,
 * Highest Prices, Lowest Prices, Closing Prices, Volumes and Adjusted Closing
 * Prices.
 *
 * @author metehan
 */
public class YahooFinancialCSVFileDownloader {

    private String nameOfSecurity;
    private String fromDate;
    private String toDate;
    private ArrayList<String> dates;
    private ArrayList<Double> openingPrices;
    private ArrayList<Double> highestPrices;
    private ArrayList<Double> lowestPrices;
    private ArrayList<Double> closingPrices;
    private ArrayList<Long> volumes;
    private ArrayList<Double> adjustedClosingPrices;

    /**
     * Constructs a YahooFinancialCSVFileDownloader object
     *
     * @param mNameOfSecurity name of the security
     * @param mFromDate starting date
     * @param mToDate ending date
     */
    public YahooFinancialCSVFileDownloader(String mNameOfSecurity, String mFromDate, String mToDate) {
        this.nameOfSecurity = mNameOfSecurity;
        this.fromDate = mFromDate;
        this.toDate = mToDate;

        this.dates = new ArrayList<>();
        this.openingPrices = new ArrayList<>();
        this.highestPrices = new ArrayList<>();
        this.lowestPrices = new ArrayList<>();
        this.closingPrices = new ArrayList<>();
        this.volumes = new ArrayList<>();
        this.adjustedClosingPrices = new ArrayList<>();
    }

    /**
     * Prepares a string representation of the url that downloads the csv file
     *
     * @return a string representation of the url that downloads the csv file
     */
    private String prepareDownloadUrl() {

        GregorianCalendar gregorianFromDate = GregorianCalendarParser
                .parseStringToGregorianCalendar(this.getFromDate());
        GregorianCalendar gregorianToDate = GregorianCalendarParser
                .parseStringToGregorianCalendar(this.getToDate());

        String url = "http://ichart.finance.yahoo.com/table.csv?"
                + "s=" + getNameOfSecurity()
                + "&a=" + gregorianFromDate.get(Calendar.MONTH)
                + "&b=" + gregorianFromDate.get(Calendar.DAY_OF_MONTH)
                + "&c=" + gregorianFromDate.get(Calendar.YEAR)
                + "&d=" + gregorianToDate.get(Calendar.MONTH)
                + "&e=" + gregorianToDate.get(Calendar.DAY_OF_MONTH)
                + "&f=" + gregorianToDate.get(Calendar.YEAR)
                + "&g=d"
                + "ignore=.csv";
        return url;
    }

    /**
     * Downloads the CSV file
     *
     * @return a YahooFinancialSecurity object
     */
    public YahooFinancialSecurity downloadCsvFileFromYahooFinancial() {

        YahooFinancialSecurity securityReport = new YahooFinancialSecurity();
        String downloadUrlAsString = prepareDownloadUrl();
        try {
            URL urlForDownloadCsvFile = new URL(downloadUrlAsString);
            URLConnection connectionForCsvFileDownload
                    = urlForDownloadCsvFile.openConnection();
            InputStream csvFileInputStream
                    = connectionForCsvFileDownload.getInputStream();
            Scanner csvFileScanner = new Scanner(csvFileInputStream);

            csvFileScanner.nextLine(); // read header line

            while (csvFileScanner.hasNext()) { //read next line in the csv file
                String line = csvFileScanner.nextLine();
                String[] fieldsInThisLine = line.split(",");
                String date = fieldsInThisLine[0];
                this.dates.add(date);
                Double openingPrice = Double.parseDouble(fieldsInThisLine[1]);
                this.openingPrices.add(openingPrice);
                Double highestPrice = Double.parseDouble(fieldsInThisLine[2]);
                this.highestPrices.add(highestPrice);
                Double lowestPrice = Double.parseDouble(fieldsInThisLine[3]);
                this.lowestPrices.add(lowestPrice);
                Double closingPrice = Double.parseDouble(fieldsInThisLine[4]);
                this.closingPrices.add(closingPrice);
                Long volume = Long.parseLong(fieldsInThisLine[5]);
                this.volumes.add(volume);
                Double adjustedClosingPrice = Double.parseDouble(fieldsInThisLine[6]);
                this.adjustedClosingPrices.add(adjustedClosingPrice);
                securityReport.addOneDayToSecurity(date, openingPrice,
                        highestPrice, lowestPrice, closingPrice,
                        volume, adjustedClosingPrice);
            }

        } catch (MalformedURLException ex) {
            System.out.println("Yahoo Financial: Malformed URL Error");
        } catch (IOException ex) {
            System.out.println("Yahoo Financial: CSV File not found error");
        }
        return securityReport;
    }

    /**
     * @return the nameOfSecurity
     */
    public String getNameOfSecurity() {
        return nameOfSecurity;
    }

    /**
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @return the dates
     */
    public ArrayList<String> getDates() {
        return dates;
    }

    /**
     * @return the openingPrices
     */
    public ArrayList<Double> getOpeningPrices() {
        return openingPrices;
    }

    /**
     * @return the highestPrices
     */
    public ArrayList<Double> getHighestPrices() {
        return highestPrices;
    }

    /**
     * @return the lowestPrices
     */
    public ArrayList<Double> getLowestPrices() {
        return lowestPrices;
    }

    /**
     * @return the closingPrices
     */
    public ArrayList<Double> getClosingPrices() {
        return closingPrices;
    }

    /**
     * @return the volumes
     */
    public ArrayList<Long> getVolumes() {
        return volumes;
    }

    /**
     * @return the adjustedClosingPrices
     */
    public ArrayList<Double> getAdjustedClosingPrices() {
        return adjustedClosingPrices;
    }
}
