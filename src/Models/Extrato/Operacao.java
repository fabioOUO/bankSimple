package Models.Extrato;

import Models.Conta.Conta;

import java.util.Date;

public class Operacao {
    private Date data;
    private int tipoOperacao;
    private String tipoOperacaoDesc;
    private Double valor;
    private Double saldo;

    private String contaDestino;

    public Operacao(Date data, int tipoOperacao, Double valor, Double saldo) {
        this.data = data;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.saldo = saldo;
        this.setTipoOperacaoDesc(this.tipoOperacao);
    }
    public Operacao(Date data, int tipoOperacao, Double valor, Double saldo, Conta contaDestino) {
        this.data = data;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.saldo = saldo;
        this.contaDestino = "[ " +  contaDestino.getBanco().getNome() + ", "  + Long.toString(contaDestino.getAgencia()) + ", "  + Long.toString(contaDestino.getNumero()) + "]";
        this.setTipoOperacaoDesc(this.tipoOperacao);
    }

    public Date getData() {
        return data;
    }

    public int getTipoOperacao() {
        return tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setTipoOperacaoDesc(int tipoOperacao){
        switch (tipoOperacao){
            case 1:
                this.tipoOperacaoDesc = "SAQUE";
                break;
            case 2:
                this.tipoOperacaoDesc = "DEPOSITO";
                break;
            case 3:
                this.tipoOperacaoDesc = "TRANSFERENCIA";
                break;
        }
    }
    public String getOperacao(){
       if(this.tipoOperacao == 3) return this.data.toString() +" TIPO: " + this.tipoOperacaoDesc +" | VALOR: " + Double.toString(this.valor)+" | SALDO ATUAL: " + Double.toString(this.saldo)+" | CONTA DESTINO: " + this.contaDestino;
       else return this.data.toString() +" TIPO: " + this.tipoOperacaoDesc +" | VALOR: " + Double.toString(this.valor)+" | SALDO ATUAL: " + Double.toString(this.saldo);
    }
}
