package ListaEnlazada3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			BufferedReader entrada = new BufferedReader(new FileReader("src\\ListaEnlazada3\\F.txt"));
			PrintWriter salida = new PrintWriter(new FileWriter("src\\ListaEnlazada3\\Fsalida.txt"));
			PilaEnListaEnlazada pila = new PilaEnListaEnlazada();
			PilaEnListaEnlazada pila2 = new PilaEnListaEnlazada();
			PilaEnListaEnlazada result = new PilaEnListaEnlazada();
			ColaEnListaEnlazada cola = new ColaEnListaEnlazada();
			ColaEnListaEnlazada cola2 = new ColaEnListaEnlazada();
			String str;
			int linea=0;
			int lleva=0;
			while(entrada.ready())
			{
				str = entrada.readLine();
				linea++;
				if(linea==1)
				{
					for(int i=0; i<str.length();i++)
					{
						try
						{
							pila.push(Integer.parseInt(str.substring(i, i+1)));//guarda el primer caracter de la cadena de texto.
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
							pila2.push(Integer.parseInt(str.substring(i, i+1)));
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
							pila.push(Integer.parseInt(str.substring(i, i+1)));
						}
						catch(NumberFormatException ea)
						{
							System.out.println("Hay una letra o caracter en la pila 1, la cual fue borrada.");
						}
						
					}
				}
				while(!pila.isEmpty()&&!pila2.isEmpty())
				{
					int numero = (int)pila.pop()+(int)pila2.pop()+lleva;
					if(numero>9)
					{
						cola.enqueue(numero%10);//sacamos el residuo del numero y lo guardamos en la cola
						lleva=1;//Incrementamos el lleva en 1, ya que hay un exceso en el numero.
					}
					else//Si el numero no es mayor que 9.
					{
						cola.enqueue(numero);//Se guarda el numero sin sacarle su residuo.
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
						cola.enqueue(lleva);
						lleva=0;
					}
				}
				while(!cola.isEmpty()&&!pila.isEmpty())
				{
					int numero = (int)cola.dequeue()+(int)pila.pop()+lleva;
					if(numero>9)
					{
						cola2.enqueue(numero%10);
						lleva=1;
					}
					else
					{
						cola2.enqueue(numero);
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
							cola.enqueue(0);
						}
					}
					if(cola.isEmpty()&&pila.isEmpty()&&lleva==1)
					{
						cola2.enqueue(lleva);
						lleva=0;
					}
				}
				while(!pila.isEmpty()&&!cola2.isEmpty())
				{
			
					int numero = (int)cola2.dequeue()+(int)pila.pop()+lleva;
					if(numero>9)
					{
						cola.enqueue(numero%10);
						lleva=1;
					}
					else
					{
						cola.enqueue(numero);
						lleva=0;
					}
					
					if(pila.isEmpty()||cola2.isEmpty())
					{
						if(cola2.size()>pila.size())
						{
							pila.push(0);
						}
						if(pila.size()>cola2.size())
						{
							cola2.enqueue(0);
						}
					}
					if(cola2.isEmpty()&&pila.isEmpty()&&lleva==1)
					{
						cola.enqueue(lleva);
						lleva=0;
					}
				}
			}
			//Sirve para invertir los valores y mostrarlos como una suma normal.
			while(!cola.isEmpty()||!cola2.isEmpty()||!pila.isEmpty())
			{
				if(!cola.isEmpty())
				{
					result.push((int)cola.dequeue());
				}
				else if(!cola2.isEmpty())
				{
					result.push((int)cola2.dequeue());
				}
				else if(!pila.isEmpty())
				{
					result.push((int)pila.pop());
				}
			}
			while(!result.isEmpty())
			{
				cola2.enqueue((int)result.pop());
			}
			System.out.print("Suma: "+cola2.toString());
			salida.print("Suma total:"+cola2.toString());
			entrada.close();
			salida.close();
	}
}