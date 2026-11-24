public class BicicletaMecanica extends Veiculo{
    private static final double TAXA_DESBLOQUEIO = 1.00;
    private static final double VALOR_MINUTO = 0.15;

    public BicicletaMecanica(String modelo) {
        super(modelo);
    }

    @Override
    public double taxaDesbloqueio() {
        return TAXA_DESBLOQUEIO;
    }

    @Override
    public double valorMinuto() {
        return VALOR_MINUTO;
    }


}
