import java.time.LocalDateTime;

public class Viagem {

    private int codigo;
    private static int contadorViagem = 0;
    private boolean emAndamento;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Usuario usuario;
    private Estacao estacaoPartida;
    private Estacao estacaoChegada;


    Viagem(){

    }

    public int getCodigo() {
        return codigo;
    }

    public static int getContadorViagem() {
        return contadorViagem;
    }

    public boolean isEmAndamento() {
        return emAndamento;
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
}
