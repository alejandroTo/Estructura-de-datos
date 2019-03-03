package UnidadRecursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ALEJANDRO
 *
 */
public class Practica1 {

	public static String reemplazarXY(String str) {
		String cambio = "";
		if(str.length() != 0)
		{
			if(str.length() == 1)
			{
				if(str.equals("x"))
				{
					cambio = "y";
				}
				else
				{
					cambio = str;
				}
			}
			else 
			{
				if(str.substring(0, 1).equals("x"))
				{
					cambio = "y";
				}
				else 
				{
					cambio = str.substring(0, 1);
				}
				return cambio + reemplazarXY(str.substring(1, str.length()));
			}
		}
		return cambio;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte dialogresult=0;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader entrada = new BufferedReader(isr);
		do
		{
			String str ="";
			System.out.print("Introduce la cadena: ");
			str = entrada.readLine();
			System.out.println("--> "+Practica1.reemplazarXY(str));
			System.out.println("¿desea seguir (1:si)(2:no)");
			dialogresult = (byte) Integer.parseInt(entrada.readLine());
			if(dialogresult==2)
			{
				break;
			}
		}while(dialogresult!=2);
	}
}