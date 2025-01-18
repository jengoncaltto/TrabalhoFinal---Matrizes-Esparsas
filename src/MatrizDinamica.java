import java.util.List;
import java.util.Vector;

public class MatrizDinamica extends Matriz{
    private Vector<EloMatriz> vetorLinhas; // Array de listas encadeadas (uma para cada linha)
    private int totalElementos;
    protected EloMatriz prim;

    public void setTotalElementos(int totalElementos) {
        this.totalElementos = totalElementos;
    }

    // Classe para representar os elementos na matriz
    protected  class EloMatriz {
        private int coluna;
        private int valor;
        private EloMatriz prox;

        public EloMatriz(int coluna, int valor) {
            this.coluna = coluna;
            this.valor = valor;
            this.prox = null;
        }
    }

    public MatrizDinamica(int linha, int coluna){

        super(linha, coluna);
        this.vetorLinhas = new Vector<>(linhas);

        // Inicializa cada linha como nula
        for (int i = 0; i < linhas; i++) {
            vetorLinhas.add(null);
        }
        totalElementos = 0;
    }

    public void gerarMatrizVazia(){
        
        for(int i= 1; i < linhas+1; i++){
            for (int j = 1 ; j < colunas+1; j++){
                inserirElemento(i, j, 0);
            }  
        }
    }

    
    public void inserirElemento(int linha, int coluna, int elemento){
        linha = linha -1;
        coluna = coluna -1;
        // Obtém a lista encadeada da linha 
        EloMatriz p = vetorLinhas.get(linha);
        if (p == null) {
            vetorLinhas.set(linha, new EloMatriz(coluna, elemento));
            totalElementos++;
            return;
        }

        EloMatriz ant = null;
        while(p != null && p.coluna < coluna ){
            ant = p;
            p = p.prox;
        } 
        if (ant != null && ant.coluna == coluna) {
            // Atualiza o valor se a coluna já existir
            p.valor = elemento;
        } else {
            // Cria o novo elemento
            EloMatriz novo = new EloMatriz(coluna, elemento);
            if (ant == null) {
                // Insere no início da lista
                novo.prox = p;
                vetorLinhas.set(linha, novo);
            } else {
                // Insere entre os nós ou no final
                novo.prox = p;
                ant.prox = novo;

            }
        }
        setTotalElementos(totalElementos++);
    }

    public void imprimirMatriz(){
        for (int i = 0; i < linhas; i++) {
            EloMatriz p = vetorLinhas.get(i);
            while(p != null){
                System.out.print(p.valor + " ");
                p = p.prox;
            }
            System.out.println("");
        }
    }

    public int buscarElemento(int linha, int coluna){
        EloMatriz p = vetorLinhas.get(linha);
        while(p.coluna != coluna){
            p = p.prox;
        }
        return p.valor;
    }

    public void preencherMatriz(){
         List<Integer> elementos = gerarElementos();
        int k = 0;

        for (int i = 1; i <= linhas; i++) {
            for (int j = 1; j <= colunas; j++) {
                inserirElemento(i, j, elementos.get(k));
                k = k++;
            }
        }
    }

    /*
    
    public void removerElemento(int linha, int coluna);
    public Vector<Integer> buscarElementoCoord(int elemento);
    
    public boolean isMatrizVazia();
    public boolean isMatrizLinha();
    public boolean isMatrizColuna();
    public boolean isMatrizTriangularInferior();
    public boolean isMatrizTriangularSuperior();
    public boolean isMatrizSimetrica();
    public MatrizEstatica somarMatrizes(MatrizEstatica matrizSecundaria);
    public MatrizEstatica multiplicarMatrizes(MatrizEstatica matrizSecundaria);
    public MatrizEstatica obterMatrizTransposta();
    public Vector<Vector<Integer>> getMatriz();*/
    
}
