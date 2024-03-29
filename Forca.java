/**************************************************************
 * Nome do projeto: 			  Forca						  *
 * Tipo aquivo:					  Forca, class                *
 * Autor: 						  Gabriel Ribeiro Bernardi	  *
 * Matricula: 					  11821BCC036		    	  *
 * Data de inicio: 				  05/09/2019				  *
 * Data final de desenvolvimento: 18/09/2019			      *
 * Data da ultima modificacao: 	  02/10/2019				  *
 * Dias de desenvolvimento:       08                          *
 * Linguagem utilizada:			  Java						  *
 * Plataforma Java utilizada:     Java SE 11 Development Kit  *
 *************************************************************/

package poo03;
import java.util.Random;
import java.util.Scanner;

public class Forca implements Interface {
	private String[] palChave = new String[] {"AMOR", "BATMAN", "COLOMBIA", "DANILO", "ELETRICISTA", "FEIJAO", "GOIABA",
			"HIPOTESE", "IGREJA", "JAPAO", "KIWI", "LAPISEIRA", "MACACO", "NAVIO", "OVO", "PAPA", "QUEIJO", "RATOEIRA",
			"SAPATO", "TEMOR", "UVA", "VIOLAO", "WESLEY", "XADREZ", "YAHOO", "ZEBRA"};	//Definindo as palavras do jogo
	private String[] dicaPalChave = new String[] {"SENTIMENTO", "SUPER HEROI", "PAÍS", "NOME", "PROFISSAO", 
			"COMIDA", "FRUTA", "TEORIA", "LUGAR", "PAIS", "FRUTA", "OBJETO", "ANIMAL", "VEICULO", "COMIDA", 
			"PESSOA", "COMIDA", "OBJETO", "OBJETO", "SENTIMENTO", "FRUTA", "OBJETO", "NOME", "JOGO", "MARCA",
			"ANIMAL"}; 															// Definindo as dicas do jogo
	private int tam = palChave.length;											// Recebendo a quantidade de palavras contidas no array
	private Random gerador = new Random(); 										// Criando objeto da classe Random
	int pal = gerador.nextInt(26);												// Gerando um numero aleatorio entre 0 e 25
//	int pal = 1;																// Chave de teste para palavras especificas
	private String palEscolhida = palChave[pal];								// A partir do numero gerado, a palavra sera escolhida pelo indice gerado
	private String dicaEscolhida = dicaPalChave[pal];							// Selecionando a dica conforme palavra escolhida
	private int tamPalEscolhida = palEscolhida.length();						// Tamanho da palavra escolhida
	private int qtdLetAcertadas, qtdLetErradas;
	private String[] vetLetAcertadas = new String[this.getTamPalEscolhida()];	// Definindo vetor que recebera as letras acertadas
	private int tamVetLetTentada = Math.abs(this.getTamPalEscolhida() - 26); 
	private String[] vetLetTentada = new String[tamVetLetTentada];				// Definindo vetor que recebera as letras tentadas, tanto as corretas quanto as incorretas
	private String[] vetLetTentada1 = new String[tamVetLetTentada];				// Definindo vetor que recebera as letras tentadas, tanto as corretas quanto as incorretas
	public int cont = 0;
	public int qtdLetTentadas = 0;												// Quantidade de letras ja informadas pelo usuario
	
	/***************
	 * CONSTRUCTOR *
	 ***************/
	public Forca() {
		this.setQtdLetAcertadas(0);
		this.setQtdLetErradas(0);
		System.out.println("###### JOGO DA FORCA ######");
		System.out.println("\n========= MENU ============");
		System.out.println(" [1] Comecar jogo");
		System.out.println(" [2] Mostrar regras do jogo");
		System.out.println(" [3] Sobre");
		System.out.println("===========================");
		System.out.print("Escolha: ");
	}
	/*********************
	 * GETTERS E SETTERS *
	 *********************/
	public String getPalChave(int index) {
		return palChave[index];
	}
	public int getTam() {
		return tam;
	}
	public String getPalEscolhida() {
		return palEscolhida;
	}
	private int getTamPalEscolhida() {
		return tamPalEscolhida;
	}
	private int getQtdLetAcertadas() {
		return qtdLetAcertadas;
	}
	private void setQtdLetAcertadas(int qtdLetAcertadas) {
		this.qtdLetAcertadas = qtdLetAcertadas;
	}
	public int getQtdLetErradas() {
		return qtdLetErradas;
	}
	private void setQtdLetErradas(int qtdLetErradas) {
		this.qtdLetErradas = qtdLetErradas;
	}
	public String getDicaEscolhida() {
		return dicaEscolhida;
	}
	
