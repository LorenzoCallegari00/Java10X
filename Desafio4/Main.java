package NivelIntermediario.Desafios.Desafio4;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        //Iniciar LinkedList
        LinkedList<Ninja> ninjaLinkedList = new LinkedList<>();
        ninjaLinkedList.add(new Ninja("Naruto Uzumaki", 17, "Konoha"));
        ninjaLinkedList.add(new Ninja("Sasuke Uchiha", 17, "Konoha"));
        ninjaLinkedList.add(new Ninja("Sakura Haruno", 17, "Konoha"));
        ninjaLinkedList.add(new Ninja("Kakashi Hatake", 31, "Konoha"));
        ninjaLinkedList.add(new Ninja("Gaara", 17, "Areia"));
        ninjaLinkedList.add(new Ninja("Shikamaru Nara", 17, "Konoha"));
        ninjaLinkedList.add(new Ninja("Temari", 18, "Areia"));

        while (run) {
            int escolha = menu(scanner);
            switch (escolha) {
                case 1:
                    //Adicionar ninjas ao inicio da lista
                    adicionarNinja(scanner, ninjaLinkedList);
                    break;
                case 2:
                    //Remover o ninja no inicio da lista
                    removerNinja(scanner, ninjaLinkedList);
                    break;
                case 3:
                    //Exibir lista de Ninjas
                    exibirListaNinjas(ninjaLinkedList);
                    break;
                case 4:
                    //Procurar Ninja por Indice
                    procurarNinjaPorIndice(scanner, ninjaLinkedList);
                    break;
                case 5:
                    //Ordenar Lista
                    ordenarListaNinjas(scanner, ninjaLinkedList);
                    break;
                case 6:
                    //Procurar Ninja por Nome
                    procurarNinjaPorNome(scanner, ninjaLinkedList);
                    break;
                case 7:
                    System.out.println("Programa Encerrado");
                    run = false;
                default:
                    System.out.println("Opção Inválida");
            }

        }

    }

    //Métodos
    public static int menu(Scanner scanner) {
        System.out.println("==================================================");
        System.out.println("Bem-vindo ao programa de Lista de Ninjas");
        System.out.println("1 - Adicionar Ninja ao início");
        System.out.println("2 - Remover Ninja do início");
        System.out.println("3 - Exibir lista completa");
        System.out.println("4 - Procurar Ninja por Índice");
        System.out.println("5 - Ordenar Lista");
        System.out.println("6 - Procurar Ninja por nome");
        System.out.println("7 - Encerrar programa");
        System.out.print("Selecione a opção que deseja: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        return escolha;
    }

    //Adicionar ninjas
    public static void adicionarNinja(Scanner scanner, LinkedList<Ninja> ninjaLinkedList) {
        System.out.println("========== Adicionar Ninja ao início da lista ==========");

        System.out.print("Digite o nome do ninja a ser adicionado: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do ninja a ser adicionado: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a vila do ninja a ser adicionado: ");
        String vila = scanner.nextLine();

        ninjaLinkedList.addFirst(new Ninja(nome, idade, vila));
        System.out.println("Ninja adicionado");
    }

    public static void  removerNinja(Scanner scanner, LinkedList<Ninja> ninjaLinkedList) {
        System.out.println("========== Remover Ninja do início da lista ==========");
        if (ninjaLinkedList.isEmpty()) {
            System.out.println("A lista está vazia");
            return;
        }
        System.out.println("Ninja a ser removido: " + ninjaLinkedList.peekFirst());
        System.out.print("Deseja continuar? [Y/N]: ");
        String escolha = scanner.nextLine();
        if (escolha.equalsIgnoreCase("y")) {
            ninjaLinkedList.removeFirst();
            System.out.println("Ninja removido com sucesso!");
        } else if (escolha.equalsIgnoreCase("n")){
            System.out.println("Remoção Cancelada");
        } else {
            System.out.println("Opção Inválida");
        }
    }

    public static void exibirListaNinjas(LinkedList<Ninja> ninjaLinkedList) {
        System.out.println("========== Exibir Lista de Ninjas ==========");
        if (ninjaLinkedList.isEmpty()) {
            System.out.println("A lista está vazia");
            return;
        }
        for (Ninja n :ninjaLinkedList) {
            System.out.println(n + ",");
        }
    }

    public static void procurarNinjaPorIndice(Scanner scanner, LinkedList<Ninja> ninjaLinkedList) {
        System.out.println("========== Procurar Ninja por Índice ==========");
        if (ninjaLinkedList.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }

        System.out.print("Qual o índice que deseja pesquisar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("O Ninja no índice [" + indice + "] é : " + ninjaLinkedList.get(indice));
    }

    public static void ordenarListaNinjas(Scanner scanner, LinkedList<Ninja> ninjaLinkedList) {
        System.out.println("========== Ordenar Lista de Ninjas ==========");
        if (ninjaLinkedList.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }

        System.out.println("Deseja ordenar a Lista de que modo: ");
        System.out.println("1 - Nome");
        System.out.println("2 - Idade");
        System.out.print("3 - Vila : ");
        int ordenar = scanner.nextInt();
        scanner.nextLine();

        switch (ordenar) {
            case 1:
                ninjaLinkedList.sort(Comparator.comparing(Ninja::getNome));
                exibirListaNinjas(ninjaLinkedList);
                break;
            case 2:
                ninjaLinkedList.sort(Comparator.comparing(Ninja::getIdade));
                exibirListaNinjas(ninjaLinkedList);
                break;
            case 3:
                ninjaLinkedList.sort(Comparator.comparing(Ninja::getVila));
                exibirListaNinjas(ninjaLinkedList);
                break;
            default:
                System.out.println("Opção Inválida");
        }
        System.out.println("Lista ordenada com Sucesso!");
    }

    public static void procurarNinjaPorNome (Scanner scanner, LinkedList<Ninja> ninjaLinkedList) {
        System.out.println("========== Procurar Ninja por Nome ==========");
        if (ninjaLinkedList.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }

        System.out.print("Qual o nome do Ninja que deseja procurar: ");
        String nome = scanner.nextLine();
        for (Ninja n : ninjaLinkedList) {
            if (nome.equalsIgnoreCase(n.getNome())) {
                System.out.println("Ninja encontrado: \n " + n);
                return;
            }
        }
        System.out.println("Ninja não encontrado");
    }
}
