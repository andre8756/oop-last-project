import java.util.ArrayList;

public class Estacao {
    private int codigo;
    private static int contadorEstacao = 0;
    private String nome;
    private int quantidadeVagas;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private ArrayList<Veiculo> frota = new ArrayList<>();

    public Estacao(String nome, int quantidadeVagas, String cep, String rua,
                   String numero, String bairro, String cidade, String estado) {
        setNome(nome);
        setQuantidadeVagas(quantidadeVagas);
        setCep(cep);
        setRua(rua);
        setNumero(numero);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);

        contadorEstacao++;
        codigo = contadorEstacao;
    }

    public boolean adicionarVeiculo(Veiculo veiculo) {

        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não pode ser nulo!");
        }

        if (frota.size() >= quantidadeVagas) {
            return false;
        }

        if (procurarVeiculo(veiculo.getCodigo()) != null) {
            return false;
        }

        return frota.add(veiculo);
    }

    public Veiculo procurarVeiculo(int codigo) {

        for (Veiculo veiculo : frota) {
            if (veiculo.getCodigo() == codigo) {
                return veiculo;
            }
        }

        return null;
    }

    public boolean removerVeiculo(int codigo) {
        return frota.removeIf(veiculo -> veiculo.getCodigo() == codigo);
    }

    public int getCodigo() {
        return codigo;
    }

    public static int getContadorEstacao() {
        return contadorEstacao;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O campo Nome da Estacao não pode estar vazio!");
        }

        this.nome = nome;
    }

    public int getQuantidadeVagas() {
        return quantidadeVagas;
    }

    private void setQuantidadeVagas(int quantidadeVagas) {
        if (quantidadeVagas <= 0) {
            throw new IllegalArgumentException("A quantidade de vagas em uma estacao precisa ser maior que zero!");
        }

        this.quantidadeVagas = quantidadeVagas;
    }

    public String getCep() {
        return cep;
    }

    private void setCep(String cep) {
        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("O campo CEP da Estacao não pode estar vazio!");
        }

        // Remove o hífen e espaços para validar apenas os dígitos
        String cepLimpo = cep.replace("-", "").trim();

        if (!cepLimpo.matches("\\d{8}")) {
            throw new IllegalArgumentException("O CEP deve conter exatamente 8 dígitos numéricos!");
        }

        this.cep = cepLimpo;
    }

    public String getRua() {
        return rua;
    }

    private void setRua(String rua) {
        if (rua == null || rua.isBlank()) {
            throw new IllegalArgumentException("O campo Rua da Estacao não pode estar vazio!");
        }

        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    private void setNumero(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("O campo Numero da Estacao não pode estar vazio!");
        }

        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    private void setBairro(String bairro) {
        if (bairro == null || bairro.isBlank()) {
            throw new IllegalArgumentException("O campo Bairro da Estacao não pode estar vazio!");
        }

        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    private void setCidade(String cidade) {
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("O campo Cidade da Estacao não pode estar vazio!");
        }

        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    private void setEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("O campo Estado da Estacao não pode estar vazio!");
        }

        // Estado no formato de sigla (UF), ex.: SC, SP
        if (!estado.trim().matches("[A-Za-z]{2}")) {
            throw new IllegalArgumentException("O Estado deve ser informado como sigla de 2 letras (ex.: SC)!");
        }

        this.estado = estado.trim().toUpperCase();
    }
}
