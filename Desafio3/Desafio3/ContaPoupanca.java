package NivelIntermediario.Desafios.Desafio3;

//Conta concreta ContaPoupanca
public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String nome, double saldo, TipoConta tipoConta) {
        super(nome, saldo, tipoConta);
    }

    public ContaPoupanca() {
    }

    //Metodo de deposito sobreescrito, devido ao fato de adicionar a taxa de deposito da conta poupanca
    @Override
    public void depositar(double valor) {
        double valorComTaxa = valor * 0.99;
        saldo += valorComTaxa;
        System.out.printf(
                "Você realizou um depósito de: R$%.2f. Aplicando um desconto de 1%% devido a conta ser do tipo poupança, o valor depositado é de: R$%.2f.%n", valor, valorComTaxa);
    }
}