public class BicicletaEletrica extends Eletrico {
    private static final double TAXA_DESBLOQUEIO = 2.00;
    private static final double VALOR_MINUTO = 0.30;
    private static final int CONSUMO_POR_MINUTO = 1;

    public BicicletaEletrica(String modelo) {
        super(modelo);
    }

    @Override
    public double taxaDesbloqueio() { return TAXA_DESBLOQUEIO; }

    @Override
    public double valorMinuto() { return VALOR_MINUTO; }

    @Override
    public int consumoPorMinuto() { return CONSUMO_POR_MINUTO; }
}