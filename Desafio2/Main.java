package NivelIntermediario.Desafios.Desafio2;

public class Main {
    public static void main(String[] args) {
        NinjaBasico naruto = new NinjaBasico("Naruto", 17, "Clones das Sombras", TipoHabilidade.NINJUTSU);
        naruto.mostrarInformacoes();
        naruto.executarHabilidade();

        NinjaAvancado sasuke = new NinjaAvancado("Sasuke", 18, "Amaterasu", TipoHabilidade.RINNEGAN, "Fogo");
        sasuke.mostrarInformacoes();
        sasuke.executarHabilidade();
    }
}
