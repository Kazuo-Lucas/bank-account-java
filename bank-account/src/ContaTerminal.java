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
                        System.out.println("Conta já existe para este CPF.");
                    } else {
                        Conta novaConta = new Conta(cpf, nome);
                        contas.put(cpf, novaConta);
                        cpfAtual = cpf;
                        System.out.printf("Conta criada com sucesso! Número: %s, Agência: %s%n", novaConta.getNumero(), novaConta.getAgencia());
                    }
                }
                case 2 -> {
                    System.out.println("Digite o CPF para consultar o saldo: ");
                    cpfAtual = scanner.nextLine();
                    if (!contas.containsKey(cpfAtual)) {
                        System.out.println("Conta não encontrada para o CPF informado.");
                        cpfAtual = null; // Reseta o CPF atual se não encontrado
                    }
                    if (cpfAtual == null) {
                        System.out.println("Nenhuma conta criada. Por favor, crie uma conta primeiro.");
                    } else {
                        Conta conta = contas.get(cpfAtual);
                        System.out.printf("Saldo atual: R$%.2f%n", conta.getSaldo());
                    }
                }
                case 3 -> {
                    System.out.println("Digite o CPF do titular para realizar o deposito: ");
                    cpfAtual = scanner.nextLine();
                    if (cpfAtual == null) {
                        System.out.println("Nenhuma conta criada. Por favor, crie uma conta primeiro.");
                        break;
                    }
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = Double.parseDouble(scanner.nextLine());
                    Conta conta = contas.get(cpfAtual);
                    conta.depositar(valorDeposito);
                }
                case 4 -> {
                    System.out.println("Digite o CPF do titular para realizar o saque: ");
                    cpfAtual = scanner.nextLine();
                    if (cpfAtual == null) {
                        System.out.println("Nenhuma conta criada. Por favor, crie uma conta primeiro.");
                        break;
                    }
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = Double.parseDouble(scanner.nextLine());
                    Conta conta = contas.get(cpfAtual);
                    conta.sacar(valorSaque);
                }
                case 5 -> {
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
        System.out.println("2. Consultar Saldo");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Sair");
        System.out.println("---------------------------");
        System.out.println("Escolha uma opção: ");
    }
}
