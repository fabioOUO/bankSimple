package Models.Cliente;

import Models.Conta.Conta;

import java.util.List;

public class Cliente {
    private long id;
    private String nome;

    public Cliente(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
