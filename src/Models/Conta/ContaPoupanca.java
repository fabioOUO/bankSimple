package Models.Conta;

import Models.Banco.Banco;
import Models.Cliente.Cliente;
import Models.Extrato.Extrato;

public class ContaPoupanca extends Conta{
    private int tipocodigo = 2;
    private String tipoDescricao = "Conta Poupanca";

    public ContaPoupanca(long id, Cliente cliente, Banco banco, long agencia, long numero) {
        super(id, cliente, banco, agencia, numero);
        super.extrato = new Extrato(this);
    }

    public int getTipocodigo() {
        return tipocodigo;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "tipocodigo=" + tipocodigo +
                ", tipoDescricao='" + tipoDescricao + '\'' +
                ", conta='" + super.toString() + '\'' +
                '}';
    }
}
