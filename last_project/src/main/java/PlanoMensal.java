public class PlanoMensal extends Plano{

    public PlanoMensal() {
        super("Mensal", 40);
    }

    @Override
    public double calcularViagem() {
        return 0;
    }
}
