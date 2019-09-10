/************************************************************
 * Nome do projeto: 			Forca						*
 * Tipo arquivo:				Interface, interface
 * Autor: 						Gabriel Ribeiro Bernardi	*
 * Matricula: 					11821BCC036					*
 * Data de inicio: 				05/09/2019					*
 * Data da ultima modificacao: 	09/09/2019					*
 * Linguagem utilizada:			Java						*
 ***********************************************************/
package poo03;
public interface Interface {
	public abstract void dados();
	public abstract void imprimeDadosPalEscolhida();
	public abstract int verificaLetra();
	public abstract int verificaGanhar();
	public abstract void verificaPerder();
	public void desenharForca(int val);
	public abstract void imprimirEspacos();
	public abstract void regrasJogo();
	public void limparTela();
	public void sobreJogo();
}
