package problema2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
public class MainPairs {

	public static void main(String[] args) throws NumberFormatException, IOException,java.io.FileNotFoundException {
		// TODO Auto-generated method stub
		int numero=0;
		int tamaño=0;
		BadPairs lista = new BadPairs();
		BufferedReader flujoEntrada = new BufferedReader
				(new FileReader("src\\problema2\\numeroPrede.txt"));
		PrintWriter flujoSalida = new PrintWriter
				(new FileWriter("src\\problema2\\numeroRemove.txt")); 
		int opcion;
		do
		{	
			opcion = MainPairs.menu();
			switch(opcion)
			{
			case 1:
				try{
					tamaño=Integer.parseInt(JOptionPane.showInputDialog
							("Tamaño ArrayList"));
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Ingresa un numero valido");
				}
				for(int i=0;i<tamaño;i++)
				{
					numero = Integer.parseInt(JOptionPane.showInputDialog((i+1)+"numero"));
					lista.insertarElemento(numero);
					//numero = flujoEntrada.read();
				}
				break;
			case 2:
				byte size;
				size = Byte.parseByte(flujoEntrada.readLine());/*lee el tamaño del arreglo con el primer
																renglon de numeroPrede.txt*/
																
				for(int i=0;i<size;i++)
				{
					lista.insertarElemento(Integer.parseInt(flujoEntrada.readLine()));
				}
				break;	
			case 3:
				//Numeros [3, 7, 9, 2, 5, 5, 8, 5, 6, 3, 4, 7, 3, 1]
				lista.insertarElemento(3);
				lista.insertarElemento(7);
				lista.insertarElemento(9);
				lista.insertarElemento(2);
				lista.insertarElemento(5);
				lista.insertarElemento(5);
				lista.insertarElemento(8);
				lista.insertarElemento(5);
				lista.insertarElemento(6);
				lista.insertarElemento(3);
				lista.insertarElemento(4);
				lista.insertarElemento(7);
				lista.insertarElemento(3);
				lista.insertarElemento(1);
				break;
			}
		} while(opcion!=0);
		String cadena = " ";
		cadena = lista.toString();
		lista.removeList();
		JOptionPane.showMessageDialog(null,"Cadena original"+cadena+"\nCadena RemovePairs"+lista.toString());
		flujoSalida.print("Cadena original"+cadena+"\nCadena RemovePairs"+lista.toString());//Impresion de datos
		flujoSalida.close();
		flujoEntrada.close();
	}
	public static int menu()
	{
		int opcion;
		opcion = Integer.parseInt(JOptionPane.showInputDialog("1.Leer numeros"
				+ "\n2.Lea la lista de números de un archivo"
				+ "\n3.Utilice una lista constante de números proporcionados por su programa"
				+ "\n4.Cero para terminar(Mostrar valores)..."));
		return opcion;
	}
}
