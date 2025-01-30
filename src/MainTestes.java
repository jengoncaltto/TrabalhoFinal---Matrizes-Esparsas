import java.time.LocalDateTime;

public class MainTestes {
	public static void main(String[] args) {

//		System.out.println("=========== COMEÇA SOMA ESTÁTICA ===========");
//		SomaEstatica();
//		System.out.println("=========== FIM da SOMA ESTÁTICA ===========");
//		System.out.println();
		System.out.println("=========== COMEÇA SOMA DINÂMICA ===========");
		SomaDinamica();
		System.out.println("=========== FIM da SOMA DINÂMICA ===========");

//		System.out.println("=========== COMEÇA TRANSPOSTA ESTÁTICA ===========");
//		TransporEstatica();
//		System.out.println("=========== FIM da TRANSPOSTA ESTÁTICA ===========");
//		System.out.println();
//		System.out.println("=========== COMEÇA TRANSPOSTA DINÂMICA ===========");
//		TransporDinamica();
//		System.out.println("=========== FIM da TRANSPOSTA DINÂMICA ===========");

//		System.out.println("=========== COMEÇA PRODUTO ESTÁTICA ===========");
//		ProdutoEstatica();
//		System.out.println("=========== FIM da PRODUTO ESTÁTICA ===========");
//		System.out.println();
//		System.out.println("=========== COMEÇA PRODUTO DINÂMICA ===========");
//		ProdutoDinamica();
//		System.out.println("=========== FIM da PRODUTO DINÂMICA ===========");


	}

	private static void TransporEstatica() {
		TesteTransporEstatica(10);
		System.out.println("======================");
		TesteTransporEstatica(20);
		System.out.println("======================");
		TesteTransporEstatica(30);
		System.out.println("======================");
		TesteTransporEstatica(40);
		System.out.println("======================");
		TesteTransporEstatica(50);
		System.out.println("======================");
		TesteTransporEstatica(100);
		System.out.println("======================");
		TesteTransporEstatica(200);
		System.out.println("======================");
		TesteTransporEstatica(500);
		System.out.println("======================");
		TesteTransporEstatica(1000);
		System.out.println("======================");
		TesteTransporEstatica(10000);
		System.out.println("======================");
		TesteTransporEstatica(20000);
		System.out.println("======================");
		TesteTransporEstatica(50000);
		System.out.println("======================");
		//	TesteTransporEstatica(100000);
	}

	private static void TransporDinamica() {
		TesteTransporDinamica(10);
		System.out.println("======================");
		TesteTransporDinamica(20);
		System.out.println("======================");
		TesteTransporDinamica(30);
		System.out.println("======================");
		TesteTransporDinamica(40);
		System.out.println("======================");
		TesteTransporDinamica(50);
		System.out.println("======================");
		TesteTransporDinamica(100);
		System.out.println("======================");
		TesteTransporDinamica(200);
		System.out.println("======================");
		TesteTransporDinamica(500);
		System.out.println("======================");
		TesteTransporDinamica(1000);
		System.out.println("======================");
		TesteTransporDinamica(10000);
		System.out.println("======================");
		TesteTransporDinamica(20000);
		System.out.println("======================");
		TesteTransporDinamica(50000);
		System.out.println("======================");
		//TesteTransporDinamica(100000);
	}

	private static void SomaEstatica() {
		TesteSomaEstatica(10);
		System.out.println("======================");
		TesteSomaEstatica(20);
		System.out.println("======================");
		TesteSomaEstatica(30);
		System.out.println("======================");
		TesteSomaEstatica(40);
		System.out.println("======================");
		TesteSomaEstatica(50);
		System.out.println("======================");
		TesteSomaEstatica(100);
		System.out.println("======================");
		TesteSomaEstatica(200);
		System.out.println("======================");
		TesteSomaEstatica(500);
		System.out.println("======================");
		TesteSomaEstatica(1000);
		System.out.println("======================");
		TesteSomaEstatica(10000);
		System.out.println("======================");
		TesteSomaEstatica(20000);
		System.out.println("======================");
		TesteSomaEstatica(50000);
		System.out.println("======================");
		//	TesteSomaEstatica(100000);
	}

