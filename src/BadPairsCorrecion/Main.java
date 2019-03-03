package BadPairsCorrecion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer> lista = new ArrayList<Integer>();
		RemoveBadPairs badPa = new RemoveBadPairs(); 
		int tamaño=0;
		int numero=0;
		int opcion=0;
		String cadena = " ";
		do {
			opcion = menu();
			switch (opcion) 
			{
			case 1:
				try
				{
					lista.removeAll(lista);
					tamaño = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de numeros a ingresar"));
					for(int i=0;i<tamaño;i++)
					{
						numero = Integer.parseInt(JOptionPane.showInputDialog((i+1)+". Ingresa numero"));
						lista.add(numero);
					}
					cadena = lista.toString();
					badPa.removeBadPairs(lista);
					JOptionPane.showMessageDialog(null,"Cadena original"+cadena+"\nCadena RemovePairs"+lista.toString());
				}
				 catch (Exception e) {
					 JOptionPane.showMessageDialog(null,"Ingresa un numero valido");
				}
				break;
			case 2:
				lista.removeAll(lista);
				try {
					BufferedReader flujoEntrada = new BufferedReader
							(new FileReader("src\\BadPairsCorrecion\\numeros.txt"));
					PrintWriter flujoSalida = new PrintWriter
							(new FileWriter("src\\BadPairsCorrecion\\numeroRemove.txt"));
					while(flujoEntrada.ready())
					{
						lista.add(Integer.parseInt(flujoEntrada.readLine()));
					}
					cadena = " ";
					cadena = lista.toString();
					badPa.removeBadPairs(lista);
					JOptionPane.showMessageDialog(null,"Cadena original"+cadena+"\nCadena RemovePairs"+lista.toString());
					flujoSalida.print("Cadena original"+cadena+"\nCadena RemovePairs"+lista.toString());//Impresion de datos
					flujoSalida.close();
					flujoEntrada.close();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"No se encontro el archivo", "aviso", JOptionPane.OK_OPTION);
				}
				catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Solo se permiten numeros", "aviso", JOptionPane.OK_OPTION);
				}
				break;
			case 3:
				//Numeros [3, 7, 9, 2, 5, 5, 8, 5, 6, 3, 4, 7, 3, 1]
				lista.removeAll(lista);
				lista.add(3);
				lista.add(7);
				lista.add(9);
				lista.add(2);
				lista.add(5);
				lista.add(5);
				lista.add(8);
				lista.add(5);
				lista.add(6);
				lista.add(3);
				lista.add(4);
				lista.add(7);
				lista.add(3);
				lista.add(1);
				cadena = " ";
				cadena = lista.toString();
				badPa.removeBadPairs(lista);
				JOptionPane.showMessageDialog(null,"Cadena original"+cadena+"\nCadena RemovePairs"+lista.toString());
				break;
			}
		} while (opcion != 4);
	}
	public static int menu()
	{
		int opcion;
		opcion = Integer.parseInt(JOptionPane.showInputDialog("1.Leer numeros"
				+ "\n2.Lea la lista de números de un archivo"
				+ "\n3.Utilice una lista de números proporcionados por el programa"
				+ "\n4.Salir..."));
		return opcion;
	}
}
