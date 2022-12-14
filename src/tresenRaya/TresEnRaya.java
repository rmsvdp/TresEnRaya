package tresenRaya;

import java.util.Scanner;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;


/**
 *  UD3.-Programación orientada a objetos: Tres en raya
 * @author lone
 * @version 2.0
 * 
 * Curso 2022 - 2023
 * Programación (1WET)
 *
 */
public class TresEnRaya {

	// Atributos
/**
 * Tablero de la partida 	
 */
	private char[][] tablero;
/**
 *  Identifica el turno actual jugador1 - jugador2
 */
	private int jugada;
/**
 * Caracter para representar la ficha de cada jugador
 */
	private final char[] ficha = {'X','O'};

	/**
	 * Objeto terminal ansi
	 * @see <a href="https://javadoc.io/doc/org.fusesource.jansi/jansi/latest/index.html">Jansi 2.4.0</a> 
	 */
	Ansi scr;
	
	// Metodos

	/**
	 * Contructor
	 * Crea un tablero vacío
	 * 
	 * texto en negrita!
	 */
		public  TresEnRaya(Ansi _scr0) {
		tablero = new char[3][3];
		jugada = 0;
		scr = _scr0;
		System.out.println(scr.fgBrightMagenta());
		System.out.println("Creando un tablero para la partida ...");
		System.out.println(scr.fg(Ansi.Color.WHITE));
	}
	
	/**
	 * setjugada: setter para la propiedad jugada
	 * @param valor : Identifica quien realiza la jugada
	 * @author lone
	 */
	public	void setjugada(int valor) {
		jugada = valor;
		
	}
	/**
	 * setter para la propiedad jugada
	 *  @return jugada: Devuelve el valor de la propiedad jugada
	  * @author lone
	 */
	public	int getjugada() {
		return jugada;
		
	}
        
        char[][] getTablero(){
            return this.tablero;
        }
	/**
	 * limpiarTablero: Inicializa el tablero, eliminando
	 * cualquier ficha existente
	 * @author lone
	 */
	public void limpiarTablero() {
		
		
		for (int i=0; i< tablero.length; i++){
			for (int j=0; j< tablero.length; j++) {
				tablero[i][j]=  '-';
			}
		}
		
	}
	/**
	 * muestraTablero: Pinta el tablero con el estado 
	 * actual de la partida
	 * @author lone
	 */
	public	void mostrarTablero() {
		char celda;
		Color colorcelda = Ansi.Color.WHITE;
		
		System.out.println();
		System.out.print("     ");
		System.out.println("  A B C");
		for (int i=0; i< tablero.length; i++){
			System.out.print("     ");
			System.out.print(i+1+ " ");
			for (int j=0; j< tablero.length; j++) {	
				
				celda = tablero[i][j];
				switch (celda){
					case 'X':
						colorcelda = Ansi.Color.RED;
						break;
					case 'O':
						colorcelda = Ansi.Color.WHITE;
						break;
					case '-':
						colorcelda = Ansi.Color.BLUE;
					}
				System.out.print(scr.fg(colorcelda));
				System.out.print(celda);
				System.out.print(scr.fg(Ansi.Color.WHITE));
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	/**
	 * Solicita la posición de la ficha y la coloca en el tablero.
	 * No está implementada la comprobación de posición válida de la ficha.
	 * <br> Utiliza {@link TresEnRaya#marcarCelda} 
	 * @param Jugador : Jugador que realiza el movimiento.
	 * @return false: jugador abandona la partida
	 * 	       true: jugada valida realizada
	 * @author lone
	 */	
	public	boolean movimientoJugador(int Jugador) {
		
		Scanner teclado = new Scanner( System.in);
		int fi,co;
		final String _filaCod ="ABC";
		char ch;
		boolean jugada_valida = false;
		String entrada="";
		System.out.println(scr.fgBrightYellow());
		System.out.print("Mueve Jugador ");
		System.out.println(Jugador);
		
	do {
		System.out.print(scr.fg(Ansi.Color.GREEN));
		System.out.print("\nEjemplo: A1, o salir:0 ? ");
		System.out.print(scr.fg(Ansi.Color.WHITE));
		entrada = teclado.nextLine();
		if(!entrada.equals("0")){
			entrada = entrada.charAt(0)+","+entrada.charAt(1);
			String coord[] = entrada.split(",");
			ch = Character.toUpperCase(coord[0].charAt(0));
			co =_filaCod.indexOf((int) ch);
			fi =Integer.parseInt(coord[1])-1;
			if (tablero[fi][co] == '-') {
				marcarCelda(fi,co,ficha[Jugador-1]);
				jugada_valida=true;
				}
			else {
				System.out.print(scr.fg(Ansi.Color.RED));
				System.out.print("Posición ocupada, elija otro movimiento ! ");
				System.out.print(scr.fg(Ansi.Color.WHITE));
				jugada_valida = false;
			}
			} 
			else {
				System.out.println("El Jugador abandona la partida !");
				return false;
			} // equals 0
	} while (!jugada_valida);
		return true;
	}
	/**
	 * comprueba el resultado de la partida, tras cada movimiento
	 * @return 1: jugador uno ganador
	 * 	       2: jugador dos ganador
	 *         0: sin resolución
	 */
	public int compruebaGanador() {
		return 0;
	}
/**
 * marcarCelda: Coloca la ficha en el tablero
 * @param fila	Fila donde colocar la ficha
 * @param columna Columna donde colocar la ficha
 * @param valor	Propiedad de la ficha: (X) Jugador 1, (O) Jugador 2
 * @author lone
 */
	public void marcarCelda(int fila, int columna,char valor) {
		
	tablero[fila][columna]= valor;
		
        }    
	
	/**
	 * Comprueba si la posición indicada está libre
	 * @param fila fila del tablero a consultar
	 * @param columna columna del tablero a consultar
	 * @return 	true : posición libre
	 * 			false: posición ocupada
	 */
	public boolean posicionLibre(int fila,int columna){
        
        if (tablero[fila][columna]=='-') return true; else return false;
        }
	/**
	 * Retorna el número de posiciones libres existentes en el tablero
	 * @return número de posiciones libres en el tablero
	 */
    private int huecosLibres(){
        int hl=0;    
        for (int i=0; i< tablero.length; i++){
            for (int j=0; j< tablero.length; j++) {
		if (tablero[i][j]==  '-') hl++;
            }
	}
        return hl;
        }
}
