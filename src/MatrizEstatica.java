import java.time.LocalTime;

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
	public boolean removerElemento(int linha, int coluna, int elements) {
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
	public boolean ehMatrizLinha() {
		return this.linhas == 1;
	}

	@Override
	public boolean ehMatrizColuna() {
		return this.colunas == 1;
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

		int[][] transposta = this.obterMatrizTransposta().getMatriz();
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				if (matriz[i][j] != transposta[i][j]) {
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
				matrizSoma.inserirElemento(i, j, this.matriz[i][j] + outraMatriz.buscarElemento(i, j));
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
			throw new IllegalArgumentException("A largura da matriz secundária deve ser igual à altura da matriz principal para multiplicação.");

		// Cria a matriz resultado com dimensões apropriadas
		MatrizEstatica matrizMultiplicada = new MatrizEstatica(this.linhas, outraMatriz.getColunas());

		// Calcula o produto das matrizes
		for (int i = 0; i < this.linhas; i++) { // Itera pelas linhas de A
			for (int j = 0; j < outraMatriz.getColunas(); j++) { // Itera pelas colunas de B
				for (int k = 0; k < this.colunas; k++) { // Itera pelas colunas de A (ou linhas de B)
					matrizMultiplicada.getMatriz()[i][j] += this.matriz[i][k] * outraMatriz.getMatriz()[k][j];
				}
			}

			if (i % (this.linhas / 50) == 0) {
				System.out.print("█"); // Escreve um quadradinho no console
			}
		}

		return matrizMultiplicada;
	}

	@Override
	public MatrizEstatica obterMatrizTransposta() {
		// as colunas viram linhas, e linhas as colunas
		MatrizEstatica matrizTransposta = new MatrizEstatica(this.colunas, this.linhas);
		for (int i = 0; i < colunas; i++) {
			for (int j = 0; j < linhas; j++) {
				matrizTransposta.inserirElemento(j, i, this.matriz[i][j]);
			}
		}
		return matrizTransposta;
	}

	@Override
	public void preencherMatriz() {
		provedorNumeros.reset();
		System.out.printf("Preenchendo matriz de %s linhas...", this.linhas);
		System.out.println("Começando as " + Relogio.Timestamp());
		LocalTime inicio = LocalTime.now();
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < this.colunas; j++) {
				this.matriz[i][j] = this.proximoNumero();
				if (this.matriz[i][j] != 0) qtdNaoNulos++;
			}
			if (i % (this.linhas / 10) == 0) {
				System.out.printf("[%s%%]", (int) (100 * i / this.linhas)); // Escreve um quadradinho no console
			}
		}
		System.out.println("[100%]");
		System.out.print("Terminou as " + Relogio.Timestamp());
		System.out.println(", -Tempo total: " + Relogio.Passou(inicio));
	}
}