	private static void SomaDinamica() {
//		TesteSomaDinamica(10);
//		System.out.println("======================");
//		TesteSomaDinamica(20);
//		System.out.println("======================");
//		TesteSomaDinamica(30);
//		System.out.println("======================");
//		TesteSomaDinamica(40);
//		System.out.println("======================");
//		TesteSomaDinamica(50);
//		System.out.println("======================");
//		TesteSomaDinamica(100);
//		System.out.println("======================");
//		TesteSomaDinamica(200);
//		System.out.println("======================");
//		TesteSomaDinamica(500);
//		System.out.println("======================");
//		TesteSomaDinamica(1000);
//		System.out.println("======================");
//		TesteSomaDinamica(10000);
//		System.out.println("======================");
//		TesteSomaDinamica(20000);
//		System.out.println("======================");
		TesteSomaDinamica(50000);
		System.out.println("======================");
		TesteSomaDinamica(100000);
	}

	private static void ProdutoEstatica() {
		TesteProdutoEstatica(10);
		System.out.println("======================");
		TesteProdutoEstatica(20);
		System.out.println("======================");
		TesteProdutoEstatica(30);
		System.out.println("======================");
		TesteProdutoEstatica(40);
		System.out.println("======================");
		TesteProdutoEstatica(50);
		System.out.println("======================");
		TesteProdutoEstatica(100);
		System.out.println("======================");
		TesteProdutoEstatica(200);
		System.out.println("======================");
		TesteProdutoEstatica(500);
		System.out.println("======================");
		TesteProdutoEstatica(1000);
		System.out.println("======================");
		TesteProdutoEstatica(10000);
		System.out.println("======================");
		TesteProdutoEstatica(20000);
		System.out.println("======================");
		TesteProdutoEstatica(50000);
//		System.out.println("======================");
// 	    TesteProdutoEstatica(100000);
	}

	private static void ProdutoDinamica() {
//		TesteProdutoDinamica(10);
//		System.out.println("======================");
//		TesteProdutoDinamica(20);
//		System.out.println("======================");
//		TesteProdutoDinamica(30);
//		System.out.println("======================");
//		TesteProdutoDinamica(40);
//		System.out.println("======================");
//		TesteProdutoDinamica(50);
//		System.out.println("======================");
//		TesteProdutoDinamica(100);
//		System.out.println("======================");
//		TesteProdutoDinamica(200);
//		System.out.println("======================");
//		TesteProdutoDinamica(500);
		System.out.println("======================");
		TesteProdutoDinamica(1000);
		System.out.println("======================");
		TesteProdutoDinamica(10000);
		System.out.println("======================");
		TesteProdutoDinamica(20000);
		System.out.println("======================");
		TesteProdutoDinamica(50000);
		System.out.println("======================");
		TesteProdutoDinamica(100000);
	}


	private static void TesteSomaEstatica(int tamanho) {
		MatrizEstatica m1 = new MatrizEstatica(tamanho, tamanho);
		m1.preencherMatriz();

		MatrizEstatica m2 = new MatrizEstatica(tamanho, tamanho);
		m2.preencherMatriz();

		LocalDateTime inicio = LocalDateTime.now();

		int loops;
		if (tamanho < 10000) {
			loops = 10000;
		} else if (tamanho <= 20000) {
			loops = 50;
		} else {
			loops = 10;
		}
		System.out.println("INICIANDO - Soma de matrizes Estáticas " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());

		for (int i = 0; i < loops; i++) {
			MatrizEstatica m3 = m1.somarMatriz(m2);
			m3.ehVazia();
		}

		System.out.println("CONCLUIDO - Soma de matrizes Estáticas " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());
		System.out.println("Tempo total: " + Relogio.tempoGasto(inicio) + ", tempo médio por operação: " + Relogio.TempoMedio(inicio, loops));
	}

	private static void TesteSomaDinamica(int tamanho) {
		MatrizDinamica m1 = new MatrizDinamica(tamanho, tamanho);
		m1.preencherMatriz();

		MatrizDinamica m2 = new MatrizDinamica(tamanho, tamanho);
		m2.preencherMatriz();

		LocalDateTime inicio = LocalDateTime.now();

		int loops;
		if (tamanho < 500) {
			loops = 10000;
		} else if (tamanho < 10000) {
			loops = 1000;
//		} else if (tamanho <= 20000) {
//			loops = 50;
		} else {
			loops = 1;
		}
		System.out.println("INICIANDO - Soma de matrizes Dinamicas " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());

		for (int i = 0; i < loops; i++) {
			MatrizDinamica m3 = m1.somarMatriz(m2);
			m3.ehVazia();
		}
		System.out.println();

		System.out.println("CONCLUIDO - Soma de matrizes Dinamicas " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());
		System.out.println("Tempo total: " + Relogio.tempoGasto(inicio) + ", tempo médio por operação: " + Relogio.TempoMedio(inicio, loops));
	}

