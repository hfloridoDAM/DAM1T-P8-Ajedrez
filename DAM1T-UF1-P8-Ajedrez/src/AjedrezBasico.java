import java.util.Scanner;

public class AjedrezBasico {

	public static void main(String[] args) {
		boolean finPartida = false;
		Scanner scan = new Scanner(System.in);
		
		String piezas = "TCAKQP"; //piezas permitidas
		String piezasRepetidas = "TCAP"; //piezas repetidas
		
		//Inicialización del ajedrez
		String [][] ajedrez = 
				{{"[T]","[C]","[A]","[K]","[Q]","[A]","[C]","[T]"},
				{"[P]","[P]","[P]","[P]","[P]","[P]","[P]","[P]"},
				{" . "," . "," . "," . "," . "," . "," . "," . "},
				{" . "," . "," . "," . "," . "," . "," . "," . "},
				{" . "," . "," . "," . "," . "," . "," . "," . "},
				{" . "," . "," . "," . "," . "," . "," . "," . "},
				{"(P)","(P)","(P)","(P)","(P)","(P)","(P)","(P)"},
				{"(T)","(C)","(A)","(Q)","(K)","(A)","(C)","(T)"}};
		
		int tam = ajedrez.length;
		
		//Imprimir ajedrez
		System.out.println();
		for (int i = 0; i < ajedrez.length; i++) {
			for (int j = 0; j < ajedrez.length; j++) {
				System.out.print(ajedrez[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println();
		
		do {
			//Control pieza seleccionada
			String pieza;
			int colP, filP;
			boolean selected = false;
			do {
				System.out.print("FILA y COLUMNA PIEZA: ");
				filP = scan.nextInt() -1;
				colP = scan.nextInt() -1;
				
			} while (!(colP <= tam && filP <= tam 
					&& colP >= 0 && filP >= 0
					&& !ajedrez[filP][colP].equals(" . ")));
			pieza = ajedrez[filP][colP];
			System.out.println("Pieza seleccionada: " + pieza);
			//Control movimiento de piezas
			int col, fil;
			
			do {
				System.out.print("FILA y COLUMNA MOVIMIENTO: ");
				fil = scan.nextInt() -1;
				col = scan.nextInt() -1;
				
			} while (!(col <= tam && fil <= tam 
					&& col >= 0 && fil >= 0
					&& ajedrez[fil][col].equals(" . ")));
			
			switch (pieza.substring(1,2)) {
				//pieza Torre
				case "T": 
					if ((filP == fil || colP == col)) {
						ajedrez[fil][col] = pieza;
						ajedrez[filP][colP] = " . ";
					} else {
						System.err.println("Movimiento no permitido");
					}
					break;
				//pieza Caballo
				case "C":
					if ((fil == filP+2 && col == colP+1) ||
							(fil == filP+1 && col == colP+2) ||
							(fil == filP+2 && col == colP-1) ||
							(fil == filP+1 && col == colP-2) ||
							(fil == filP-2 && col == colP+1) ||
							(fil == filP-1 && col == colP+2) ||
							(fil == filP-2 && col == colP-1) ||
							(fil == filP-1 && col == colP-2)) {
						ajedrez[fil][col] = pieza;
						ajedrez[filP][colP] = " . ";
					} else {
						System.err.println("Movimiento no permitido");
					}
					break;
				
				//pieza Alfil
				case "A": 
					if (Math.abs(filP-fil) == Math.abs(colP-col)) {
						ajedrez[fil][col] = pieza;
						ajedrez[filP][colP] = " . ";
					} else {
						System.err.println("Movimiento no permitido");
					}
					break;
				
				//pieza King
				case "K": 
					if ((fil == filP+2 && col == colP+1) ||
							(fil == filP+1 && col == colP) ||
							(fil == filP+1 && col == colP+1) ||
							(fil == filP+1 && col == colP-1) ||
							(fil == filP && col == colP) ||
							(fil == filP && col == colP+1) ||
							(fil == filP && col == colP-1) ||
							(fil == filP-1 && col == colP) ||
							(fil == filP-1 && col == colP-1)) {
						ajedrez[fil][col] = pieza;
						ajedrez[filP][colP] = " . ";
					} else {
						System.err.println("Movimiento no permitido");
					}
					break;
				
				//pieza Queen
				case "Q": 
					if ((Math.abs(filP-fil) == Math.abs(colP-col)) 
							|| (filP == fil || colP == col)) {
						ajedrez[fil][col] = pieza;
						ajedrez[filP][colP] = " . ";
					} else {
						System.err.println("Movimiento no permitido");
					}
					break;
				
				//pieza Peon
				case "P": 
					int dif = colP - col;
					if (dif < 0) dif += -1;
					if (col == colP && dif <= 2 && dif >= 0) {
						ajedrez[fil][col] = pieza;
						ajedrez[filP][colP] = " . ";
					} else {
						System.err.println("Movimiento no permitido");
					}
					break;
			}
			
			//Imprimir ajedrez
			System.out.println();
			for (int i = 0; i < ajedrez.length; i++) {
				for (int j = 0; j < ajedrez.length; j++) {
					System.out.print(ajedrez[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println();
			
		} while (!finPartida);
	}
}