public class Bateria {

    public static final int MAX_CARGA = 100;
    public static final int MIN_CARGA = 0;
    private int carga;

    Bateria(){
        carga = MAX_CARGA;
    }

    public void recarregarBateria(){
        carga = MAX_CARGA;
    }

    public void utilizarCarga(int valor){
        if(valor < (MIN_CARGA)){
            throw new IllegalArgumentException("A bateria não pode ser utilizada com este valor! Valor inferior a 0");
        } else if( valor > carga) {
            carga = 0;
        } else{
            carga -= valor;
        }

    }

    public int getCarga() {
        return carga;
    }

}