	private static void TesteTransporEstatica(int tamanho) {
		MatrizEstatica m1 = new MatrizEstatica(tamanho, tamanho);
		m1.preencherMatriz();

		LocalDateTime inicio = LocalDateTime.now();

		int loops;
		if (tamanho < 500) {
			loops = 10000;
		} else if (tamanho < 10000) {
			loops = 1000;
		} else if (tamanho <= 20000) {
			loops = 50;
		} else {
			loops = 10;
		}
		System.out.println("INICIANDO - Transposicao de matriz Estatica " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());

		for (int i = 0; i < loops; i++) {
			MatrizEstatica m2 = m1.obterMatrizTransposta();
			m2.ehVazia();
		}
		System.out.println();

		System.out.println("CONCLUIDO - Transposicao de matriz Estatica " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());
		System.out.println("Tempo total: " + Relogio.tempoGasto(inicio) + ", tempo médio por operação: " + Relogio.TempoMedio(inicio, loops));
	}

	private static void TesteTransporDinamica(int tamanho) {
		MatrizDinamica m1 = new MatrizDinamica(tamanho, tamanho);
		m1.preencherMatriz();

		LocalDateTime inicio = LocalDateTime.now();

		int loops;
		if (tamanho < 500) {
			loops = 10000;
		} else if (tamanho < 1000) {
			loops = 1000;
		} else if (tamanho < 10000) {
			loops = 100;
//		} else if (tamanho <= 20000) {
//			loops = 50;
		} else {
			loops = 1;
		}
		System.out.println("INICIANDO - Transposicao de matriz Dinamica " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());

		for (int i = 0; i < loops; i++) {
			MatrizDinamica m2 = m1.obterMatrizTransposta();
			m2.ehVazia();
		}
		System.out.println();

		System.out.println("CONCLUIDO - Transposicao de matriz Dinamica " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());
		System.out.println("Tempo total: " + Relogio.tempoGasto(inicio) + ", tempo médio por operação: " + Relogio.TempoMedio(inicio, loops));
	}

	private static void TesteProdutoEstatica(int tamanho) {
		MatrizEstatica m1 = new MatrizEstatica(tamanho, tamanho);
		m1.preencherMatriz();

		MatrizEstatica m2 = new MatrizEstatica(tamanho, tamanho);
		m2.preencherMatriz();

		LocalDateTime inicio = LocalDateTime.now();

		int loops;
		if (tamanho < 1000) {
			loops = 10000;
		} else if (tamanho < 10000) {
			loops = 1000;
//		} else if (tamanho < 20000) {
//			loops = 10;
		} else {
			loops = 1;
		}
		System.out.println("INICIANDO - Produto de matrizes Estáticas " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());

		for (int i = 0; i < loops; i++) {
			MatrizEstatica m3 = m1.multiplicarMatriz(m2);
			m3.ehVazia();
		}

		System.out.println("CONCLUIDO - Produto de matrizes Estáticas " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());
		System.out.println("Tempo total: " + Relogio.tempoGasto(inicio) + ", tempo médio por operação: " + Relogio.TempoMedio(inicio, loops));
	}

	private static void TesteProdutoDinamica(int tamanho) {
		MatrizDinamica m1 = new MatrizDinamica(tamanho, tamanho);
		m1.preencherMatriz();

		MatrizDinamica m2 = new MatrizDinamica(tamanho, tamanho);
		m2.preencherMatriz();

		LocalDateTime inicio = LocalDateTime.now();

		int loops;
		if (tamanho < 500) {
			loops = 1000;
		} else if (tamanho < 1000) {
			loops = 100;
		} else if (tamanho < 10000) {
			loops = 10;
//		} else if (tamanho <= 20000) {
//			loops = 50;
		} else {
			loops = 1;
		}
		System.out.println("INICIANDO - Produto de matrizes Dinamicas " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());

		for (int i = 0; i < loops; i++) {
			MatrizDinamica m3 = m1.multiplicarMatriz(m2);
			m3.ehVazia();
		}
		System.out.println();

		System.out.println("CONCLUIDO - Produto de matrizes Dinamicas " + tamanho + "x" + tamanho + " - " + loops + " vezes - " + Relogio.Timestamp());
		System.out.println("Tempo total: " + Relogio.tempoGasto(inicio) + ", tempo médio por operação: " + Relogio.TempoMedio(inicio, loops));
	}
}
