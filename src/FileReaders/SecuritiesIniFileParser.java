/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import Securities.Security;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author metehan
 */
public class SecuritiesIniFileParser {

    private String iniFilePath;

    /**
     * Constructs an SecuritiesIniFileParser object for the INI file at the
     * specified path.
     *
     * @param path the absolute path of the INI file.
     */
    public SecuritiesIniFileParser(String path) {
        this.iniFilePath = path;
    }

    /**
     * Reads and returns a HashMap of the securities in the INI file.
     */
    public HashMap<String, Security> readSecuritiesFromIniFile() {
        HashMap<String, Security> securitiesMap = new HashMap<>();

        try {
            Scanner iniFileScanner = new Scanner(new File(this.iniFilePath));
            while (iniFileScanner.hasNext()) {

                iniFileScanner.next(); //read "[<ticker name>]"
                iniFileScanner.next(); //read "Ticker"
                iniFileScanner.next(); // read "=" 
                String nameOfSecurity = iniFileScanner.next(); //read name of the security

                iniFileScanner.next(); //read "From"
                iniFileScanner.next(); //read "="
                String fromDate = iniFileScanner.next(); //read fromDate

                iniFileScanner.next(); //read "To"
                iniFileScanner.next(); //read "="
                String toDate = iniFileScanner.next(); //read toDate

                Security newSecurity = new Security(nameOfSecurity, fromDate, toDate);
                securitiesMap.put(nameOfSecurity, newSecurity);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SecuritiesIniFileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return securitiesMap;
    }
}
