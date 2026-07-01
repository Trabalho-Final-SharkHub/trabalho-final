import java.util.*;
public class Main {
    static final int MAX = 100;
    static final int MAXPitch = 2000;
    //cria vetor para investidores
    static Investidor[] investidores = new Investidor[MAX];
    //cria vetor para startups
    static Startup [] startups = new Startup[MAX];
    //vetor de pitches
    static Pitch [] pitches = new Pitch[MAXPitch];
    //vetor de investimentos
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
            System.out.println("10) Exibir Indice de Unicornizacao (IPU)");
            System.out.println("---------- Cases Extras ----------");
            System.out.println("11) Listar Pitches");
            System.out.println("12) Simulador de Crescimento (5 anos)");
            System.out.println("==================================");

            opcao = lerInteiro(in, "Escolha uma opcao: ");

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
                    consultarStartup(in);
                    break;
                case 6:
                    listarInvestidores();
                    break;
                case 7:
                    consultarInvestimentos();
                    break;
                case 8:
                    calcularValuation(in);
                    break;
                case 9:
                    exibirRankingStartups();
                    break;
                case 10:
                    exibirIndiceUnicornizacao();
                    break;
                case 11:
                    listarPitches();
                    break;
                case 12:
                    simuladorCrescimento(in);
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    // ===================== Leitura segura (resolve o bug do Scanner) =====================

    // Le um inteiro e consome o "Enter" que sobra no buffer (resolve o bug do Scanner).
    public static int lerInteiro(Scanner in, String mensagem){
        System.out.print(mensagem);
        int valor = in.nextInt();
        in.nextLine(); // limpa o buffer
        return valor;
    }

    // Le um double e consome o "Enter" que sobra no buffer.
    public static double lerDouble(Scanner in, String mensagem){
        System.out.print(mensagem);
        double valor = in.nextDouble();
        in.nextLine(); // limpa o buffer
        return valor;
    }

    // ===================== Opcao 1 - Cadastrar Investidor =====================
    public static void cadastrarInvestidor(Scanner in){
        if (totalInvestidores >= MAX) {
            System.out.println("Limite de investidores atingido.");
            return;
        }
        int id = lerInteiro(in, "Digite o ID do investidor: ");
        System.out.print("Digite o nome do investidor: ");
        String nome = in.nextLine();

        String email;
        do {
            System.out.print("Digite o email do investidor: ");
            email = in.nextLine();
            if (emailJaExiste(email)) {
                System.out.println("Email ja cadastrado! Informe outro.");
            }
        } while (emailJaExiste(email));

        Investidor novo = new Investidor(id, nome, email);
        investidores[totalInvestidores] = novo;
        totalInvestidores++;
        System.out.println("Investidor cadastrado com sucesso!");
    }

    // ===================== Opcao 2 - Cadastrar Startup =====================
    public static void cadastrarStartup(Scanner in){
        if (totalStartups >= MAX){
            System.out.println("Limite de Startups no programa atingido!");
            return;
        }
        if (totalInvestidores == 0) {
            System.out.println("Cadastre um investidor antes de cadastrar uma startup.");
            return;
        }
        int id = lerInteiro(in, "Digite o ID da Startup: ");
        System.out.print("Digite o nome da Startup: ");
        String nome = in.nextLine();
        System.out.print("Digite a Area de Atuacao da Startup: ");
        String areaAtuacao = in.nextLine();
        System.out.print("Digite a data de fundacao (formato dd/mm/aaaa): ");
        String data = in.nextLine();

        System.out.println("Escolha o investidor responsavel pelo nome:");
        listarInvestidores();
        System.out.print("Nome do investidor: ");
        String nomeInvestidor = in.nextLine();
        Investidor investidorEscolhido = buscarInvestidor(nomeInvestidor);
        if (investidorEscolhido == null) {
            System.out.println("Investidor nao encontrado!");
            return;
        }
        Startup novo = new Startup(id, nome, areaAtuacao, data, investidorEscolhido);
        startups[totalStartups] = novo;
        totalStartups++;
        System.out.println("Startup cadastrada com sucesso!");
    }

    // ===================== Buscas (reuso) =====================
    public static Investidor buscarInvestidor(String nome){
        for(int i = 0; i < totalInvestidores; i++){
            if(investidores[i].getNome().equals(nome)){
                return investidores[i];
            }
        }
        return null;
    }

