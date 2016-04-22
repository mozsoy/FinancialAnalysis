package FileReaders;

import Securities.Security;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The SecuritiesIniFileParser class parses an INI file of securities into a
 * HashMap<name of the security, security>.
 *
 * @author metehan
 */
public class SecuritiesIniFileParser {

    private final String iniFilePath; // Path for the INI file

    /**
     * Constructs an SecuritiesIniFileParser object for the INI file at the
     * specified path.
     *
     * @param path the absolute path of the INI file.
     */
    public SecuritiesIniFileParser(String path) {
        if (path == null) {
            throw new NullPointerException("error: empty path");
        }
        this.iniFilePath = path;
    }

    /**
     * Reads the INI file.
     *
     * @return a HashMap of the securities in the INI file.
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
        } catch (FileNotFoundException ex) { // File not found
            System.out.println("error: ini file not found at the specified path");
        } catch (NoSuchElementException ex) { // Mis-formatted INI file
            System.out.println("error: ini file mis-formatted");
        }
        return securitiesMap;
    }
}
