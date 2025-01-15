import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

public class MatrizEstatica extends Matriz{
    private Vector<Vector<Integer>> matriz;
    private int qtdNaoNulos;

    public MatrizEstatica(int largura, int altura){
        super(largura, altura);
        gerarMatrizVazia();
        this.qtdNaoNulos = 0;
    }

    private void gerarMatrizVazia(){
        matriz = new Vector<Vector<Integer>>();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                matriz.get(i).set(j, 0);
            }
        }
    }    
    
    public void preencherMatriz(){
        List<Integer> elementos = gerarElementos();
        int k = 0;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                inserirElemento(altura, largura, elementos.get(k));
                if(elementos.get(k++) != 0) qtdNaoNulos++;
            }
        }
    }

    public void inserirElemento(int linha, int coluna, int elemento){
        matriz.get(linha).set(coluna, elemento);
        if(elemento != 0) qtdNaoNulos++;
    }

    public void removerElemento(int linha, int coluna){
        //para remover, o elemento é substituído por 0 para manter o tamanho da matriz  
        matriz.get(linha).set(coluna, 0);
        qtdNaoNulos--;
    }

    public int[] buscarElemento(int elemento){
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if(buscarElemento(i, j) == elemento)
                    return new int[]{i, j}; // retorna um vetor com as coordenadas [linha, coluna]
            }
        }
        return new int[]{-1, -1}; // [-1, -1] quando não encontra o elemento
    }
    
    public int buscarElemento(int linha, int coluna){
        return matriz.get(linha).get(coluna);
    }

    public void imprimirMatriz(){
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                System.out.println(buscarElemento(i, j) + " ");
            }
            System.out.println();
        }
    }

    public boolean isMatrizVazia(){
        return qtdNaoNulos == 0;
    }

    public boolean isMatrizDiagonal(){
        // Uma matriz diagonal é aquela em que todos os elementos fora da diagonal principal são zero.
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (i == j) continue; // ignora os valores da diagonal
                if(buscarElemento(i, j) != 0) return false; // verifica se os elementos fora da diagonal são não nulos
            }
        }
        return true;
    }

    public boolean isMatrizLinha(){
        // Uma matriz linha é aquela em que apenas uma linha possui mais de um  elemento diferente de zero.
        List<Vector<Integer>> linhas = new ArrayList<Vector<Integer>>();
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if(buscarElemento(i, j) != 0){
                    linhas.add(matriz.get(i)); // adiciona a linha com elemento(s) diferente(s) de 0 na lista
                }
                if(linhas.size() > 1) return false;
                // se houver mais de uma linha com elemento(s) diferente(s) de 0 na lista, não é matriz linha
            }
        }
        return true;
    }

    public boolean isMatrizColuna(){
        // Uma matriz coluna é aquela em que apenas uma coluna possui mais de um  elemento diferente de zero.
        List<Vector<Integer>> colunas = new ArrayList<Vector<Integer>>();
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                if(buscarElemento(i, j) != 0){
                    colunas.add(matriz.get(i)); // adiciona a coluna com elemento(s) diferente(s) de 0 na lista
                }
                if(colunas.size() > 1) return false;
                // se houver mais de uma coluna com elemento(s) diferente(s) de 0 na lista, não é matriz coluna
            }
        }
        return true;
    }

    public boolean isMatrizTriangularInferior(){
        // ainda que esteja zerada, a matriz é considerada uma matriz triangular inferior porque a parte superior esta zerada.
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if(i >= j) continue;
                
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
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
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
        if((getAltura() != getLargura())) return false;
        if((matrizTransposta.getAltura() != matrizTransposta.getLargura())) return false;
        // Elas não são simétricas se não possuírem as mesmas dimensões.
        // se elas forem quadradas e não possuírem a mesma capacidade, elas não possuem as mesmas dimensões
        if((matrizTransposta.getCapacidade() != getCapacidade())) return false;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if(matrizTransposta.getMatriz().get(i).get(j).equals(matriz.get(i).get(j))) return false;
            }
        }

        return true;
    }

    public MatrizEstatica somarMatrizes(MatrizEstatica matrizSecundaria){
        // verificar se ambas tem as mesmas quantidades de linhas e colunas
        // fazer um if informando que não é possível somar quando as dimensões forem diferentes
        // a posição [i,j] da nova matriz e dada por A[i,j] + B[i, j]
        MatrizEstatica matrizSomada = new MatrizEstatica(matrizSecundaria.getLargura(), getAltura());
        return matrizSomada;
    }

    public MatrizEstatica multiplicarMatrizes(MatrizEstatica matrizSecundaria){//alterar valores
        MatrizEstatica matrizMultiplicada = new MatrizEstatica(0, 0);


        return matrizMultiplicada;
    }  

    public MatrizEstatica obterMatrizTransposta(){
        // as colunas viram linhas, e linhas as colunas
        MatrizEstatica matrizTransposta = new MatrizEstatica(getAltura(), getLargura());
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
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
