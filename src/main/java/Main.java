import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
    public static void main(String[] args) {
        // chama o metodo getMoeda e imprime o resultado
        try {
            Moeda[] result = ApiConnector.getMoedaTime("BRL-BTC","1500");
            //System.out.println(result[0].toString());
            MoedaChart.show(result,"BRL-USD");
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
