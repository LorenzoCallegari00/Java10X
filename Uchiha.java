package NivelIntermediario.Desafio1;

public class Uchiha extends Ninja {
    String habilidadeEspecial;

    public String mostrarHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome + "| Idade: " + idade + " anos | Missão atual: " + missao + " | Nível dificuldade missão: " + nivelDificuldade + "| Status Missão: " + statusMissao + " | Habilidade Especial: " + habilidadeEspecial);
    }
}
