import java.time.LocalDateTime;

public class Operacao {
    private LocalDateTime data;
    private double valor;
    private boolean entrada;
    private double saldoApos;

    public Operacao(double valor, boolean entrada, double saldoApos) {
        this.data = LocalDateTime.now();
        this.valor = valor;
        this.entrada = entrada;
        this.saldoApos = saldoApos;
    }

    public LocalDateTime getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public double getSaldoApos() {
        return saldoApos;
    }
}
