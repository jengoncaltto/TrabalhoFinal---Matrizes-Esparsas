import java.time.LocalDateTime;

public class MatrizEstatica extends Matriz<MatrizEstatica> {
	private final int[][] matriz;
	private int qtdNaoNulos;

	public int[][] getMatriz() {
		return this.matriz;
	}

	public MatrizEstatica(int linhas, int colunas) {
		super(linhas, colunas);
		matriz = new int[linhas][colunas];
		this.gerarMatrizVazia();
		this.qtdNaoNulos = 0;
	}

	@Override
	public void inserirElemento(int linha, int coluna, int elemento) {
		matriz[linha - 1][coluna - 1] = elemento;
		if (elemento != 0) qtdNaoNulos++;
	}

	@Override
	public boolean removerElemento(int linha, int coluna) {
		//para remover, o elemento é substituído por 0 para manter o tamanho da matriz
		var item = matriz[linha - 1][coluna - 1];
		matriz[linha - 1][coluna - 1] = 0;
		return item != 0;
	}

	@Override
	public void gerarMatrizVazia() {
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < this.colunas; j++) {
				matriz[i][j] = 0; // Preencher com zeros
			}
		}
	}

	@Override
	public int buscarElemento(int linha, int coluna) {
		return matriz[linha - 1][coluna - 1];
	}

	@Override
	public void imprimirMatriz() {
		try {
			for (int i = 0; i < this.linhas; i++) {
				for (int j = 0; j < this.colunas; j++) {
					System.out.print(matriz[i][j] + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean ehVazia() {
		return qtdNaoNulos == 0;
	}

	@Override
	public boolean ehDiagonal() {
		// Verifica se a matriz é quadrada
		if (linhas != colunas)
			return false;

		// vazia tb é diagonal
		if (this.ehVazia())
			return true;

		// Uma matriz diagonal é aquela em que todos os elementos fora da diagonal principal são zero.
		for (int i = 0; i < colunas; i++) {
			for (int j = 0; j < linhas; j++) {
				if (i == j) continue; // ignora os valores da diagonal
				if (matriz[i][j] != 0) return false; // verifica se os elementos fora da diagonal são não nulos
			}
		}
		return true;
	}

	@Override
	public boolean ehTriangularInfeior() {
		if (linhas != colunas) return false; // não é quadrada

		for (int i = 0; i < linhas; i++) {
			for (int j = i + 1; j < linhas; j++) { // Somente elementos acima da diagonal principal
				if (matriz[i][j] != 0) {
					return false; // Algum elemento acima da diagonal principal não é zero
				}
			}
		}
		return true; // É triangular inferior
	}

	@Override
	public boolean ehTriangularSuperior() {
		if (linhas != colunas) return false; // não é quadrada

		for (int i = 1; i < linhas; i++) { // Começar da segunda linha
			for (int j = 0; j < i; j++) { // Somente elementos abaixo da diagonal principal
				if (matriz[i][j] != 0) {
					return false; // Algum elemento abaixo da diagonal principal não é zero
				}
			}
		}
		return true; // É triangular inferior
	}

	@Override
	public boolean ehSimetrica() {
		if (linhas != colunas) return false; // não é quadrada

		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				if (i != j && matriz[i][j] != matriz[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public MatrizEstatica somarMatriz(MatrizEstatica outraMatriz) {
		if ((this.colunas != outraMatriz.getColunas() && (this.linhas != outraMatriz.getLinhas())))
			throw new IllegalArgumentException("As matrizes precisam ter as mesmas dimensões para poder somar.");

		// a posição [i,j] da nova matriz e dada por A[i,j] + B[i, j]
		MatrizEstatica matrizSoma = new MatrizEstatica(this.linhas, this.colunas);
		for (int i = 0; i < this.colunas; i++) {
			for (int j = 0; j < this.linhas; j++) {
				matrizSoma.inserirElemento(i + 1, j + 1, this.matriz[i][j] + outraMatriz.buscarElemento(i + 1, j + 1));
			}
		}
		return matrizSoma;
	}

	/*
		- recebe this e matriz secundaria
		- verifica se o numero de colunas de this eh igual o numero de linhas da matrizsecundaria
		- se sim, passa por this pegando elemento de cada coluna de this e multiplicando com cada elemento das linhas da matriz secundaria
		- matriz multiplicada recebe coluna de this e linha de matrizsecundaria 	*/
	@Override
	public MatrizEstatica multiplicarMatriz(MatrizEstatica outraMatriz) {
		if (outraMatriz == null || (outraMatriz.getLinhas() != this.colunas))
			throw new IllegalArgumentException("Para poder multiplicar, o número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz.");

		// Cria a matriz resultado com dimensões apropriadas
		MatrizEstatica matrizMultiplicada = new MatrizEstatica(this.linhas, outraMatriz.getColunas());

		// Calcula o produto das matrizes
		for (int i = 0; i < this.linhas; i++) { // Itera pelas linhas de A
			for (int j = 0; j < outraMatriz.getColunas(); j++) { // Itera pelas colunas de B
				for (int k = 0; k < this.colunas; k++) { // Itera pelas colunas de A (ou linhas de B)
					matrizMultiplicada.getMatriz()[i][j] += this.matriz[i][k] * outraMatriz.getMatriz()[k][j];
				}
			}

			if (this.capacidade > 10000000 && this.linhas >= 50 && i % (this.linhas / 50) == 0) {
				System.out.print("█"); // Escreve um quadradinho no console
			}

			if (this.capacidade > 10000000 && this.linhas > 10 && (i % (this.linhas / 10) == 0)) {
				System.out.printf("[%s%%]", (int) (100 * i / this.linhas));
			}
		}

		return matrizMultiplicada;
	}

	@Override
	public MatrizEstatica obterMatrizTransposta() {
		// as colunas viram linhas, e linhas as colunas
		MatrizEstatica matrizTransposta = new MatrizEstatica(this.colunas, this.linhas);
		for (int i = 1; i <= this.linhas; i++) {
			for (int j = 1; j <= this.colunas; j++) {
				matrizTransposta.inserirElemento(j, i, this.matriz[i - 1][j - 1]);
			}
		}
		return matrizTransposta;
	}

	@Override
	public void preencherMatriz() {
		provedorNumeros.reset(this.capacidade);
		System.out.printf("Preenchendo matriz de %s linhas...", this.linhas);
		System.out.println("Começando as " + Relogio.Timestamp());
		LocalDateTime inicio = LocalDateTime.now();
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < this.colunas; j++) {
				this.matriz[i][j] = this.proximoNumero();
				if (this.matriz[i][j] != 0) qtdNaoNulos++;
			}
			if (this.capacidade > 10000000 && this.linhas > 10 && (i % (this.linhas / 10) == 0)) {
				System.out.printf("[%s%%]", (int) (100 * i / this.linhas));
			}
		}
		System.out.println("[100%]");
		System.out.print("Terminou as " + Relogio.Timestamp());
		System.out.println(", Tempo total: " + Relogio.tempoGasto(inicio));
	}
}
