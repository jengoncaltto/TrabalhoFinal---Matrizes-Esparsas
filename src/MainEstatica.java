public class MainEstatica {
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
        MatrizEstatica estatica = new MatrizEstatica(3,3);
        /*estatica.inserirElemento(0,0,1);
        estatica.inserirElemento(0,1,2);
        estatica.inserirElemento(0,2,3);
        estatica.inserirElemento(1,0,4);
        estatica.inserirElemento(1,1,5);
        estatica.inserirElemento(1,2,6);
        estatica.inserirElemento(2,0,7);
        estatica.inserirElemento(2,1,8);
        estatica.inserirElemento(2,2,9);*/
        estatica.inserirElemento(1,1,1);
        estatica.inserirElemento(1,2,2);
        estatica.inserirElemento(1,3,4);
        estatica.inserirElemento(2,1,0);
        estatica.inserirElemento(2,2,0);
        estatica.inserirElemento(2,3,0);
        estatica.inserirElemento(3,1,4);
        estatica.inserirElemento(3,2,0);
        estatica.inserirElemento(3,3,3);
        estatica.imprimirMatriz();
        /*estatica.removerElemento(2,2);
        System.out.println("===============================");
        estatica.imprimirMatriz();
        System.out.println("===============================");
        System.out.println(estatica.buscarElementoCoord(9));
        System.out.println(estatica.buscarElemento(2,0));
        System.out.println(estatica.isMatrizDiagonal());
        System.out.println(estatica.isMatrizLinha());
        System.out.println(estatica.isMatrizColuna());
        System.out.println(estatica.isMatrizTriangularInferior());
        MatrizEstatica e2 = new MatrizEstatica(3,3);
        e2.inserirElemento(0,0,2);
        e2.inserirElemento(0,1,2);
        e2.inserirElemento(0,2,2);
        e2.inserirElemento(1,0,2);
        e2.inserirElemento(1,1,2);
        e2.inserirElemento(1,2,2);
        e2.inserirElemento(2,0,2);
        e2.inserirElemento(2,1,2);
        e2.inserirElemento(2,2,2);
        estatica.multiplicarMatrizes(e2).imprimirMatriz();
        estatica.obterMatrizTransposta().imprimirMatriz();
        System.out.println(estatica.isMatrizSimetrica());*/
        System.out.println("===============================");



    }
}
