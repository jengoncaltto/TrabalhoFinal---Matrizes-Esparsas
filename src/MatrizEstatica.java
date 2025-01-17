import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

public class MatrizEstatica extends Matriz{
    private Vector<Vector<Integer>> matriz;
    private int qtdNaoNulos;

    public MatrizEstatica(int linha, int coluna){
        super(linha, coluna);
        gerarMatrizVazia();
        this.qtdNaoNulos = 0;
    }

    private void gerarMatrizVazia(){

        matriz = new Vector<>(colunas);
        for (int i = 0; i < colunas; i++) {
            Vector<Integer> linha = new Vector<>(this.linhas);
            for (int j = 0; j < this.linhas; j++) {
                linha.add(0); // Preencher com zeros
            }
            matriz.add(linha);
        }
    }
    
    public void preencherMatriz(){
        List<Integer> elementos = gerarElementos();
        int k = 1;

        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                inserirElemento(i, j, elementos.get(k));
                if(elementos.get(k++) != 0) qtdNaoNulos++;
            }
        }
    }

    public void inserirElemento(int linha, int coluna, int elemento){
        matriz.get(linha -1).set(coluna -1, elemento);
        if(elemento != 0) qtdNaoNulos++;
    }


    public void removerElemento(int linha, int coluna){
        //para remover, o elemento é substituído por 0 para manter o tamanho da matriz  
        matriz.get(linha).set(coluna, 0);
        qtdNaoNulos--;
    }

    public Vector<Integer> buscarElementoCoord(int elemento){
        Vector<Integer> vetor = new Vector<Integer>(2);
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                if(buscarElemento(i, j) == elemento) {
                    vetor.add(i);
                    vetor.add(j);
                    // retorna um vetor com as coordenadas [linha, coluna]
                }
            }
        }
        if(vetor.isEmpty()){vetor.add(-1);vetor.add(-1);}
        return vetor; // [-1, -1] quando não encontra o elemento
    }
    
    public int buscarElemento(int linha, int coluna){
        return matriz.get(linha -1).get(coluna -1);
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
        List<Vector<Integer>> ls = new ArrayList<Vector<Integer>>();
        for (int i = 0; i < linhas; i++) {
            if(ls.size() > 1) return false;
            for (int j = 0; j < colunas; j++) {
                if(buscarElemento(i, j) != 0){
                    ls.add(matriz.get(i)); // adiciona a linha com elemento(s) diferente(s) de 0 na lista
                    break;
                }

                // se houver mais de uma linha com elemento(s) diferente(s) de 0 na lista, não é matriz linha
            }
        }
        return true;
    }

    public boolean isMatrizColuna(){
        // Uma matriz coluna é aquela em que apenas uma coluna possui mais de um  elemento diferente de zero.
        List<Vector<Integer>> cols = new ArrayList<Vector<Integer>>();
        for (int i = 0; i < colunas; i++) {
            if(cols.size() > 1) return false;
            for (int j = 0; j < linhas; j++) {
                if(buscarElemento(j, i) != 0){
                    cols.add(matriz.get(j)); // adiciona a coluna com elemento(s) diferente(s) de 0 na lista
                    break;
                }
                // se houver mais de uma coluna com elemento(s) diferente(s) de 0 na lista, não é matriz coluna
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

        // A matriz só é simétrica se for uma matriz quadrada.
        if((getColunas() != getLinhas())) return false;
        if((matrizTransposta.getColunas() != matrizTransposta.getLinhas())) return false;
        // Elas não são simétricas se não possuírem as mesmas dimensões.
        // se elas forem quadradas e não possuírem a mesma capacidade, elas não possuem as mesmas dimensões
        if((matrizTransposta.getCapacidade() != getCapacidade())) return false;

        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                if(!matrizTransposta.getMatriz().get(i).get(j).equals(matriz.get(i).get(j))) return false;
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

    public Vector<Vector<Integer>> getMatriz(){
        return this.matriz;
    }

    public void setMatriz(Vector<Vector<Integer>> matriz){
        this.matriz = matriz;
    }
}
