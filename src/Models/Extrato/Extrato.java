 package Models.Extrato;

import Models.Conta.ContaCorrente;
import Models.Conta.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class Extrato {

    private String cabesalho;
    private List<Operacao> corpo = new ArrayList<Operacao>();
    private String semparador;

    public String getCabesalho() {
        return cabesalho;
    }

    public List<Operacao> getCorpo() {
        return corpo;
    }

    public String getSemparador() {
        return semparador;
    }

    public Extrato(ContaCorrente contaCorrente) {
        this.cabesalho =
                "\nTIPO DE CONTA: " + contaCorrente.getTipoDescricao()
                + "\nAGENCIA: " + contaCorrente.getAgencia()
                + "\nNUMERO: " + contaCorrente.getNumero()
                + "\nCLIENTE: " + contaCorrente.getCliente().getNome();

        this.extratoCorpo();
    }

    public Extrato(ContaPoupanca contaPoupanca) {
        this.cabesalho = "TIPO DE CONTA: " + contaPoupanca.getTipoDescricao()
                + "\nAGENCIA: " + contaPoupanca.getAgencia()
                + "\nNUMERO: " + contaPoupanca.getNumero()
                + "\nCLIENTE: " + contaPoupanca.getCliente().getNome();

        this.extratoCorpo();
    }

    private void extratoCorpo(){
        this.semparador = "......................................................";
    }

    public void imprimir(){
        System.out.println(this.cabesalho);
        System.out.println(this.semparador);
        if(this.corpo != null) for(Operacao operacao : this.corpo) System.out.println(operacao.getOperacao());
        System.out.println(this.semparador);
    }
}
