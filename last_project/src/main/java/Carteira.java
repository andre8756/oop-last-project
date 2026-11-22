import java.util.ArrayList;

public class Carteira {
    private int saldo;
    private ArrayList<Operacao> operacoes;

    public Carteira() {
        this.saldo = 0;
        this.operacoes = new ArrayList<>();
    }
}
