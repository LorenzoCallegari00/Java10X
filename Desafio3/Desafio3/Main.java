package NivelIntermediario.Desafios.Desafio3;

import java.util.Scanner;


// Metodo Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("      Bem vindo ao Banco de Konoha");
        System.out.println("==========================================");
        System.out.println(" ");

        //Inicialização dos objetos de cada conta
        ContaCorrente contaCorrente = null;
        ContaPoupanca contaPoupanca = null;


        //Inicio do programa
        while (true) {
            menuBanco();

            int opcao = scanner.nextInt();

            scanner.nextLine();

            //Encerramento do programa caso o usuario deseje sair
            if (opcao == 5) {
                System.out.println("Você escolheu sair do programa");
                System.out.println("Obrigado por usar o Banco de Konoha");
                break;
            }

            switch (opcao) {

                //Case para a criacao de contas
                case 1:
                    //Tipo de conta desejado
                    System.out.println("Selecione o tipo de conta que deseja abrir");
                    System.out.println("1 - Corrente");
                    System.out.println("2 - Poupança");
                    System.out.println("3 - Cancelar");
                    int tipoConta = scanner.nextInt();
                    scanner.nextLine();

                    //Entrada dos dados da conta
                    System.out.println("Digite os dados da conta");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();

                    //Condicionais para criacao de conta com nome, saldo e tipo da conta
                    if (tipoConta == 1) {
                        contaCorrente = new ContaCorrente(nome, saldo, TipoConta.CORRENTE);
                    } else if (tipoConta == 2) {
                        contaPoupanca = new ContaPoupanca(nome, saldo, TipoConta.POUPANCA);
                    } else if (tipoConta == 3) {
                        System.out.println("Cancelando abertura de conta");
                    } else {
                        System.out.println("Opção Inválida");
                    }
                    break;
                //Caso para consultar saldo das contas
                case 2:
                    System.out.println("Selecione qual a sua conta: ");
                    System.out.println("Corrente");
                    System.out.println("Poupança");
                    String contaSaldo = scanner.nextLine();

                    //Criacao de variavel para escolher o tipo da conta
                    ContaBancaria consultaSaldo = tipoDeConta(contaSaldo, contaCorrente, contaPoupanca);

                    //Condicional para saber se a conta existe e, se sim, mostrar o seu saldo
                    if (consultaSaldo != null) {
                        System.out.println(consultaSaldo.consultarSaldo());
                    } else {
                        System.out.println("Conta Inválida ou Inexistente");
                    }
                    break;
                //Caso para depositar
                case 3:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Para qual conta será o depósito: ");
                    System.out.println("Corrente");
                    System.out.println("Poupança");
                    String contaDeposito = scanner.nextLine();

                    //Criacao de variavel para escolher o tipo da conta
                    ContaBancaria consultaDeposito = tipoDeConta(contaDeposito, contaCorrente, contaPoupanca);

                    //Se a conta existir, adicionar o valorDeposito ao seu saldo
                    if (consultaDeposito != null) {
                        consultaDeposito.depositar(valorDeposito);
                    }
                    break;
                //Caso transferência de saldo
                case 4:
                    //Escolha da conta que transferirá o saldo
                    System.out.println("Selecione a conta de origem: ");
                    String contaOrigem = scanner.nextLine();

                    //Escolha da conta que receberá o saldo
                    System.out.println("Selecione a conta destino: ");
                    String contaDestino = scanner.nextLine();

                    System.out.print("Qual o valor que deseja transferir: R$");
                    double valorTransferir = scanner.nextDouble();
                    scanner.nextLine();

                    //Variáveis que guardam qual conta assumirá qual papel
                    ContaBancaria origem = tipoDeConta(contaOrigem, contaCorrente, contaPoupanca);
                    ContaBancaria destino = tipoDeConta(contaDestino, contaCorrente, contaPoupanca);

                    //Se as contas existirem, subtrair o valor da origem a somar o valor a conta de destino
                    if (destino != null && origem != null){
                        if (origem.saldo >= valorTransferir) {
                            origem.saldo -= valorTransferir;
                            destino.saldo += valorTransferir;
                            System.out.println("Transferência realizada com sucesso!");
                        } else {
                            System.out.println("Saldo Insuficiente");
                        }
                    } else {
                        System.out.println("Ambas as contas precisam estar registradas para ocorrer a transferência");
                    }
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    //Metodo para exibição do Menu
    public static void menuBanco() {
        System.out.println(" ");
        System.out.println("==========================================");
        System.out.println("Selecione a opção desejada");
        System.out.println("1 - Abrir Conta");
        System.out.println("2 - Consultar Saldo");
        System.out.println("3 - Realizar Depósito");
        System.out.println("4 - Transferir");
        System.out.println("5 - Sair");
        System.out.println("==========================================");
        System.out.print("Opção: ");
    }

    //Metodo para selecao de conta. Utilizada para evitar repetição desnecessária
    public static ContaBancaria tipoDeConta(String tipo, ContaBancaria contaCorrente, ContaBancaria contaPoupanca) {
        if (tipo.equals("Corrente")) return contaCorrente;
        if (tipo.equals("Poupança")) return contaPoupanca;
        return null;
    }
}