public class Investidor {
    int id;
    String nome;
    String email;

    public Investidor(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId(){
        return id;
    }
    public void setId(int idNovo){
        id = idNovo;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nomeNovo){
        nome = nomeNovo;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String emailNovo){
        email = emailNovo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
