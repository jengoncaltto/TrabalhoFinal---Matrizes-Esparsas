import java.util.Vector;

public class MatrizLista {
    private EloMatriz[] m; // Array de listas encadeadas (uma para cada linha)
    private int numLinhas;
    private int numColunas;

    // Classe para representar os elementos na matriz
    private class EloMatriz {
        int coluna;
        int valor;

        public EloMatriz(int coluna, int valor) {
            this.coluna = coluna;
            this.valor = valor;
        }
    }
}
