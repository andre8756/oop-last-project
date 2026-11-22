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

    

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public Plano getAssinatura() {
        return plano;
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<Viagem> viagens) {
        this.viagens = viagens;
    }
}
