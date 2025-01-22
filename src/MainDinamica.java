public class MainDinamica {
    public static void main(String[] args) {
        MatrizDinamica dinamica = new MatrizDinamica(3,3);
        dinamica.gerarMatrizVazia();
        
        dinamica.inserirElemento(1,1,1);
        dinamica.inserirElemento(1,2,0);
        dinamica.inserirElemento(1,3,0);
        dinamica.inserirElemento(2,1,2);
        dinamica.inserirElemento(2,2,0);
        dinamica.inserirElemento(2,3,0); 
        dinamica.inserirElemento(3,1,1); 
        dinamica.inserirElemento(3,2,0); 
        dinamica.inserirElemento(3,3,0); 
        dinamica.imprimirMatriz();
        System.out.println("================");
        //System.out.println(dinamica.isMatrizLinha());
        System.out.println(dinamica.isMatrizColuna());
        dinamica.imprimirMatriz();
        
        /*MatrizDinamica d2 = new MatrizDinamica(3,3);
        d2.gerarMatrizVazia();
        d2.imprimirMatriz();*/

        /*System.out.println("====================");
        MatrizDinamica d3 = new MatrizDinamica(3,3);
        d3.preencherMatriz();
        d3.imprimirMatriz();*/

    }

}
