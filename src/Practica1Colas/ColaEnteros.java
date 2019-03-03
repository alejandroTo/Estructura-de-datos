package Practica1Colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JOptionPane;
public class ColaEnteros {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Queue<Integer> cola = new LinkedList<Integer>();
				int opcion=0;
				do {
					
					opcion = menu();
					switch(opcion)
					{
					case 1:
					Queue<Integer>cola2=new LinkedList<Integer>();
					Random r = new Random();
					for(int i=0; i<4; i++)
					{
						cola.offer(r.nextInt(6));
						cola2.offer(r.nextInt(10));
					}
					System.out.println("\nCola original Random 1: "+cola.toString()
							+ "\nCola orignial Random 2: "+cola2.toString());
					Queue<Integer>cola3=new LinkedList<Integer>();
					int mayor=0;
					int suma=0;
					boolean comprobacion=true;
					while(!cola.isEmpty()&&!cola2.isEmpty())
					{
						if(cola.peek()>mayor)
						{
							mayor=cola.peek();
						}
						cola3.offer(cola.poll());
					}
					while(!cola3.isEmpty()&&!cola2.isEmpty()){
						suma+=cola3.peek();
						if(cola3.poll()!=cola2.poll())
							comprobacion = false;
					}
					cola3.poll();
					System.out.println("Numero mayor 1: "+mayor+"\nSuma 1: "+suma);
					System.out.println("Cola igual = "+comprobacion);
					
					break;
					case 2:
					break;
					}
	}while(opcion!=0);
	}
	public static int menu()
	{
		int opcion=0;
		opcion = Integer.parseInt(JOptionPane.showInputDialog("1)Comparar(sumar,mayor)"
				+ "\n0)Salir..."));
		return opcion;
		
	}
}