	/***********************
	 * METODOS DO PROGRAMA *
	 ***********************/
	public void dados() {														// Imprime as palavras contidas no array
		System.out.println(tam);
		for(int i = 0; i < 26; i++) {
			System.out.println(palChave[i]);
		}
	}
	public void imprimeDadosPalEscolhida() { 									// Imprime a palavra escolhida. Metodo utilizado para fazer testes
		System.out.println(palEscolhida);
		System.out.println("Tamanho: " + this.getTamPalEscolhida());
	}
	public int verificaLetra() {
		Scanner teclado = new Scanner(System.in);								// Criando o objeto teclado que recebera os dados informados pelo usuario atraves do teclado
		int index, j = 0;
		String letra, letra1;
		System.out.print("Letra escolhida: ");
		letra = teclado.next();
		letra = letra.toUpperCase();
		letra1 = letra;
		if(letra.contentEquals("FECHAR") || letra.contentEquals("QUIT") || letra.contentEquals("EXIT")) {										// Verificar se o usuario deseja fechar o jogo
			System.out.println("Encerramento solicitado pelo usuario");
			System.out.println("Fechando o programa");
			System.exit(0);
		}
		if(palEscolhida.indexOf(letra) != -1) {
			index = palEscolhida.indexOf(letra);
			vetLetAcertadas[index] = letra.valueOf(letra);
			vetLetTentada[qtdLetTentadas] = letra.valueOf(letra);
			while(palEscolhida.indexOf(letra) != -1 && j < tamPalEscolhida) {	// Faz a verficacao se possui mais de uma mesma letra na palavra escolhida
				int index1;
				if(palEscolhida.indexOf(letra, index+1) != -1) {				// Se a letra existe apenas uma vez, nao entrara na atribuicao presente dentro do loop
					index1 = palEscolhida.indexOf(letra, index+1);
					vetLetAcertadas[index1] = letra.valueOf(letra);
					j++;
				}else {
					break;
				}
			}
			try {																	// Excecao para tamanho maximo do array com letras tentadas
				vetLetTentada1[cont] = letra.valueOf(letra1);
				qtdLetTentadas++;
				for(int c = 0; c < qtdLetTentadas-1; c++) {
					if(vetLetTentada1[c].equals(letra)) {
						System.out.println("Letra ja tentada. Digite outra letra!");
						return 900;
					}
				}
			} catch (Exception e) {
				System.out.println("\n\nQuantidade de tentativas excedidas");
				System.exit(0);
			}
			imprimirEspacos();
			System.out.println();
			limparTela();
			System.out.println("Contem a letra: " + letra);
			this.setQtdLetAcertadas(this.getQtdLetAcertadas() + 1);
			if(verificaGanhar() == -1) {
				imprimirEspacos();
				return 1000;													// Se retorno igual a 1000, significa que o usuario acertou a letra
			}else if(verificaGanhar() == 1) {
				desenharForca(this.getQtdLetErradas());
				imprimirEspacos();
				System.out.println("Voce Ganhou");
				System.out.println("Palavra esolhida: " + this.getPalEscolhida());
				System.exit(0);
				return 1001;													// Se retorno igual a 1001, significa que o usuario acertou a palavra
			} 
			return 50;
		}else {
			try {																// Excecao para tamanho maximo do array com letras tentadas
				vetLetTentada1[cont] = letra.valueOf(letra1);
				qtdLetTentadas++;
				for(int c = 0; c < qtdLetTentadas-1; c++) {
					if(vetLetTentada1[c].equals(letra)) {
						System.out.println("Letra ja tentada. Digite outra letra!");
						return 900;
//						System.exit(0);
					}
				}
			} catch (Exception e) {
				System.out.println("\n\nQuantidade de tentativas excedidas");
				System.exit(0);
			}
			limparTela();
			System.out.println("Nao contem a letra: " + letra);
			this.setQtdLetErradas(this.getQtdLetErradas() + 1);
			vetLetTentada[cont] = letra.valueOf(letra1);
//			System.out.println("Quantidade de vidas restantes: " + Math.abs(this.getQtdLetErradas() - 7));
			verificaPerder();
			imprimirEspacos();
			return 999;															// Se retorno igual a 999, significa que o usuario errou a letra
		}
	}
	int qtdNullVetLetAcertadas;
	// O metodo verificaGanhar() sera chamado somente se o usuario acertar alguma letra da palavra
	public int verificaGanhar() {												// Metodo para verificar se o usuario ganhou o jogo ou acertou alguma letra
//		System.out.println(tamPalEscolhida);
		qtdNullVetLetAcertadas=0;
		for(int j = 0; j < tamPalEscolhida; j++) {								// Repeticao para fazer a contagem de quantos espacos nao foram 'revelados' na palavra escolhida
			if(vetLetAcertadas[j] != null) {
				qtdNullVetLetAcertadas++;
			}else {
				qtdNullVetLetAcertadas--;
			}
		}
		if(qtdNullVetLetAcertadas == tamPalEscolhida) {							// Verificacao para saber se o jogo sera encerrado, caso a palavra nao tenha mais espacos em branco
			return 1;
		}else {																	// Se o usuario nao ganhou o jogo, nesse caso ele acertou pelo menos uma letra
			desenharForca(this.getQtdLetErradas());
			System.out.println("Quantidade de vidas restantes: " + Math.abs(this.getQtdLetErradas() - 7));
			return -1;
		}
	}
	// O metodo verificaPerder() sera chamada somente quando o usuario errar alguma letra da palavra
	public void verificaPerder() {												// Metodo para verificar se o usuario perdeu o jogo
		if(this.getQtdLetErradas() == 7) {
			desenharForca(this.getQtdLetErradas());
			imprimirEspacos();
			System.out.println("Voce perdeu");
			System.out.println("Palavra esolhida: " + this.getPalEscolhida());
			System.exit(0);
		}else {
			desenharForca(this.getQtdLetErradas());
			System.out.println("Quantidade de vidas restantes: " + Math.abs(this.getQtdLetErradas() - 7));
		}
	}
	public void desenharForca(int val) {										// Metodo para imprimir, no console do usuario, a forca
		switch (val) {
		case 7:
			System.out.println("_________________");
			System.out.println("|               |");
			System.out.println("|             (x x)");
			System.out.println("|              /|\\");
			System.out.print("|              /");
			System.out.println(" \\");
			System.out.println("|");
			System.out.println("-----------------");
			break;
		case 6:
			System.out.println("_________________");
			System.out.println("|               |");
			System.out.println("|             (o o)");
			System.out.println("|              /|\\");
			System.out.print("|              /");
			System.out.println(" \\");
			System.out.println("|");
			System.out.println("-----------------");
			break;
		case 5:
			System.out.println("_________________");
			System.out.println("|               |");
			System.out.println("|             (o o)");
			System.out.println("|              /|\\");
			System.out.print("|              /");
			System.out.println(" ");
			System.out.println("|");
			System.out.println("-----------------");
			break;
		case 4:
			System.out.println("_________________");
			System.out.println("|               |");
			System.out.println("|             (o o)");
			System.out.println("|              /|\\");
			System.out.print("|              ");
			System.out.println(" ");
			System.out.println("|");
			System.out.println("-----------------");
			break;
		case 3:
			System.out.println("_________________");
			System.out.println("|               |");
			System.out.println("|             (o o)");
			System.out.println("|              /|");
			System.out.print("|               ");
			System.out.println(" ");
			System.out.println("|");
			System.out.println("-----------------");			
			break;
		case 2:
			System.out.println("_________________");
			System.out.println("|               |");
			System.out.println("|             (o o)");
			System.out.println("|               |");
			System.out.print("|              ");
			System.out.println(" ");
			System.out.println("|");
			System.out.println("-----------------");			
			break;
		case 1:
			System.out.println("_________________");
			System.out.println("|               |");
			System.out.println("|             (o o)");
			System.out.println("|               ");
			System.out.print("|              ");
			System.out.println(" ");
			System.out.println("|");
			System.out.println("-----------------");
			break;
		case 0:
			System.out.println("_________________");
			System.out.println("|               |");
			System.out.println("|             ");
			System.out.println("|               ");
			System.out.print("|              ");
			System.out.println(" ");
			System.out.println("|");
			System.out.println("-----------------");
		default:
			break;
		}
	}
	public void imprimirEspacos() {												// Metodo utilizado para imprimir na tela os vetores contendo tanto as letras acertadas quanto as ja tentadas
		System.out.println("Dica: " + this.getDicaEscolhida());
		System.out.println("Palavra:");
		for(int j = 0; j < tamPalEscolhida; j++) {
			if(vetLetAcertadas[j] == null) {
				System.out.print(" _ ");
			}else {
				System.out.print(" " + vetLetAcertadas[j] + " ");
			}
		}
		System.out.println("\nLetras ja tentadas:");
		for(int j = 0; j < tamVetLetTentada; j++) {
			if(vetLetTentada[j] != null) {
				System.out.print(" " + vetLetTentada1[j]);
			}
		}
		System.out.println();
	}
	public void regrasJogo() {													// Metodo usado para imprimir as regras do jogo
		System.out.println("Para jogar informe uma letra ao jogo");
		System.out.println("O jogador possui 7 vidas inicialmente");
		System.out.println("Conforme o usuário for acertando as letras, elas aparecerao na tela\nCaso contrario, permanecera um \"_\" ");
		System.out.println("Conforme o jogador errar uma letra, perde uma vida");
		System.out.println("\nPara encerrar o jogo, digite\n 'fechar', 'quit' ou 'exit'\nquando pedir uma letra");
	}
	public void limparTela() {
		for(int j = 0; j < 50; j++) {
			System.out.println();
		}
	}
	public void sobreJogo() {													// Metodo usado para imprimir as informacoes do jogo
		System.out.println("Desenvolvido por Gabriel Bernardi");
		System.out.println("Entre os dias 05/09/2019 e 14/09/2019");
		System.out.println("Versao 1.9");
	}
}
