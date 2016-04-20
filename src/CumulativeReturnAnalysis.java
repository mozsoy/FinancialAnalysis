
import FileReaders.SecuritiesIniFileParser;
import FinancialAPIs.YahooFinancialCSVFileDownloader;
import FinancialCalculators.SecurityCalculator;
import GraphingTools.LineChartFrame;
import Securities.Security;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * The CumulativeReturnAnalysis is the main class of the application. It extends
 * javafx.application.Application class. It overrides the start method of
 * Application class.
 *
 * @author metehan
 */
public class CumulativeReturnAnalysis extends Application {

    private String iniFilePath; // Path for the INI file of securities
    HashMap<String, Security> securitiesMap; // A map to access securities
    ArrayList<Double> adjustedClosingPrices; // Adjusted closing prices for a security

    public static void main(String[] args) {
        launch(args); // Launchs the application
    }

    /**
     * This method is called implicitly by the launch() method in the main. This
     * method starts the application.
     *
     * @param primaryStage the top container of the GUI
     */
    @Override
    public void start(Stage primaryStage) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Select file");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // Chosing INI file from a JFileChooser 
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    iniFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    // Parse the INI file using SecuritiesIniFileParser
                    SecuritiesIniFileParser iniFileParser = new SecuritiesIniFileParser(iniFilePath);
                    securitiesMap = iniFileParser.readSecuritiesFromIniFile();
                    frame.setVisible(false);
                    frame.dispose();
                    // ArrayList of cumulative return for each day
                    ArrayList<Double> cumulativeReturn = new ArrayList<>();
                    for (String securityName : securitiesMap.keySet()) {
                        /* Download the CSV file from Yahoo Financial Web Site 
                         * for this security in the INI file.
                         */
                        YahooFinancialCSVFileDownloader downloader
                                = new YahooFinancialCSVFileDownloader(securityName,
                                        securitiesMap.get(securityName).getFromDate(),
                                        securitiesMap.get(securityName).getToDate());
                        downloader.downloadCsvFileFromYahooFinancial();
                        // Retrieve adjusted closing prices from CSV File
                        adjustedClosingPrices = downloader.getAdjustedClosingPrices();
                        // Calculate the cumulative return of the security
                        cumulativeReturn = SecurityCalculator.calculateCumulativeReturn(adjustedClosingPrices);
                        // Plotting the line chart for the security
                        LineChartFrame<Double> plotter = new LineChartFrame(cumulativeReturn);
                        plotter.setyAxisLabel("Cumulative Return");
                        plotter.setxAxisLabel("Days");
                        plotter.setTitle(securityName);
                        // Show the line chart
                        plotter.showLineChart();
                    }
                }
            }
        });
        frame.add(button);
        frame.setSize(300, 120);
        frame.setLocation(800, 400);
        frame.setVisible(true);
    }
}
