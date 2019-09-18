/************************************************************
 * Nome do projeto: 			Forca						*
 * Tipo aquivo:					Forca, class                *
 * Autor: 						Gabriel Ribeiro Bernardi	*
 * Matricula: 					11821BCC036					*
 * Data de inicio: 				05/09/2019					*
 * Data da ultima modificacao: 	18/09/2019					*
 * Dias de desenvolvimento:     08                          *
 * Linguagem utilizada:			Java						*
 ***********************************************************/

package poo03;
import java.util.Scanner;
import java.io.IOException;

public class poo3 {
	public static void main(String[] args) throws IOException {					// Capturando excecao para 'pausar' o sistema quando abrir opcao 2 ou 3 do menu. Similar ao sleep do Python
		Forca f = new Forca();
		Scanner teclado = new Scanner(System.in);
		int choose=0;
		try {
			choose = teclado.nextInt();			
		} catch (Exception e) {
			System.out.println("Neste momento o programa so pode receber valores inteiros");
			System.out.println("\nO jogo sera iniciado");
			System.out.println("\nPressione Enter para continuar.........");
			System.in.read();
		}
		switch (choose) {
		case 2:
			f.regrasJogo();
			System.out.println("\nPressione Enter para continuar.........");
			System.in.read();													// Utilizado para dar a 'sensacao' de que o sistema pausou para esperar o usuario ler o conteudo da tela
			break;
		case 3:
			f.sobreJogo();
			System.out.println("\nPressione Enter para continuar.........");
			System.in.read();													// Utilizado para dar a 'sensacao' de que o sistema pausou para esperar o usuario ler o conteudo da tela
			break;
		default:
			
			break;
		}
//		f.dados();
//		f.imprimeDadosPalEscolhida();
		f.desenharForca(0);														// Funcao usada para desenhar a forca inicial no console. Caso 1
		f.imprimirEspacos();													// Funcao usada para imprimir os espacos na tela, para que 'limpe' o console do usuario
		System.out.println("Quantidade de vidas restantes: " + Math.abs(f.getQtdLetErradas() - 7));
		while(true) {															// Como o metodo esta em uma classe separada, utiliza-se o loop para chamar esse metodo
			f.verificaLetra();
			f.cont++;
		}
		
	}

}
