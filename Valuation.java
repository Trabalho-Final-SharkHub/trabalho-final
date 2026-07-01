public class Valuation {
     private Startup startup;
    private double valorCaptado;

    public Valuation(Startup startup) {
        this.startup = startup;
        this.valorCaptado = 0;
    }

    //Getters e Setters 

    public Startup getStartup() {
        return startup;
    }

    public void setStartup(Startup startup) {
        this.startup = startup;
    }

    public double getValorCaptado() {
        return valorCaptado;
    }

    public void setValorCaptado(double valorCaptado) {
        this.valorCaptado = valorCaptado;
    }

    
     //Percorre o vetor de investimentos
    public double calcularTotalCaptado(Investimento[] investimentos, int totalInvestimentos) {
        double soma = 0;
        for (int i = 0; i < totalInvestimentos; i++) {
            if (investimentos[i].getStartup().getId() == startup.getId()) {
                soma += investimentos[i].getValor();
            }
        }
        this.valorCaptado = soma;
        return soma;
    }

    
    public String toString() {
        String nomeStartup = "N/A";
        if (startup != null) {
            nomeStartup = startup.getNome();
        }
        return "Valuation [Startup: " + nomeStartup + " | Total captado: R$ " + valorCaptado + "]";
    }
}

