package unidad1;

import java.util.Scanner;

public class PRACTICA9EJERCICIO2{
	public static void main(String[] arg){
		//inicializamos las variables
		int numero1,numero2;
		int numero3;
		//añadimos el Scanner
		Scanner teclado = new Scanner(System.in);
		
		//leemos los valores
		numero1 = teclado.nextInt();
		numero3 = teclado.nextInt();
		numero2= teclado.nextInt();
		//calculamos con la formula y mostramos en pantalla
		System.out.println("La media es: " + (numero1 + numero2 + numero3) / 3);
		
		//cerramos teclado
		teclado.close();
	}
}
