public abstract class Veiculo {
    private int codigo;
    private static int contadorVeiculo = 0;
    private String modelo;

    public Veiculo(String modelo) {
        setModelo(modelo);

        contadorVeiculo++;
        codigo = contadorVeiculo;
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
