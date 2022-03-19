import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONArray;


public class ApiConnector {

    private static String parseMoeda(String moeda){
        moeda = moeda.toUpperCase();
        moeda = moeda.replace("[^A-z\\-]", "");
        if(moeda.matches("BRL-...")){
            String aux = moeda.split("-")[1];
            moeda = aux+"-BRL";
        }
        return moeda;
    }

    private static String parseData(String data){
        data = data.replaceAll("[^0-9]", "");
        String[] aux = data.split("");
        // transforma DDMMYYYY em YYYYMMDD
        String dataFormatada = aux[4] + aux[5] + aux[6] + aux[7] + aux[2] + aux[3] + aux[0] + aux[1]; // Cara quem ver isso por favor
                                                                                                      // me desculpa 
        return dataFormatada;
    }

    public static Moeda getMoeda(String moeda,String param) throws UnirestException{
    moeda = moeda.toUpperCase();
    HttpResponse<JsonNode> response = Unirest.get("https://economia.awesomeapi.com.br/last/"+moeda)
        .header("accept", "application/json")
        .asJson();
        moeda = moeda.replace("-", "");
        String moedajson = moeda.replace("-", "");
        Moeda result = new Moeda(
            moeda.split("-")[0], // nome da moeda
            response.getBody().getObject().getJSONObject(moedajson).get("high").toString(), // Alta 
            response.getBody().getObject().getJSONObject(moedajson).get("low").toString()); // Baixa
        result.setTime(response.getBody().getObject().getJSONObject(moedajson).get("timestamp").toString());
        return result;
    }
    public static Moeda  getMoeda(String moeda) throws UnirestException{
        moeda = moeda.toUpperCase();
        HttpResponse<JsonNode> response = Unirest.get("https://economia.awesomeapi.com.br/last/"+moeda)
            .header("accept", "application/json")
            .asJson();
            String moedajson = moeda.replace("-", "");
            moedajson += "BRL";
            Moeda result = new Moeda(
            moeda.split("-")[0], // nome da moeda
            response.getBody().getObject().getJSONObject(moedajson).get("high").toString(), // Alta 
            response.getBody().getObject().getJSONObject(moedajson).get("low").toString()
            ); // Baixa
            result.setTime(response.getBody().getObject().getJSONObject(moedajson).get("timestamp").toString());
            
            return result;
        }
        // aparentemente esse metodo retorna o valor de uma moeda de 3 em 3 minutos, a data e meio inutil
    public static Moeda[] getMoedaTime(String moeda,String qtd,String start,String end)throws UnirestException {
        moeda = parseMoeda(moeda);
        start = parseData(start);
        end = parseData(end);
       String url = "https://economia.awesomeapi.com.br/"+moeda+"/"+qtd+"?start_date="+start+"&end_date="+end;
        HttpResponse<JsonNode> response = Unirest.get(url)
            .header("accept", "application/json")
            .asJson();
        //response é um array de objetos
        JSONArray jsonArray = response.getBody().getArray();
        Moeda[] arrMoedas = new Moeda[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            Moeda obj = new Moeda(
                moeda.split("-")[0], // nome da moeda
                jsonArray.getJSONObject(i).get("high").toString(),
                jsonArray.getJSONObject(i).get("low").toString()
            );
            obj.setTime(jsonArray.getJSONObject(i).get("timestamp").toString());
            arrMoedas[i] = obj;
        }
        return arrMoedas;
    }
    // esse aqui teoricamente retorna o valor diario dentre um periodo de tempo
    public static Moeda[] getMoedaTime(String moeda,String start,String end)throws UnirestException {
        moeda = parseMoeda(moeda);
        start = parseData(start);
        end = parseData(end);
       String url = "https://economia.awesomeapi.com.br/json/daily/"+moeda+"/"+"?start_date="+start+"&end_date="+end;
        HttpResponse<JsonNode> response = Unirest.get(url)
            .header("accept", "application/json")
            .asJson();
        //response é um array de objetos
        JSONArray jsonArray = response.getBody().getArray();
        Moeda[] arrMoedas = new Moeda[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            Moeda obj = new Moeda(
                moeda.split("-")[0], // nome da moeda
                jsonArray.getJSONObject(i).get("high").toString(),
                jsonArray.getJSONObject(i).get("low").toString()
            );
            obj.setTime(jsonArray.getJSONObject(i).get("timestamp").toString());
            arrMoedas[i] = obj;
        }
        return arrMoedas;
    }

    public static Moeda[] getMoedaTime(String moeda,String qtd)throws UnirestException {
        moeda = parseMoeda(moeda);
       String url = "https://economia.awesomeapi.com.br/json/daily/"+moeda+"/"+qtd;
        HttpResponse<JsonNode> response = Unirest.get(url)
            .header("accept", "application/json")
            .asJson();
        //response é um array de objetos
        JSONArray jsonArray = response.getBody().getArray();
        Moeda[] arrMoedas = new Moeda[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            Moeda obj = new Moeda(
                moeda.split("-")[0], // nome da moeda
                jsonArray.getJSONObject(i).get("high").toString(),
                jsonArray.getJSONObject(i).get("low").toString()
            );
            obj.setTime(jsonArray.getJSONObject(i).get("timestamp").toString());
            arrMoedas[i] = obj;
        }
        return arrMoedas;
    }

}
