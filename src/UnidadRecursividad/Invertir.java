package UnidadRecursividad;

import java.util.Arrays;
import java.util.Scanner;

public class Invertir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float [] [] a = new float[2][3];
		float valor=0.f;
		Scanner leer = new Scanner(System.in);
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<a[i].length; j++)
			{
				a[i][j] = leer.nextFloat();
			}
		}
		float b [] [] = new float[3][2];
		for(int i=0; i<b.length; i++)
		{
			for(int j=0; j<b[i].length; j++)
			{
				b[i][j] = b[j][i];
			}
		}
		for(int i=0; i<b.length; i++)
		{
			System.out.println(Arrays.toString(b[i]));
		}
		

	}

}
