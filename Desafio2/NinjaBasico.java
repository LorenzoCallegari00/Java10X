package NivelIntermediario.Desafios.Desafio2;

public class NinjaBasico implements Ninja{
    String nome;
    int idade;
    String habilidade;
    TipoHabilidade tipoHabilidade;

    public NinjaBasico() {
    }

    public NinjaBasico(String nome, int idade, String habilidade, TipoHabilidade tipoHabilidade) {
        this.nome = nome;
        this.idade = idade;
        this.habilidade = habilidade;
        this.tipoHabilidade = tipoHabilidade;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Habilidade: " + habilidade + " | Tipo Habilidade: " + tipoHabilidade.name());
    }

    @Override
    public void executarHabilidade() {
        System.out.println("O ninja " + nome + " usou a habilidade: " + habilidade + " do tipo: " + tipoHabilidade.name());
    }
}
