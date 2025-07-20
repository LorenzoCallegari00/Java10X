package NivelIntermediario.Desafio1;

public class Ninja {
    String nome;
    int idade;
    String missao;
    String nivelDificuldade;
    String statusMissao;

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome + "| Idade: " + idade + " anos | Missão atual: " + missao + " | Nível dificuldade missão: " + nivelDificuldade + "| Status Missão: " + statusMissao);
    }
}
