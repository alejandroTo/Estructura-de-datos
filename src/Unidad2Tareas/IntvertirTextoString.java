package Unidad2Tareas;
import java.util.Stack;
import javax.swing.JOptionPane;

public class IntvertirTextoString {
	public static void main()
	{
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