
import FinancialAPIs.YahooFinancialCSVFileDownloader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author metehan
 */
public class Main {
    
    public static void main(String[] args) {
        IniFileReader myIniFileReader = new IniFileReader("config.ini");
        myIniFileReader.readSecuritiesFromIniFile();
        
        YahooFinancialCSVFileDownloader downloader = new YahooFinancialCSVFileDownloader("SPY","20151101","20151109");
        downloader.openConnectionForCsvFileDownload();
    }
}
