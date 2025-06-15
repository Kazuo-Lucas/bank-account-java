import java.util.Random;

public class Conta {
    private String numero;
    private String agencia;
    private String nome;
    private String cpf;
    private double saldo;

    public Conta(String cpf, String nome) {
        this.numero = gerarNumeroConta();
        this.agencia = gerarAgenciaConta(); 
        this.cpf = cpf;
        this.nome = nome;
        this.saldo = 0.0; 
    }

    private String gerarNumeroConta() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }   

    private String gerarAgenciaConta() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(9999)) + "-X";
    }

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNome() {
        return nome;
    }   

    public String getCpf() {
        return cpf;
    }   

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$%.2f realizado com sucesso!\n\n Saldo atual: R$%.2f%n\n", valor, saldo);
        } else {
            System.out.println("Valor de depósito inválido.\n");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$%.2f realizado com sucesso! Saldo atual: R$%.2f%n\n", valor, saldo);
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.\n");
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }

    public void exibirDados() {
        System.out.printf("Conta: %s\nAgência: %s\nTitular: %s\nCPF: %s\nSaldo: R$%.2f%n\n", numero, agencia, nome, cpf, saldo);
    }
}
