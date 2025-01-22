
public class MatrizDinamica extends Matriz{
    private EloMatriz[] vetorLinhas; // Array de listas encadeadas (uma para cada linha)
    private int totalElementos;

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
        this.vetorLinhas = new EloMatriz[linhas];
        this.gerarMatrizVazia();
        totalElementos = 0;
    }

    public boolean isMatrizVazia(){
        if(vetorLinhas.length == 0)return true;
        return false;
    }

    public void gerarMatrizVazia(){
        // Inicializa cada linha como nula
        for (int i = 0; i < linhas; i++) {
            vetorLinhas[i] = null;
        }
    }

    
    public void inserirElemento(int linha, int coluna, int elemento){
        linha = linha -1;
        coluna = coluna -1;
        // Obtém a lista encadeada da linha 
        EloMatriz p = vetorLinhas[linha];
        // adiciona na primeira posição que é null
        if (p == null) {
            vetorLinhas[linha] = new EloMatriz(coluna, elemento);
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
                vetorLinhas[linha] = novo;
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
            EloMatriz p = vetorLinhas[i];
            while(p != null){
                System.out.print(p.valor + " ");
                p = p.prox;
            }
            System.out.println("");
        }
    }


    public void preencherMatriz(){
        int[] elementos = gerarElementos();
        int k = 0;

        for (int i = 1; i <= linhas; i++) {
            for (int j = 1; j <= colunas; j++) {
                inserirElemento(i, j, elementos[k]);
                k = k++;
            }
        }
    }

    public boolean removerElemento(int linha, int coluna){
        EloMatriz p = vetorLinhas[linha];
        EloMatriz ant = null;
        while(p.coluna != coluna && p != null){
            ant = p;    
            p = p.prox;
        }
        if(p==null) return false;    
        ant.prox = p.prox;
        p.prox=null;
        return true;
    }

    public int buscarElemento(int linha, int coluna){
        EloMatriz p = vetorLinhas[linha];
        while(p.coluna != coluna){
            p = p.prox;
        }
        return p.valor;
    }

    public int[] buscarElementoCoord(int elemento){
        int[] vetor = new int[2];
        
        for (int i = 0; i < linhas; i++) {
            EloMatriz p = vetorLinhas[i];
            while(p!= null && p.valor != elemento)p = p.prox;
            if(p.valor == elemento && p != null){
                vetor[0] = i;
                vetor[1] = p.coluna; 
                break;
            }
        }
        return vetor;
    }

    public boolean isMatrizLinha() {
    // Contador para linhas com mais de um elemento diferente de zero
    int ls = 0;

    for (int i = 0; i < linhas; i++) {
        boolean linhasComElementos = false;
        if (ls > 1) {
            return false;
        }
        EloMatriz p = vetorLinhas[i];
        
        while (p != null) {
            if (p.valor != 0) {
                linhasComElementos = true;
            }
            p = p.prox;
        }

        if(linhasComElementos) ls++;
        // Se mais de uma linha tiver elementos diferentes de zero
        
    }
        return true;
    }

    public boolean isMatrizColuna() {
    // Contador para cada coluna com elementos diferentes de zero
    int[] contagemPorColuna = new int[colunas];
    int colunasComElementos = 0;

    for (int i = 0; i < linhas; i++) {
        EloMatriz p = vetorLinhas[i];
        
        while (p != null) {
            if (p.valor != 0) {
                // Incrementa a contagem de elementos na coluna correspondente
                contagemPorColuna[p.coluna]++;
                
                // Verifica se a coluna agora tem mais de um elemento diferente de zero
                if (contagemPorColuna[p.coluna] == 1) {
                    colunasComElementos++;
                }

                // Se mais de uma coluna contém elementos diferentes de zero, não é matriz coluna
                if (colunasComElementos > 1) {
                    return false;
                }
            }
            p = p.prox;
        }
    }

    return true;
    }

    // não está funcionando 
    public boolean isMatrizTriangularInferior(){
        // ainda que esteja zerada, a matriz é considerada uma matriz triangular inferior porque a parte superior esta zerada.
        for (int i = 0; i < linhas; i++) {
            EloMatriz p = vetorLinhas[i];
            while(p!= null){
                if(i > p.coluna || i == p.coluna){
                    if (buscarElemento(i,p.coluna) == 0){
                        return false;
                    }
                }
                p = p.prox;
            }
            // verifica somente a parte superior. Se algum elemento for diferente de 0, não é uma matriz triangular inferior.
            if(buscarElemento(i, p.coluna) != 0){
                return false;
            }
            
        }
        return true;
    }



    /*
    public boolean isMatrizTriangularInferior();
    public boolean isMatrizTriangularSuperior();
    public boolean isMatrizSimetrica();
    public MatrizEstatica somarMatrizes(MatrizEstatica matrizSecundaria);
    public MatrizEstatica multiplicarMatrizes(MatrizEstatica matrizSecundaria);
    public MatrizEstatica obterMatrizTransposta();
    */
    
}
