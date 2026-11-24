import Enums.StatusVeiculo;

public abstract class Eletrico extends Veiculo{

    private static final int CARGA_MINIMA_VIAGEM = 20;

    private final Bateria bateria;

    public Eletrico(String modelo) {
        super(modelo);
        this.bateria = new Bateria();
    }

    // Percentual de bateria consumido a cada minuto de uso
    public abstract int consumoPorMinuto();

    // Validacao de se a bateria tem ao menos 20% da carga antes de iniciar a viagem
    @Override
    public void utilizarVeiculo(){
        if(bateria.getCarga() < CARGA_MINIMA_VIAGEM){
            throw new IllegalStateException("O veículo precisa de pelo menos "
                    + CARGA_MINIMA_VIAGEM + "% de carga para ser utilizado!");
        }

        super.utilizarVeiculo();
    }

    // Chamado ao terminar a viagem
    public void consumirBateria(int minutos){
        if(minutos < 1){
            throw new IllegalArgumentException("Os minutos de uso devem ser maiores que zero!");
        }

        bateria.utilizarCarga(minutos * consumoPorMinuto());
    }

    public void recarregar(){
        if(getStatus() == StatusVeiculo.EM_USO){
            throw new IllegalStateException("Um veículo em uso não pode ser recarregado!");
        }

        bateria.recarregarBateria();
    }

    public int getCargaBateria() {
        return bateria.getCarga();
    }

    public Bateria getBateria() {
        return bateria;
    }

}
