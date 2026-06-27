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

    //Opcao 3 do menu - Adicionar Pitch.
     /* Fluxo: pedir id da startup -> buscar -> se nao existir, erro ->
     * pedir titulo e notas -> validar -> criar Pitch -> guardar no vetor.
     */
    /*public static void adicionarPitch(Scanner in) {
        if (totalStartups == 0) {
            System.out.println("Erro: nenhuma startup cadastrada. Cadastre uma startup antes.");
            return;
        }

        if (totalPitches >= MAX) {
            System.out.println("Erro: limite de pitches atingido.");
            return;
        }

        int idStartup = lerInteiro(in, "Id da startup: ");
        Startup startup = buscarStartupPorId(idStartup);

        if (startup == null) {
            System.out.println("Erro: startup nao encontrada.");
            return;
        }

        System.out.print("Titulo do pitch: ");
        String titulo = in.nextLine();

        if (titulo.isBlank()) {
            System.out.println("Erro: titulo invalido.");
            return;
        }

        double notaInovacao = lerDouble(in, "Nota de inovacao (0 a 10): ");
        if (notaInovacao < 0 || notaInovacao > 10) {
            System.out.println("Erro: nota deve estar entre 0 e 10.");
            return;
        }

        double notaMercado = lerDouble(in, "Nota de mercado (0 a 10): ");
        if (notaMercado < 0 || notaMercado > 10) {
            System.out.println("Erro: nota deve estar entre 0 e 10.");
            return;
        }

        int idPitch = totalPitches + 1; // id sequencial simples
        Pitch novoPitch = new Pitch(idPitch, titulo, notaInovacao, notaMercado, startup);

        pitches[totalPitches] = novoPitch;
        totalPitches++;

        System.out.println("Pitch cadastrado com sucesso.");
    }

    /**
     * Media dos pitches de UMA startup especifica.
     * Percorre o vetor de pitches filtrando pela startup (relacionamento).
     */
    /*public static double calcularMediaPitchesStartup(Startup startup) {
        double soma = 0;
        int quantidade = 0;

        for (int i = 0; i < totalPitches; i++) {
            if (pitches[i].getStartup().getId() == startup.getId()) {
                soma += pitches[i].calcularMediaPitch();
                quantidade++;
            }
        }

        if (quantidade == 0) {
            return 0;
        }

        return soma / quantidade;
    }

    /**
     * Opcao 4 do menu - Adicionar Investimento.
     * Fluxo: pedir id da startup -> buscar -> se nao existir, erro ->
     * pedir valor e percentual -> validar -> criar Investimento -> guardar no vetor.
     */
    /*static void adicionarInvestimento(Scanner in) {
        if (totalStartups == 0) {
            System.out.println("Erro: nenhuma startup cadastrada. Cadastre uma startup antes.");
            return;
        }

        if (totalInvestimentos >= MAX) {
            System.out.println("Erro: limite de investimentos atingido.");
            return;
        }

        int idStartup = lerInteiro(in, "Id da startup: ");
        Startup startup = buscarStartupPorId(idStartup);

        if (startup == null) {
            System.out.println("Erro: startup nao encontrada.");
            return;
        }

        double valor = lerDouble(in, "Valor investido (R$): ");
        if (valor <= 0) {
            System.out.println("Erro: valor investido deve ser maior que zero.");
            return;
        }

        double percentual = lerDouble(in, "Percentual de participacao (%): ");
        if (percentual <= 0) {
            System.out.println("Erro: percentual de participacao deve ser maior que zero.");
            return;
        }

        int idInvestimento = totalInvestimentos + 1; // id sequencial simples
        Investimento novoInvestimento = new Investimento(idInvestimento, valor, percentual, startup);

        investimentos[totalInvestimentos] = novoInvestimento;
        totalInvestimentos++;

        System.out.println("Investimento cadastrado com sucesso.");
    }

    /**
     * Opcao 7 do menu - Consultar Investimentos.
     * Lista todos os investimentos cadastrados (independente da startup).
     */
    /*static void consultarInvestimentos() {
        if (totalInvestimentos == 0) {
            System.out.println("Nenhum investimento cadastrado.");
            return;
        }

        System.out.println("\n--- Investimentos cadastrados ---");
        for (int i = 0; i < totalInvestimentos; i++) {
            System.out.println(investimentos[i]);
        }
    }

    /**
     * Soma o total investido em UMA startup especifica, percorrendo
     * o vetor de investimentos e filtrando pelo relacionamento com a startup.
     * Usado tanto pela consulta de startup quanto pelo calculo de valuation.
     */
    /*static double calcularTotalInvestidoStartup(Startup startup) {
        double soma = 0;
        for (int i = 0; i < totalInvestimentos; i++) {
            if (investimentos[i].getStartup().getId() == startup.getId()) {
                soma += investimentos[i].getValor();
            }
        }
        return soma;
    }

    /**
     * Opcao 8 do menu - Calcular Valuation.
     * Pede a startup, cria um objeto Valuation e calcula o total captado
     * somando os investimentos ligados a ela.
     */
    /*static void calcularValuation(Scanner in) {
        if (totalStartups == 0) {
            System.out.println("Erro: nenhuma startup cadastrada.");
            return;
        }

        int idStartup = lerInteiro(in, "Id da startup: ");
        Startup startup = buscarStartupPorId(idStartup);

        if (startup == null) {
            System.out.println("Erro: startup nao encontrada.");
            return;
        }

        Valuation valuation = new Valuation(startup);
        double total = valuation.calcularTotalCaptado(investimentos, totalInvestimentos);

        System.out.println("\n--- Valuation ---");
        System.out.println("Startup: " + startup.getNome());
        System.out.println("Total captado: R$ " + String.format("%.2f", total));
    }

 
    //IPU - INDICE DE POTENCIAL DE UNICORNIZACAO
    /**
     * IPU = mediaDosPitches * 25 + totalCaptado / 10000 + tempoExistenciaAnos * 10
     */
    /*static double calcularIPU(Startup startup) {
        double mediaPitches = calcularMediaPitchesStartup(startup);
        double totalCaptado = calcularTotalInvestidoStartup(startup);

        int anoAtual = 2026;
        int tempoExistencia;
        try {
            tempoExistencia = startup.calcularTempoExistencia(anoAtual);
            if (tempoExistencia < 0) {
                tempoExistencia = 0;
            }
        } catch (Exception e) {
            // Se a data estiver em formato invalido, considera tempo de existencia 0
            // em vez de quebrar o programa.
            tempoExistencia = 0;
        }

        return mediaPitches * 25 + totalCaptado / 10000 + tempoExistencia * 10;
    }

    static String classificarIPU(double ipu) {
        if (ipu <= 100) {
            return "Startup Inicial";
        } else if (ipu <= 250) {
            return "Startup Promissora";
        } else if (ipu <= 500) {
            return "Startup em Crescimento";
        } else {
            return "Potencial Unicornio";
        }
    }

    /**
     * Opcao 9 do menu - Exibir Ranking de Startups.
     * Calcula o IPU de cada startup cadastrada e ordena da maior
     * para a menor pontuacao usando ordenacao simples (dois for, bolha).
     */
    /*static void exibirRankingStartups() {
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrada.");
            return;
        }

        // Vetores auxiliares (tamanho = totalStartups) para nao alterar a ordem
        // original do vetor "startups", apenas a ordem do ranking.
        Startup[] ranking = new Startup[totalStartups];
        double[] pontuacoes = new double[totalStartups];

        for (int i = 0; i < totalStartups; i++) {
            ranking[i] = startups[i];
            pontuacoes[i] = calcularIPU(startups[i]);
        }

        // Ordenacao simples (bolha), da maior pontuacao para a menor.
        for (int i = 0; i < totalStartups - 1; i++) {
            for (int j = 0; j < totalStartups - 1 - i; j++) {
                if (pontuacoes[j] < pontuacoes[j + 1]) {
                    double pontoTemp = pontuacoes[j];
                    pontuacoes[j] = pontuacoes[j + 1];
                    pontuacoes[j + 1] = pontoTemp;

                    Startup startupTemp = ranking[j];
                    ranking[j] = ranking[j + 1];
                    ranking[j + 1] = startupTemp;
                }
            }
        }

        System.out.println("\n--- Ranking de Startups (por IPU) ---");
        for (int i = 0; i < totalStartups; i++) {
            System.out.println((i + 1) + "o lugar - " + ranking[i].getNome()
                    + " | IPU: " + String.format("%.2f", pontuacoes[i])
                    + " | Classificacao: " + classificarIPU(pontuacoes[i]));
        }
    }

    /**
     * Opcao 10 do menu - Exibir Indice de Unicornizacao.
     * Mostra: startup mais promissora, startup com maior volume de
     * investimentos, investidor com maior valor investido e a
     * classificacao de cada startup.
     */
    /*static void exibirIndiceUnicornizacao() {
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrada.");
            return;
        }

        // Startup mais promissora (maior IPU)
        Startup maisPromissora = startups[0];
        double maiorIPU = calcularIPU(startups[0]);

        for (int i = 1; i < totalStartups; i++) {
            double ipuAtual = calcularIPU(startups[i]);
            if (ipuAtual > maiorIPU) {
                maiorIPU = ipuAtual;
                maisPromissora = startups[i];
            }
        }

        // Startup com maior volume de investimentos (soma de valores captados)
        Startup maiorVolume = startups[0];
        double maiorTotalCaptado = calcularTotalInvestidoStartup(startups[0]);

        for (int i = 1; i < totalStartups; i++) {
            double totalAtual = calcularTotalInvestidoStartup(startups[i]);
            if (totalAtual > maiorTotalCaptado) {
                maiorTotalCaptado = totalAtual;
                maiorVolume = startups[i];
            }
        }

        // Investidor com maior valor investido.
        // Caminho: Investimento -> Startup -> Investidor principal.
        // Somamos, para cada investidor cadastrado, o total captado de
        // todas as startups das quais ele e o investidor principal.
        Investidor investidorComMaiorValor = null;
        double maiorValorInvestidor = -1;

        for (int i = 0; i < totalInvestidores; i++) {
            double totalDoInvestidor = 0;

            for (int j = 0; j < totalStartups; j++) {
                if (startups[j].getInvestidor().getId() == investidores[i].getId()) {
                    totalDoInvestidor += calcularTotalInvestidoStartup(startups[j]);
                }
            }

            if (totalDoInvestidor > maiorValorInvestidor) {
                maiorValorInvestidor = totalDoInvestidor;
                investidorComMaiorValor = investidores[i];
            }
        }

        System.out.println("\n--- Indice de Potencial de Unicornizacao (IPU) ---");
        System.out.println("Startup mais promissora: " + maisPromissora.getNome()
                + " (IPU: " + String.format("%.2f", maiorIPU) + ")");

        System.out.println("Startup com maior volume de investimentos: " + maiorVolume.getNome()
                + " (Total captado: R$ " + String.format("%.2f", maiorTotalCaptado) + ")");

        if (investidorComMaiorValor != null) {
            System.out.println("Investidor com maior valor investido: " + investidorComMaiorValor.getNome()
                    + " (Total: R$ " + String.format("%.2f", maiorValorInvestidor) + ")");
        }

        System.out.println("\n--- Classificacao de cada Startup ---");
        for (int i = 0; i < totalStartups; i++) {
            double ipu = calcularIPU(startups[i]);
            System.out.println(startups[i].getNome()
                    + " | IPU: " + String.format("%.2f", ipu)
                    + " | Classificacao: " + classificarIPU(ipu));
        }
    }
}*/
