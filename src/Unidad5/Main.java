package Unidad5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader entrada = new BufferedReader(new FileReader
				("src\\Unidad5\\cadenas.txt"));
		ArbolBinarioDeBusqueda root = new ArbolBinarioDeBusqueda();
		//ArbolBinarioDeBusqueda root2 = new ArbolBinarioDeBusqueda();
		String str = "";
		PrintingVisitor visitor = new PrintingVisitor();
		int result=0;
		int opc;
		
		do 
		{
			opc = menu();
			while (entrada.ready()) {
				str = entrada.readLine();				
				/*Agregar caracter por caracter y acomodarlo
				 * en forma alfabetica
				 * for(int i=0; i<str.length(); i++)
				 *  {
				 * 	 root.insertar(str.substring(i,i+1))
				 *  }
				 */
				root.insertar(str);
			}
			switch(opc)
			{
				case 1:
				root.recorridoEnProfundidad(new InOrder(visitor));
					break;
				case 2:
					root.recorridoEnProfundidad(new InOrder(visitor));
					do
					{
						String busqueda = JOptionPane.showInputDialog
						("Ingresa cadena a buscar");
						if(root.find((Comparable)busqueda)!=null)
						{
							JOptionPane.showMessageDialog
							(null,"Se encontro la cadena: "
							+busqueda,"Aviso", JOptionPane.INFORMATION_MESSAGE);						
						}
						else
						{
							JOptionPane.showMessageDialog
							(null,"No se encontro la cadena: "
							+busqueda,"Aviso",JOptionPane.OK_OPTION);
						}
						result = JOptionPane.showConfirmDialog
								(null,"¿Desea buscar otro elemento?","Aviso", JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
					}while(result!=1);
					
					break;		
			}
		}while(opc!=3);
		entrada.close();
	}
	public static int menu()
	{
		int opc = Integer.parseInt(JOptionPane.showInputDialog(
				"1.Ver cadenas"
				+ "\n2.Buscar cadena"
				+ "\n3.salir"));
		return opc;
	}
}