public class Investimento {
    Startup startup;
    double valorCaptado;

    public Investimento(Startup startup, double valorCaptado){
        this.startup = startup;
        this.valorCaptado = valorCaptado;
    }

    public Startup getStartup() {
        return startup;
    }

    public double getValorCaptado() {
        return valorCaptado;
    }

    public void setStartup(Startup startup) {
        this.startup = startup;
    }
    
    public void setValorCaptado(double valorCaptado) {
        this.valorCaptado = valorCaptado;
    }

    public void adicionarInvestimento(Startup startup, double valorCaptado){
        this.startup = startup;
        this.valorCaptado = valorCaptado;
    }
}
