import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Matriz<T extends Matriz<T>> {
	protected int linhas;
	protected int colunas;
	protected int capacidade;

	public Matriz(int linha, int coluna) {
		this.linhas = linha;
		this.colunas = coluna;
		this.capacidade = linha * coluna;
	}

	public class provedorNumeros {
		private static final List<Integer> conjuntoDeNumeros = new ArrayList<>();
		private static int indiceAtual = 0; // Controla qual número será retornado a seguir
		private static final int tamanhoLote = 1000; // Quantidade de números gerados por vez
		private static final Random random = new Random();

		// Inicializa a lista com os primeiros números
		static {
			gerarNovosNumeros();
		}

		public static synchronized void reset() {
			gerarNovosNumeros();
			indiceAtual = 0;
		}

		// obter o próximo número
		public static synchronized int next() {

			if (indiceAtual == tamanhoLote) {
				gerarNovosNumeros();
				indiceAtual = 0;
			}
			return conjuntoDeNumeros.get(indiceAtual++);
		}

		// gerar novos números
		private static void gerarNovosNumeros() {
			conjuntoDeNumeros.clear();

			// Calcula o número de elementos iguais a 0 (60%)
			int qtdZeros = (int) (tamanhoLote * 0.6);

			// Adiciona os 0 na lista
			for (int i = 0; i < qtdZeros; i++) {
				conjuntoDeNumeros.add(0);
			}

			// Adiciona os números aleatórios de 1 a 9 (restantes 40%)
			for (int i = 0; i < (tamanhoLote - qtdZeros); i++) {
				conjuntoDeNumeros.add(random.nextInt(9) + 1); // Gera números de 1 a 9
			}

			// Embaralha a lista
			Collections.shuffle(conjuntoDeNumeros);
		}
	}

	protected int proximoNumero() {
		return provedorNumeros.next();
	}

	private int calcularMinimoZeros() {
		// calcula a capacidade total e depois 60% dela, caso resulte em um numero decimal é arrendondado para um inteiro maior.
		return (int) Math.ceil(capacidade * 0.6);
	}

	public int getLinhas() {
		return this.linhas;
	}

	public int getColunas() {
		return this.colunas;
	}

	public int getCapacidade() {
		return this.capacidade;
	}

	public abstract void inserirElemento(int linha, int coluna, int elements);

	public abstract boolean removerElemento(int linha, int coluna, int elements);

	public abstract int buscarElemento(int linha, int coluna);

	public abstract void imprimirMatriz();

	public abstract void gerarMatrizVazia();

	public abstract boolean ehVazia();

	public abstract boolean ehDiagonal();

	public abstract boolean ehMatrizLinha();

	public abstract boolean ehMatrizColuna();

	public abstract boolean ehTriangularInfeior();

	public abstract boolean ehTriangularSuperior();

	public abstract boolean ehSimetrica();

	public abstract T somarMatriz(T outraMatriz);

	public abstract T multiplicarMatriz(T outraMatriz);

	public abstract T obterMatrizTransposta();

	public abstract void preencherMatriz();
}
