/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author metehan
 */
public class YahooFinancialCSVFileDownloader {

    private String nameOfSecurity;
    private String fromDate;
    private String toDate;
    private ArrayList<GregorianCalendar> dates;
    private ArrayList<Double> openingPrices;
    private ArrayList<Double> highestPrices;
    private ArrayList<Double> lowestPrices;
    private ArrayList<Double> closingPrices;
    private ArrayList<Long> volumes;
    private ArrayList<Double> adjustedClosingPrices;

    //private String downloadUrl;

     public YahooFinancialCSVFileDownloader(String mNameOfSecurity, String mFromDate, String mToDate) {
         this.nameOfSecurity = mNameOfSecurity;
         this.fromDate = mFromDate;
         this.toDate = mToDate;
     } 
    private String prepareDownloadUrl() {

        GregorianCalendar gregorianFromDate = GregorianCalendarParser.parseStringToGregorianCalendar(this.fromDate);
        GregorianCalendar gregorianToDate = GregorianCalendarParser.parseStringToGregorianCalendar(this.toDate);
        
        String url = "http://ichart.finance.yahoo.com/table.csv?"
                + "s=" + nameOfSecurity
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

    public void openConnectionForCsvFileDownload() {

        String downloadUrlAsString = prepareDownloadUrl();
        try {
            URL urlForDownloadCsvFile = new URL(downloadUrlAsString);
            URLConnection connectionForCsvFileDownload = urlForDownloadCsvFile.openConnection();
            InputStream csvFileInputStream = connectionForCsvFileDownload.getInputStream();
            Scanner csvFileData = new Scanner(csvFileInputStream);

            csvFileData.nextLine();

            while (csvFileData.hasNext()) {
                System.out.println(csvFileData.nextLine());
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(YahooFinancialCSVFileDownloader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(YahooFinancialCSVFileDownloader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
