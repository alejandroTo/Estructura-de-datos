/**
 * Write a description of class MainBool here.
 * @author ("Alejandro Torres Ramirez") 
 * @version (a version number or a date)
 */
package problema1;
import javax.swing.JOptionPane;
public class MainBool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConjuntoDeEnteros conjuntoA = new ConjuntoDeEnteros();
		ConjuntoDeEnteros conjuntoB = new ConjuntoDeEnteros();
		int numero;
		Byte numArreglo=-1;
		while(numArreglo<0) 
		{
			try
			{
				numArreglo=Byte.parseByte(JOptionPane.showInputDialog("Ingresa tamaño del conjunto A"));
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Error ingresa un numero valido de 1 a 100");
			}
			finally 
			{}
		}
		for(int i=0;i<numArreglo;i++)
		{
			numero =  Integer.parseInt(JOptionPane.showInputDialog("Numero conjunto A"));
			conjuntoA.insertarElemento(numero);
		}
		
		numArreglo=-1;
		while(numArreglo<0)
		{
			try
			{
				numArreglo=Byte.parseByte(JOptionPane.showInputDialog("Ingresa tamaño del conjunto b"));
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Error ingresa un numero valido de 1 a 100");
			}
			finally 
			{}
		}
		
		for(int i=0;i<numArreglo;i++)
		{
			numero =  Integer.parseInt(JOptionPane.showInputDialog("Numero conjunto B"));
			conjuntoB.insertarElemento(numero);
		}
		int yes;
		yes = JOptionPane.showConfirmDialog(null, "¿Desea borrar un numero?");
		if(yes==0)
		{
			numero = Integer.parseInt(JOptionPane.showInputDialog("Borrar numero"));
			conjuntoA.borrarElemento(numero);
			conjuntoB.borrarElemento(numero);
		}
		else
		{}
		JOptionPane.showMessageDialog(null,"Conjunto A "+conjuntoA.toString()+"\nConjunto B"+conjuntoB.toString()+
				"\nUnion "+ConjuntoDeEnteros.union(conjuntoA, conjuntoB)+"\n¿Los conjuntos son iguales?: "+conjuntoA.isEqualTo(conjuntoB)
				+"\nInterseccion: "+ConjuntoDeEnteros.interseccion(conjuntoA, conjuntoB));
		//if(conjuntoA.equals(conjuntoB))
			//System.out.print("Son iguales");
	}
	

}
