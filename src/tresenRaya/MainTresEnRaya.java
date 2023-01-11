package tresenRaya;
import java.util.Scanner;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

/**
 * Clase principal que implementa la partida, para
 * ello se sirve de la clase TresEnRaya que implementa los
 * elementos del juego propiamente dicho: tablero, fichas, movimientos
 * También utiliza una librería auxiliar para poder enviar códigos
 * de color a la consola
 
 * @author loned
 * 
 */
public class MainTresEnRaya {

	/**
	 * Emulación de consola Ansi 
	 */
	public static Ansi scr0;
	
	public MainTresEnRaya() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * menú del juego, pinta en pantalla las opciones disponibles y 
	 * solicita al jugador la elección de una ellas
	 * @return sel Opción elegida por el jugador
	 */
	public static int menu() {	
		int sel = 0;

		Scanner teclado = new Scanner(System.in);
		System.out.println(scr0.fgBrightCyan());
		System.out.println("---- Opciones ----");
		System.out.print(scr0.fg(Ansi.Color.WHITE));
		System.out.println("1. Mueve Jugador 1");
		System.out.println("2. Mueve Jugador 2");
		System.out.println("0. Termina Partida");
		System.out.println(scr0.fgBrightCyan());
		System.out.println("------------------");
		System.out.println(scr0.fgBrightYellow());
		System.out.print(">>>?");
		System.out.print(scr0.fg(Ansi.Color.WHITE));
		sel = teclado.nextInt();
		return sel;
                
	}
/**
 * Función principal, donde se gestiona la partida
  * <br>
 * Consultar el método: {@link TresEnRaya#mostrarTablero}
 * @param args	Parámetro sin uso, se manteniene por compatibidad
 * @see "Clase 3 en raya"
 */
	
	public void lanzaPartida() {
		// TODO Auto-generated method stub
		/**
		 * Seudocódigo
		 *  Instancia partida
		 *  Limpia y muestra tablero
		 *  mientras no exista ganador o o no se empate 
		 *  no se abandone partida
		 *  	Ejecuta turnos de jugador 1/2
		 *  	muestra la jugada
		 *  	evalua resultado
		 *  muestra mensaje  
		 */
	    
			
        AnsiConsole.systemInstall();			// Activar
		//int opc = -1;
		int opc = 1;
		int resultado =0; 		// partida en curso
		boolean turno = true; 	// 
		scr0 = new Ansi();
		// creamos una partida
		TresEnRaya partida = new TresEnRaya(scr0);
		partida.limpiarTablero();
        partida.mostrarTablero();
		while (opc != 0) {
		/*	opc = menu();		
		    if((opc == 1) || (opc ==2 )) {
		        partida.movimientoJugador(opc);
		        partida.mostrarTablero();
		      } else if(opc==0) {
		        opc = 0;
		        System.out.println(scr0.fg(Ansi.Color.GREEN));
		        System.out.println("Partida Terminada");
		      } else {
		    	  System.out.println(scr0.fg(Ansi.Color.RED));
		    	  System.out.println("Opcion no valida!");
				  opc = -1;
		      }	
		    */
			// Lanza siguiente turno
	        if (partida.movimientoJugador(opc)) {
	        partida.mostrarTablero();
	        opc = opc%2 +1;
		    System.out.println("Jugador siguiente: " + opc);
	        // Evaluar el resultado de la partida
		    resultado = partida.compruebaGanador();
	        } // movimiento realizado y comprobado
	        else
	        {opc=0; resultado=0;}
	        if (resultado !=0) opc = 0;
		    System.out.println(scr0.fg(Ansi.Color.WHITE));
		} // while
		// Publicar resultado de la partida
		if (resultado!=0)System.out.println("Ganó el jugador : " + resultado);
		AnsiConsole.systemUninstall();// Terminar
	}	
}
