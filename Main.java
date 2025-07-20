package NivelIntermediario.Desafio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int MAX_LEN = 10;
        Uchiha[] uchihas = new Uchiha[MAX_LEN];
        Ninja[] ninjas = new Ninja[MAX_LEN];
        int quantidadeComuns = 0;
        int quantidadeUchihas = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Menu Ninja =====");
            System.out.println("1. Adicionar novos ninjas");
            System.out.println("2. Exibir informações de todos os ninjas");
            System.out.println("3. Atualizar habilidades especiais");
            System.out.println("4. Sair do programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar novos ninjas selecionado");
                    System.out.println("Selecione o tipo de ninja que deseja cadastrar");
                    System.out.println("1. Ninja Comum");
                    System.out.println("2. Uchiha");
                    int tipoNinja = scanner.nextInt();
                    switch (tipoNinja) {
                        case 1:
                            if (quantidadeComuns >= MAX_LEN) {
                                System.out.println("Número máximo de ninjas comuns cadastrados.");
                                break;
                            }

                            System.out.print("Digite o nome do ninja: ");
                            scanner.nextLine();
                            ninjas[quantidadeComuns] = new Ninja();
                            ninjas[quantidadeComuns].nome = scanner.nextLine();
                            System.out.print("Digite a idade do ninja: ");
                            ninjas[quantidadeComuns].idade = scanner.nextInt();
                            System.out.print("Digite a qual missão o ninja está designado: ");
                            scanner.nextLine();
                            ninjas[quantidadeComuns].missao = scanner.nextLine();
                            System.out.print("Qual o nível de dificuldade da missão do ninja: ");
                            ninjas[quantidadeComuns].nivelDificuldade = scanner.nextLine();
                            System.out.print("Qual o status da missao do ninja: ");
                            ninjas[quantidadeComuns].statusMissao = scanner.nextLine();
                            System.out.println("Ninja cadastrado com sucesso!");
                            quantidadeComuns++;
                            break;
                        case 2:
                            if (quantidadeUchihas >= MAX_LEN) {
                                System.out.println("Número máximo de Uchihas cadastrados");
                                break;
                            }

                            System.out.print("Digite o nome do ninja: ");
                            scanner.nextLine();
                            uchihas[quantidadeUchihas] = new Uchiha();
                            uchihas[quantidadeUchihas].nome = scanner.nextLine();
                            System.out.print("Digite a idade do ninja: ");
                            uchihas[quantidadeUchihas].idade = scanner.nextInt();
                            System.out.print("Digite a qual missão o ninja está designado: ");
                            scanner.nextLine();
                            uchihas[quantidadeUchihas].missao = scanner.nextLine();
                            System.out.print("Qual o nível de dificuldade da missão do ninja: ");
                            uchihas[quantidadeUchihas].nivelDificuldade = scanner.nextLine();
                            System.out.print("Qual o status da missao do ninja: ");
                            uchihas[quantidadeUchihas].statusMissao = scanner.nextLine();
                            System.out.print("Qual a habilidade especial do ninja: ");
                            uchihas[quantidadeUchihas].habilidadeEspecial = scanner.nextLine();
                            System.out.println("Ninja cadastrado com sucesso!");
                            quantidadeUchihas++;
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }

                    break;
                case 2:
                    System.out.println("Exibir informações de ninjas selecionado");
                    for (int i = 0; i < quantidadeComuns; i++) {
                        ninjas[i].mostrarInformacoes();
                    }
                    for (int i = 0; i < quantidadeUchihas; i++) {
                        uchihas[i].mostrarInformacoes();
                    }
                    break;
                case 3:
                    System.out.println("Atualização de Habilidades Especiais selecionada");
                    System.out.print("Digite o nome do ninja que deseja alterar a habilidade:");
                    scanner.nextLine();
                    String opcaoNomeMudarHabilidade = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < quantidadeUchihas; i++) {
                        if (opcaoNomeMudarHabilidade.equals(uchihas[i].nome)) {
                            System.out.println("A habilidade do ninja " + uchihas[i].nome + " atual é: " + uchihas[i].mostrarHabilidadeEspecial());
                            System.out.println("Digite a nova habilidade do ninja " + uchihas[i].nome);
                            uchihas[i].habilidadeEspecial = scanner.nextLine();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Ninja não encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Você escolheu sair do programa");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}