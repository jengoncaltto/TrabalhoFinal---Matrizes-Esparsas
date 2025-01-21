public class MatrizEstatica extends Matriz{
	private int[][] matriz;
    private int qtdNaoNulos;
    
    public int[][] getMatriz(){
    	return this.matriz;
    }

    public MatrizEstatica(int linhas, int colunas) {
        super(linhas, colunas);
        matriz = new int[linhas][colunas];
        gerarMatrizVazia();
        this.qtdNaoNulos = 0;
    }


    private void gerarMatrizVazia(){
        for (int i = 0; i < colunas; i++) {
            int[] linha = new int[this.linhas];
            for (int j = 0; j < this.linhas; j++) {
                matriz[i][j] = 0; // Preencher com zeros
            }
        }
    }
    
    public void preencherMatriz(){
        int[] elementos = gerarElementos();
        int k = 1;
        
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                inserirElemento(i, j, elementos[k]);
                if(elementos[k++] != 0) qtdNaoNulos++;
            }
        }
    }

    public void inserirElemento(int linha, int coluna, int elemento) {
        matriz[linha -1][coluna -1] = elemento;
        if (elemento != 0) qtdNaoNulos++;
    }



    public void removerElemento(int linha, int coluna){
        //para remover, o elemento é substituído por 0 para manter o tamanho da matriz  
    	linha = linha -1;
    	coluna = coluna -1;
        matriz[linha][coluna] = 0;
        qtdNaoNulos--;
    }

    public int[] buscarElementoCoord(int elemento){
        int[] vetor = new int[2];
        for (int i = 1; i < colunas+1; i++) {
            for (int j = 1; j < linhas+1; j++) {
                if(buscarElemento(i, j) == elemento) {
                	vetor[0] = i;
                	vetor[1] = j;
                    return vetor;// retorna um vetor com as coordenadas [linha, coluna]
                }
            }
        }
        if(vetor.length == 0) {
        	vetor[0] = -1;
        	vetor[1] = -1;
        	return vetor;
        } 
        
        return vetor; // [-1, -1] quando não encontra o elemento
    }
    
    public int buscarElemento(int linha, int coluna) {
    	linha = linha -1;
    	coluna = coluna -1;
        return matriz[linha][coluna];
    }

    public void imprimirMatriz(){
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                System.out.print(buscarElemento(i+1, j+1) + " ");
            }
            System.out.println();
        }
    }

    public boolean isMatrizVazia(){
        return qtdNaoNulos == 0;
    }

    public boolean isMatrizDiagonal(){
        // Uma matriz diagonal é aquela em que todos os elementos fora da diagonal principal são zero.
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                if (i == j) continue; // ignora os valores da diagonal
                if(buscarElemento(i, j) != 0) return false; // verifica se os elementos fora da diagonal são não nulos
            }
        }
        return true;
    }

    public boolean isMatrizLinha(){
        // Uma matriz linha é aquela em que apenas uma linha possui mais de um  elemento diferente de zero.
        int[] ls = new int[linhas];
        for (int i = 0; i < linhas; i++) {
            // se houver mais de uma linha com elemento(s) diferente(s) de 0 na lista, não é matriz linha
            if(ls.length > 1) return false;
            for (int j = 0; j < colunas; j++) {
                if(buscarElemento(i, j) != 0){
                    ls[i] = i;  // adiciona a linha com elemento(s) diferente(s) de 0 na lista
                    break;
                }
            }
        }
        return true;
    }

    public boolean isMatrizColuna(){
        // Uma matriz coluna é aquela em que apenas uma coluna possui mais de um  elemento diferente de zero.
        int[] cols = new int[colunas];
        for (int i = 0; i < colunas; i++) {
            // se houver mais de uma coluna com elemento(s) diferente(s) de 0 na lista, não é matriz coluna
            if(cols.length> 1) return false;
            for (int j = 0; j < linhas; j++) {
                if(buscarElemento(j, i) != 0){
                    cols[j] = j; // adiciona a coluna com elemento(s) diferente(s) de 0 na lista
                    break;
                }
                
            }
        }
        return true;
    }

    public boolean isMatrizTriangularInferior(){
        // ainda que esteja zerada, a matriz é considerada uma matriz triangular inferior porque a parte superior esta zerada.
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if(i > j || i == j){
                    if (buscarElemento(i,j) == 0){
                        return false;
                    }
                    continue;
                }
                
                // verifica somente a parte superior. Se algum elemento for diferente de 0, não é uma matriz triangular inferior.
                if(buscarElemento(i, j) != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMatrizTriangularSuperior(){
        // ainda que esteja zerada, a matriz é considerada uma matriz triangular superior porque a parte superior esta zerada.
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                if(i <= j) continue;
                
                // verifica somente a parte inferior. Se algum elemento for diferente de 0, não é uma matriz triangular superior.
                if(buscarElemento(i, j) != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMatrizSimetrica(){
        // Uma matriz é considerada simétrica quando ela é igual à sua transposta.
        MatrizEstatica matrizTransposta = obterMatrizTransposta();
        int[][] matrizTrans = matrizTransposta.getMatriz();

        // A matriz só é simétrica se for uma matriz quadrada.
        if((getColunas() != getLinhas())) return false;
        if((matrizTransposta.getColunas() != matrizTransposta.getLinhas())) return false;
        // Elas não são simétricas se não possuírem as mesmas dimensões.
        // se elas forem quadradas e não possuírem a mesma capacidade, elas não possuem as mesmas dimensões
        if((matrizTransposta.getCapacidade() != getCapacidade())) return false;

        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                if (matrizTrans[i][j] == this.matriz[j][i]) return false;
            }
        }
        return true;
    }

    public MatrizEstatica somarMatrizes(MatrizEstatica matrizSecundaria){
        // verificar se ambas tem as mesmas quantidades de linhas e colunas
        // fazer um if informando que não é possível somar quando as dimensões forem diferentes
        // a posição [i,j] da nova matriz e dada por A[i,j] + B[i, j]
        if((this.getColunas() != matrizSecundaria.getColunas() && (this.getLinhas() != matrizSecundaria.getLinhas()))) throw new IllegalArgumentException("As matrizes precisam ter as mesmas dimensões");
        MatrizEstatica matrizSomada = new MatrizEstatica(getLinhas(), getColunas());
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                int soma = this.buscarElemento(i, j) + matrizSecundaria.buscarElemento(i, j);

                matrizSomada.inserirElemento(i, j, soma);
            }
        }
        return matrizSomada;
    }
    /*
    - recebe this e matriz secundaria
    - verifica se o numero de colunas de this eh igual o numero de linhas da matrizsecundaria
    - se sim, passa por this pegando elemento de cada coluna de this e multiplicando com cada elemento das linhas da matriz secundaria
    - matriz multiplicada recebe coluna de this e linha de matrizsecundaria

    */
    public MatrizEstatica multiplicarMatrizes(MatrizEstatica matrizSecundaria){//alterar valores
        if(matrizSecundaria.getLinhas() != this.getColunas()) throw new IllegalArgumentException("A largura da matriz secundária deve ser igual à altura da matriz principal para multiplicação.");
        MatrizEstatica matrizMultiplicada = new MatrizEstatica(matrizSecundaria.getLinhas(), this.getColunas());

        // Percorrer as linhas da matriz principal
        for (int i = 0; i < this.getColunas(); i++) {
            // Percorrer as colunas da matriz secundária
            for (int j = 0; j < matrizSecundaria.getLinhas(); j++) {
                int soma = 0;

                for (int k = 0; k < this.getLinhas(); k++) {
                    soma += this.buscarElemento(i, k) * matrizSecundaria.buscarElemento(k, j);
                }

                matrizMultiplicada.inserirElemento(i, j, soma);
            }
        }
        return matrizMultiplicada;
    }  

    public MatrizEstatica obterMatrizTransposta(){
        // as colunas viram linhas, e linhas as colunas
        MatrizEstatica matrizTransposta = new MatrizEstatica(getColunas(), getLinhas());
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                matrizTransposta.inserirElemento(j, i, buscarElemento(i,j));
            }
        }
        return matrizTransposta;
    }    
}
