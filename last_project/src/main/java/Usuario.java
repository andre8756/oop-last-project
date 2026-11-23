import java.util.ArrayList;

public class Usuario {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private Carteira carteira;
    private Plano plano;
    private ArrayList<Viagem> viagens;

    public Usuario(String cpf, String nome, String email, String telefone, Plano plano) {
        if (plano == null) {
            throw new IllegalArgumentException("Erro: Plano não pode ser nulo");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.carteira = new Carteira();
        this.plano = plano;
        this.viagens = new ArrayList<>();
    }

    public boolean mudarPlano(Plano plano) {
        if(plano == this.plano){
            return false;
        }
        if (plano.getValor() > carteira.getSaldo()){
            return false;
        }
        if (plano.getValor() > 0) {
            if (!carteira.debitar(plano.getValor())) {
                return false;
            }
        }
        setPlano(plano);
        return true;
    }

    public boolean possuiViagemEmAndamento(){
        return false;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        if (plano == null) {
            throw new IllegalArgumentException("Erro: Plano não pode ser nulo");
        }
        this.plano = plano;
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public void addViagem(Viagem viagem) {
        if(viagem == null){
            throw new IllegalArgumentException("Erro: Viagem inválida");
        }
        this.viagens.add(viagem);
    }
}
