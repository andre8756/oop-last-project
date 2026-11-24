import Enums.StatusVeiculo;

public abstract class Veiculo {
    private int codigo;
    private static int contadorVeiculo = 0;
    private String modelo;
    private StatusVeiculo status;

    public Veiculo(String modelo) {
        setModelo(modelo);

        contadorVeiculo++;
        codigo = contadorVeiculo;
    }

    // Vai retornar a taxa de desbloqueio do veiculo
    public abstract double taxaDesbloquieo();

    // Metodo que ira retornar o valor que o veiculo custa por minuto
    public abstract double valorMinuto();

    // Por padrao o veiculo nao aceita desconto
    public boolean aceitaDesconto(){
        return false;
    }

    public void enviarManutencao(){
        status = StatusVeiculo.EM_MANUTENCAO;
    }

    public void disponibilizarVeiculo(){
        status = StatusVeiculo.DISPONIVEL;
    }

    public void utilizarVeiculo(){
        status = StatusVeiculo.EM_USO;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getContadorVeiculo() {
        return contadorVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        if(modelo != null &&  !modelo.isBlank()) {
            this.modelo = modelo;
        }

        throw new IllegalArgumentException("o campo Modelo não pode estar vazio!");
    }


}
