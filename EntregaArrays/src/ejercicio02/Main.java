package ejercicio02;

import java.util.Scanner;

public class Main {
	static String respuesta;				// guarda la respuesta del jugador para ver si quiere cartas o no
	static double tirada=0;					// se guadara la puntuacion de la tirada 
	
	public static  double carta(double tirada) {
		
		return tirada;
	}
	
	public static  String respuesta (String rsp) {
		
		switch (respuesta){
		case "s":
			break;
		case "n":
			break;
		default:
			System.out.println("ESCRIBE UNA RESPUESTA DE s/n. ");
		}
		return rsp;
	}

	public static void main(String[] args) {
		// bloque de variables
		double jugador1,jugador2; 		// se guardara la puntuacion que vayan acumulando
		String baraja[]= {"1","2","3","4","5","6","7","sota","caballo","rey"};
		String palos[]= {"ORO","BASTO","ESPADA","COPAS"};
		
		
		//creamos scanner y preguntamos 
		Scanner sc= new Scanner (System.in) ;
		
		System.out.println("BIENVENIDOS AL JUEGO DE LAS 7 Y MEDIA.");
		System.out.println("ES EL TURNO DEL JUGADOR 1:");
		
		
		System.out.println("DESEA PEDIR UNA CARTA?: ");
		respuesta = sc.next();
		
		// llamamos a la funcion para ver si la respuesta pasa a ejecutar una tirada o pasa al jugador 2
		respuesta(respuesta);
		
		if (respuesta == "s") {
			carta(tirada);
			
		}else if (respuesta=="n") {
			System.out.println("PASA AL SIGUIENTE JUGADOR");
		}
		
		
		sc.close();
	}

}
