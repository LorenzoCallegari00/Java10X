package NivelIntermediario.Desafios.Desafio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("      Bem vindo ao Banco de Konoha");
        System.out.println("==========================================");
        System.out.println(" ");

        ContaCorrente contaCorrente = null;
        ContaPoupanca contaPoupanca = null;


        while (true) {
            System.out.println(" ");
            System.out.println("==========================================");
            System.out.println("Selecione a opção desejada");
            System.out.println("1 - Abrir Conta");
            System.out.println("2 - Consultar Saldo");
            System.out.println("3 - Realizar Depósito");
            System.out.println("4 - Transferir");
            System.out.println("5 - Sair");
            System.out.println("==========================================");
            System.out.println(" ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 5) {
                System.out.println("Você escolheu sair do programa");
                System.out.println("Obrigado por usar o Banco de Konoha");
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o tipo de conta que deseja abrir");
                    System.out.println("1 - Corrente");
                    System.out.println("2 - Poupança");
                    System.out.println("3 - Cancelar");

                    int tipoConta = scanner.nextInt();
                    scanner.nextLine();

                    switch (tipoConta) {
                        case 1:
                            System.out.println("Informe os dados da conta corrente: ");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Saldo inicial: ");
                            double saldo = scanner.nextDouble();
                            scanner.nextLine();

                            contaCorrente = new ContaCorrente(nome, saldo, TipoConta.CORRENTE);
                            break;
                        case 2:
                            System.out.println("Informe os dados da conta poupança: ");
                            System.out.print("Nome: ");
                            String nomePoupanca = scanner.nextLine();
                            System.out.print("Saldo inicial: ");
                            double saldoPoupanca = scanner.nextDouble();
                            scanner.nextLine();

                            contaPoupanca = new ContaPoupanca(nomePoupanca, saldoPoupanca, TipoConta.POUPANCA);
                            break;
                        case 3:
                            System.out.println("Voltando ao menu principal");
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Selecione qual a sua conta: ");
                    System.out.println("Corrente");
                    System.out.println("Poupança");

                    String contaConsultarSaldo = scanner.nextLine();

                    if (contaConsultarSaldo.equals("Corrente")) {
                        if (contaCorrente != null) {
                            System.out.println(contaCorrente.consultarSaldo());
                        } else {
                            System.out.println("Conta Inexistente");
                        }
                    } else if (contaConsultarSaldo.equals("Poupança")) {
                        if (contaPoupanca != null) {
                            System.out.println(contaPoupanca.consultarSaldo());
                        } else {
                            System.out.println("Conta Inexistente");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Para qual conta será o depósito: ");
                    System.out.println("Corrente");
                    System.out.println("Poupança");

                    String contaDeposito = scanner.nextLine();

                    if (contaDeposito.equals("Corrente")) {
                        if (contaCorrente != null) {
                            contaCorrente.depositar(valorDeposito);
                        }
                    } else if (contaDeposito.equals("Poupança")) {
                        if (contaPoupanca != null) {
                            contaPoupanca.depositar(valorDeposito);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Selecione de qual conta deseja transferir");
                    System.out.println("Corrente");
                    System.out.println("Poupança");
                    String contaTransferir = scanner.nextLine();

                    System.out.print("Qual o valor que deseja transferir: R$");
                    double valorTransferir = scanner.nextDouble();
                    scanner.nextLine();

                    if (contaTransferir.equals("Corrente")) {
                        if (contaCorrente != null && contaPoupanca != null) {
                            if (contaCorrente.saldo >= valorTransferir) {
                                contaCorrente.saldo -= valorTransferir;
                                contaPoupanca.saldo += valorTransferir;
                                System.out.println("Transferência realizada com sucesso");
                            } else {
                                System.out.println("Saldo Insuficiente");
                                break;
                            }
                        } else {
                            System.out.println("Ambas contas precisam estar registradas para realizar uma transferência");
                            break;
                        }
                    } else if (contaTransferir.equals("Poupança")) {
                        if (contaCorrente != null && contaPoupanca != null) {
                            if (contaPoupanca.saldo >= valorTransferir) {
                                contaPoupanca.saldo -= valorTransferir;
                                contaCorrente.saldo += valorTransferir;
                                System.out.println("Transferência realizada com sucesso");
                            } else {
                                System.out.println("Saldo Insuficiente");
                                break;
                            }
                        } else {
                            System.out.println("Ambas contas precisam estar registradas para realizar uma transferência");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }
}
