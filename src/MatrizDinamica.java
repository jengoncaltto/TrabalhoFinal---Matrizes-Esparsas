
public class MatrizDinamica extends Matriz<MatrizDinamica> {
	private Elo[] vetorLinhas; // Array de listas encadeadas (uma para cada linha)
	private int totalElementos;

	// Classe para representar os elementos na matriz
	protected static class Elo {
		private int coluna;
		private int valor;
		private Elo prox;

		public Elo(int coluna, int valor) {
			this.coluna = coluna;
			this.valor = valor;
			this.prox = null;
		}
	}

	public MatrizDinamica(int linha, int coluna) {
		super(linha, coluna);
		this.vetorLinhas = new Elo[this.linhas];
		this.totalElementos = 0;
	}

	@Override
	public void preencherMatriz() {
		provedorNumeros.reset(this.capacidade);

		// Percorre as linhas em ordem reversa
		// para sempre inserir na primeira posição (sem percorrer as listas)

		for (int linha = this.linhas; linha >= 1; linha--) {
			for (int coluna = this.colunas; coluna >= 1; coluna--) {
				int valor = this.proximoNumero();
				if (valor != 0)
					this.inserirElemento(linha, coluna, valor);
			}
		}
	}

	@Override
	public void inserirElemento(int linha, int coluna, int elemento) {
		linha--;
		coluna--;

		if (linha < 0 || linha >= this.linhas || coluna < 0 || coluna >= this.colunas)
			throw new IllegalArgumentException("Linha ou coluna fora dos limites.");

		if (elemento == 0) {
			removerElemento(linha, coluna);
			return;
		}

		Elo atual = this.vetorLinhas[linha];
		Elo anterior = null;

		// procura posição pra inserir
		while (atual != null && atual.coluna < coluna) {
			anterior = atual;
			atual = atual.prox;
		}

		// Atualiza o valor se a coluna já existir
		if (atual != null && atual.coluna == coluna) {
			atual.valor = elemento;
			return;
		}

		Elo novoElo = new Elo(coluna, elemento);

		// Inserir o novo elo na posição correta
		if (anterior == null) {
			// Inserção no início da lista
			this.vetorLinhas[linha] = novoElo;
		} else {
			// Inserção entre dois elos ou no final
			anterior.prox = novoElo;
		}
		novoElo.prox = atual;

		this.totalElementos++;
	}

	@Override
	public boolean removerElemento(int linha, int coluna) {
		linha--;
		coluna--;
		Elo atual = this.vetorLinhas[linha];
		Elo anterior = null;

		// achar o elemento
		while (atual != null && atual.coluna < coluna) {
			anterior = atual;
			atual = atual.prox;
		}

		if (atual != null && atual.coluna == coluna) {
			if (anterior == null) {
				this.vetorLinhas[linha] = atual.prox; // primeiro
			} else {
				anterior.prox = atual.prox; // no meio ou final
			}
			this.totalElementos--;
			return true;
		}
		return false;
	}

	@Override
	public int buscarElemento(int linha, int coluna) {
		linha--;
		coluna--;
		if (linha < 0 || linha >= this.linhas || coluna < 0 || coluna >= this.colunas)
			throw new IllegalArgumentException("Linha ou coluna fora dos limites.");

		Elo atual = this.vetorLinhas[linha];

		while (atual != null) {
			if (atual.coluna == coluna)
				return atual.valor; // se achou, retorna

			atual = atual.prox;
		}

		// como não achou, é 0.
		return 0;
	}

	@Override
	public void imprimirMatriz() {
		for (int i = 0; i < linhas; i++) {
			Elo atual = vetorLinhas[i];

			for (int j = 0; j < colunas; j++) {
				if (atual != null && atual.coluna == j) {
					System.out.print(atual.valor + " ");
					atual = atual.prox;
				} else {
					// se não havia elemento, imprime 0
					System.out.print("0 ");
				}
			}

			System.out.println();
		}
	}

	@Override
	public void gerarMatrizVazia() {
		// Matriz vazia é vetor de nulos, então basta criar novo vetor.
		this.vetorLinhas = new Elo[linhas];
		this.totalElementos = 0;
	}

	@Override
	public boolean ehVazia() {
		return this.totalElementos == 0;
	}

	@Override
	public boolean ehDiagonal() {
		// Verifica se a matriz é quadrada
		if (linhas != colunas)
			return false;

		// vazia tb é diagonal
		if (this.ehVazia())
			return true;

		for (int i = 0; i < linhas; i++) {
			Elo atual = vetorLinhas[i]; // Pega o início da lista da linha

			if (atual != null) {
				// 1) Verificar se o elemento está na diagonal principal
				if (atual.coluna != i)
					return false; // Está fora da diagonal

				// 2) Verificar se existe mais de um elemento na linha
				if (atual.prox != null)
					return false; // Linha tem mais de um elemento
			}
		}

		// Passou por todas as verificações, é diagonal
		return true;
	}

	@Override
	public boolean ehTriangularInfeior() {
		// Verifica se a matriz é quadrada
		if (linhas != colunas)
			return false;

		// vazia tb é triangular inferior e superior
		if (this.ehVazia())
			return true;

		for (int i = 0; i < linhas; i++) {
			Elo atual = vetorLinhas[i];

			// Percorre os elementos da lista da linha até a diagonal
			while (atual != null) {
				if (atual.coluna == i) {
					// Verifica se é o último elemento na linha
					if (atual.prox != null)
						return false; // Existe algum elemento após a diagonal
					break;
				}
				atual = atual.prox;
			}
		}
		return true; // Todas as condições para triangular inferior foram atendidas
	}

