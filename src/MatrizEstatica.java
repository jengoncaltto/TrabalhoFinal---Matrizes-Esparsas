public class MatrizEstatica {
    private int matriz[][];
    private int N;

    public MatrizEstatica(int n) {
            this.matriz = new int[n][n];
            this.N = n;
    }

    public void exibirMatriz() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] geraAleatorio(){
        
    }
}
