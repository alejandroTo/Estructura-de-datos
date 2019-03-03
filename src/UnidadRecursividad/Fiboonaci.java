package UnidadRecursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Fiboonaci {

	public static int fiboncciteratica(int n)
	{
		if(n==0 || n==1)
		{
			return  n;
		}
		int fibinf = 0;
		int fibsup =1;
		for(int i =2; i<=n; i++)
		{
			int x;
			x = fibinf;
			fibinf = fibsup;
			fibsup = x+ fibinf;
		}
		return fibsup;
	}
	public static int fibonacci(int n)  {
	    if(n == 0 || n==1)
	        return n;
	   else
	      return fibonacci(n - 1) + fibonacci(n - 2);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int n=0;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader ent = new BufferedReader(isr);
		PrintStream sal = System.out;
		
		sal.print("Ingresa numero: ");
		n = Integer.parseInt(ent.readLine());
		sal.print("Respuesta iterativa: "+ fiboncciteratica(n));
		sal.print("\nRespuesta Recursiva: "+ fibonacci(n));
		ent.close();
		sal.close();
		

	}

}
