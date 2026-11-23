import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Carteira implements Extratavel {
    private double saldo;
    private ArrayList<Operacao> operacoes;
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

    public Carteira() {
        this.saldo = 0;
        this.operacoes = new ArrayList<>();
    }

    public Carteira(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Erro: Saldo inicial inválido");
        }
        this.saldo = saldoInicial;
        this.operacoes = new ArrayList<>();
    }

    public boolean recarregar(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Erro: Valor de recarga inválido");
        }
        saldo += valor;
        operacoes.add(new Operacao(valor, true, saldo));
        return true;
    }

    public boolean debitar(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Erro: Valor de debito inválido");
        }
        saldo-= valor;
        operacoes.add(new Operacao(valor, false, saldo));
        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String gerarExtrato() {
        StringBuilder stringBuilder = new StringBuilder();
        if (operacoes.isEmpty()){
            return "Não há operações no momento";
        }
        int indice = 0;
        System.out.println("Operações: ");
        for (Operacao operacao : operacoes){
            indice+=1;
            stringBuilder
                    .append(indice).append("- ID: ")
                    .append(operacao.getId())
                    .append(" - Data: ")
                    .append(operacao.getData().format(FORMATO_DATA))
                    .append(" - Hora: ")
                    .append(operacao.getData().format(FORMATO_HORA))
                    .append(" - Tipo: ")
                    .append(operacao.isEntrada() ? "Entrada" : "Saída")
                    .append(" - Valor: ")
                    .append(operacao.getValor())
                    .append(" - Valor após: ")
                    .append(operacao.getSaldoApos())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}

