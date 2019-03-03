package BrunoProblema2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**Metodo main. Aplicacion que lee un archivo de entrada llamado brunoF.txt el cual
 * tiene guardados numros enteros positivos los cuales van a ser sumados por medio
 * de pilas y colas, el resultado se almacenara en una cola y mostrara el resultado
 * en consola y en un archivo de salida llamado brunoSalida.
 * @author ALEJANDRO Torres
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader entrada = new BufferedReader
				(new FileReader("src\\BrunoProblema2\\brunoF.txt"));//Documento para lectura de archivos.
		PrintWriter salida = new PrintWriter
			(new FileWriter("src\\BrunoProblema2\\brunoSalida.txt")); //Creacion de documento para salida de archivo.
		PilaEnArreglo pila = new PilaEnArreglo(50);
		PilaEnArreglo pila2 = new PilaEnArreglo(50);
		PilaEnArreglo result = new PilaEnArreglo(50);
		ColaEnArreglo cola = new ColaEnArreglo();
		ColaEnArreglo cola2 = new ColaEnArreglo();
		String str = "";//Cadena para guardar la linea de cada renglon del archivo de texto.
		int linea=0;//contador de linea para el archivo de texto.
		int lleva=0;//acomulador si el numero sumado es >9 el lleva se convierte en 1, y se suma con las pilas y colas.

		while(entrada.ready())
		{
			str=entrada.readLine();//guarda la linea en la que este actualmente el archivo de texto.
			linea++;//Incrementa la linea de texto hasta que se terminen.
			if(linea==1)//Pregunta si actualmenete se esta en la linea 1, del texto entradaC.txt.
			{
				for(int i=0; i<str.length();i++)
				{
					try
					{
						pila.agregar(Integer.parseInt(str.substring(i, i+1)));//guarda el primer caracter de la cadena de texto.
						   //En la pila, e incrementa el contador.	
					}
					catch(NumberFormatException eq)
					{
						System.out.println("Hay una letra o caracter en la pila 1, la cual fue borrada.");
					}
				}
			}
			else if(linea==2)
			{
				for(int i=0; i<str.length();i++)
				{
					try
					{
						pila2.agregar(Integer.parseInt(str.substring(i, i+1)));
					}
					catch(NumberFormatException ea)
					{
						System.out.println("Hay una letra o caracter en la pila 2, la cual fue borrada.");
					}
					
				}

			}
			else//De no cumplise las condiciones anterirores entramos a este ciclo else.
			{
				for(int i=0; i<str.length();i++)
				{
					try
					{
						pila.agregar(Integer.parseInt(str.substring(i, i+1)));
					}
					catch(NumberFormatException ea)
					{
						System.out.println("Hay una letra o caracter en la pila 1, la cual fue borrada.");
					}
					
				}
			}
			while(!pila.isEmpty()&&!pila2.isEmpty())
			{
				int numero = (int)pila.borrar()+(int)pila2.borrar()+lleva;
				if(numero>9)
				{
					cola.agregar(numero%10);//sacamos el residuo del numero y lo guardamos en la cola
					lleva=1;//Incrementamos el lleva en 1, ya que hay un exceso en el numero.
				}
				else//Si el numero no es mayor que 9.
				{
					cola.agregar(numero);//Se guarda el numero sin sacarle su residuo.
					lleva=0;//le bajamos el valor del lleva a 0, para evitar problemas de acarreo posteriores.
				}
				
				if(pila.isEmpty()||pila2.isEmpty())
				{
					if(pila.size()>pila2.size())
					{
						pila2.agregar(0);
					}
					if(pila.size()<pila2.size())
					{
						pila.agregar(0);
					}
				}
				if(pila.isEmpty()&&pila2.isEmpty()&&lleva==1)//Si la pila, la pila2 estan vacias y el lleva ==1 
					 //significa que no hay un numero para sumar, pero estoy llevando 
					 //un acarreo
					 //el cual tengo que tener en cuenta para la sig suma.
				{
					cola.agregar(lleva);
					lleva=0;
				}
			}
			while(!cola.isEmpty()&&!pila.isEmpty())
			{
				int numero = (int)cola.desencolar()+(int)pila.borrar()+lleva;
				if(numero>9)
				{
					cola2.agregar(numero%10);
					lleva=1;
				}
				else
				{
					cola2.agregar(numero);
					lleva=0;
				}
				if(pila.isEmpty()||cola.isEmpty())
				{
					if(cola.size()>pila.size())
					{
						pila.agregar(0);
					}
					if(pila.size()>cola.size())
					{
						cola.agregar(0);
					}
				}
				if(cola.isEmpty()&&pila.isEmpty()&&lleva==1)
				{
					cola2.agregar(lleva);
					lleva=0;
				}
			}
			while(!pila.isEmpty()&&!cola2.isEmpty())
			{
		
				int numero = (int)cola2.desencolar()+(int)pila.borrar()+lleva;
				if(numero>9)
				{
					cola.agregar(numero%10);
					lleva=1;
				}
				else
				{
					cola.agregar(numero);
					lleva=0;
				}
				
				if(pila.isEmpty()||cola2.isEmpty())
				{
					if(cola2.size()>pila.size())
					{
						pila.agregar(0);
					}
					if(pila.size()>cola2.size())
					{
						cola2.agregar(0);
					}
				}
				if(cola2.isEmpty()&&pila.isEmpty()&&lleva==1)
				{
					cola.agregar(lleva);
					lleva=0;
				}
			}
		}
		
		//Sirve para invertir los valores y mostrarlos como una suma normal.
		while(!cola.isEmpty()||!cola2.isEmpty())
		{
			if(!cola.isEmpty())
			{
				result.agregar(cola.desencolar());
			}
			else
			{
				result.agregar(cola2.desencolar());
			}
		}
		while(!result.isEmpty())
		{
			cola2.agregar(result.borrar());
		}
		System.out.print("Suma: "+cola2.toString());
		salida.print("Suma total:"+cola2.toString());
		entrada.close();
		salida.close();
	}
}