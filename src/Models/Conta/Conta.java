package Models.Conta;

import Models.Banco.Banco;
import Models.Cliente.Cliente;
import Models.Extrato.Extrato;
import Models.Extrato.Operacao;

import java.util.Date;

public abstract class Conta implements IConta {

    protected long id;
    protected Cliente cliente;
    protected Banco banco;
    protected long agencia;
    protected long numero;
    protected double saldo;

    protected Extrato extrato;

    protected Conta(long id, Cliente cliente, Banco banco, long agencia, long numero) {
        this.id = id;
        this.cliente = cliente;
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
    }

    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Banco getBanco() {
        return banco;
    }

    public long getAgencia() {
        return agencia;
    }

    public long getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Extrato getExtrato() {
        return extrato;
    }
    @Override
    public boolean verificarSaque(double valor) {
        return valor > 0 && this.saldo >= valor;
    }

    @Override
    public boolean verificarDeposito(double valor) {
        return valor > 0;
    }

    @Override
    public boolean verificarTransferencia(Conta contaDestino, double valor) {
        return this.verificarSaque(valor) && contaDestino.verificarDeposito(valor) ;
    }

    @Override
    public boolean saque(double valor) {
        if(this.verificarSaque(valor)){
            this.saldo -= valor;
            this.extrato.getCorpo().add(new Operacao(new Date(), 1, valor, this.saldo));
            return true;
        }
        return false;
    }

    @Override
    public boolean deposito(double valor) {
        if(this.verificarDeposito(valor)){
            this.saldo += valor;
            this.extrato.getCorpo().add(new Operacao(new Date(), 2, valor, this.saldo));
            return true;
        }
        return false;
    }

    @Override
    public boolean transferencia(Conta contaDestino, double valor) {
        if(this.verificarTransferencia(contaDestino, valor)){
            this.saque(valor);
            contaDestino.deposito(valor);
            this.extrato.getCorpo().add(new Operacao(new Date(), 3, valor, this.saldo, contaDestino));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", banco=" + banco +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
    public void imprimirExtrato(){
        this.extrato.imprimir();
    }
}