	@Override
	public boolean ehTriangularSuperior() {
		// Verifica se a matriz é quadrada
		if (linhas != colunas)
			return false;

		// vazia tb é triangular inferior e superior
		if (this.ehVazia())
			return true;

		for (int i = 0; i < linhas; i++) {
			Elo atual = vetorLinhas[i];

			// se existir algum elemento na linha...
			if (atual != null) {
				// ... deve ser o elemento da diagonal
				if (atual.coluna < i)
					return false; // Existe um elemento abaixo da diagonal
			}
		}
		return true;
	}

	@Override
	public boolean ehSimetrica() {
		// verifica se é quadrada pq só quadrada pode ser simétrica
		if (linhas != colunas)
			return false;

		for (int i = 0; i < linhas; i++) {
			Elo atual = vetorLinhas[i];

			// Percorre os elementos da lista da linha i
			while (atual != null) {
				int j = atual.coluna; // Coluna atual

				// Verifica se o elemento atual é igual ao seu transposto
				if (i != j && atual.valor != buscarElemento(j + 1, i + 1)) {
					return false; // A matriz não é simétrica
				}

				atual = atual.prox; // Avança para o próximo elemento na linha
			}
		}
		return true;
	}

	@Override
	public MatrizDinamica somarMatriz(MatrizDinamica outraMatriz) {
		if (this.linhas != outraMatriz.linhas || this.colunas != outraMatriz.colunas) {
			throw new IllegalArgumentException("As matrizes precisam ter as mesmas dimensões para poder somar.");
		}

		MatrizDinamica matrizSoma = new MatrizDinamica(this.linhas, this.colunas);

		// Percorre cada linha das matrizes
		for (int i = 0; i < this.linhas; i++) {
			Elo atual = this.vetorLinhas[i];
			Elo outra = outraMatriz.vetorLinhas[i];

			// Itera simultaneamente pelas listas encadeadas das duas matrizes
			while (atual != null || outra != null) {
				if (atual != null && (outra == null || atual.coluna < outra.coluna)) { // Elemento só na matriz atual
					matrizSoma.inserirElemento(i + 1, atual.coluna + 1, atual.valor);
					atual = atual.prox;
				} else if (atual == null || outra.coluna < atual.coluna) { // Elemento só na outra matriz
					matrizSoma.inserirElemento(i + 1, outra.coluna + 1, outra.valor);
					outra = outra.prox;
				} else {
					// Elemento nas duas matrizes (somar valores)
					matrizSoma.inserirElemento(i + 1, atual.coluna + 1, atual.valor + outra.valor);
					atual = atual.prox;
					outra = outra.prox;
				}
			}
		}

		return matrizSoma;
	}

	@Override
	public MatrizDinamica multiplicarMatriz(MatrizDinamica matriz2) {
		// Verifica se a multiplicação é válida (número de colunas da primeira matriz deve ser igual ao número de linhas da segunda)
		if (this.colunas != matriz2.linhas) {
			throw new IllegalArgumentException("Para poder multiplicar, o número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz.");
		}

		MatrizDinamica matrizResultado = new MatrizDinamica(this.linhas, matriz2.colunas);

		// varre linhas da matriz1 (this)
		for (int linhaM1 = 0; linhaM1 < this.linhas; linhaM1++) {
			Elo elementoM1 = this.vetorLinhas[linhaM1];

			// varre cada elemento na linha atual da matriz1
			while (elementoM1 != null) {
				int colunaM1 = elementoM1.coluna; // Coluna do elemento atual na matriz1
				int valorM1 = elementoM1.valor;  // Valor do elemento atual na matriz1

				// linha correspondente na matriz2 pra multiplicar
				Elo elementoLinhaM2 = matriz2.vetorLinhas[colunaM1];

				// varre os elementos dessa linha correspondente na matriz2
				while (elementoLinhaM2 != null) {
					int colunaMResultado = elementoLinhaM2.coluna;
					int valorM2 = elementoLinhaM2.valor;

					// Soma o produto ao elemento correspondente na matriz resultado
					int valorAtualResultado = matrizResultado.buscarElemento(linhaM1 + 1, colunaMResultado + 1);
					matrizResultado.inserirElemento(linhaM1 + 1, colunaMResultado + 1, valorAtualResultado + valorM1 * valorM2);

					elementoLinhaM2 = elementoLinhaM2.prox; // Avança para o próximo elemento na linha da matriz2
				}

				elementoM1 = elementoM1.prox; // Avança para o próximo elemento na linha da matriz1
			}
		}

		return matrizResultado;
	}

	@Override
	public MatrizDinamica obterMatrizTransposta() {
		MatrizDinamica matrizTransposta = new MatrizDinamica(this.colunas, this.linhas);

		if (this.ehVazia())
			return matrizTransposta; // nada a fazer

		for (int i = 0; i < this.linhas; i++) {
			Elo atual = this.vetorLinhas[i];

			// Percorre cada elemento da linha
			while (atual != null) {
				// Insere o elemento na posição transposta
				matrizTransposta.inserirElemento(atual.coluna + 1, i + 1, atual.valor);
				atual = atual.prox;
			}
		}

		return matrizTransposta;
	}
}
