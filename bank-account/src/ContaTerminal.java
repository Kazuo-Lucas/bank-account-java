import java.util.*;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Map<String, Conta> contas = new HashMap<>();
        String cpfAtual = null;
        int opcao;

        while(true) {
            exibirMenu(); 
            opcao = Integer.parseInt(scanner.nextLine());

            switch(opcao) {
                case 1 -> {
                    System.out.print("Digite seu CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();

                    if (contas.containsKey(cpf)) {
                        System.out.println("Conta já existe para este CPF.\n");
                    } else {
                        Conta novaConta = new Conta(cpf, nome);
                        contas.put(cpf, novaConta);
                        cpfAtual = cpf;
                        System.out.printf("Conta criada com sucesso! Número: %s, Agência: %s%n\n", novaConta.getNumero(), novaConta.getAgencia());
                    }
                }
                case 2 -> {
                    System.out.print("Digite seu CPF: ");
                    String cpf = scanner.nextLine();
                    if (contas.containsKey(cpf)) {
                        cpfAtual = cpf;
                        System.out.println("Você entrou na conta com sucesso!\n");
                    } else {
                        System.out.println("Conta não encontrada para o CPF informado.\n");
                    }
                }
                case 3 -> {
                    if (cpfAtual == null) {
                        System.out.println("Nenhuma conta logada. Por favor, crie uma conta primeiro.\n");
                    } else {
                        Conta conta = contas.get(cpfAtual);
                        System.out.printf("Saldo atual: R$%.2f%n\n", conta.getSaldo());
                    }
                }
                case 4 -> {
                    if (cpfAtual == null) {
                        System.out.println("Nenhuma conta logada. Por favor, crie uma conta primeiro.\n");
                        break;
                    }
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = Double.parseDouble(scanner.nextLine());
                    Conta conta = contas.get(cpfAtual);
                    conta.depositar(valorDeposito);
                }
                case 5 -> {
                    if (cpfAtual == null) {
                        System.out.println("Nenhuma conta logada. Por favor, crie uma conta primeiro.\n");
                        break;
                    }
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = Double.parseDouble(scanner.nextLine());
                    Conta conta = contas.get(cpfAtual);
                    conta.sacar(valorSaque);
                }
                case 6 -> {
                    if (cpfAtual == null) {
                        System.out.println("Nenhuma conta logada. Por favor, crie uma conta primeiro.\n");
                    } else {
                        Conta conta = contas.get(cpfAtual);
                        System.out.printf("Dados da Conta:\nNome: %s\nCPF: %s\nNúmero: %s\nAgência: %s\nSaldo: R$%.2f%n\n",
                                conta.getNome(), conta.getCpf(), conta.getNumero(), conta.getAgencia(), conta.getSaldo());
                    }
                }
                case 7 -> {
                    System.out.println("Digite o CPF do titular para trocar de conta: ");
                    String novoCpf = scanner.nextLine();
                    if (contas.containsKey(novoCpf)) {
                        cpfAtual = novoCpf;
                        System.out.println("Conta trocada com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada para o CPF informado.");
                    }
                }
                case 8 -> {
                    if (cpfAtual == null) {
                        System.out.println("Nenhuma conta logada. Por favor, crie ou entre em uma conta primeiro.\n");
                    } else {
                        cpfAtual = null; 
                        System.out.println("Você saiu da conta atual.\n");
                    }
                }   
                case 9 -> {
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                }
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("Bem-vindo ao Banco!");
        System.out.println("1. Criar Conta");
        System.out.println("2. Entrar em Conta");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Depositar");
        System.out.println("5. Sacar");
        System.out.println("6. Exibir Dados da Conta");
        System.out.println("7. Trocar de Conta");
        System.out.println("8. Sair da Conta");
        System.out.println("9. Sair");
        System.out.println("---------------------------");
        System.out.println("Escolha uma opção: ");
    }
}
