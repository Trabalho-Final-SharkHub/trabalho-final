public class Pitch {
    private int id;
    private String titulo;
    private double notaInovacao;
    private double notaMercado;
    private Startup startup;

    public Pitch(int id, String titulo, double notaInovacao, double notaMercado, Startup startup) {
        this.id = id;
        this.titulo = titulo;
        this.notaInovacao = notaInovacao;
        this.notaMercado = notaMercado;
        this.startup = startup;
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getNotaInovacao() {
        return notaInovacao;
    }

    public void setNotaInovacao(double notaInovacao) {
        this.notaInovacao = notaInovacao;
    }

    public double getNotaMercado() {
        return notaMercado;
    }

    public void setNotaMercado(double notaMercado) {
        this.notaMercado = notaMercado;
    }

    public Startup getStartup() {
        return startup;
    }

    public void setStartup(Startup startup) {
        this.startup = startup;
    }

    
     // Media simples entre a nota de inovacao e a nota de mercado.
     
    public double calcularMediaPitch() {
        return (notaInovacao + notaMercado) / 2.0;
    }

    
    public String toString() {
        String nomeStartup = "N/A";
        if (startup != null) {
            nomeStartup = startup.getNome();
        }
        return "Pitch [ID: " + id
                + " | Titulo: " + titulo
                + " | Nota Inovacao: " + notaInovacao
                + " | Nota Mercado: " + notaMercado
                + " | Media: " + calcularMediaPitch()
                + " | Startup: " + nomeStartup + "]";
    }
}
