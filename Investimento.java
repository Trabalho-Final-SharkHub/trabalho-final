public class Investimento {
    private int id;
    private double valor;
    private double percentualParticipacao;
    private Startup startup;

    public Investimento(int id, double valor, double percentualParticipacao, Startup startup) {
        this.id = id;
        this.valor = valor;
        this.percentualParticipacao = percentualParticipacao;
        this.startup = startup;
    }

    //etters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPercentualParticipacao() {
        return percentualParticipacao;
    }

    public void setPercentualParticipacao(double percentualParticipacao) {
        this.percentualParticipacao = percentualParticipacao;
    }

    public Startup getStartup() {
        return startup;
    }

    public void setStartup(Startup startup) {
        this.startup = startup;
    }

   
    public String toString() {
        String nomeInvestidorPrincipal = "N/A";
        if (startup != null && startup.getInvestidor() != null) {
            nomeInvestidorPrincipal = startup.getInvestidor().getNome();
        }
        return "Investimento [ID: " + id
                + " | Valor: R$ " + String.format("%.2f", valor)
                + " | Participacao: " + String.format("%.2f", percentualParticipacao) + "%"
                + " | Startup: " + (startup != null ? startup.getNome() : "N/A")
                + " | Investidor principal: " + nomeInvestidorPrincipal + "]";
    }
}
  
