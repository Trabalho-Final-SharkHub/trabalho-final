import java.util.*;
public class Main {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int opcao = 0;

        while(opcao != 11){
            System.out.println("=========== Shark Hub ============");
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
            System.out.println("11) SAIR");
            System.out.println("==================================");

            opcao = in.nextInt();

            if(opcao == 1){
                cadastrarInvestidor(in);
            }
        }

    }

    public static void cadastrarInvestidor(Scanner in){
        final int MAX = 2;
        Investidor[] inv = new Investidor[MAX];
        int totalInvestidores = 0;
        if (totalInvestidores >= MAX) {
            System.out.println("Limite atingido.");
            return;
        }
        System.out.println("Digite o ID do investidor:");
        int id = in.nextInt();
        System.out.println("Digite o nome do investidor:");
        String nome = in.nextLine();
        in.nextLine();
        System.out.println("Digite o email do investidor:");
        String email = in.nextLine();
        Investidor novo = new Investidor(id, nome, email);
        inv[totalInvestidores] = novo;
        totalInvestidores++;
        System.out.println("Investidor cadastrado com sucesso! Aperte ENTER para voltar ao menu.");
        in.nextLine();
    }
}
