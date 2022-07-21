package Models.Banco;

public class Banco {

    private Long codigo;
    private String nome;

    public Banco(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
