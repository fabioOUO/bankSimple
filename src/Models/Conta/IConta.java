package Models.Conta;

public interface IConta {

    boolean verificarSaque(double valor);
    boolean verificarDeposito(double valor);
    boolean verificarTransferencia(Conta contaDestino, double valor);

    boolean saque(double valor);
    boolean deposito(double valor);
    boolean transferencia(Conta contaDestino, double valor);

}
