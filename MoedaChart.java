import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoedaChart extends JPanel {

    public static void show(Moeda[] moeda, String title) {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the chart.
        Candlestick Candlestick = new Candlestick(title);
        Candlestick.candleGenerator(moeda);
        frame.setContentPane(Candlestick);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
}
