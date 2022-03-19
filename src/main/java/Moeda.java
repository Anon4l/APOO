import java.sql.Date;
import java.sql.Time;

public class Moeda {
    private String nome;
    private String valorAlta;
    private String valorBaixa;
    private String time;
    
    public Moeda(String nome, String valorAlta, String valorBaixa) {
        this.nome = nome;
        this.valorAlta = valorAlta;
        this.valorBaixa = valorBaixa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValorAlta() {
        return valorAlta;
    }

    public void setValorAlta(String valorAlta) {
        this.valorAlta = valorAlta;
    }

    public String getValorBaixa() {
        return valorBaixa;
    }

    public void setValorBaixa(String valorBaixa) {
        this.valorBaixa = valorBaixa;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        Date date = new Date(Long.parseLong(time)*1000);
        Time tempo = new Time(Long.parseLong(time)*1000);
        this.time = date.toString()+"/"+tempo.toString();
    }

    @Override
    public String toString() {
        return "Moeda: {\n" + "nome=" + nome +
               ",\nvalorAlta=" + valorAlta +
               ",\nvalorBaixa=" + valorBaixa + "\n }";
    }
    
}
