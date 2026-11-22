import java.util.ArrayList;

public class Carteira implements Extratavel {
    private double saldo;
    private ArrayList<Operacao> operacoes;

    public Carteira() {
        this.saldo = 0;
        this.operacoes = new ArrayList<>();
    }

    public Carteira(double saldoInicial) {
        this.saldo = saldoInicial;
        this.operacoes = new ArrayList<>();
    }

    public boolean recarregar(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Erro: Valor de recarga inválido");
        }
        operacoes.add(new Operacao(valor, true, saldo+valor));
        saldo += valor;
        return true;
    }

    public boolean debitar(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Erro: Valor de debito inválido");
        }
        if (valor > saldo){
            return false;
        }
        operacoes.add(new Operacao(valor, false, saldo-valor));
        saldo-= valor;
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
        System.out.println("Operações: ");
        int indice = 0;
        for (Operacao operacao : operacoes){
            indice+=1;
            stringBuilder.append(indice+"- Data: "+operacao.getData()
                    +" - Tipo: " + (operacao.isEntrada()? "Entrada" : "Saída")
                    +" - Valor: "+operacao.getValor()
                    +" - Valor após: "+operacao.getSaldoApos()+"\n");
        }
        return stringBuilder.toString();
    }
}

