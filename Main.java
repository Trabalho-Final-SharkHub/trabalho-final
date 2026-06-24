import java.util.*;
public class Main {
    static final int MAX = 100;
    static final int MAXPitch = 2000;
    //cria vetor para investidores
    static Investidor[] investidores = new Investidor[MAX];
    //cria vetor para startups
    static Startup [] startups = new Startup[MAX];
    //total
    static Pitch [] pitches = new Pitch[MAXPitch];
    static Investimento [] investimentos = new Investimento[MAX];
    static int totalInvestidores = 0;
    static int totalStartups = 0;
    static int totalPitches = 0;
    static int totalInvestimentos = 0;

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
            System.out.println("---------- Cases Extras ----------");
            System.out.println("11) Listar Pitches");
            System.out.println("==================================");

            opcao = in.nextInt();
            in.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    cadastrarInvestidor(in);
                    break;
                case 2:
                    cadastrarStartup(in);
                    break;
                case 3:
                    adicionarPitch(in);
                    break;
                case 4:
                    adicionarInvestimento(in);
                    break;
                case 5:
                    listarStartup();
                    break;
                case 6:
                    listarInvestidores();
                    break;
                case 7:
                    consultarInvestimentos();
                    break;
                case 8:
                    // calcularValuation(in);
                    break;
                case 9:
                    // exibirRanking();
                    break;
                case 10:
                    // exibirIndiceUnicornizacao();
                    break;
                case 11:
                    listarPitches();
                    break;
                case 12:
                    consultarStartup(in);
                default:
                    System.out.println("Opção inválida!");
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
        String email1 = in.nextLine();
        String email = verificarEmail(email1, in);
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
            if(investidores[i].getNome().equals(nome)){
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

    public static void listarStartup(){
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrado.");
            return;
        }
        System.out.println("=== Startups Cadastradas ===");

        for (int i = 0; i < totalStartups; i++) {
            System.out.println("ID: " + startups[i].getId());
            System.out.println("Nome: " + startups[i].getNome());
            System.out.println("Área de Atuacao: " + startups[i].getAreaAtuacao());
            System.out.println("Data de criação: " + startups[i].getData());
            System.out.println("Investidor: " + startups[i].getInvestidor());
            System.out.println("-----------------------------");
        }
    }

    public static String verificarEmail(String email, Scanner in) {
        for (int i = 0; i < totalInvestidores; i++)
            if (email.equals(investidores[i].getEmail())) {
                System.out.println("Email já cadastrado!");
                System.out.println("Digite novamente um email:");
                email = in.nextLine();
                return email;
            } else {
                return email;
            }
        return email;
    }

    //Métodos para pitch

    public static void adicionarPitch(Scanner in) {
        System.out.println("Qual o id do pitch?");
        int id = in.nextInt();
        System.out.println("Qual o título da apresentacao?");
        String titulo = in.nextLine();
        System.out.println("Qual a nota de inovacao?");
        double notaIno = in.nextDouble();
        System.out.println("Qual a nota de mercado?");
        double notaMercado = in.nextDouble();
        System.out.println("Por fim, selecione uma das Startups abaixo:");
        listarStartup();
        System.out.println("Digite o id de uma das Startups acima:");
        int escolher = in.nextInt();
        for (int i = 0; i < totalStartups; i++) {
            if (startups[i].getId() == escolher) {
                System.out.println("Pitch registrado com sucesso!");
            } else {
                System.out.println("Tente novamente!");
            }
        }
        Pitch pitch = new Pitch(id, titulo, notaIno, notaMercado, startups[escolher]);
        pitches[totalPitches] = pitch;
        totalPitches++;
        System.out.println("Startup cadastrada com sucesso! Aperte ENTER para voltar ao menu.");

        if (totalPitches == 0) {
            System.out.println("Nenhuma startup cadastrado.");
            return;
        }
    }

    public static void listarPitches(){
        System.out.println("=== Pitches Cadastrados ===");

        for (int i = 0; i < totalPitches; i++) {
            System.out.println("ID: " + pitches[i].getId());
            System.out.println("Título: " + pitches[i].getTitulo());
            System.out.println("Nota Inovacao: " + pitches[i].getNotaInovacao());
            System.out.println("Nota Mercado: " + pitches[i].getNotaMercado());
            System.out.println("Startup Relacionada: " + pitches[i].getStartup());
            System.out.println("-----------------------------");
        }
    }

    public static void adicionarInvestimento(Scanner in){
        System.out.println("=== Adicionar Investimento ===");
        System.out.println("Digite o ID da Startup que você quer adicionar abaixo:");
        listarStartup();
        int idStartup = in.nextInt();
        for (int i = 0; i < totalStartups; i++) {
            if (startups[i].getId() == idStartup) {
                System.out.println("Startup encontrada: " + startups[i].getNome());
            } else {
                System.out.println("Startup não encontrada. Tente novamente.");
                return;
            }
        }
        System.out.println("Digite o ID do investidor abaixo:");
        listarInvestidores();
        int idInvestidor = in.nextInt();
        for (int i = 0; i < totalInvestidores; i++) {
            if (investidores[i].getId() == idInvestidor) {
                System.out.println("Investidor encontrado: " + investidores[i].getNome());
            } else {
                System.out.println("Investidor não encontrado. Tente novamente.");
                return;
            }
        }
        System.out.println("Digite o valor do investimento:");
        double valorInvestimento = in.nextDouble();
        Investimento investimento = new Investimento(startups[idStartup], valorInvestimento);
        System.out.println("Investimento adicionado com sucesso!");        
    }

    public static void consultarStartup(Scanner in){
            System.out.println("=== Startups Cadastradss ===");
            if (totalStartups == 0){
                System.out.println("Nenhuma Startup encontrada!");
            }else {
                for (int i = 0; i < totalStartups; i++) {
                    System.out.println("ID: " + startups[i].getId());
                    System.out.println("Nome: " + startups[i].getNome());
                    System.out.println("Area de Atuacao: " + startups[i].getAreaAtuacao());
                    System.out.println("Data: " + startups[i].getData());
                    System.out.println("Investidor: " + startups[i].getInvestidor());
                    System.out.println("Titulo de Pitch: " + pitches[i].getTitulo());
                    System.out.println("-----------------------------");
                }
            }
            System.out.println("Digite enter para voltar ao Menu!");
            in.nextLine();
    }

    public static void consultarInvestimentos(){
        for (int i = 0; i < totalInvestimentos; i++) {
            System.out.println("Startup ID: " + investimentos[i].getStartup());
            System.out.println("Valor da Startup captado: " + investimentos[i].getValorCaptado());
        }
    }

}