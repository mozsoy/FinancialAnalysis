package FileReaders;

import Securities.Security;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author metehan
 */
public class IniFileReader {

    private FileInputStream iniFileInputStream;
    private String iniFilePath;
    private Properties iniFileProperties;

    // Key values in the ini file
    private final String TICKER = "Ticker";
    private final String FROM = "From";
    private final String TO = "To";

    /**
     * Constructs an IniFileReader object for the INI file at the specified
     * path.
     *
     * @param path the absolute path of the INI file.
     */
    public IniFileReader(String path) {
        try {
            this.iniFilePath = path;
            this.iniFileInputStream = new FileInputStream(path);
            this.iniFileProperties = new Properties();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IniFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reads and returns the list of securities in the INI file.
     */
    public void readSecuritiesFromIniFile() {
        try {
            ArrayList<Security> listOfSecurities = new ArrayList<>();
            this.iniFileProperties.load(this.iniFileInputStream);
            System.out.println(TICKER + " " + this.iniFileProperties.getProperty(TICKER));
            System.out.println(FROM + " " + this.iniFileProperties.getProperty(FROM));
            System.out.println(TO + " " + this.iniFileProperties.getProperty(TO));

            System.out.println(TICKER + " " + this.iniFileProperties.getProperty(TICKER));
            System.out.println(FROM + " " + this.iniFileProperties.getProperty(FROM));
            System.out.println(TO + " " + this.iniFileProperties.getProperty(TO));
        } catch (IOException ex) {
            Logger.getLogger(IniFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
