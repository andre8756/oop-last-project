import Enums.StatusVeiculo;

public abstract class Veiculo {
    private final int codigo;
    private static int contadorVeiculo = 0;
    private String modelo;
    private StatusVeiculo status;

    public Veiculo(String modelo) {
        setModelo(modelo);
        disponibilizarVeiculo();


        contadorVeiculo++;
        codigo = contadorVeiculo;
    }

    // Vai retornar a taxa de desbloqueio do veiculo
    public abstract double taxaDesbloqueio();

    // Metodo que ira retornar o valor que o veiculo custa por minuto
    public abstract double valorMinuto();

    // Por padrao o veiculo nao aceita desconto
    public boolean aceitaDesconto(){
        return false;
    }

    public void enviarManutencao(){
        if(status == StatusVeiculo.EM_USO){
            throw new IllegalStateException("Um veículo em uso não pode ser enviado para manutenção!");
        }

        status = StatusVeiculo.EM_MANUTENCAO;
    }

    public void disponibilizarVeiculo(){
        status = StatusVeiculo.DISPONIVEL;
    }

    public void utilizarVeiculo(){
        if(status == StatusVeiculo.EM_MANUTENCAO){
            throw new IllegalStateException("Apenas veículos disponíveis podem ser utilizados!");
        }

        status = StatusVeiculo.EM_USO;
    }

    public int getCodigo() {
        return codigo;
    }

    public static int getContadorVeiculo() {
        return contadorVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        if(modelo == null ||  modelo.isBlank()) {
            throw new IllegalArgumentException("o campo Modelo não pode estar vazio!");
        }

        this.modelo = modelo;

    }

    public StatusVeiculo getStatus(){
        return status;
    }

}
