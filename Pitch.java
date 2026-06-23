public class Pitch {
    int id;
    String titulo;
    double notaInovacao;
    double notaMercado;
    Startup startup;

    public Pitch(int id, String titulo, double notaInovacao, double notaMercado, Startup startup){
        this.id = id;
        this.titulo = titulo;
        this.notaInovacao = notaInovacao;
        this.notaMercado = notaMercado;
        this.startup = startup;
    }
    public static double mediaPitch (double notaInovacao, double notaMercado){
        double mediaPitch;
        mediaPitch = (notaInovacao + notaMercado)/2;
        return mediaPitch;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getNotaInovacao() {
        return notaInovacao;
    }

    public double getNotaMercado() {
        return notaMercado;
    }

    public Startup getStartup() {
        return startup;
    }
}
