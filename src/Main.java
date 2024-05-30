public class Main {

	public static void main(String[] args) {
		Cliente marcos = new Cliente();
		marcos.setNome("Marco Veio");
		
		Cliente vania = new Cliente();
		vania.setNome("Vania");
		
		
		Conta cc = new ContaCorrente(marcos);
		Conta poupanca = new ContaPoupanca(vania);

		cc.depositar(10000);
		cc.transferir(3000, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}