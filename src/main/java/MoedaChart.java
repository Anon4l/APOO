package main.java;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class MoedaChart {

    public static ChartPanel show(Moeda[] moeda, String title) {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the chart.
        Candlestick Candlestick = new Candlestick(title);
        Candlestick.candleGenerator(moeda);
        return Candlestick.getChartPanel();
        // frame.setContentPane(Candlestick);
        // frame.setResizable(false);
        // frame.pack();
        // frame.setVisible(true);
    }

    public static JFreeChart showRaw (Moeda[] moeda, String title) {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the chart.
        Candlestick Candlestick = new Candlestick(title);
        Candlestick.candleGenerator(moeda);
        return Candlestick.getRawChart();
        // frame.setContentPane(Candlestick);
        // frame.setResizable(false);
        // frame.pack();
        // frame.setVisible(true);
    }
    
}