    public static Startup buscarStartupPorId(int id){
        for (int i = 0; i < totalStartups; i++) {
            if (startups[i].getId() == id) {
                return startups[i];
            }
        }
        return null;
    }

    public static Investidor buscarInvestidorPorId(int id){
        for (int i = 0; i < totalInvestidores; i++) {
            if (investidores[i].getId() == id) {
                return investidores[i];
            }
        }
        return null;
    }

    // Responde "esse e-mail ja existe?" comparando com TODOS os investidores.
    public static boolean emailJaExiste(String email){
        for (int i = 0; i < totalInvestidores; i++) {
            if (email.equals(investidores[i].getEmail())) {
                return true;
            }
        }
        return false;
    }

    // ===================== Opcao 6 - Listar Investidores =====================
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
            System.out.println("Nenhuma startup cadastrada.");
            return;
        }
        System.out.println("=== Startups Cadastradas ===");
        for (int i = 0; i < totalStartups; i++) {
            System.out.println("ID: " + startups[i].getId()
                    + " | Nome: " + startups[i].getNome()
                    + " | Area: " + startups[i].getAreaAtuacao()
                    + " | Investidor: " + startups[i].getInvestidor().getNome());
        }
    }

    // ===================== Opcao 3 - Adicionar Pitch =====================
    public static void adicionarPitch(Scanner in) {
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrada. Cadastre uma startup antes.");
            return;
        }
        if (totalPitches >= MAXPitch) {
            System.out.println("Limite de pitches atingido.");
            return;
        }

        int id = lerInteiro(in, "Qual o id do pitch? ");
        System.out.print("Qual o titulo da apresentacao? ");
        String titulo = in.nextLine();

        double notaIno = lerDouble(in, "Qual a nota de inovacao (0 a 10)? ");
        if (notaIno < 0 || notaIno > 10) {
            System.out.println("Nota invalida. Deve estar entre 0 e 10.");
            return;
        }
        double notaMercado = lerDouble(in, "Qual a nota de mercado (0 a 10)? ");
        if (notaMercado < 0 || notaMercado > 10) {
            System.out.println("Nota invalida. Deve estar entre 0 e 10.");
            return;
        }

        System.out.println("Selecione a Startup pelo ID:");
        listarStartup();
        int escolher = lerInteiro(in, "Digite o id da Startup: ");
        Startup startup = buscarStartupPorId(escolher);
        if (startup == null) {
            System.out.println("Startup nao encontrada!");
            return;
        }

        Pitch pitch = new Pitch(id, titulo, notaIno, notaMercado, startup);
        pitches[totalPitches] = pitch;
        totalPitches++;
        System.out.println("Pitch registrado com sucesso!");
    }

    // ===================== Opcao 11 - Listar Pitches =====================
    public static void listarPitches(){
        if (totalPitches == 0) {
            System.out.println("Nenhum pitch cadastrado.");
            return;
        }
        System.out.println("=== Pitches Cadastrados ===");
        for (int i = 0; i < totalPitches; i++) {
            System.out.println("ID: " + pitches[i].getId());
            System.out.println("Titulo: " + pitches[i].getTitulo());
            System.out.println("Nota Inovacao: " + pitches[i].getNotaInovacao());
            System.out.println("Nota Mercado: " + pitches[i].getNotaMercado());
            System.out.println("Media: " + pitches[i].calcularMediaPitch());
            System.out.println("Startup Relacionada: " + pitches[i].getStartup().getNome());
            System.out.println("-----------------------------");
        }
    }

    // ===================== Opcao 4 - Adicionar Investimento =====================
    public static void adicionarInvestimento(Scanner in){
        System.out.println("=== Adicionar Investimento ===");
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrada. Cadastre uma startup antes.");
            return;
        }
        if (totalInvestimentos >= MAX) {
            System.out.println("Limite de investimentos atingido.");
            return;
        }

        System.out.println("Escolha a Startup pelo ID:");
        listarStartup();
        int idStartup = lerInteiro(in, "Digite o ID da Startup: ");
        Startup startup = buscarStartupPorId(idStartup);
        if (startup == null) {
            System.out.println("Startup nao encontrada. Tente novamente.");
            return;
        }

        double valor = lerDouble(in, "Digite o valor do investimento (R$): ");
        if (valor <= 0) {
            System.out.println("Valor invalido. Deve ser maior que zero.");
            return;
        }
        double percentual = lerDouble(in, "Digite o percentual de participacao (%): ");
        if (percentual <= 0 || percentual > 100) {
            System.out.println("Percentual invalido. Deve estar entre 0 e 100.");
            return;
        }

        int idInvestimento = totalInvestimentos + 1; // id sequencial simples
        Investimento investimento = new Investimento(idInvestimento, valor, percentual, startup);
        investimentos[totalInvestimentos] = investimento;
        totalInvestimentos++;
        System.out.println("Investimento adicionado com sucesso!");
    }

    // ===================== Opcao 7 - Consultar Investimentos =====================
    public static void consultarInvestimentos(){
        if (totalInvestimentos == 0) {
            System.out.println("Nenhum investimento cadastrado.");
            return;
        }
        System.out.println("=== Investimentos cadastrados ===");
        for (int i = 0; i < totalInvestimentos; i++) {
            System.out.println("ID: " + investimentos[i].getId());
            System.out.println("Valor: R$ " + investimentos[i].getValor());
            System.out.println("Participacao: " + investimentos[i].getPercentualParticipacao() + "%");
            System.out.println("Startup: " + investimentos[i].getStartup().getNome());
            System.out.println("-----------------------------");
        }
    }

    // Soma o total investido em UMA startup especifica (filtra pelo ID da startup).
    public static double calcularTotalInvestidoStartup(Startup startup){
        double soma = 0;
        for (int i = 0; i < totalInvestimentos; i++) {
            if (investimentos[i].getStartup().getId() == startup.getId()) {
                soma += investimentos[i].getValor();
            }
        }
        return soma;
    }

    // Media dos pitches de UMA startup especifica.
    public static double calcularMediaPitchesStartup(Startup startup){
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

    // ===================== Opcao 5 - Consultar Startup (dossie completo) =====================
    public static void consultarStartup(Scanner in){
        if (totalStartups == 0){
            System.out.println("Nenhuma Startup cadastrada!");
            return;
        }
        System.out.println("Escolha a Startup pelo ID:");
        listarStartup();
        int id = lerInteiro(in, "Digite o ID da Startup: ");
        Startup startup = buscarStartupPorId(id);
        if (startup == null) {
            System.out.println("Startup nao encontrada!");
            return;
        }

        System.out.println("\n===== Dossie da Startup =====");
        System.out.println("ID: " + startup.getId());
        System.out.println("Nome: " + startup.getNome());
        System.out.println("Area de Atuacao: " + startup.getAreaAtuacao());
        System.out.println("Data de fundacao: " + startup.getData());
        System.out.println("Tempo de existencia: " + startup.calcularExistencia() + " ano(s)");
        System.out.println("Investidor responsavel: " + startup.getInvestidor().getNome());

        System.out.println("\n--- Pitches ---");
        boolean temPitch = false;
        for (int i = 0; i < totalPitches; i++) {
            if (pitches[i].getStartup().getId() == startup.getId()) {
                System.out.println("- " + pitches[i].getTitulo()
                        + " | Media: " + pitches[i].calcularMediaPitch());
                temPitch = true;
            }
        }
        if (!temPitch) System.out.println("Nenhum pitch cadastrado para esta startup.");

        System.out.println("\n--- Investimentos ---");
        boolean temInvest = false;
        for (int i = 0; i < totalInvestimentos; i++) {
            if (investimentos[i].getStartup().getId() == startup.getId()) {
                System.out.println("- R$ " + investimentos[i].getValor()
                        + " (" + investimentos[i].getPercentualParticipacao() + "%)");
                temInvest = true;
            }
        }
        if (!temInvest) System.out.println("Nenhum investimento cadastrado para esta startup.");

        Valuation valuation = new Valuation(startup);
        double total = valuation.calcularTotalCaptado(investimentos, totalInvestimentos);
        System.out.println("\nTotal captado: R$ " + total);
        System.out.println("=============================");
    }

    // ===================== Opcao 8 - Calcular Valuation =====================
    public static void calcularValuation(Scanner in){
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrada.");
            return;
        }
        System.out.println("Escolha a Startup pelo ID:");
        listarStartup();
        int idStartup = lerInteiro(in, "Digite o ID da Startup: ");
        Startup startup = buscarStartupPorId(idStartup);
        if (startup == null) {
            System.out.println("Startup nao encontrada.");
            return;
        }

        Valuation valuation = new Valuation(startup);
        double total = valuation.calcularTotalCaptado(investimentos, totalInvestimentos);
        System.out.println("\n--- Valuation ---");
        System.out.println("Startup: " + startup.getNome());
        System.out.println("Total captado: R$ " + total);
    }

    // ===================== IPU - Indice de Potencial de Unicornizacao =====================
    // IPU = mediaDosPitches * 25 + totalCaptado / 10000 + tempoExistenciaAnos * 10
    public static double calcularIPU(Startup startup){
        double mediaPitches = calcularMediaPitchesStartup(startup);
        double totalCaptado = calcularTotalInvestidoStartup(startup);
        int tempoExistencia = startup.calcularExistencia();
        return mediaPitches * 25 + totalCaptado / 10000 + tempoExistencia * 10;
    }

    public static String classificarIPU(double ipu){
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

    // ===================== Opcao 9 - Ranking de Startups (por IPU) =====================
    public static void exibirRankingStartups(){
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrada.");
            return;
        }

        // Vetores auxiliares para nao alterar a ordem original do vetor "startups".
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
                    + " | IPU: " + pontuacoes[i]
                    + " | Classificacao: " + classificarIPU(pontuacoes[i]));
        }
    }

    // ===================== Opcao 10 - Indice de Unicornizacao =====================
    public static void exibirIndiceUnicornizacao(){
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

        // Startup com maior volume de investimentos
        Startup maiorVolume = startups[0];
        double maiorTotalCaptado = calcularTotalInvestidoStartup(startups[0]);
        for (int i = 1; i < totalStartups; i++) {
            double totalAtual = calcularTotalInvestidoStartup(startups[i]);
            if (totalAtual > maiorTotalCaptado) {
                maiorTotalCaptado = totalAtual;
                maiorVolume = startups[i];
            }
        }

        // Investidor com maior valor investido (soma das startups das quais ele e responsavel)
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
                + " (IPU: " + maiorIPU + ")");
        System.out.println("Startup com maior volume de investimentos: " + maiorVolume.getNome()
                + " (Total captado: R$ " + maiorTotalCaptado + ")");
        if (investidorComMaiorValor != null) {
            System.out.println("Investidor com maior valor investido: " + investidorComMaiorValor.getNome()
                    + " (Total: R$ " + maiorValorInvestidor + ")");
        }

        System.out.println("\n--- Ranking das Startups ---");
        exibirRankingStartups();

        System.out.println("\n--- Classificacao de cada Startup ---");
        for (int i = 0; i < totalStartups; i++) {
            double ipu = calcularIPU(startups[i]);
            System.out.println(startups[i].getNome()
                    + " | IPU: " + ipu
                    + " | Classificacao: " + classificarIPU(ipu));
        }
    }

    // ===================== Opcao 12 - Simulador de Crescimento (desafio extra) =====================
    public static void simuladorCrescimento(Scanner in){
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrada.");
            return;
        }
        System.out.println("Escolha a Startup pelo ID:");
        listarStartup();
        int idStartup = lerInteiro(in, "Digite o ID da Startup: ");
        Startup startup = buscarStartupPorId(idStartup);
        if (startup == null) {
            System.out.println("Startup nao encontrada.");
            return;
        }

        double valor = calcularTotalInvestidoStartup(startup);
        if (valor <= 0) {
            System.out.println("Esta startup ainda nao captou investimentos. Usando valor base de R$ 1000,00.");
            valor = 1000;
        }
        double percentual = lerDouble(in, "Percentual de crescimento anual (%): ");

        System.out.println("\n--- Projecao de crescimento (5 anos) para " + startup.getNome() + " ---");
        System.out.println("Ano 0: R$ " + valor);
        for (int ano = 1; ano <= 5; ano++) {
            valor = valor * (1 + percentual / 100);
            System.out.println("Ano " + ano + ": R$ " + valor);
        }
    }
}
