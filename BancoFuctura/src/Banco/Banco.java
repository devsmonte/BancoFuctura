package Banco;

import java.util.Scanner;

public class Banco {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca cp = new ContaPoupanca();

		Scanner entrada = new Scanner(System.in);
		Scanner entradaS = new Scanner(System.in);

		int testeLacoMenu = 7;
		boolean lacoMenu = false;

		do {
			System.out.println("+================================+");
			System.out.println("|       Banco Fuctura            |");
			System.out.println("|                                |");
			System.out.println("| Escolha uma das opções abaixo: |");
			System.out.println("| 1 - Abrir conta                |");
			System.out.println("| 2 - Depósito em conta corrente |");
			System.out.println("| 3 - Saque em conta corrente    |");
			System.out.println("| 4 - Aplicar na poupança        |");
			System.out.println("| 5 - Resgate da poupança        |");
			System.out.println("| 6 - Informações de conta       |");
			System.out.println("| 0 - Sair                       |");
			System.out.println("+================================+");

			testeLacoMenu = entrada.nextInt();

			/*
			 * if (testeLacoMenu == 0) { lacoMenu = true; }
			 */

			switch (testeLacoMenu) {
			case 0:{
				lacoMenu = true;
				break;
			}
			case 1: {
				System.out.println("| Digite o nome do titular: |");
				String nome = entradaS.next().toUpperCase();
				System.out.println("| Digite o número da conta: |");
				int conta = entrada.nextInt();

				cc = new ContaCorrente(nome, conta, 0);
				cp = new ContaPoupanca(nome, conta, 1);

				System.out.println("| Deseja realizar um depósito inicial?");
				System.out.println("| 1 - SIM     2 - NÂO       |");
				int selDeposito = entrada.nextInt();
				if (selDeposito == 1) {
					System.out.println("| Digite o valor: R$ ");
					double deposito = entrada.nextDouble();
					cc.deposito(deposito);
					System.out.println("| Depósito realizado com sucesso!");

				} else if (selDeposito == 2) {
					System.out.println("|");
					System.out.println("| Contas criadas com sucesso!");
				}

				cc.exibirConta();
				cp.exibirConta();
				System.out.println("+================================+");

				break;
			}
			case 2: {
				System.out.println("| Digite o valor: R$ ");
				double deposito = entrada.nextDouble();
				cc.deposito(deposito);
				System.out.println("| Depósito realizado com sucesso!");
				System.out.println("|");
				cc.exibirConta();
				cp.exibirConta();
				break;
			}
			case 3: {
				System.out.println("| Digite o valor: R$ ");
				double saque = entrada.nextDouble();
				Boolean retSaque = cc.saque(saque);

				if (retSaque == true) {
					System.out.println("| Saque realizado com sucesso!");
					System.out.println("|");
				} else {
					System.out.println("| Saldo insuficiente para saque! ");
					System.out.println("|");
				}
				cc.exibirConta();
				cp.exibirConta();
				break;
			}
			case 4: {
				System.out.println("| Digite o valor: R$ ");
				
				double saque = entrada.nextDouble();
				Boolean retSaque = cc.saque(saque);

				if (retSaque == true) {
					cp.deposito(saque);
					System.out.println("| Aplicação realizada com sucesso!");
					System.out.println("|");
				} else {
					System.out.println("| Saldo insuficiente para aplicação! ");
					System.out.println("|");
				}
				cc.exibirConta();
				cp.exibirConta();
				break;
			}
			case 5: {
				System.out.println("| Digite o valor: R$ ");
				
				double saque = entrada.nextDouble();
				Boolean retSaque = cp.saque(saque);

				if (retSaque == true) {
					cc.deposito(saque);
					System.out.println("| Resgate realizado com sucesso!");
					System.out.println("|");
				} else {
					System.out.println("| Saldo insuficiente para resgate! ");
					System.out.println("|");
				}
				cc.exibirConta();
				cp.exibirConta();
				break;	
			}
			case 6:{
				cc.exibirConta();
				cp.exibirConta();
			break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + testeLacoMenu);
			}

		} while (lacoMenu == false);

		entrada.close();
		entradaS.close();

	}
}
