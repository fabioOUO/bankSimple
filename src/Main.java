import Models.Banco.Banco;
import Models.Cliente.Cliente;
import Models.Conta.ContaCorrente;
import Models.Conta.ContaPoupanca;

public class Main {
    public static void main(String[] args) {

        Banco banco1 = new Banco(1L, "Banco do Barsil");
        Banco banco2 = new Banco(2L, "Banco Santander");

        Cliente cliente1 = new Cliente(1, "Ana Paula Silva");
        Cliente cliente2 = new Cliente(2, "Fernando Santos de Oliveira");

        ContaCorrente cc = new ContaCorrente(1L, cliente1, banco1, 2L, 234L);
        ContaPoupanca cp = new ContaPoupanca(2L, cliente2, banco2, 3L, 6857L);

        cc.deposito(1000D);
        cp.deposito(5000D);

        cc.saque(50D);
        cp.saque(250D);


        cc.transferencia(cp, 50D);
        cp.transferencia(cc,1000D);

        cc.deposito(50D);
        cp.deposito(250D);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
