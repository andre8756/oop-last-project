import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Duration;

public class Viagem {

    private final int codigo;
    private static int contadorViagem = 0;
    private final LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    private Usuario usuario;
    private Veiculo veiculo;

    private Estacao estacaoPartida;
    private Estacao estacaoChegada;

    private double valorTotal;


    Viagem(Usuario usuario, Veiculo veiculo, Estacao estacaoPartida){
        setUsuario(usuario);
        setVeiculo(veiculo);
        setEstacaoPartida(estacaoPartida);

        dataInicio = LocalDateTime.now();

        contadorViagem++;
        codigo = contadorViagem;

        estacaoPartida.getFrota().remove(veiculo);
        veiculo.utilizarVeiculo();
    }

    public boolean encerrarViagem(Estacao estacaoChegada){

        if(!isEmAndamento()){
            throw new IllegalArgumentException("Esta viagem já foi encerrada!");
        }

        setEstacaoChegada(estacaoChegada);
        setDataFim(LocalDateTime.now());

        estacaoChegada.getFrota().add(veiculo);
        veiculo.disponibilizarVeiculo();

        return true;
    }

    public long calcularDuracao() {

        if (isEmAndamento()) {
            throw new IllegalStateException(
                    "Não é possível calcular a duração de uma viagem em andamento!"
            );
        }

        return java.time.Duration.between(dataInicio, dataFim).toMinutes();
    }

    public void calcularValorTotal(){
        if (isEmAndamento()) {
            throw new IllegalStateException(
                    "Não é possível calcular o valor de uma viagem em andamento!"
            );
        }

        double taxaDesbloqueio = veiculo.taxaDesbloqueio();
        double valorMinuto = veiculo.valorMinuto();

        valorTotal = taxaDesbloqueio + (calcularDuracao() * valorMinuto);
    }

    public int getCodigo() {
        return codigo;
    }

    public static int getContadorViagem() {
        return contadorViagem;
    }

    // returna true se a dataFim == null
    public boolean isEmAndamento() {
        return dataFim == null;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        if(dataFim.isBefore(dataInicio)){
            throw new IllegalArgumentException("A data de fim não pode ser anterior à data de início.");
        }

        this.dataFim = dataFim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    private void setUsuario(Usuario usuario) {
        if(usuario == null){
            throw new IllegalArgumentException("Usuário não pode ser null para inicar uma viagem.");
        }

        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    private void setVeiculo(Veiculo veiculo) {
        if(veiculo == null){
            throw new IllegalArgumentException("Veiculo não pode ser null para inicar uma viagem.");
        }

        this.veiculo = veiculo;
    }

    public Estacao getEstacaoPartida() {
        return estacaoPartida;
    }

    private void setEstacaoPartida(Estacao estacaoPartida) {
        if(estacaoPartida == null){
            throw new IllegalArgumentException("Estação de partida não pode ser null para inicar uma viagem.");
        }

        for(Veiculo veiculo : estacaoPartida.getFrota()){
            if(veiculo == this.veiculo){
                this.estacaoPartida = estacaoPartida;
            }
        }

        throw new IllegalArgumentException("A estação de partida não possui este veículo!");

    }

    public Estacao getEstacaoChegada() {
        return estacaoChegada;
    }

    public void setEstacaoChegada(Estacao estacaoChegada) {
        if(estacaoChegada == null){
            throw new IllegalArgumentException("Estacao de chegada não pode ser null para encerrar uma viagem.");
        }

        if(estacaoChegada.getFrota().size() >= estacaoChegada.getQuantidadeVagas()){
            throw new IndexOutOfBoundsException("A estação de chegada não tem vagas disponíveis!");
        }

        this.estacaoChegada = estacaoChegada;
    }

    public double getValorTotal(){
        return valorTotal;
    }
}
