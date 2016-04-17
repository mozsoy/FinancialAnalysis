
import FileReaders.IniFileReader;
import FileReaders.SecuritiesIniFileParser;
import FinancialAPIs.YahooFinancialCSVFileDownloader;
import FinancialCalculators.FinancialCalculator;
import Securities.Security;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
public class CumulativeReturnAnalysis {
    
    private String iniFilePath;
    HashMap<String, Security> securitiesMap;
    ArrayList<Double> adjustedClosingPrices;
    
    public static void main(String[] args) {
        
        CumulativeReturnAnalysis myReturnAnalysis = new CumulativeReturnAnalysis();
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Select file");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    myReturnAnalysis.iniFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    SecuritiesIniFileParser iniFileParser = new SecuritiesIniFileParser(myReturnAnalysis.iniFilePath);
                    myReturnAnalysis.securitiesMap = iniFileParser.readSecuritiesFromIniFile();
                    
                    for (String securityName : myReturnAnalysis.securitiesMap.keySet()) {
                        YahooFinancialCSVFileDownloader downloader = new YahooFinancialCSVFileDownloader(securityName, "20151101", "20151109");
                        downloader.downloadCsvFileFromYahooFinancial();
                        myReturnAnalysis.adjustedClosingPrices = downloader.getAdjustedClosingPrices();
                    }
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
        frame.add(button);
        frame.setSize(300, 120);
        frame.setLocation(800, 400);
        frame.setVisible(true);
    }
}
