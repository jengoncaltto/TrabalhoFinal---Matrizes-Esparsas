public class MatrizDinamica extends Matriz{
    private EloMatriz[] m; // Array de listas encadeadas (uma para cada linha)

    // Classe para representar os elementos na matriz
    private class EloMatriz {
        int coluna;
        int valor;

        public EloMatriz(int coluna, int valor) {
            this.coluna = coluna;
            this.valor = valor;
        }
    }

    public MatrizDinamica(int largura, int altura){
        super(largura, altura);
    }
}
