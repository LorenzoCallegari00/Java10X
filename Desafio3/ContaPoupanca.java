package NivelIntermediario.Desafios.Desafio3;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String nome, double saldo, TipoConta tipoConta) {
        super(nome, saldo, tipoConta);
    }

    public ContaPoupanca() {
    }

    @Override
    public void depositar(double valor) {
        double valorComTaxa = valor * 0.99;
        saldo += valorComTaxa;
        System.out.println("Você realizou um depósito de: R$" + valor + ". Aplicando um desconto de 1% devido a conta ser do tipo poupança, o valor depositado é de: R$" + valorComTaxa + ".");

    }

    @Override
    public String consultarSaldo() {
        return "Seu saldo é de: R$" + saldo + ".";
    }
}
