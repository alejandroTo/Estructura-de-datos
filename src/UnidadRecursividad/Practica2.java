package UnidadRecursividad;

import java.util.Scanner;

/**
 * @author ALEJANDRO
 *
 */
public class Practica2 {
	public static int sumarDigitos(int num) {
		if(num < 10) 
		{
			return num;
		}
		else
		{
			return num%10 + sumarDigitos(num/10);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int dialogResult = 0;
		int numero = 0;
		do
		{	
			System.out.print("Introduzca un numero positivo: ");
			numero = leer.nextInt();
			System.out.println("--> "+Practica2.sumarDigitos(numero));
			System.out.println("¿desea seguir (1:si)(2:no)");
			dialogResult = leer.nextInt();
			if(dialogResult==2)
			{
				break;
			}
		}while(dialogResult!=2);
		leer.close();
	}
}
