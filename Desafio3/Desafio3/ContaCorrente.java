package NivelIntermediario.Desafios.Desafio3;

//Classe concreta ContaCorrente
public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String nome, double saldo, TipoConta tipoConta) {
        super(nome, saldo, tipoConta);
    }

    public ContaCorrente() {
    }
}