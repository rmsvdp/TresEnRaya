import tresenRaya.MainTresEnRaya;

public class MainApp {

	public MainApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Menu menuPrincipal;
		String[] opciones = {"Partida Tres en Raya","Creditos"};
		boolean finSesion = false;
		int result;
		menuPrincipal = new Menu(opciones);
		
		while (!finSesion) {
			menuPrincipal.mostrarMenu();
			result = menuPrincipal.eligeOpcion();
			switch(result) {
				
				case 1:	// iniciar partida
					MainTresEnRaya ter = new MainTresEnRaya();
					ter.lanzaPartida();
					break;
				case 2: // Creditos
					System.out.println("1wet : 0486 Programación 2023");
					break;
				case 0: // salir aplicación
					finSesion= true;
				
			} // switch
		} // while !finSesion

	}

}
