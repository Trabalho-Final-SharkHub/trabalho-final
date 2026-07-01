import java.util.*;
public class Startup {
    int id;
    String nome;
    String areaAtuacao;
    String data;
    Investidor investidor;

    public Startup(int id, String nome, String areaAtuacao, String data, Investidor investidor){
        this.id = id;
        this.nome = nome;
        this.areaAtuacao = areaAtuacao;
        this.data = data;
        this.investidor = investidor;
    }

    //Getters
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getAreaAtuacao(){
        return areaAtuacao;
    }
    public String getData(){
        return data;
    }
    public Investidor getInvestidor(){
        return investidor;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    //Calcular tempo de existencia da startup em anos, a partir do atributo "data".
    //A data e uma String no formato "dd/mm/aaaa": o ano sao os 4 ultimos caracteres.
    public int calcularExistencia(){
        int anoAtual = 2026; // ano de referencia
        String anoTexto = data.substring(6); // ex.: de "10/03/2020" pega "2020"

        // Converte o texto do ano para numero, digito por digito (sem usar parseInt).
        int anoFundacao = 0;
        for (int i = 0; i < anoTexto.length(); i++) {
            int digito = anoTexto.charAt(i) - '0';
            anoFundacao = anoFundacao * 10 + digito;
        }

        int anos = anoAtual - anoFundacao;
        if (anos < 0) {
            anos = 0;
        }
        return anos;
    }

    @Override
    public String toString() {
        String nomeInvestidor = "N/A";
        if (investidor != null) {
            nomeInvestidor = investidor.getNome();
        }
        return nome + " (ID: " + id + " | Area: " + areaAtuacao
                + " | Fundacao: " + data
                + " | Investidor: " + nomeInvestidor + ")";
    }

}
