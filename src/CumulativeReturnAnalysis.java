
import FileReaders.IniFileReader;
import FileReaders.SecuritiesIniFileParser;
import FinancialAPIs.YahooFinancialCSVFileDownloader;
import Securities.Security;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Select file");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    IniFileReader myIniFileReader = new IniFileReader(filePath);
                    myIniFileReader.readSecuritiesFromIniFile();
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
        frame.add(button);
        frame.setSize(300, 120);
        frame.setLocation(800, 400);
        frame.setVisible(true);

        YahooFinancialCSVFileDownloader downloader = new YahooFinancialCSVFileDownloader("SPY", "20151101", "20151109");
        downloader.downloadCsvFile();

        SecuritiesIniFileParser iniFileParser = new SecuritiesIniFileParser("config.ini");
        HashMap<String, Security> securitiesMap = iniFileParser.readSecuritiesFromIniFile();
        // System.out.println(securitiesMap.get("UCO").toString());
    }
}
