import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;
	
	 public Banco(String nome) {
	        this.nome = nome;
	        this.contas = new ArrayList<>();
	    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	// Método para adicionar uma conta ao banco
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
    
    // Método para buscar uma conta pelo número
    public Conta buscarContaPorNumero(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null; // Conta não encontrada
    }
    
    // Método para calcular o saldo total do banco
    public double calcularSaldoTotal() {
        double saldoTotal = 0.0;
        for (Conta conta : contas) {
            saldoTotal += conta.getSaldo();
        }
        return saldoTotal;
    }
}
	

