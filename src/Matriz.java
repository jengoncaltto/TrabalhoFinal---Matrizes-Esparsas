import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    protected List<Integer> gerarElementos(){
        int minZeros = calcularMinimoZeros();
        List<Integer> elementos = new ArrayList<>();
        for (int i = 0; i < capacidade +1; i++) {
            if(minZeros >= i)
                elementos.add(0);
            else{
                elementos.add((new Random()).nextInt(0, 9));
            }
        }

        // Embaralha a lista para distribuir os zeros
        Collections.shuffle(elementos);
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
