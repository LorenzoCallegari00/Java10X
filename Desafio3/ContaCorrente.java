package NivelIntermediario.Desafios.Desafio3;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String nome, double saldo, TipoConta tipoConta) {
        super(nome, saldo, tipoConta);
    }

    public ContaCorrente() {
    }


    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Você realizou um depósito de: R$" + valor + ".");
    }

    @Override
    public String consultarSaldo() {
        return "Seu saldo é de: R$" + saldo + ".";
    }
}
