public class Main {
    public static void main(String[] args) {
        /*// roda 10 vezes
        long to = System.currentTimeMillis();
        for(int i = 0; i < 10; i++){
            //...
        long t1 = System.currentTimeMillis();
        }
        //long tempoTomado = (t1 - t0) / 10;
        *//*  estatica.gerarMatrizEsparsa(5);
        estatica.exibirMatriz();
        */
        MatrizEstatica estatica = new MatrizEstatica(5, 5);
        estatica.preencherMatriz();
        estatica.imprimirMatriz();
    }
}
