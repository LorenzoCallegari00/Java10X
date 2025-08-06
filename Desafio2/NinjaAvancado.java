package NivelIntermediario.Desafios.Desafio2;

public class NinjaAvancado extends NinjaBasico implements Ninja{
    String especialidade;

    public NinjaAvancado() {
    }

    public NinjaAvancado(String nome, int idade, String habilidade, TipoHabilidade tipoHabilidade, String especialidade) {
        super(nome, idade, habilidade, tipoHabilidade);
        this.especialidade = especialidade;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Habilidade: " + habilidade + " | Especialidade: " + especialidade + " | Tipo Habilidade: " + tipoHabilidade.name());
    }

    @Override
    public void executarHabilidade() {
        System.out.println("O ninja " + nome + " usou a habilidade: " + habilidade + " do tipo: " + tipoHabilidade.name());
    }
}
