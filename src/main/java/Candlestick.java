import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;

public class Candlestick {

    

    public static double round(double num){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(num));
    }
 
    private OHLCSeries ohlcSeries;
    private ChartPanel chart;
 
    public Candlestick(String title) {
        final JFreeChart candlestickChart = createChart(title);
        final ChartPanel chartPanel = new ChartPanel(candlestickChart);
        this.chart = chartPanel;
        // chartPanel.setPreferredSize(new java.awt.Dimension(1200, 500));
        // chartPanel.setMouseZoomable(true);
        // chartPanel.setMouseWheelEnabled(true);
        // add(chartPanel, BorderLayout.CENTER);
    }
    
    public ChartPanel getChartPanel(){
        return this.chart;
    }
    

    private JFreeChart createChart(String chartTitle) {
 
        /**
         * Creating candlestick subplot
         */
        // Create OHLCSeriesCollection as a price dataset for candlestick chart
        OHLCSeriesCollection candlestickDataset = new OHLCSeriesCollection();
        ohlcSeries = new OHLCSeries("Preço 🤠");
        candlestickDataset.addSeries(ohlcSeries);
        // Create candlestick chart priceAxis
        NumberAxis priceAxis = new NumberAxis("Preço 🤠");
        priceAxis.setAutoRangeIncludesZero(false);
        // Create candlestick chart renderer
        CandlestickRenderer candlestickRenderer = new CandlestickRenderer(CandlestickRenderer.WIDTHMETHOD_AVERAGE,
                false,null);
        // Create candlestickSubplot
        XYPlot candlestickSubplot = new XYPlot(candlestickDataset, null, priceAxis, candlestickRenderer);
        candlestickSubplot.setBackgroundPaint(Color.white);
 
        DateAxis dateAxis = new DateAxis("Time");
        //dateAxis.setDateFormatOverride(new SimpleDateFormat("kk:mm"));
        dateAxis.setLowerMargin(0.02);
        dateAxis.setUpperMargin(0.02);
        // Create mainPlot
        CombinedDomainXYPlot mainPlot = new CombinedDomainXYPlot(dateAxis);
        mainPlot.setGap(10.0);
        mainPlot.add(candlestickSubplot, 3);
        mainPlot.setOrientation(PlotOrientation.VERTICAL);
        JFreeChart chart = new JFreeChart(chartTitle, JFreeChart.DEFAULT_TITLE_FONT, mainPlot, true);
        chart.removeLegend();
        return chart;
    }
 

    public void addCandle(Date time, double open, double high, double low, double close) {
        try {
           Day Day = new Day(time);
            ohlcSeries.add(Day, open, high, low, close);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
     
    /**
     * Aggregate the (open, high, low, close, volume) based on the predefined time interval (1 minute)
     *
     * @param t the t
     */
    public void candleGenerator(Moeda[] valores) {

        for (int i = 0; i < valores.length; i++) {
                addCandle(valores[i].getData(),
                Double.parseDouble(valores[i].getValorAlta()),
                Double.parseDouble(valores[i].getValorAlta()),
                Double.parseDouble(valores[i].getValorBaixa()),
                Double.parseDouble(valores[i].getValorBaixa()));
        }
    }
 
}