import java.util.*;
public class Main {
    static final int MAX = 100;
    //cria vetor para investidores
    static Investidor[] investidores = new Investidor[MAX];

    //cria vetor para startups
    static Startup [] startups = new Startup[MAX];
    //total
    static int totalInvestidores = 0;
    static int totalStartups = 0;

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int opcao = -1;


        while(opcao != 0){
            System.out.println("=========== Shark Hub ============");
            System.out.println("0) SAIR");
            System.out.println("1) Cadastrar Investidor");
            System.out.println("2) Cadastrar Startup");
            System.out.println("3) Adicionar Pitch");
            System.out.println("4) Adicionar Investimento");
            System.out.println("5) Consultar Startup");
            System.out.println("6) Consultar Investidores");
            System.out.println("7) Consultar Investimentos");
            System.out.println("8) Calcular Valuation");
            System.out.println("9) Exibir Ranking de Startups");
            System.out.println("10) Exibir Índice de Unicornização");
            System.out.println("==================================");

            opcao = in.nextInt();
            in.nextLine();

            if(opcao == 1){
                cadastrarInvestidor(in);
            }else if(opcao == 2){
                cadastrarStartup(in);
            } else if (opcao == 3) {
                
            } else if (opcao == 4) {
                
            } else if (opcao == 6) {
                listarInvestidores();
            }
        }

    }

    //Opcao 1 do Menu principal
    public static void cadastrarInvestidor(Scanner in){


        if (totalInvestidores >= MAX) {
            System.out.println("Limite atingido.");
            return;
        }
        System.out.println("Digite o ID do investidor:");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Digite o nome do investidor:");
        String nome = in.nextLine();
        System.out.println("Digite o email do investidor:");
        String email = in.nextLine();
        Investidor novo = new Investidor(id, nome, email);
        investidores[totalInvestidores] = novo;
        totalInvestidores++;
        System.out.println("Investidor cadastrado com sucesso! Aperte ENTER para voltar ao menu.");
        in.nextLine();
    }

    //Opcao 2 do Menu principal
    public static void cadastrarStartup(Scanner in){
        if (totalStartups >= MAX){
            System.out.println("Limite de Startups no programa atingido!");
            return;
        }
        if (totalInvestidores == 0) {
            System.out.println("Cadastre um investidor antes de cadastrar uma startup.");
            return;
        }
        System.out.println("Digite o ID da Startup:");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Digite o nome da Startup:");
        String nome = in.nextLine();
        System.out.println("Digite a Área de Atuação da Startup:");
        String areaAtuacao = in.nextLine();
        System.out.println("Digite a data em que a fundação foi fundada (formato dd/mm/aaaa):");
        String data = in.nextLine();
        System.out.println("Digite o nome do investidor correspondente da lista:");
        listarInvestidores();
        String nomeInvestidor = in.nextLine();
        Investidor investidorEscolhido = buscarInvestidor(nomeInvestidor);
        if (investidorEscolhido == null) {
            System.out.println("Investidor não encontrado!");
            return;
        }
        Startup novo = new Startup(id, nome, areaAtuacao, data, investidorEscolhido);
        startups[totalStartups] = novo;
        totalStartups++;
        System.out.println("Startup cadastrada com sucesso! Aperte ENTER para voltar ao menu.");
        in.nextLine();
    }

    //Metodos para investidores
    public static Investidor buscarInvestidor(String nome){
        for(int i = 0; i < totalInvestidores; i++){
            if(investidores[i].getNome() == nome){
                return investidores[i];
            }
        }
        return null;
    }

    public static void listarInvestidores() {
        if (totalInvestidores == 0) {
            System.out.println("Nenhum investidor cadastrado.");
            return;
        }
        System.out.println("=== Investidores cadastrados ===");

        for (int i = 0; i < totalInvestidores; i++) {
            System.out.println("ID: " + investidores[i].getId());
            System.out.println("Nome: " + investidores[i].getNome());
            System.out.println("Email: " + investidores[i].getEmail());
            System.out.println("-----------------------------");
        }
    }

    
}
