public class MainDinamica {
    public static void main(String[] args) {
        MatrizDinamica dinamica = new MatrizDinamica(3,3);
        
        dinamica.inserirElemento(1,1,1);
        dinamica.inserirElemento(1,2,2);
        dinamica.inserirElemento(1,3,3);
        dinamica.inserirElemento(2,1,4);
        dinamica.inserirElemento(2,2,5);
        dinamica.inserirElemento(2,3,6); 
        dinamica.inserirElemento(3,1,7); 
        dinamica.inserirElemento(3,2,8); 
        dinamica.inserirElemento(3,3,9); 
        dinamica.imprimirMatriz();
        System.out.println("================");
        
        MatrizDinamica d2 = new MatrizDinamica(3,3);
        d2.gerarMatrizVazia();
        d2.imprimirMatriz();

        System.out.println("====================");
        MatrizDinamica d3 = new MatrizDinamica(3,3);
        d3.preencherMatriz();
        d3.imprimirMatriz();
    }

}
