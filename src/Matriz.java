import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Matriz {
    protected int largura;
    protected int altura;
    protected int capacidade;

    public Matriz(int largura, int altura){
        this.largura = largura;
        this.altura = altura;
        this.capacidade = largura * altura;
    }

    protected List<Integer> gerarElementos(){
        int minZeros = calcularMinimoZeros();
        List<Integer> elementos = new ArrayList<>();
        for (int i = 0; i < capacidade; i++) {
            if(minZeros < i)
                elementos.add(0);
            else
                elementos.add((new Random()).nextInt(0, 9));
        }

        // Embaralha a lista para distribuir os zeros
        Collections.shuffle(elementos);
        return elementos;
    }

    private int calcularMinimoZeros(){
        // calcula a capacidade total e depois 60% dela, caso resulte em um numero decimal é arrendondado para um inteiro maior.
        return (int) Math.ceil(capacidade * 0.6);
    }

    public int getLargura(){
        return this.largura;
    }

    public int getAltura(){
        return this.altura;
    }

    public int getCapacidade(){
        return this.capacidade;
    }
}
