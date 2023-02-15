package ejercicio01;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
	static final int TAMAÑO= 20; //  tamaño del tablero
	static final int MINAS = 6; //  cantidad de minas
	
	public static char[] bombas(char tablerOculto[]) {
		int indice; // Para guardar las minas en valores aleatorios
		char bombas[] = new char[TAMAÑO]; // Creamos un nuevo array
		char contador = 0; // Contador para rellenar las minas necesarias

		for (int i = 0; i < TAMAÑO; i++) { // Rellenamos el array inicialmente con ceros
			bombas[i] = '0';
		}

		while (contador < MINAS) { 							 // este bucle terminara al llegar al numero de minas

			indice = (int) (Math.random() * (20 + 1) - 1); 	 // Guardamos el índice 
			if (bombas[indice] != '*') { 					 //Si hay mina vuelve al while

				bombas[indice] = '*'; 						 // Si no hay mina, la ponemos

				if (izq(indice)) { 							 // Llamamos a la función izq
					if (!compruebaDer(bombas, indice)) { // si no hay mina a la derecha se sima 1 en la posicion siguiente
															
						bombas[indice + 1] += 1;
					}
				} else if (der(indice)) {  					  // Llamamos a la función der
					if (!compruebaIzq(bombas, indice)) {  // Si no hay mina a la izquierda sumamos 1 en la posicion anterior
															
						bombas[indice - 1] += 1;
					}
				} else {
					if (!compruebaIzq(bombas, indice)) { // Si no hay mina a la izquierda, sumammos +1 a
																	// 'indice - 1'
						bombas[indice - 1] += 1;
					}
					if (!compruebaDer(bombas, indice)) { // Si no hay mina a la derecha, sumamos +1 a 'indice
																	// + 1'
						bombas[indice + 1] += 1;
					}
				}
				contador++; // al colocar una mina correctamente se aumenta en 1 el contador 
			}
		}
		return bombas; // ya estaria el tablero relleno con las minas y los numeros
	}
	
	
	public static Boolean der(int indice) {
		Boolean borde = false;

		if (indice == (TAMAÑO - 1)) {
			borde = true;
		}
		return borde;
	}
	
	public static Boolean izq(int indice) {
		Boolean borde = false;

		if (indice == 0) {
			borde = true;
		}

		return borde;
	}
	
	public static Boolean compruebaDer(char tablerOculto[], int indice) {
		Boolean mina = false;

		if (tablerOculto[indice + 1] == '*') {
			mina = true;
		}

		return mina;
	}
	
	public static Boolean compruebaIzq(char tablerOculto[], int indice) {
		Boolean mina = false;

		if (tablerOculto[indice - 1] == '*') {
			mina = true;
		}

		return mina;
	}
	 
	 public static char[] juego(char tablero[], char tablerOculto[], int numero) {

			if (tablero[numero] == '-') {
				tablero[numero] = tablerOculto[numero];
			}

			return tablero;
		}
	 
	 public static Boolean hasperdido(char tablerOculto[], int numero) {
			Boolean derrota = false;

			if (tablerOculto[numero] == '*') {
				derrota = true;
			}

			return derrota;
	 }
	 
	 public static Boolean hasganado(int resultado) {
			Boolean victoria = false;

			if (resultado > 13) {
				victoria = true;
			}
			return victoria;
		}
	 
public static void main(String[] args) {
		//bloque de variables
		char[] tablerOculto=new char [20];	    //tablero en el que se generan las minas
		char[] tablero=new char[20];			// tabero con el que se juega
		int numero; 							// sera el numero que vaya escribiendo el usuario
		int contador=0; 						// cuando este llegue a 14 el jugador habrá ganado
		
		//creamos scanner para leer los numeros del usuario
		Scanner sc= new Scanner (System.in);
		
		// llamamos a la funcion para generar las bombas
		tablerOculto=bombas(tablerOculto);
		
		//rellenemos el tablero de - en los lugares que no haya bombas
		for (int i = 0; i < TAMAÑO; i++) { // Rellenamos el tablero de juego con guiones
			tablero[i] = '-';
		}
		System.out.println(Arrays.toString(tablerOculto));
		
		System.out.println("Empieza el juego:");
		//empezamos con el juego, mostrando el tablero vacio
		System.out.println(Arrays.toString(tablero));
		
		//pedimos al usuario un numero del 1-20 para saber si hay bomba en esa posicion
		// comprobamos que el numero este dentro del rango
		do {
			do {
				System.out.println("Escribe un numero del 0-19: ");
				numero=sc.nextInt();
			}while(numero>19 || numero<0 || tablero[numero]!='-'); 
			
			contador++;
			
			System.out.println(Arrays.toString(juego(tablero, tablerOculto, numero)));
			
		}while (!hasperdido(tablerOculto, numero) && !hasganado(contador));
			
		
		if (hasperdido(tablerOculto, numero)) { 									// si el contador esta por debajo de 14 hbrá perdido
			System.out.println("HAS PERDIDO,BUENA SUERTE LA PROXIMA: ");
		} else { 															// si ha conseguido llegar a 14 sin encontarse con una mina
			System.out.println("ERES UNA MAQUINA HAS GANADO!! ");
		}

		System.out.println(Arrays.toString(tablerOculto)); 						// Mostramos el tablero 
			
		
		//cerramos scanner 
		sc.close();
	}
}
