import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
    public static void main(String[] args) {
        // chama o metodo getMoeda e imprime o resultado
        try {
            // Parametros = ("MOEDA","QTD","DATA INICIAL","DATA FINAL") SE INVERTER DA RUIM
            Moeda[] result = ApiConnector.getMoedaTime("BRL-USD","15");
            System.out.println(result);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
