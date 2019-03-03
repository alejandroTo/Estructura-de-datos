package Unidad2Tareas;
/**
 * Alejandro Torres Ramirez
 */

import javax.swing.JOptionPane;
import java.util.Stack;

public class InvertirTexto{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String cadena="";
		Stack<Character> pila = new Stack<Character>();
		int dialogResult=1;
		do
		{
			cadena = JOptionPane.showInputDialog("Ingresa cadena");
			for(int i=0;i<cadena.length();i++)
			{
				pila.push(cadena.charAt(i));		
			}
			System.out.print("\nPila Original\n"+pila.toString()+"\n");
			System.out.print("Pila inversa\n");
			while(!pila.empty())
			{
				System.out.print(pila.pop());
			}
			dialogResult =JOptionPane.showConfirmDialog(null,"Desea salir?");
		}while(dialogResult==1);*/
		String cadena="";
		Stack<String> pila = new Stack<String>();
		int dialogResult=1;
		String a =" ";
		while(dialogResult==1)
		{ 
			cadena = JOptionPane.showInputDialog("Ingresa cadena");
			pila.push(cadena);
			System.out.println("\nPila Original\n"+pila.toString());
			pila.clear();
			int j=cadena.length()-1;
			for(int i=0;i<cadena.length();i++)
			{
				//a=Character.toString(cadena.charAt(j));
				//System.out.println(a+"orden");
				a = ""+cadena.charAt(j);
				pila.push(a);
				System.out.print(pila.pop());
				//System.out.print("\nPila"+pila.pop());
				j--;
			}
			/*while(!pila.empty())
			{
				System.out.print("\nPila"+pila.pop());
			}*/
			dialogResult =JOptionPane.showConfirmDialog(null,"Desea salir?");
		}		
	
	}
}