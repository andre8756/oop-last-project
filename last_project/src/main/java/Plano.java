public abstract class Plano {
    private String nome;
    private double valor;

    public Plano(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public double calcularMensalidade(){
        return getValor();
    }

    public abstract double calcularViagem();

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
