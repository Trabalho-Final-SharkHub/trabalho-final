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

    //Calcular tempo de existencia da startup
    public static void calcularExistencia(Scanner in){
        System.out.println("Digite a data de hoje no formato dia/mes/ano:");
        String dataHoje = in.nextLine();

    }

    @Override
    public String toString() {
        return super.toString();
    }

    //

}
