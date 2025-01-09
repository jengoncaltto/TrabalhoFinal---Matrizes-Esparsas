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

   public void gerarMatrizEsparsa(int n) {
        double grauDeEsparsidade = 0.6;
        int totalElementos = n*n;
        int numZeros = (int) (totalElementos * grauDeEsparsidade); // Calcula 60% do total
        int elementosNaoZero = totalElementos - numZeros;
        Random random = new Random();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }

        while (numZeros > 0) {
            int numLinha = random.nextInt(N);
            int numColuna = random.nextInt(N);

            if (matriz[numLinha][numColuna] != 0) { // Apenas substitui se não for zero
                matriz[numLinha][numColuna] = 0;
                numZeros--;
            }
        }
    }
}
