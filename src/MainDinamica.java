import java.time.LocalDateTime;

public class MainDinamica {
	public static void main(String[] args) {


//		MatrizDinamica dinamica = new MatrizDinamica(3, 3);
//
//		dinamica.inserirElemento(1, 1, 1);
//		dinamica.inserirElemento(2, 2, 2);
//		dinamica.inserirElemento(3, 3, 3);
//		dinamica.inserirElemento(3, 1, 7);
//
//		dinamica.removerElemento(2, 2);
//
//		dinamica.imprimirMatriz();
//
//		System.out.println("elemento 3,1>> " + dinamica.buscarElemento(3, 1));
//		System.out.println("elemento 3,2>> " + dinamica.buscarElemento(3, 2));
//		System.out.println("elemento 3,3>> " + dinamica.buscarElemento(3, 3));
//
//		System.out.println("====================");
//		MatrizDinamica d1 = new MatrizDinamica(7, 10);
//		d1.preencherMatriz();
//		d1.imprimirMatriz();


//		MatrizDinamica d2 = new MatrizDinamica(3, 3);
//
//		d2.inserirElemento(1, 1, 1);
//	//	d2.inserirElemento(2, 2, 2);
//		d2.inserirElemento(3, 3, 3);
//
//		d2.imprimirMatriz();
//
//		System.out.println("Diagonal?  " + d2.ehDiagonal());
//		d2.inserirElemento(3, 1, 7);
//		d2.imprimirMatriz();
//		System.out.println("Diagonal?  " + d2.ehDiagonal());
//		System.out.println("====================");

//		MatrizDinamica d3 = new MatrizDinamica(6, 6);
//
//		d3.inserirElemento(1, 1, 1);
//		d3.inserirElemento(2, 2, 2);
//		d3.inserirElemento(3, 3, 3);
//
//		d3.imprimirMatriz();
//
//		System.out.println("Triangular Inferior?  " + d3.ehTriangularInfeior());
//		d3.inserirElemento(3, 1, 7);
//		d3.imprimirMatriz();
//		System.out.println("Triangular Inferior?  " + d3.ehTriangularInfeior());
//
//		d3.inserirElemento(3, 6, 7);
//		d3.imprimirMatriz();
//		System.out.println("Triangular Inferior?  " + d3.ehTriangularInfeior());
//		System.out.println("====================");

//		MatrizDinamica d4 = new MatrizDinamica(5, 5);
//
//		d4.inserirElemento(1, 1, 1);
//		d4.inserirElemento(2, 2, 2);
//		d4.inserirElemento(3, 3, 3);
//		d4.inserirElemento(5, 5, 5);
//
//		d4.imprimirMatriz();
//
//		System.out.println("Triangular Superior?  " + d4.ehTriangularSuperior());
//		d4.inserirElemento(1, 5, 7);
//		d4.imprimirMatriz();
//		System.out.println("Triangular Superior?  " + d4.ehTriangularSuperior());
//
//		d4.inserirElemento(5, 2, 7);
//		d4.imprimirMatriz();
//		System.out.println("Triangular Superior?  " + d4.ehTriangularSuperior());
//		System.out.println("====================");


//		MatrizEstatica d5 = new MatrizEstatica(4, 4);
//		d5.inserirElemento(1,2,6);
//		d5.inserirElemento(2,3,5);
//		d5.inserirElemento(2,1,6);
//		d5.inserirElemento(3,2,5);
//		d5.inserirElemento(4,4,4);
//
//		d5.imprimirMatriz();
//		System.out.println("Eh Simétrica: " + d5.ehSimetrica());
//		System.out.println("============");
//
//		d5.inserirElemento(4,2,7);
//
//		d5.imprimirMatriz();
//		System.out.println("Eh Simétrica: " + d5.ehSimetrica());
//		System.out.println("============");


//
//		LocalDateTime inicio = LocalDateTime.now();
//		System.out.println("Começando a somar as " + Relogio.Timestamp());
//
//		MatrizDinamica ds1 = new MatrizDinamica(5000, 5000);
//		ds1.preencherMatriz();
//		MatrizDinamica ds2 = new MatrizDinamica(5000, 5000);
//		ds2.preencherMatriz();
//
//		var bla = ds1.somarMatriz(ds2);
//
//		System.out.println();
//		System.out.println("terminou depois de " + Relogio.Passou(inicio));

//		MatrizDinamica ds4 = new MatrizDinamica(4, 5);
//		ds4.preencherMatriz();
//		ds4.imprimirMatriz();
//		System.out.println("============");
//		MatrizDinamica ds5 = new MatrizDinamica(4, 5);
//		ds5.preencherMatriz();
//		ds5.imprimirMatriz();
//		System.out.println("============");
//		var ds6 = ds4.somarMatriz(ds5);
//		ds6.imprimirMatriz();

//		MatrizDinamica d7 = new MatrizDinamica(4, 5);
//		d7.preencherMatriz();
//		d7.imprimirMatriz();
//		System.out.println("============");
//		var d8=d7.obterMatrizTransposta();
//		d8.imprimirMatriz();


		MatrizDinamica d10 = new MatrizDinamica(3, 4);
		d10.preencherMatriz();

		MatrizDinamica d11 = new MatrizDinamica(4, 3);
		d11.preencherMatriz();

		var d12 = d10.multiplicarMatriz(d11);

		d10.imprimirMatriz();
		System.out.println("============");
		d11.imprimirMatriz();
		System.out.println("============");
		d12.imprimirMatriz();
		System.out.println("============");

		
//		dinamica.gerarMatrizVazia();
//
//		dinamica.inserirElemento(1, 1, 1);
//		dinamica.inserirElemento(1, 2, 0);
//		dinamica.inserirElemento(1, 3, 0);
//		dinamica.inserirElemento(2, 1, 2);
//		dinamica.inserirElemento(2, 2, 0);
//		dinamica.inserirElemento(2, 3, 0);
//		dinamica.inserirElemento(3, 1, 1);
//		dinamica.inserirElemento(3, 2, 0);
//		dinamica.inserirElemento(3, 3, 0);
//		dinamica.imprimirMatriz();
//		System.out.println("================");
//		//System.out.println(dinamica.isMatrizLinha());
//		System.out.println(dinamica.isMatrizColuna());
//		dinamica.imprimirMatriz();
        
        /*MatrizDinamica d2 = new MatrizDinamica(3,3);
        d2.gerarMatrizVazia();
        d2.imprimirMatriz();*/

        /*System.out.println("====================");
        MatrizDinamica d3 = new MatrizDinamica(3,3);
        d3.preencherMatriz();
        d3.imprimirMatriz();*/

	}

}
