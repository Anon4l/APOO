import com.mashape.unirest.http.exceptions.UnirestException;

import org.jfree.chart.ChartPanel;

public class Main {
    public static void main(String[] args) {
        // chama o metodo getMoeda e imprime o resultado
        String codigo = "BRL-BTC";
        try {
            Moeda[] result = ApiConnector.getMoedaTime(codigo,"200");
            //System.out.println(result[0].toString());
            ChartPanel chart = MoedaChart.show(result,codigo);
            Grafico grafico = new Grafico(chart);
            grafico.setVisible(true);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        
    }
}
