package GraphingTools;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class extends JFrame class to plot a simple line chart
 *
 * @author metehan
 * @param <Object> object is the data type of y-axis
 */
public class LineChartFrame<Object> extends JFrame {

    private JFXPanel fxPanel;  // Line Chart will be drawn on fxPanel

    private ArrayList<Object> dataPoints; // y-values of the line chart
    private String xAxisLabel;
    private String yAxisLabel;
    private String title; // Title of the line chart

    /**
     * Constructs a LineChartFrame with dataPoints
     *
     * @param dataPoints an ArrayList of y-values of the line chart
     */
    public LineChartFrame(ArrayList<Object> dataPoints) {
        this.dataPoints = dataPoints;
        initComponents();
    }

    /**
     * Initialize LineChartFrame
     */
    private void initComponents() {
        JPanel mainPanel = new JPanel();
        fxPanel = new JFXPanel();
        mainPanel.add(fxPanel);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
    }

    /**
     * Display the line chart
     */
    public void showLineChart() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // Defining the axes
                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                if (xAxisLabel != null) {
                    xAxis.setLabel(xAxisLabel);
                }
                if (yAxisLabel != null) {
                    yAxis.setLabel(yAxisLabel);
                }
                // Create the line plot
                final LineChart<String, Number> lineChart
                        = new LineChart<>(xAxis, yAxis);
                // Defining data series
                XYChart.Series series = new XYChart.Series();
                for (int i = 0; i < dataPoints.size(); i++) {
                    System.out.println(dataPoints.get(i));
                    series.getData().add(new XYChart.Data(String.valueOf(i + 1), dataPoints.get(i)));
                }
                series.setName("Data Point");
                // Create a scene containing the line chart
                lineChart.getData().add(series);
                if (title != null) {
                    lineChart.setTitleSide(Side.TOP);
                    lineChart.setTitle(title);
                }
                Scene scene = new Scene(lineChart, 800, 600);
                fxPanel.setScene(scene);
                setVisible(true);
            }
        });
    }

    /**
     * @return the dataPoints
     */
    public ArrayList<Object> getDataPoints() {
        return dataPoints;
    }

    /**
     * @param dataPoints the dataPoints to set
     */
    public void setDataPoints(ArrayList<Object> dataPoints) {
        this.dataPoints = dataPoints;
    }

    /**
     * @return the xAxisLabel
     */
    public String getxAxisLabel() {
        return xAxisLabel;
    }

    /**
     * @param xAxisLabel the xAxisLabel to set
     */
    public void setxAxisLabel(String xAxisLabel) {
        this.xAxisLabel = xAxisLabel;
    }

    /**
     * @return the yAxisLabel
     */
    public String getyAxisLabel() {
        return yAxisLabel;
    }

    /**
     * @param yAxisLabel the yAxisLabel to set
     */
    public void setyAxisLabel(String yAxisLabel) {
        this.yAxisLabel = yAxisLabel;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
