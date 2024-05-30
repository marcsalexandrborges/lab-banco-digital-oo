### Validações :

    Adicionei validações nos métodos sacar, depositar e transferir para garantir que o saldo não fique negativo.
    Por exemplo, verifique se o valor a ser sacado não excede o saldo disponível.

    Vamos adicionar as validações necessárias nos métodos sacar, depositar e transferir para garantir que o saldo não fique negativo. 

public abstract class Conta implements IConta {

    // ... (código anterior)

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque.");
            return;
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
            return;
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    // Restante do código permanece o mesmo
    // ...
}



---------------------------------------------------------------------------------------------------------------------------------------------------------------
## Encapsulamento:

    Considere tornar os atributos privados e fornecer métodos getters e setters para acessá-los.
    Isso ajuda a controlar o acesso aos dados e a manter a coesão.

    Vamos aplicar o encapsulamento ao código. Primeiro, tornaremos os atributos privados e, em seguida, criaremos os métodos getters e setters para acessá-los.  

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    // Métodos getters e setters para os atributos

public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Restante do código permanece o mesmo
    // ...
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------
## Implementação da Classe Banco

Aqui está uma implementação básica da classe Banco:
Nessa implementação, a classe Banco possui um nome e uma lista de contas. Ela tem métodos para adicionar contas e buscar contas pelo número.

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
}



-------------------------------------------------------------------------------------------------------------------------------------------------------------

## Adicionei Metodo para calcular o saldo total do banco, você ele é possivel percorrer todas as contas e somar os saldos individuais de cada uma delas. Aqui está uma implementação básica desse cálculo na classe Banco:

Nesse método calcularSaldoTotal(), percorremos todas as contas no banco e somamos os saldos individuais. O resultado é o saldo total do banco.

    // Método para calcular o saldo total do banco
    public double calcularSaldoTotal() {
        double saldoTotal = 0.0;
        for (Conta conta : contas) {
            saldoTotal += conta.getSaldo();
        }
        return saldoTotal;
    }
}



