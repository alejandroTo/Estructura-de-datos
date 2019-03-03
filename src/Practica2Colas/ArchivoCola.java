package Practica2Colas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * En un archivo F están almacenados números enteros arbitrariamente grandes. La disposición es
   tal que hay un número entero por cada línea de F. Escribir un programa que muestre por
   pantalla la suma de todos los números enteros. Al resolver el problema habrá que tener en
   cuenta que, al ser enteros grandes, no pueden almacenarse en variables numéricas. Utilizar dos
   pilas para guardar los dos primeros números enteros, almacenándose dígito a dígito. Al extraer 
   los elementos de la pila, salen en orden inverso y, por tanto, de menor peso a mayor peso; se
   suman dígito con dígito y el resultado se guarda en una cola, también dígito a dígito. A partir de
   este primer paso se obtiene el siguiente número del archivo, se guarda en una pila y, a
   continuación, se suma dígito a dígito con el número que se encuentra en la cola; el resultado se 
   guarda en otra cola. El proceso se repite, nuevo número del archivo se mete en la pila, que se
   suma con el número actual de la cola.
 * @author ALEJANDRO Torres Ramirez
 * @version 1.0.
 */
public class ArchivoCola {

	/**Metodo main
	 * @param args
	 * @throws IOException: Utilizada para controlar la excepcion de archivos.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader flujoEntrada = new BufferedReader
					(new FileReader("src\\Practica2Colas\\F.txt"));//Documento para lectura de archivos.
		PrintWriter flujoSalida = new PrintWriter
				(new FileWriter("src\\Practica2Colas\\salida.txt")); //Creacion de documento para salida de archivo.
		Stack<Integer> pila = new Stack<>();//guarda la primer linea de texto.
		Stack<Integer> pila2 = new Stack<Integer>();//guarda la segunda linea de texto.
		Queue<Integer> cola = new LinkedList<Integer>();//guarda la suma de las dos primeras pilas.
		Queue<Integer> cola2 = new LinkedList<Integer>();//guarda la suma de la cola + la pila2.
		Stack<Integer> resultado = new Stack<Integer>();//guarda el resultado de la cola o cola2.
		String str = "";//Cadena para guardar la linea de cada renglon del archivo de texto.
		int linea=0;//contador de linea para el archivo de texto.
		int lleva=0;//acomulador si el numero sumado es >9 el lleva se convierte en 1, y se suma con las pilas y colas.
		while(flujoEntrada.ready())
		{
			str=flujoEntrada.readLine();//guarda la linea en la que este actualmente el archivo de texto.
			linea++;//Incrementa la linea de texto hasta que se terminen.
			if(linea==1)//Pregunta si actualmenete se esta en la linea 1, del texto entradaC.txt.
			{
				for(int i=0; i<str.length();i++)
				{
					try
					{
						pila.push(Integer.parseInt(str.substring(i, i+1)));//guarda el primer caracter de la cadena de texto.
						   //En la pila, e incrementa el contador.	
					}
					catch(NumberFormatException e)
					{
						System.out.println("Hay una letra o caracter en la pila 1, la cual fue borrada.");
					}
				}
			}
			else if(linea==2)//De no estar en la linea 1, pregunta si actualmente se esta en la linea 2 del texto.
			{
				for(int i=0;i<str.length();i++)
				{
					try
					{
						pila2.push(Integer.parseInt(str.substring(i,i+1)));//guarda el primer caracter de la cadena de texto.
						   //En la pila2, e incrementa el contador
					}
					catch(NumberFormatException e)
					{
						System.out.println("Hay una letra o caracter en la pila 2, la cual fue borrada.");
					}
				}
			}
			else//De no estar en la 1 y no estar en la 2, significa que esta en la linea 3, en delante del texto.
			{
				for(int i=0; i<str.length();i++)
				{
					try
					{
						pila.push(Integer.parseInt(str.substring(i,i+1)));//guarda el primer caracter de la cadena de texto.
						  //En la pila1, para poder sumarlo con la cola 1 o la 2.
					}
					catch(NumberFormatException e)
					{
						System.out.println("Hay una letra o caracter en la pila 1,al momento de sumarla con la Cola."
								+ "La cual fue borrada.");
					}
				}
			}
			while(!pila.isEmpty()&&!pila2.isEmpty())//Mientras pila no este vacia y pila2 no este vacia.
													//Deben de estar vacias las 2 para salir del cilco while.
			{
			
				int numero = pila.pop()+pila2.pop()+lleva;//numero para guardar la suma de los dos caracteres de pila y pila2
														  //no produce error, ya que solo de guardan dos digitos
							   			  //Por lo tanto no puede arrojar error de tamaño java.lang.NumberFormatException
				if(numero>9)//Si numero es mayor de 9, sigifica que hay un lleva. y se tiene que agregar a la sig vuelta.
				{
					cola.offer(numero%10);//sacamos el residuo del numero y lo guardamos en la cola
					lleva=1;//Incrementamos el lleva en 1, ya que hay un exceso en el numero.
				}			
				else//Si el numero no es mayor que 9.
				{
					cola.offer(numero);//Se guarda el numero sin sacarle su residuo.
					lleva=0;//le bajamos el valor del lleva a 0, para evitar problemas de acarreo posteriores.
				}
				if(pila.isEmpty()||pila2.isEmpty())
				{
					if(pila.size()>pila2.size())
					{
						pila2.push(0);
					}
					if(pila.size()<pila2.size())
					{
						pila.push(0);
					}
				}
				if(pila.isEmpty()&&pila2.isEmpty()&&lleva==1)//Si la pila, la pila2 estan vacias y el lleva ==1 
															 //significa que no hay un numero para sumar, pero estoy llevando 
															 //un acarreo
															 //el cual tengo que tener en cuenta para la sig suma.
				{
					cola.offer(lleva);
					lleva=0;
				}
			}
			while(!cola.isEmpty()&&!pila.isEmpty())
			{
				int numero =cola.poll()+pila.pop()+lleva;
				if(numero>9)
				{
					cola2.offer(numero%10);
					lleva=1;
				}
				else
				{
					cola2.offer(numero);
					lleva=0;
				}
				if(pila.isEmpty()||cola.isEmpty())
				{
					if(cola.size()>pila.size())
					{
						pila.push(0);
					}
					if(pila.size()>cola.size())
					{
						cola.offer(0);
					}
				}
				if(cola.isEmpty()&&pila.isEmpty()&&lleva==1)
				{
					cola2.offer(lleva);
					lleva=0;
				}
			}
			while(!pila.isEmpty()&&!cola2.isEmpty())
			{
		
				int numero = cola2.poll()+pila.pop()+lleva;
				if(numero>9)
				{
					cola.offer(numero%10);
					lleva=1;
				}
				else
				{
					cola.offer(numero);
					lleva=0;
				}
				if(pila.isEmpty()||cola2.isEmpty())//ultima modificacion. correcion de diferente tamño cola2 y pila.
				{
					if(cola2.size()>pila.size())
					{
						pila.push(0);
					}
					if(pila.size()>cola2.size())
					{
						cola2.offer(0);
					}
				}
				if(cola2.isEmpty()&&pila.isEmpty()&&lleva==1)
				{
					cola.offer(lleva);
					lleva=0;
				}
			}
		}
		//Sireve para invertir los valores y mostrarlos como una suma normal.
		while(!cola.isEmpty()||!cola2.isEmpty()||!pila.isEmpty())
		{
			if(!cola.isEmpty())
			{
				resultado.push(cola.poll());
			}
			if(!pila.isEmpty())
			{
				resultado.push(pila.pop());
			}
			if(!cola2.isEmpty())
			{
				resultado.push(cola2.poll());
			}
		}
		while(!resultado.isEmpty())
		{
			cola2.offer(resultado.pop());
		}
		System.out.print("Suma: "+cola2.toString());
		flujoSalida.print("Suma total:"+cola2.toString());
		flujoEntrada.close();
		flujoSalida.close();
	}
}