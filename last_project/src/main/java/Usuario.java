import java.util.ArrayList;

public class Usuario {
    private int cpf;
    private String nome;
    private String email;
    private String telefone;
    private Carteira carteira;
    private Plano plano;
    private ArrayList<Viagem> viagens;

    public Usuario( int cpf, String nome, String email, String telefone, Plano plano) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.carteira = new Carteira();
        this.plano = plano;
        this.viagens = new ArrayList<>();
    }
}
