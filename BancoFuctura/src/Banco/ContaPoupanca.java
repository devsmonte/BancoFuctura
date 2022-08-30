package Banco;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
	}

	public ContaPoupanca(String nome, int numeroConta, int digVerificador) {
		this.nomeTitular = nome;
		this.numeroConta = numeroConta;
		this.digVerificador = digVerificador;
	}

}
