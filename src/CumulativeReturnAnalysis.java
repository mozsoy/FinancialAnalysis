
import FileReaders.SecuritiesIniFileParser;
import FinancialAPIs.YahooFinancialCSVFileDownloader;
import FinancialCalculators.FinancialCalculator;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author metehan
 */
public class CumulativeReturnAnalysis extends Application {

    private String iniFilePath;
    HashMap<String, Security> securitiesMap;
    ArrayList<Double> adjustedClosingPrices;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Select file");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    iniFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    SecuritiesIniFileParser iniFileParser = new SecuritiesIniFileParser(iniFilePath);
                    securitiesMap = iniFileParser.readSecuritiesFromIniFile();
                    frame.setVisible(false);
                    frame.dispose();
                    ArrayList<Double> cumulativeReturn = new ArrayList<>();
                    for (String securityName : securitiesMap.keySet()) {
                        YahooFinancialCSVFileDownloader downloader
                                = new YahooFinancialCSVFileDownloader(securityName, 
                                        securitiesMap.get(securityName).getFromDate(), 
                                        securitiesMap.get(securityName).getToDate());
                        downloader.downloadCsvFileFromYahooFinancial();
                        adjustedClosingPrices = downloader.getAdjustedClosingPrices();
                        cumulativeReturn = FinancialCalculator.calculateCumulativeReturn(adjustedClosingPrices);
                        LineChartFrame<Double> plotter = new LineChartFrame(cumulativeReturn);
                        plotter.setyAxisLabel("Cumulative Return");
                        plotter.setTitle(securityName);
                        plotter.showLineChart();
                    }
                }
            }
        });
        frame.add(button);
        frame.setSize(300, 120);
        frame.setLocation(800, 400);
        frame.setVisible(true);
        System.out.println("Frame complete");
        System.out.println("File read complete");
    }
}
