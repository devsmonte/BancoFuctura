package Banco;

public class ContaCorrente extends Conta {

//	public ContaCorrente() {}

	public ContaCorrente() {
	}

	public ContaCorrente(String nome, int numeroConta, int digVerificador) {
		this.nomeTitular = nome;
		this.numeroConta = numeroConta;
		this.digVerificador = digVerificador;

	}

}
