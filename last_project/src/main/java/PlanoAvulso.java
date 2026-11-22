public class PlanoAvulso extends Plano{

    public PlanoAvulso() {
        super("Avulso", 0);
    }

    @Override
    public double calcularMensalidade() {
        return super.calcularMensalidade();
    }

    @Override
    public double calcularViagem() {
        return 0;
    }
}
