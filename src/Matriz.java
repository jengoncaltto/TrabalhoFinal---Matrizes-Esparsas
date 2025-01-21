import java.util.Random;

public class Matriz {
    protected int linhas;
    protected int colunas;
    protected int capacidade;

    public Matriz(int linha, int coluna){
        this.linhas = linha;
        this.colunas = coluna;
        this.capacidade = linha * coluna;
    }

    protected int[]gerarElementos(){
        int minZeros = calcularMinimoZeros();
        int[] elementos = new int[linhas*colunas];
        for (int i = 0; i < capacidade +1; i++) {
            if(minZeros >= i)
            	elementos[i] = 0;
            else{
                elementos[i] = new Random().nextInt(0, 9);
            }
        }

        // Embaralha a lista para distribuir os zeros
        for (int i = elementos.length - 1; i > 0; i--) {
            int j = new Random().nextInt(i + 1);
            int temp = elementos[i];
            elementos[i] = elementos[j];
            elementos[j] = temp;
        }
        return elementos;
    }

    private int calcularMinimoZeros(){
        // calcula a capacidade total e depois 60% dela, caso resulte em um numero decimal é arrendondado para um inteiro maior.
        return (int) Math.ceil(capacidade * 0.6);
    }

    public int getLinhas(){
        return this.linhas;
    }

    public int getColunas(){
        return this.colunas;
    }

    public int getCapacidade(){
        return this.capacidade;
    }
}
