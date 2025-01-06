import java.util.Vector;

public class MatrizLista {
    private ListaGenerica<ListaGenerica<EloMatriz>>[] m; // Array de listas encadeadas (uma para cada linha)
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
  /*  public boolean inserirElemento(int numLinha, int numColuna, int numElemento){
        int i = 0;
        while(linhas.indexOf(i) != numLinha){
            if(linhas.)

        }

        for (p = linhas; p != null && i < numLinha +1; p = p.prox, i++);
        if(p == null) {
            while (i <= numLinha) {
                Lista novaLinha = new Lista(); // Criar nova lista para a linha
                linhas.insere(novaLinha);     // Inserir na lista de linhas
                i++;
            }
        }

    }*/

}
