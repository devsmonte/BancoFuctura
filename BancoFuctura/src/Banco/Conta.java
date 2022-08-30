package Banco;

public abstract class Conta {

	String nomeTitular;
	int numeroConta, digVerificador;
	boolean confSaque, confDeposito;
	private double saldo;

	public Boolean saque(double valorSaque) {
		if (valorSaque <= this.saldo) {
			this.saldo -= valorSaque;
			confSaque = true;
			return confSaque;
		} else {
			confSaque = false;
			return confSaque;
		}
		// return confDeposito;
	}

	public void deposito(double valorDeposito) {
		this.saldo += valorDeposito;
		confDeposito = true;
	}

	public void exibirConta() {
		System.out.println("|");
		System.out.println("| CONTA CORRENTE");
		System.out.println("| Titular: " + this.nomeTitular);
		System.out.println("| Conta: " + this.numeroConta + "-" + this.digVerificador);
		System.out.println("| Saldo: " + this.saldo);
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getDigVerificador() {
		return digVerificador;
	}

	public void setDigVerificador(int digVerificador) {
		this.digVerificador = digVerificador;
	}

	public double getSaldo() {
		return saldo;
	}

}
